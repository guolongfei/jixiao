package com.hoyotech.prison.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.Area;
import com.hoyotech.prison.bean.Dictionary;
import com.hoyotech.prison.bean.Organization;
import com.hoyotech.prison.bean.PrisonInfo;
import com.hoyotech.prison.bean.User;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.DictionaryService;
import com.hoyotech.prison.service.impl.OrganizationService;
import com.hoyotech.prison.service.impl.PrisonInfoService;
import com.hoyotech.prison.service.impl.UserService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.ObjectUpdateUtil;
import com.hoyotech.prison.util.Type;
import com.hoyotech.prison.bean.Police;

import com.isa.pims.basic.ServletRequestUtils;
import com.opensymphony.xwork2.ActionSupport;

public class PrisonInfoAction extends ActionSupport {

	PrisonInfoService prisonService;
	UserService userService;
	DictionaryService dictionaryService;
	OrganizationService organizationService;
	private List<PrisonInfo> prisonInfolist;
	private PrisonInfo prisoninfo;
	private List<Dictionary> prisonLevel;
	private List<Dictionary> prisonSize;
	private int pageNum;
	private int limit; 
	private int totalPage;
	private int totalNum;
	private String id ;
	private String username;
	private String password;
	private File prisonImage;

	private String priNum; //检索用的拘留所编号
	private String priName; //检索用的拘留所名称
	private String priLevel; //检索用的等级
	private String priSize; //检索用的规模
	
	private Map<Area, List<Area>> areaList;
	private List<Organization> orgList;	
	private LogFactory log;
	private List<Police> plic;//警员实例
	
	public List<Police> getPlic() {
		return plic;
	}

	public void setPlic(List<Police> plic) {
		this.plic = plic;
	}

	public File getPrisonImage() {
		return prisonImage;
	}

