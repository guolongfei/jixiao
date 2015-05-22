package com.hoyotech.prison.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.Document;
import com.hoyotech.prison.bean.Interview;
import com.hoyotech.prison.bean.Police;
import com.hoyotech.prison.bean.Prisoner;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.DictionaryService;
import com.hoyotech.prison.service.impl.InterviewService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.ObjectUpdateUtil;
import com.hoyotech.prison.util.PrisonUtil;
import com.isa.pims.basic.ServletRequestUtils;

public class InterviewAction {

	DictionaryService dictionaryService;
	InterviewService interviewService;
	private List<Interview> interviewlist;
	private Interview interview;
	private int pageNum;
	private int limit; 
	private int totalPage;
	private int totalNum;
	private String id;
	private String name; //姓名
	private Date time; //职称
	
	private LogFactory log;
	
	private List<Document> documents;
	private List<Prisoner> prisonerlist;
	private List<Police> policelist;
	
	public void selectPolice(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode=PrisonUtil.getPrisonCode(request);
		policelist=dictionaryService.selectPolice(prisonCode);
	}
	
	/**
	 * 会见登记信息-打印（台账）
	 * **/
	public String print() {
		HttpServletRequest request=ServletActionContext.getRequest();
		pageNum = ServletRequestUtils.getInt(request, "page","1");
		limit = ServletRequestUtils.getInt(request, "limit","20");
		String prisonCode=PrisonUtil.getPrisonCode(request);
		interviewlist = interviewService.list(name,time, pageNum, limit,prisonCode);
		totalNum=interviewService.count(name, time,prisonCode);
		totalPage=(totalNum-1)/limit+1;
		
		return "ListPrint";
	}
	
	/**
	 * 查询所有会见登记的信息
	 * **/
	public String select() {
		HttpServletRequest request=ServletActionContext.getRequest();
		pageNum = ServletRequestUtils.getInt(request, "page","1");
		limit = ServletRequestUtils.getInt(request, "limit","20");
		String prisonCode=PrisonUtil.getPrisonCode(request);
		interviewlist = interviewService.list(name,time, pageNum, limit,prisonCode);
		totalNum=interviewService.count(name, time,prisonCode);
		totalPage=(totalNum-1)/limit+1;
		return "List";
	}
	
	/**
	 * 添加一条会见登记的信息
	 * **/
	public String add() {
		HttpServletRequest request = ServletActionContext.getRequest();
		interview.setPrisonCode(PrisonUtil.getPrisonCode(request));
		id = interviewService.add(interview); //添加数据得到id
		
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(interview, config.getInsert(), operate, config.getInterview(), config.getSucceed(), request);
		return "detail";
	}

	/**
	 * 查询一条会见登记的信息,返回到详细页面
	 * **/
	public String detail() {
		interview=interviewService.detail(id);
		return "Detail";
	}
	
	/**
	 * 删除一条会见登记的信息
	 * **/
	public String delete() {
		interviewService.delete(id);
		
		// 添加日志
		Interview object = new Interview();
		object.setId(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "删除成功。";
		log.getModifyLogMessage(null, object, config.getDelete(), operate, config.getInterview(), config.getSucceed(), request);
		return "select";
	}
	
	/**
	 * 修改一条会见登记的信息
	 * **/
	public String update() {
		Interview obj = interviewService.detail(interview.getId());
		Interview old_obj = interviewService.detail(interview.getId());
		ObjectUpdateUtil.compareProperty(interview, obj);
		interviewService.update(obj);
		id=interview.getId();
		
		// 添加日志
		
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。";
		log.getModifyLogMessage(obj, old_obj, config.getUpdate(), operate, config.getInterview(), config.getSucceed(), request);
		return "detail";
	}
	
	/**
	 * 进入添加页面
	 * **/
	public String interAdd() {
		selectPrisoner();
		selectPolice();
		documents = dictionaryService.selectDocument(1);
		return "Add";
	}
	
	/**
	 * 进入修改页面
	 * **/
	public String interEdit() {
		selectPrisoner();
		selectPolice();
		documents = dictionaryService.selectDocument(1);
		interview=interviewService.detail(id);
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

	public DictionaryService getDictionaryService() {
		return dictionaryService;
	}

	public void setDictionaryService(DictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public InterviewService getInterviewService() {
		return interviewService;
	}

	public void setInterviewService(InterviewService interviewService) {
		this.interviewService = interviewService;
	}

	public List<Interview> getInterviewlist() {
		return interviewlist;
	}

	public void setInterviewlist(List<Interview> interviewlist) {
		this.interviewlist = interviewlist;
	}

	public Interview getInterview() {
		return interview;
	}

	public void setInterview(Interview interview) {
		this.interview = interview;
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
