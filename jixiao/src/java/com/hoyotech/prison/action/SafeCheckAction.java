package com.hoyotech.prison.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.SafeCheck;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.DictionaryService;
import com.hoyotech.prison.service.impl.SafeCheckService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.ObjectUpdateUtil;
import com.hoyotech.prison.util.PrisonUtil;
import com.isa.pims.basic.ServletRequestUtils;
import com.hoyotech.prison.bean.Police;

public class SafeCheckAction {

	private SafeCheckService safeCheckService;
	private DictionaryService dictionaryService;	
	private List<SafeCheck> safeChecklist;
	private SafeCheck safeCheck;
	private int pageNum;
	private int limit; 
	private int totalPage;
	private int totalNum;
	private String id;
	private Date time; 
	
	private LogFactory log;
	private List<Police> policelist;

	private String allPolice;//用于装载反馈到页面上的警员信息
	

	/**
	 * 安全检查记录登记信息-打印（台账）
	 * **/
	public String print() {
		safeCheck=safeCheckService.detail(id);
		return "ListPrint";
	}
	
	public void selectPolice(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode=PrisonUtil.getPrisonCode(request);
		policelist=dictionaryService.selectPolice(prisonCode);
	}
	
	/**
	 * 查询所有安全检查记录的信息
	 * **/
	public String select() {
		HttpServletRequest request=ServletActionContext.getRequest();
		pageNum = ServletRequestUtils.getInt(request, "page","1");
		limit = ServletRequestUtils.getInt(request, "limit","20");
		String prisonCode=PrisonUtil.getPrisonCode(request);
		safeChecklist = safeCheckService.list(time, pageNum, limit,prisonCode);
		totalNum=safeCheckService.count(time,prisonCode);
		totalPage=(totalNum-1)/limit+1;
		return "List";
	}
	
	/**
	 * 添加一条安全检查记录的信息
	 * **/
	public String add() {
		HttpServletRequest request = ServletActionContext.getRequest();
		safeCheck.setPrisonCode(PrisonUtil.getPrisonCode(request));
		id = safeCheckService.add(safeCheck); //添加数据得到id
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(safeCheck, config.getInsert(), operate, config.getSafeCheck(), config.getSucceed(), request);
		return "detail";
	}

	/**
	 * 查询一条安全检查记录的信息,返回到详细页面
	 * **/
	public String detail() {
		safeCheck=safeCheckService.detail(id);
		return "Detail";
	}
	
	/**
	 * 删除一条安全检查记录的信息
	 * **/
	public String delete() {
		safeCheckService.delete(id);
		
		// 添加日志
		SafeCheck object = new SafeCheck();
		object.setId(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "删除成功。";
		log.getModifyLogMessage(null, object, config.getDelete(), operate, config.getSafeCheck(), config.getSucceed(), request);
		return "select";
	}
	
	/**
	 * 修改一条安全检查记录
	 * **/
	public String update() {
		SafeCheck obj = safeCheckService.detail(safeCheck.getId());
		SafeCheck old_obj = safeCheckService.detail(safeCheck.getId());
		ObjectUpdateUtil.compareProperty(safeCheck, obj);
		
		safeCheckService.update(obj);
		id=safeCheck.getId();
		
		// 添加日志
		
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。";
		log.getModifyLogMessage(obj, old_obj, config.getUpdate(), operate, config.getSafeCheck(), config.getSucceed(), request);
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
		
		safeCheck=safeCheckService.detail(id);
		return "Edit";
	}
	
	public LogFactory getLog() {
		return log;
	}

	public void setLog(LogFactory log) {
		this.log = log;
	}

	public SafeCheckService getSafeCheckService() {
		return safeCheckService;
	}

	public void setSafeCheckService(SafeCheckService safeCheckService) {
		this.safeCheckService = safeCheckService;
	}

	public List<SafeCheck> getSafeChecklist() {
		return safeChecklist;
	}

	public void setSafeChecklist(List<SafeCheck> safeChecklist) {
		this.safeChecklist = safeChecklist;
	}

	public SafeCheck getSafeCheck() {
		return safeCheck;
	}

	public void setSafeCheck(SafeCheck safeCheck) {
		this.safeCheck = safeCheck;
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

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	public String getAllPolice() {
		return allPolice;
	}

	public void setAllPolice(String allPolice) {
		this.allPolice = allPolice;
	}
	
	public List<Police> getPolicelist() {
		return policelist;
	}

	public void setPolicelist(List<Police> policelist) {
		this.policelist = policelist;
	}
	
	public DictionaryService getDictionaryService() {
		return dictionaryService;
	}

	public void setDictionaryService(DictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}

}
