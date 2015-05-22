package com.hoyotech.prison.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.Dictionary;
import com.hoyotech.prison.bean.Medical;
import com.hoyotech.prison.bean.Peoples;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.DictionaryService;
import com.hoyotech.prison.service.impl.MedicalService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.ObjectUpdateUtil;
import com.hoyotech.prison.util.PrisonUtil;
import com.hoyotech.prison.util.Type;
import com.isa.pims.basic.ServletRequestUtils;
import com.opensymphony.xwork2.ActionSupport;

public class MedicalAction extends ActionSupport {

	MedicalService medicalService;
	DictionaryService dictionaryService;
	private List<Medical> medlist;
	private Medical medical;
	private int pageNum;
	private int limit; 
	private int totalPage;
	private int totalNum;
	private String id;
	private String name; //姓名
	private String titles; //职称
	private String workstatus; //工作状态
	private String gender; //性别
	
	private List<Dictionary> genders;
	private List<Peoples> peoples;
	private List<Dictionary> politicals;
	private List<Dictionary> educations;
	private List<Dictionary> works;
	private String workState;
	
	private LogFactory log;
	
	/**
	 * 查询所有医务人员的信息
	 * **/
	public String select() {
		works=dictionaryService.selectDictionary(Type.WORKTYPE);
		genders=dictionaryService.selectDictionary(Type.GENDERTYPE);
		HttpServletRequest request=ServletActionContext.getRequest();
		pageNum = ServletRequestUtils.getInt(request, "page","1");
		limit = ServletRequestUtils.getInt(request, "limit","20");
		String prisonCode=PrisonUtil.getPrisonCode(request);
		medlist = medicalService.allmedical(name, titles, workstatus, gender,workState, pageNum, limit,prisonCode);
		totalNum=medicalService.countMedical(name, titles, workstatus, gender,workState,prisonCode);
		totalPage=(totalNum-1)/limit+1;
		return "List";
	}
	
	/**
	 * 添加一条医务人员的信息
	 * **/
	public String add() {
		HttpServletRequest request = ServletActionContext.getRequest();
		medical.setPrisonCode(PrisonUtil.getPrisonCode(request));
		id = medicalService.addMedical(medical); //添加数据得到id
		
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(medical, config.getInsert(), operate, config.getMedical(), config.getSucceed(), request);
		return "detail";
	}

	/**
	 * 查询一条医务人员的信息,返回到详细页面
	 * **/
	public String detailMedical() {
		medical=medicalService.medicalDetail(id);
		return "Detail";
	}
	
	/**
	 * 删除一条医务人员的信息
	 * **/
	public String delete() {
		medicalService.medDel(id);
		
		// 添加日志
		Medical object = new Medical();
		object.setId(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "删除成功。";
		log.getModifyLogMessage(null, object, config.getDelete(), operate, config.getMedical(), config.getSucceed(), request);
		return "select";
	}
	
	/**
	 * 修改一条医务人员的信息
	 * **/
	public String update() {
		Medical obj = medicalService.medicalDetail(medical.getId());
		Medical old_obj = medicalService.medicalDetail(medical.getId());
		ObjectUpdateUtil.compareProperty(medical, obj);
		
		medicalService.medUpdate(obj);
		id=medical.getId();
		
		// 添加日志
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。";
		log.getModifyLogMessage(obj, old_obj, config.getUpdate(), operate, config.getMedical(), config.getSucceed(), request);
		return "detail";
	}
	
	/**
	 * 进入添加页面
	 * **/
	public String interMedAdd() {
		selectDictionay();
		return "Add";
	}
	
	/**
	 * 进入修改页面
	 * **/
	public String interMedEdit() {
		selectDictionay();
		medical=medicalService.medicalDetail(id);
		return "Edit";
	}

	/**
	 * 从数据字典查询下拉列表选项
	 * **/
	public void selectDictionay(){
	     genders=dictionaryService.selectDictionary(Type.GENDERTYPE);
		 peoples=dictionaryService.selectPeoples(1);
		 politicals=dictionaryService.selectDictionary(Type.POLITICALTYPE);
		 educations=dictionaryService.selectDictionary(Type.EDUCATYPE);
		 works=dictionaryService.selectDictionary(Type.WORK_TYPE);
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

	public DictionaryService getDictionaryService() {
		return dictionaryService;
	}

	public void setDictionaryService(DictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}

	public MedicalService getMedicalService() {
		return medicalService;
	}

	public void setMedicalService(MedicalService medicalService) {
		this.medicalService = medicalService;
	}

	public List<Medical> getMedlist() {
		return medlist;
	}

	public void setMedlist(List<Medical> medlist) {
		this.medlist = medlist;
	}

	public Medical getMedical() {
		return medical;
	}

	public void setMedical(Medical medical) {
		this.medical = medical;
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

	public String getTitles() {
		return titles;
	}

	public void setTitles(String titles) {
		this.titles = titles;
	}

	public String getWorkstatus() {
		return workstatus;
	}

	public void setWorkstatus(String workstatus) {
		this.workstatus = workstatus;
	}

	

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public List<Dictionary> getWorks() {
		return works;
	}

	public void setWorks(List<Dictionary> works) {
		this.works = works;
	}
	
	

	
}
