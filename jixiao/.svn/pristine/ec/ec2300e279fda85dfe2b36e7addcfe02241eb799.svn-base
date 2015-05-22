package com.hoyotech.prison.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.Dictionary;
import com.hoyotech.prison.bean.Logistic;
import com.hoyotech.prison.bean.Peoples;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.DictionaryService;
import com.hoyotech.prison.service.impl.LogisticService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.ObjectUpdateUtil;
import com.hoyotech.prison.util.PrisonUtil;
import com.hoyotech.prison.util.Type;
import com.isa.pims.basic.ServletRequestUtils;

public class LogisticAction {

	LogisticService logiService;
	DictionaryService dictionaryService;
	private List<Logistic> logiList;
	private Logistic logistic;
	private int pageNum;
	private int limit; 
	private int totalPage;
	private int totalNum;
	private String id;
	private String name; //姓名
	private String gender; //性别
	private String education;//学历 
	private String workState;
	
	private List<Dictionary> genders;
	private List<Peoples> peoples;
	private List<Dictionary> politicals;
	private List<Dictionary> educations;
	private List<Dictionary> marryStatus;
	
	private LogFactory log;
	/**
	 * 查询所有工勤人员的信息
	 * **/
	public String select() {
		genders=dictionaryService.selectDictionary(Type.GENDERTYPE);
		educations=dictionaryService.selectDictionary(Type.EDUCATYPE);
		HttpServletRequest request=ServletActionContext.getRequest();
		pageNum = ServletRequestUtils.getInt(request, "page","1");
		limit = ServletRequestUtils.getInt(request, "limit","20");
		String prisonCode=PrisonUtil.getPrisonCode(request);
		logiList = logiService.alllogistic(name, gender, education,workState, pageNum, limit,prisonCode); 
		totalNum=logiService.countLogistic(name, gender, education,workState,prisonCode);
		totalPage=(totalNum-1)/limit+1;
		return "List";
	}
	
	/**
	 * 添加一条工勤人员的信息
	 * **/
	public String add() {
		HttpServletRequest request = ServletActionContext.getRequest();
		logistic.setPrisonCode(PrisonUtil.getPrisonCode(request));
		id = logiService.addLogistic(logistic);  //添加数据得到id
		
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(logistic, config.getInsert(), operate, config.getLogistic(), config.getSucceed(), request);
		return "detail";
	}

	/**
	 * 查询一条工勤人员的信息,返回到详细页面
	 * **/
	public String detail() {
		logistic=logiService.logiDetail(id);
		return "Detail";
	}
	
	/**
	 * 删除一条工勤人员的信息
	 * **/
	public String delete() {
		logiService.logiDel(id);
		
		// 添加日志
		Logistic object = new Logistic();
		object.setId(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "删除成功。";
		log.getModifyLogMessage(null, object, config.getDelete(), operate, config.getLogistic(), config.getSucceed(), request);
		return "select";
	}
	
	/**
	 * 修改一条工勤人员的信息
	 * **/
	public String update() {
		//logistic.setUpdateTime(new Date());
		Logistic obj = logiService.logiDetail(logistic.getId());
		Logistic old_obj = logiService.logiDetail(logistic.getId());
		ObjectUpdateUtil.compareProperty(logistic, obj);
		logiService.logiUpdate(obj);
		id=logistic.getId();
		
		// 添加日志
		
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。";
		log.getModifyLogMessage(obj, old_obj, config.getUpdate(), operate, config.getLogistic(), config.getSucceed(), request);
		return "detail";
	}
	
	/**
	 * 进入添加页面
	 * **/
	public String interLogiAdd() {
		selectDictionay();
		return "Add";
	}
	
	/**
	 * 进入修改页面
	 * **/
	public String interLogiEdit() {
		selectDictionay();
		logistic=logiService.logiDetail(id); 
		return "Edit";
	}

	/**
	 * 从数据字典查询下拉列表选项
	 * **/
	public void selectDictionay(){
	     genders=dictionaryService.selectDictionary(Type.GENDERTYPE);
		 peoples=dictionaryService.selectPeoples(1);
		 marryStatus=dictionaryService.selectDictionary(Type.MARRYTYPE);
		 politicals=dictionaryService.selectDictionary(Type.POLITICALTYPE);
		 educations=dictionaryService.selectDictionary(Type.EDUCATYPE);
		
	}

	
	public String getWorkState() {
		return workState;
	}

	public void setWorkState(String workState) {
		this.workState = workState;
	}

	public LogFactory getLog() {
		return log;
	}

	public void setLog(LogFactory log) {
		this.log = log;
	}

	public LogisticService getLogiService() {
		return logiService;
	}

	public void setLogiService(LogisticService logiService) {
		this.logiService = logiService;
	}

	public DictionaryService getDictionaryService() {
		return dictionaryService;
	}

	public void setDictionaryService(DictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}

	public List<Logistic> getLogiList() {
		return logiList;
	}

	public void setLogiList(List<Logistic> logiList) {
		this.logiList = logiList;
	}

	public Logistic getLogistic() {
		return logistic;
	}

	public void setLogistic(Logistic logistic) {
		this.logistic = logistic;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public List<Dictionary> getGenders() {
		return genders;
	}

	public void setGenders(List<Dictionary> genders) {
		this.genders = genders;
	}

	public List<Peoples> getPeoples() {
		return peoples;
	}

	public void setPeoples(List<Peoples> peoples) {
		this.peoples = peoples;
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

	public List<Dictionary> getMarryStatus() {
		return marryStatus;
	}

	public void setMarryStatus(List<Dictionary> marryStatus) {
		this.marryStatus = marryStatus;
	}

	
}
