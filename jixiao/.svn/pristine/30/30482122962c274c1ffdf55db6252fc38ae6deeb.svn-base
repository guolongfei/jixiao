package com.hoyotech.prison.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.hoyotech.prison.bean.Dictionary;
import com.hoyotech.prison.bean.Police;
import com.hoyotech.prison.bean.PrisonInfo;
import com.hoyotech.prison.bean.Role;
import com.hoyotech.prison.bean.User;
import com.hoyotech.prison.bean.PrisonInfo;
import com.hoyotech.prison.bean.UserRole;
import com.hoyotech.prison.bean.UserPowerZD;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.DictionaryService;
import com.hoyotech.prison.service.impl.PoliceService;
import com.hoyotech.prison.service.impl.UserService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.ObjectUpdateUtil;
import com.hoyotech.prison.util.PrisonUtil;
import com.hoyotech.prison.util.Type;
import com.isa.pims.basic.ServletRequestUtils;
import com.isa.pims.basic.StringUtils;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

	UserService userService;
	DictionaryService dictionaryService;
	private List<User> users;
	private List<Role> roles;
	private String[] roleIds;
	private User user;
	private String user_id; 
	private int pageNum;
	private int limit; 
	private int totalPage;
	private int totalNum;
	private String id;
	private String idp;
	private String zuzhi;
	private String zhanghao;
	private String name;
	private String useState;
	private String checkstring;
	private List<Dictionary> genders;
	private List<Dictionary> politicals;
	private List<Dictionary> educations;
	private List<Police> policelist;
	private List<PrisonInfo> prisoninfolist;	
	PoliceService policeService;
	private Police police;
	private LogFactory log;
	private PrisonInfo prisoninfo;
	private String checkr;
	private UserPowerZD upzd;
	private UserRole ur;
	private String userPower;

	public String getUserPower() {
		return userPower;
	}

	public void setUserPower(String userPower) {
		this.userPower = userPower;
	}

	public UserRole getUr() {
		return ur;
	}

	public void setUr(UserRole ur) {
		this.ur = ur;
	}

	public UserPowerZD getUpzd() {
		return upzd;
	}

	public void setUpzd(UserPowerZD upzd) {
		this.upzd = upzd;
	}

	public String getCheckr() {
		return checkr;
	}

	public void setCheckr(String checkr) {
		this.checkr = checkr;
	}

	public void selectPolice(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode=PrisonUtil.getPrisonCode(request);
		policelist=dictionaryService.selectPolice(prisonCode);
	}
	
	/**
	 * 查询所有用户的信息
	 * **/
	public String select() {
		HttpServletRequest request = ServletActionContext.getRequest();
		pageNum = ServletRequestUtils.getInt(request, "page", "1");
		limit = ServletRequestUtils.getInt(request, "limit", "20");
		String prisonCode=PrisonUtil.getPrisonCode(request);
		users = userService.list(zuzhi, zhanghao, name,useState,pageNum, limit,prisonCode);
		totalNum = userService.count(zuzhi, zhanghao, name,useState,prisonCode);
		totalPage = (totalNum - 1) / limit + 1;
		
		String type=(String)request.getSession().getAttribute("orgType");
		if("2".equals(type)){
			return "stList";
		}else{
			return "List";
		}
		
	}
	
	public String editPWD(){
		user = userService.detail(user_id);
		return "PWD_Edit";
	}
	
	/*
	 * 查询所有支队用户的信息
	 * */
	public String selectZD(){
		HttpServletRequest request = ServletActionContext.getRequest();
		pageNum = ServletRequestUtils.getInt(request, "page", "1");
		limit = ServletRequestUtils.getInt(request, "limit", "20");
		String prisonCode=PrisonUtil.getPrisonCode(request);
		users = userService.listZD(zuzhi, zhanghao, name,useState,pageNum, limit,prisonCode);
		totalNum = userService.count(zuzhi, zhanghao, name,useState,prisonCode);
		totalPage = (totalNum - 1) / limit + 1;
		return "listZD";
	}

	/**
	 * 添加一条用户的信息
	 * **/
	public String add() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String type=(String)request.getSession().getAttribute("orgType");
		PrisonInfo prison = new PrisonInfo();
		if("2".equals(type)){
			user.setPrison(null);
		}else{
			prison.setId(PrisonUtil.getPrisonId(request));
			user.setPrison(prison);
			
		}
		user.setPrisonCode(PrisonUtil.getPrisonCode(request));
		String organize=StringUtils.$C(type,"");
		user.setOrganizeType(organize);
		id = userService.add(user); // 添加数据得到id
		
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(user, config.getInsert(), operate, config.getUser(), config.getSucceed(), request);
		
		
		return "detail";
	}
	
	/*
	 * 添加一条支队用户信息
	 * */
	public String addZD(){		
		String strpname=police.getName();
		police.setName(policeService.addZD(police));
		user.setName(police);
		user.setOrganizeType("3");
		id = userService.add(user);
		police.setName(strpname);
		upzd = new UserPowerZD();
		upzd.setUserId(id);
		userService.addPowerZD(upzd);
		ur=new UserRole();
		ur.setIsSync(0);
		ur.setUserId(id);
		userService.addRolePowerZD(ur);
		return "detailZD";		
	}
	
	/*
	 * 进入设置支队权限界面
	 * */
	public String PowerEditZD(){
		userPower=userService.getUserPowerStr(id);
		return "intouserPowerEdit";
	}
	
	/*
	 * 查询所有拘留所信息
	 * */
	public void PowerEditZDAjax(){
		List list=userService.getUsingPrisonInfo();
		
		// id,prisonCode,prisonName
		StringBuilder sb = new StringBuilder("{\"pridata\":[");
		for(Iterator<Object[]> it = list.iterator();it.hasNext();){
			Object[] objs = it.next();
			sb.append("{\"id\":\""+objs[0]+"\"," +
					"\"prisonCode\":\""+objs[1]+"\"," +					
					"\"prisonName\":\""+objs[2]+"\"}");
			if(it.hasNext()){
				sb.append(",");
			}
		}
		sb.append("]}");

		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		try {
			PrintWriter out = response.getWriter();
			out.println(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 更新支队权限
	 * */
	 public String PowerSaveZDAjax(){
		 userService.updatePowerZD(upzd);
		 
		 HttpServletRequest request = ServletActionContext.getRequest();
		 pageNum = ServletRequestUtils.getInt(request, "page", "1");
		 limit = ServletRequestUtils.getInt(request, "limit", "20");
		 String prisonCode=PrisonUtil.getPrisonCode(request);
		 users = userService.listZD(zuzhi, zhanghao, name,useState,pageNum, limit,prisonCode);
		 totalNum = userService.count(zuzhi, zhanghao, name,useState,prisonCode);
		 totalPage = (totalNum - 1) / limit + 1;
		 return "listZD";
	 }

	/**
	 * 查询一条用户的信息
	 * **/
	public String detail() {
		user = userService.detail(id);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String type=(String)request.getSession().getAttribute("orgType");
		if("2".equals(type)){
			return "stDetail";
		}else{
			return "Detail";
		}
		
	}
	
	/*
	 * 查询一条支队用户信息
	 * */
	public String detailZD(){
		user = userService.detail(id);
		return "detailZD";
	}

	/**
	 * 删除一条用户的信息
	 * **/
	public String delete() {
		userService.delete(id);
		
		// 添加日志
		User object = new User();
		object.setId(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "删除成功。";
		log.getModifyLogMessage(null, object, config.getDelete(), operate, config.getUser(), config.getSucceed(), request);
		return "select";
	}
	
	/**
	 * 删除一条支队用户的信息
	 * **/
	public String deleteZD() {
		userService.delete(id);
		
		// 添加日志
		User object = new User();
		object.setId(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "删除成功。";
		log.getModifyLogMessage(null, object, config.getDelete(), operate, config.getUser(), config.getSucceed(), request);
		return "listZD";
	}

	/**
	 * 修改一条用户的信息
	 * **/
	public String update() {
		User obj = userService.detail(user.getId());
		User old_obj = userService.detail(user.getId());
		ObjectUpdateUtil.compareProperty(user, obj);
		userService.update(obj);
		id = user.getId();
		
		// 添加日志
		
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。";
		log.getModifyLogMessage(obj, old_obj, config.getUpdate(), operate, config.getUser(), config.getSucceed(), request);
		return "detail";
	}
	
	/*
	 * 修改一条支队用户信息
	 * */
	public String updateZD(){
		User obj = userService.detail(user.getId());
		User old_obj = userService.detail(user.getId());
		ObjectUpdateUtil.compareProperty(user, obj);
		userService.updateZD(user.getName().getId(),user.getName().getName(),obj);
		
		// 添加日志
		
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。";
		log.getModifyLogMessage(obj, old_obj, config.getUpdate(), operate, config.getUser(), config.getSucceed(), request);
		return "detailZD";
	}
	
	/**
	 * 修改用户密码    2014年11月26日  刘泉
	 * **/
	public void changeUserPassword(){
		System.out.println(user.getId());
		System.out.println(user.getPassword());
		User obj = userService.detail(user.getId());		
		ObjectUpdateUtil.compareProperty(user, obj);
		userService.update(obj);
	}

	/**
	 * 进入添加页面
	 * **/
	public String interAdd() {
		selectPolice();
		selectDictionay();
		return "Add";
	}
	
	/*
	 * 进入添加支队用户界面
	 * */
	public String interAddZD(){
		return "AddZD";		
	}

	
	/**
	 * 进入修改页面
	 * **/
	public String interEdit() {
		selectPolice();
		user = userService.detail(id);
		selectDictionay();
		return "Edit";
	}
	
	/*
	 * 进入支队修改界面
	 * */
	public String interEditZD(){
		user = userService.detail(id);
		return "editZD";
	}

	/**
	 * 从数据字典查询下拉列表选项
	 * **/
	@SkipValidation
	public void selectDictionay(){
	     genders=dictionaryService.selectDictionary(Type.GENDERTYPE);
		 politicals=dictionaryService.selectDictionary(Type.POLITICALTYPE);
		 educations=dictionaryService.selectDictionary(Type.EDUCATYPE);
	}
	
	/**
	 * 进入角色修改页面
	 * **/
	public String roleEdit() {
		user = userService.detail(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		String orgType=StringUtils.$C((String)request.getSession().getAttribute("orgType"),"");
		String prisonCode=PrisonUtil.getPrisonCode(request);
		roles=userService.roleList(orgType,prisonCode);
		checkstring="";
		for(UserRole i:user.getRoles()){
			checkstring=checkstring+i.getRoleId().getId()+"," ;
		}
		String type=(String)request.getSession().getAttribute("orgType");
		if("2".equals(type)){
			return "stroleedit";
		}else{
			return "roleedit";
		}
		
	}
	
	/**
	 * 修改角色
	 * **/
	public String updateRole() {
		userService.updateRole(id,roleIds);
		
		// 添加日志
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。修改了用户id为"+id+"的角色";
		log.getModifyLogMessage(null, null, config.getUpdate(), operate, config.getUser(), config.getSucceed(), request);
		return "detail";
	}
	
	public List<Police> getPolicelist() {
		return policelist;
	}

	public void setPolicelist(List<Police> policelist) {
		this.policelist = policelist;
	}

	public LogFactory getLog() {
		return log;
	}

	public void setLog(LogFactory log) {
		this.log = log;
	}

	public String getCheckstring() {
		return checkstring;
	}

	public void setCheckstring(String checkstring) {
		this.checkstring = checkstring;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String[] getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String[] roleIds) {
		this.roleIds = roleIds;
	}

	public DictionaryService getDictionaryService() {
		return dictionaryService;
	}

	public void setDictionaryService(DictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}

	public List<Dictionary> getGenders() {
		return genders;
	}

	public void setGenders(List<Dictionary> genders) {
		this.genders = genders;
	}

	public List<Dictionary> getPoliticals() {
		return politicals;
	}

	public void setPoliticals(List<Dictionary> politicals) {
		this.politicals = politicals;
	}

	public List<Dictionary> getEducations() {
		return educations;
	}

	public void setEducations(List<Dictionary> educations) {
		this.educations = educations;
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

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getZuzhi() {
		return zuzhi;
	}

	public void setZuzhi(String zuzhi) {
		this.zuzhi = zuzhi;
	}

	public String getZhanghao() {
		return zhanghao;
	}

	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUseState() {
		return useState;
	}

	public void setUseState(String useState) {
		this.useState = useState;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String userId) {
		user_id = userId;
	}
	
	public String getIdp() {
		return idp;
	}

	public void setIdp(String idp) {
		this.idp = idp;
	}
	public Police getPolice() {
		return police;
	}

	public void setPolice(Police police) {
		this.police = police;
	}

	public PoliceService getPoliceService() {
		return policeService;
	}

	public void setPoliceService(PoliceService policeService) {
		this.policeService = policeService;
	}
	
	public PrisonInfo getPrisoninfo() {
		return prisoninfo;
	}

	public void setPrisoninfo(PrisonInfo prisoninfo) {
		this.prisoninfo = prisoninfo;
	}
	public List<PrisonInfo> getPrisoninfolist() {
		return prisoninfolist;
	}

	public void setPrisoninfolist(List<PrisonInfo> prisoninfolist) {
		this.prisoninfolist = prisoninfolist;
	}

}