	public void setPrisonImage(File prisonImage) {
		this.prisonImage = prisonImage;
	}
	//显示风貌图片
	public void image(){
		 try {
			 HttpServletRequest request=ServletActionContext.getRequest();
			 String prisonId = (String) request.getSession().getAttribute("prisonId");
			 byte[] image = prisonService.getImageById(prisonId);
			 if(image != null){
				 HttpServletResponse response = ServletActionContext.getResponse();
				 response.setContentType("image/jpeg");
				 OutputStream toClient = response.getOutputStream();//获取输出流      
				 toClient.write(image);//输出到页面      
				 toClient.close();//关闭输出流      
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 查询所有拘留所的信息
	 * **/
	public String select() {
		levAndSize();
		HttpServletRequest request=ServletActionContext.getRequest();
		pageNum = ServletRequestUtils.getInt(request, "page","1");
		limit = ServletRequestUtils.getInt(request, "limit","5");
		prisonInfolist = prisonService.allPrisonInfo(priNum,priName,priLevel,priSize,pageNum,limit);
		totalNum = prisonService.countPrisonInfo(priNum,priName,priLevel,priSize);
		totalPage = (totalNum-1)/limit+1;
		
		String type=(String)request.getSession().getAttribute("orgType");
		if("2".equals(type)){
			return "stinfoList";
		}else{
			return "infoList";
		}
	}
	
	/**
	 * 添加一条拘留所的信息
	 * **/
	public String addInfo() {
		id = prisonService.addPrisonInfo(prisoninfo); //添加数据得到id
		//添加拘留所的默认登录账号
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);System.out.println(password+"  tttttttttttttttttt");
		user.setOrganizeType("1");
		user.setPrisonCode(prisoninfo.getPrisonCode());
		user.setPrison(prisoninfo);
		userService.add(user);
		userService.updateRole(user.getId(), new String[]{"8aca6a95425103f00142544589f30037"});
		
		if(prisonImage != null){
			try {
				InputStream inputStream = new FileInputStream(prisonImage);
				int fileSize = (int) prisonImage.length();
				byte[] buff= new byte[fileSize];
				inputStream.read(buff, 0, fileSize);
				HttpServletRequest request=ServletActionContext.getRequest();
				String prisonId = (String) request.getSession().getAttribute("prisonId");
				PrisonInfo pi =prisonService.prisonInfoDetail(prisonId);
				pi.setPrisonImage(buff);
				prisonService.prisonInfoUpdate(pi);
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		// 添加日志
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(prisoninfo, config.getInsert(), operate, config.getPrisonInfo(), config.getSucceed(), request);
		log.getInsertLogMessage(user, config.getInsert(), operate, config.getUser(), config.getSucceed(), request);
		return "detail";
	}
	
	/**
	 * 查询一条拘留所的信息
	 * **/
	public String detail() {
		prisoninfo = prisonService.prisonInfoDetail(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		String type=(String)request.getSession().getAttribute("orgType");
		if("2".equals(type)){
			return "stinfoDetail";
		}else{
			return "infoDetail";
		}
		
	}
	
	/**
	 * 废弃一条拘留所的信息
	 * **/
	public String delInfo() {
		prisonService.prisonInfoDel(id) ;
		// 添加日志
		PrisonInfo object = new PrisonInfo();
		object.setId(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "删除成功。";
		log.getModifyLogMessage(null, object, config.getDelete(), operate, config.getPrisonInfo(), config.getSucceed(), request);
		return "select";
	}
	
	/**
	 * 启用一个拘留所
	 * **/
	public String startPrison() {
		prisonService.prisonInfoStart(id);
		return "select";
	}
	
	/**
	 * 修改一条拘留所的信息
	 * **/
	public String updateInfo() {
		PrisonInfo obj = prisonService.prisonInfoDetail(prisoninfo.getId());
		PrisonInfo old_obj = prisonService.prisonInfoDetail(prisoninfo.getId());
		ObjectUpdateUtil.compareProperty(prisoninfo, obj);
		if(prisonImage != null){
			try {
				InputStream inputStream = new FileInputStream(prisonImage);
				int fileSize = (int) prisonImage.length();
				byte[] buff= new byte[fileSize];
				inputStream.read(buff, 0, fileSize);
				 
				obj.setPrisonImage(buff);
				inputStream.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		prisonService.prisonInfoUpdate(obj);
		id = prisoninfo.getId();
		
		// 添加日志
		
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。";
		log.getModifyLogMessage(obj, old_obj, config.getUpdate(), operate, config.getPrisonInfo(), config.getSucceed(), request);
		return "detail";
	}
	
	/**
	 * 进入添加页面
	 * **/
	public String interInfoAdd() {
		levAndSize();
		getPoliceLis();
		areaList = dictionaryService.getAllAreaList();
		return "infoAdd";
	}
	
	/**
	 * 进入修改页面
	 * **/
	public String interInfoEdit() {
		levAndSize();
		areaList = dictionaryService.getAllAreaList();
		prisoninfo = prisonService.prisonInfoDetail(id);
		return "infoEdit";
	}
	
	/**
	 * 查询拘留所等级列表和规模列表
	 * **/
	public void levAndSize() {
		orgList = organizationService.getOrgTwoList();
		prisonLevel=dictionaryService.selectDictionary(Type.LEVELTYPE);
		prisonSize=dictionaryService.selectDictionary(Type.SIZETYPE);
	}
	
	/**
	 * 读取警员信息
	 * @return
	 */
	public void getPoliceLis(){
		plic = organizationService.getPoliceList();		
	}
	
	public LogFactory getLog() {
		return log;
	}

	public void setLog(LogFactory log) {
		this.log = log;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public DictionaryService getDictionaryService() {
		return dictionaryService;
	}

	public void setDictionaryService(DictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}

	public String getPriNum() {
		return priNum;
	}

	public void setPriNum(String priNum) {
		this.priNum = priNum;
	}

	public String getPriName() {
		return priName;
	}

	public void setPriName(String priName) {
		this.priName = priName;
	}

	public String getPriLevel() {
		return priLevel;
	}

	public void setPriLevel(String priLevel) {
		this.priLevel = priLevel;
	}

	public String getPriSize() {
		return priSize;
	}

	public void setPriSize(String priSize) {
		this.priSize = priSize;
	}

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public List<Dictionary> getPrisonLevel() {
		return prisonLevel;
	}

	public void setPrisonLevel(List<Dictionary> prisonLevel) {
		this.prisonLevel = prisonLevel;
	}

	public List<Dictionary> getPrisonSize() {
		return prisonSize;
	}

	public void setPrisonSize(List<Dictionary> prisonSize) {
		this.prisonSize = prisonSize;
	}
	public PrisonInfoService getPrisonService() {
		return prisonService;
	}

	public void setPrisonService(PrisonInfoService prisonService) {
		this.prisonService = prisonService;
	}

	public List<PrisonInfo> getPrisonInfolist() {
		return prisonInfolist;
	}

	public void setPrisonInfolist(List<PrisonInfo> prisonInfolist) {
		this.prisonInfolist = prisonInfolist;
	}

	public PrisonInfo getPrisoninfo() {
		return prisoninfo;
	}

	public void setPrisoninfo(PrisonInfo prisoninfo) {
		this.prisoninfo = prisoninfo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Map<Area, List<Area>> getAreaList() {
		return areaList;
	}

	public void setAreaList(Map<Area, List<Area>> areaList) {
		this.areaList = areaList;
	}

	public List<Organization> getOrgList() {
		return orgList;
	}

	public void setOrgList(List<Organization> orgList) {
		this.orgList = orgList;
	}

	public OrganizationService getOrganizationService() {
		return organizationService;
	}

	public void setOrganizationService(OrganizationService organizationService) {
		this.organizationService = organizationService;
	}

}
