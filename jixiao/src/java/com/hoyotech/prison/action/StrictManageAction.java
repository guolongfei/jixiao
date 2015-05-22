package com.hoyotech.prison.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.Dictionary;
import com.hoyotech.prison.bean.Police;
import com.hoyotech.prison.bean.Prisoner;
import com.hoyotech.prison.bean.StrictManage;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.DictionaryService;
import com.hoyotech.prison.service.impl.StrictManageService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.ObjectUpdateUtil;
import com.hoyotech.prison.util.PrisonUtil;
import com.hoyotech.prison.util.Type;
import com.isa.pims.basic.ServletRequestUtils;

public class StrictManageAction {

	StrictManageService strictManageService;
	private DictionaryService dictionaryService;
	private List<StrictManage> strictManagelist;
	private StrictManage strictManage;
	private int pageNum;
	private int limit; 
	private int totalPage;
	private int totalNum;
	private String id ;
	private String name; //姓名
	private Date time; 
	
	private LogFactory log;
	
	private List<Dictionary> gender;
	private List<Prisoner> prisonerlist;
	private List<Police> policelist;
	
	public void selectPolice(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode=PrisonUtil.getPrisonCode(request);
		policelist=dictionaryService.selectPolice(prisonCode);
	}
	
	/**
	 * 严管登记信息-打印（台账）
	 * **/
	public String print() {
		HttpServletRequest request=ServletActionContext.getRequest();
		pageNum = ServletRequestUtils.getInt(request, "page","1");
		limit = ServletRequestUtils.getInt(request, "limit","20");
		String prisonCode=PrisonUtil.getPrisonCode(request);
		strictManagelist = strictManageService.list(name, time, pageNum, limit,prisonCode);
		totalNum=strictManageService.count(name, time,prisonCode);
		totalPage=(totalNum-1)/limit+1;
		return "ListPrint";
	}
	
	/**
	 * 查询所有严管登记信息
	 * **/
	public String select() {
		HttpServletRequest request=ServletActionContext.getRequest();
		pageNum = ServletRequestUtils.getInt(request, "page","1");
		limit = ServletRequestUtils.getInt(request, "limit","20");
		String prisonCode=PrisonUtil.getPrisonCode(request);
		strictManagelist = strictManageService.list(name, time, pageNum, limit,prisonCode);
		totalNum=strictManageService.count(name, time,prisonCode);
		totalPage=(totalNum-1)/limit+1;
		return "List";
	}
	
	/**
	 * 添加一条严管登记信息
	 * **/
	public String add() {
		HttpServletRequest request = ServletActionContext.getRequest();
		strictManage.setPrisonCode(PrisonUtil.getPrisonCode(request));
		id = strictManageService.add(strictManage); //添加数据得到id
		
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(strictManage, config.getInsert(), operate, config.getStrictManage(), config.getSucceed(), request);
		return "detail";
	}

	/**
	 * 查询一条严管登记信息,返回到详细页面
	 * **/
	public String detail() {
		strictManage = strictManageService.detail(id);
		return "Detail";
	}
	
	/**
	 * 删除一条严管登记信息
	 * **/
	public String delete() {
		strictManageService.delete(id);
		
		// 添加日志
		StrictManage object = new StrictManage();
		object.setId(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "删除成功。";
		log.getModifyLogMessage(null, object, config.getDelete(), operate, config.getStrictManage(), config.getSucceed(), request);
		return "select";
	}
	
	/**
	 * 修改一条严管登记信息
	 * **/
	public String update() {
		StrictManage obj = strictManageService.detail(strictManage.getId());
		StrictManage old_obj = strictManageService.detail(strictManage.getId());
		ObjectUpdateUtil.compareProperty(strictManage, obj);
		
		strictManageService.update(obj);
		id=strictManage.getId();
		
		// 添加日志
		
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。";
		log.getModifyLogMessage(obj, old_obj, config.getUpdate(), operate, config.getStrictManage(), config.getSucceed(), request);
		return "detail";
	}
	
	/**
	 * 进入添加页面
	 * **/
	public String interAdd() {
		selectPrisoner();
		selectPolice();
		gender = dictionaryService.selectDictionary(Type.GENDERTYPE);
		return "Add";
	}
	
	/**
	 * 进入修改页面
	 * **/
	public String interEdit() {
		selectPrisoner();
		selectPolice();
		gender = dictionaryService.selectDictionary(Type.GENDERTYPE);
		strictManage=strictManageService.detail(id);
		return "Edit";
	}
	
	public void selectPrisoner(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode=PrisonUtil.getPrisonCode(request);
		prisonerlist=dictionaryService.selectPrisoner(prisonCode);
	}
	
	public List<Police> getPolicelist() {
		return policelist;
	}

	public void setPolicelist(List<Police> policelist) {
		this.policelist = policelist;
	}

	public List<Prisoner> getPrisonerlist() {
		return prisonerlist;
	}

	public void setPrisonerlist(List<Prisoner> prisonerlist) {
		this.prisonerlist = prisonerlist;
	}

	public LogFactory getLog() {
		return log;
	}

	public void setLog(LogFactory log) {
		this.log = log;
	}

	public StrictManageService getStrictManageService() {
		return strictManageService;
	}

	public void setStrictManageService(StrictManageService strictManageService) {
		this.strictManageService = strictManageService;
	}

	public DictionaryService getDictionaryService() {
		return dictionaryService;
	}

	public void setDictionaryService(DictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}

	public List<StrictManage> getStrictManagelist() {
		return strictManagelist;
	}

	public void setStrictManagelist(List<StrictManage> strictManagelist) {
		this.strictManagelist = strictManagelist;
	}

	public StrictManage getStrictManage() {
		return strictManage;
	}

	public void setStrictManage(StrictManage strictManage) {
		this.strictManage = strictManage;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public List<Dictionary> getGender() {
		return gender;
	}

	public void setGender(List<Dictionary> gender) {
		this.gender = gender;
	}
	
	
}
