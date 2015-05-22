package com.hoyotech.prison.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.Dictionary;
import com.hoyotech.prison.bean.Peoples;
import com.hoyotech.prison.bean.Police;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.DictionaryService;
import com.hoyotech.prison.service.impl.PoliceService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.ObjectUpdateUtil;
import com.hoyotech.prison.util.PrisonUtil;
import com.hoyotech.prison.util.Type;
import com.isa.pims.basic.ServletRequestUtils;

public class PoliceAction {
	DictionaryService dictionaryService;
	PoliceService policeService;
	private List<Police> list;
	private Police police;
	private int pageNum;
	private int limit; 
	private int totalPage;
	private int totalNum;
	private String id ;
	
	private List<Dictionary> genderList;
	private List<Peoples> peoplesList;
	private List<Dictionary> politicalList;
	private List<Dictionary> educationalList;
	private List<Dictionary> postList;
	private List<Dictionary> originList;
	private List<Dictionary> statusList;
	
	// 检索条件
	private String policeNumber;
	private String name;
	private String gender;
	private String peoples;
	private String workState;
	
	private LogFactory log;
	
	public String list(){
		HttpServletRequest request = ServletActionContext.getRequest();
		pageNum = ServletRequestUtils.getInt(request, "page","1");
		limit = ServletRequestUtils.getInt(request, "limit","20");
		String prisonCode=PrisonUtil.getPrisonCode(request);
		list = policeService.getList(policeNumber, name, gender, peoples,workState, pageNum, limit,prisonCode);
		totalNum = policeService.getCount(policeNumber, name, gender, peoples,workState,prisonCode);
		
		totalPage=(totalNum-1)/limit+1;
		
		genderList = dictionaryService.selectDictionary(Type.GENDERTYPE);
		peoplesList = dictionaryService.selectPeoples(1);
		return "list";
	}
	
	public String addUI(){
		initDict();
		return "addUI";
	}
	public String editUI(){
		initDict();
		police = policeService.detail(id);
		return "edit";
	}
	
	public String add(){
		HttpServletRequest request = ServletActionContext.getRequest();
		police.setPrisonCode(PrisonUtil.getPrisonCode(request));
		id = policeService.add(police);
		
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(police, config.getInsert(), operate, config.getPolice(), config.getSucceed(), request);
		return "Detail";
	}
	
	public String update(){
		Police old_obj = policeService.detail(police.getId());
		Police obj = policeService.detail(police.getId());
		ObjectUpdateUtil.compareProperty(police, obj);
		
		policeService.update(obj);
		id=police.getId();
		
		// 添加日志
		
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。";
		log.getModifyLogMessage(obj, old_obj, config.getUpdate(), operate, config.getPolice(), config.getSucceed(), request);
		return "Detail";
	}
	
	public String detail(){
		police = policeService.detail(id);
		return "detail";
	}
	
	public String delete(){
		policeService.delete(id);
		
		// 添加日志
		Police object = new Police();
		object.setId(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "删除成功。";
		log.getModifyLogMessage(null, object, config.getDelete(), operate, config.getPolice(), config.getSucceed(), request);
		return "select";
	}

	/**
	 * 查询数据字典
	 * **/
	public void initDict() {
		genderList = dictionaryService.selectDictionary(Type.GENDERTYPE);
		peoplesList = dictionaryService.selectPeoples(1);
		politicalList = dictionaryService.selectDictionary(Type.POLITICALTYPE);
		educationalList = dictionaryService.selectDictionary(Type.EDUCATYPE);
		postList = dictionaryService.selectDictionary(Type.POST_TYPE);
		originList = dictionaryService.selectDictionary(Type.ADDRESSTYPE);
		statusList = dictionaryService.selectDictionary(Type.STATUS_TYPE);
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

	public PoliceService getPoliceService() {
		return policeService;
	}

	public void setPoliceService(PoliceService policeService) {
		this.policeService = policeService;
	}

	public List<Police> getList() {
		return list;
	}

	public void setList(List<Police> list) {
		this.list = list;
	}

	public Police getPolice() {
		return police;
	}

	public void setPolice(Police police) {
		this.police = police;
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

	public String getPoliceNumber() {
		return policeNumber;
	}

	public void setPoliceNumber(String policeNumber) {
		this.policeNumber = policeNumber;
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

	public String getPeoples() {
		return peoples;
	}

	public void setPeoples(String peoples) {
		this.peoples = peoples;
	}

	public List<Dictionary> getGenderList() {
		return genderList;
	}

	public void setGenderList(List<Dictionary> genderList) {
		this.genderList = genderList;
	}

	public List<Peoples> getPeoplesList() {
		return peoplesList;
	}

	public void setPeoplesList(List<Peoples> peoplesList) {
		this.peoplesList = peoplesList;
	}

	public List<Dictionary> getPoliticalList() {
		return politicalList;
	}

	public void setPoliticalList(List<Dictionary> politicalList) {
		this.politicalList = politicalList;
	}

	public List<Dictionary> getEducationalList() {
		return educationalList;
	}

	public void setEducationalList(List<Dictionary> educationalList) {
		this.educationalList = educationalList;
	}

	public List<Dictionary> getPostList() {
		return postList;
	}

	public void setPostList(List<Dictionary> postList) {
		this.postList = postList;
	}

	public List<Dictionary> getOriginList() {
		return originList;
	}

	public void setOriginList(List<Dictionary> originList) {
		this.originList = originList;
	}

	public List<Dictionary> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<Dictionary> statusList) {
		this.statusList = statusList;
	}
	
}