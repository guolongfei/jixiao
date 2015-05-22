package com.hoyotech.prison.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.AnalysisMeeting;
import com.hoyotech.prison.bean.Police;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.AnalysisMeetingService;
import com.hoyotech.prison.service.impl.DictionaryService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.ObjectUpdateUtil;
import com.hoyotech.prison.util.PrisonUtil;
import com.isa.pims.basic.ServletRequestUtils;

public class AnalysisMeetingAction {
	private AnalysisMeetingService analysisMeetingService;
	private DictionaryService dictionaryService;	

	private List<AnalysisMeeting> analysisMeetinglist;
	private AnalysisMeeting analysisMeeting;
	private int pageNum;
	private int limit; 
	private int totalPage;
	private int totalNum;
	private String id ;
	
	private String address; //地点
	private Date time; 
	
	private LogFactory log;
	private List<Police> policelist;
	private String allPolice;//用于装载反馈到页面上的警员信息
	


	/**
	 * 动态分析会议记录-打印（台账）
	 * **/
	public String print() {
		analysisMeeting=analysisMeetingService.detail(id);

		return "ListPrint";
	}
	
	/**
	 * 查询所有动态分析会议记录
	 * **/
	public String select() {
		HttpServletRequest request=ServletActionContext.getRequest();
		pageNum = ServletRequestUtils.getInt(request, "page","1");
		limit = ServletRequestUtils.getInt(request, "limit","20");
		String prisonCode=PrisonUtil.getPrisonCode(request);
		analysisMeetinglist = analysisMeetingService.list(address, time, pageNum, limit,prisonCode);
		totalNum=analysisMeetingService.count(address, time,prisonCode);
		totalPage=(totalNum-1)/limit+1;
		return "List";
	}
	
	public void selectPolice(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode=PrisonUtil.getPrisonCode(request);
		policelist=dictionaryService.selectPolice(prisonCode);
	}
	
	/**
	 * 添加一条动态分析会议记录
	 * **/
	public String add() {
		HttpServletRequest request = ServletActionContext.getRequest();
		analysisMeeting.setPrisonCode(PrisonUtil.getPrisonCode(request));
		id = analysisMeetingService.add(analysisMeeting); //添加数据得到id
		
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(analysisMeeting, config.getInsert(), operate, config.getAnalysisMetting(), config.getSucceed(), request);
		return "detail";
	}

	/**
	 * 查询一条动态分析会议记录,返回到详细页面
	 * **/
	public String detail() {
		analysisMeeting=analysisMeetingService.detail(id);
		return "Detail";
	}
	
	/**
	 * 删除一条动态分析会议记录
	 * **/
	public String delete() {
		analysisMeetingService.delete(id);
		
		// 添加日志
		AnalysisMeeting object = new AnalysisMeeting();
		object.setId(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "删除成功。";
		log.getModifyLogMessage(null, object, config.getDelete(), operate, config.getAnalysisMetting(), config.getSucceed(), request);
		return "select";
	}
	
	/**
	 * 修改一条动态分析会议记录
	 * **/
	public String update() {
		AnalysisMeeting obj = analysisMeetingService.detail(analysisMeeting.getId());
		AnalysisMeeting old_obj = analysisMeetingService.detail(analysisMeeting.getId());
		ObjectUpdateUtil.compareProperty(analysisMeeting, obj);
		analysisMeetingService.update(obj);
		id=analysisMeeting.getId();
		
		// 添加日志
		
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。";
		log.getModifyLogMessage(obj, old_obj, config.getUpdate(), operate, config.getReception(), config.getSucceed(), request);
		return "detail";
	}
	
	/**
	 * 进入添加页面
	 * **/
	public String interAdd() {
		
		/***********************************刘泉****************************/
		allPolice="";
		selectPolice();
		System.out.println(policelist.size());
		for(int i=0;i<policelist.size();i++)
		{
			allPolice=allPolice+policelist.get(i).getName()+",";
		}
		System.out.println(allPolice);
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode=PrisonUtil.getPrisonCode(request);
		
		/***********************************2014.07.15****************************/
		
		return "Add";
	}
	
	/**
	 * 进入修改页面
	 * **/
	public String interEdit() {
		/***********************************刘泉****************************/
		allPolice="";
		selectPolice();
		System.out.println(policelist.size());
		for(int i=0;i<policelist.size();i++)
		{
			allPolice=allPolice+policelist.get(i).getName()+",";
		}
		System.out.println(allPolice);
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode=PrisonUtil.getPrisonCode(request);
		
		/***********************************2014.07.15****************************/
		analysisMeeting=analysisMeetingService.detail(id);
		return "Edit";
	}

	public AnalysisMeetingService getAnalysisMeetingService() {
		return analysisMeetingService;
	}

	public void setAnalysisMeetingService(
			AnalysisMeetingService analysisMeetingService) {
		this.analysisMeetingService = analysisMeetingService;
	}

	public List<AnalysisMeeting> getAnalysisMeetinglist() {
		return analysisMeetinglist;
	}

	public void setAnalysisMeetinglist(List<AnalysisMeeting> analysisMeetinglist) {
		this.analysisMeetinglist = analysisMeetinglist;
	}

	public AnalysisMeeting getAnalysisMeeting() {
		return analysisMeeting;
	}

	public void setAnalysisMeeting(AnalysisMeeting analysisMeeting) {
		this.analysisMeeting = analysisMeeting;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
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
	
	public List<Police> getPolicelist() {
		return policelist;
	}

	public void setPolicelist(List<Police> policelist) {
		this.policelist = policelist;
	}
	
	public String getAllPolice() {
		return allPolice;
	}

	public void setAllPolice(String allPolice) {
		this.allPolice = allPolice;
	}
}
