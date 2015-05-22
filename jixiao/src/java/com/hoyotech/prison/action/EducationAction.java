package com.hoyotech.prison.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.Education;
import com.hoyotech.prison.bean.Police;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.DictionaryService;
import com.hoyotech.prison.service.impl.EducationService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.ObjectUpdateUtil;
import com.hoyotech.prison.util.PrisonUtil;
import com.isa.pims.basic.ServletRequestUtils;

public class EducationAction {

	private EducationService educationService;
	private DictionaryService dictionaryService;
	private List<Education> educationlist;
	private Education education;
	private int pageNum;
	private int limit; 
	private int totalPage;
	private int totalNum;
	private String id;
	private String name; //姓名
	private Date time; //职称
	
	private LogFactory log;
	private List<Police> policelist;
	
	/**
	 * 无意义的初始化
	 * 
	 */
	
	public String init(){
		/**
		 * 初始化
		 */
		return "init";
	}
	public String init1(){
		/**
		 * 初始化
		 */
		return "init1";
	}
	public String init2(){
		/**
		 * 初始化
		 */
		return "init2";
	}
	public String init3(){
		/**
		 * 初始化
		 */
		return "init3";
	}
	public String init4(){
		/**
		 * 初始化
		 */
		return "init4";
	}
	public String init5(){
		/**
		 * 初始化
		 */
		return "init5";
	}
	
	public void selectPolice(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode=PrisonUtil.getPrisonCode(request);
		policelist=dictionaryService.selectPolice(prisonCode);
	}
	
	/**
	 * 集体教育记录信息-打印（台账）
	 * **/
	public String print() {
		education=educationService.detail(id);

		return "ListPrint";
	}
	
	/**
	 * 查询所有集体教育记录的信息
	 * **/
	public String select() {
		HttpServletRequest request=ServletActionContext.getRequest();
		pageNum = ServletRequestUtils.getInt(request, "page","1");
		limit = ServletRequestUtils.getInt(request, "limit","20");
		String prisonCode=PrisonUtil.getPrisonCode(request);
		educationlist = educationService.list(name, time, pageNum, limit,prisonCode);
		totalNum=educationService.count(name, time,prisonCode);
		totalPage=(totalNum-1)/limit+1;
		return "List";
	}
	
	/**
	 * 添加一条集体教育记录的信息
	 * **/
	public String add() {
		HttpServletRequest request = ServletActionContext.getRequest();
		education.setPrisonCode(PrisonUtil.getPrisonCode(request));
		id = educationService.add(education); //添加数据得到id
		
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(education, config.getInsert(), operate, config.getEducation(), config.getSucceed(), request);
		return "detail";
	}

	/**
	 * 查询一条集体教育记录的信息,返回到详细页面
	 * **/
	public String detail() {
		education=educationService.detail(id);
		return "Detail";
	}
	
	/**
	 * 删除一条集体教育记录的信息
	 * **/
	public String delete() {
		educationService.delete(id);
		
		// 添加日志
		Education object = new Education();
		object.setId(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "删除成功。";
		log.getModifyLogMessage(null, object, config.getDelete(), operate, config.getEducation(), config.getSucceed(), request);
		return "select";
	}
	
	/**
	 * 修改一条集体教育记录
	 * **/
	public String update() {
		Education obj = educationService.detail(education.getId());
		Education old_obj = educationService.detail(education.getId());
		ObjectUpdateUtil.compareProperty(education, obj);
		
		educationService.update(obj);
		id=education.getId();
		
		// 添加日志
		
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。";
		log.getModifyLogMessage(obj, old_obj, config.getUpdate(), operate, config.getEducation(), config.getSucceed(), request);
		return "detail";
	}
	
	/**
	 * 进入添加页面
	 * **/
	public String interAdd() {
		selectPolice();
		return "Add";
	}
	
	/**
	 * 进入修改页面
	 * **/
	public String interEdit() {
		selectPolice();
		education=educationService.detail(id);
		return "Edit";
	}
	
	public DictionaryService getDictionaryService() {
		return dictionaryService;
	}

	public void setDictionaryService(DictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
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

	public EducationService getEducationService() {
		return educationService;
	}

	public void setEducationService(EducationService educationService) {
		this.educationService = educationService;
	}

	public List<Education> getEducationlist() {
		return educationlist;
	}

	public void setEducationlist(List<Education> educationlist) {
		this.educationlist = educationlist;
	}

	public Education getEducation() {
		return education;
	}

	public void setEducation(Education education) {
		this.education = education;
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
	
}
