package com.hoyotech.prison.action;

import java.util.Date; 
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.Police;
import com.hoyotech.prison.bean.SocietyOpen;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.DictionaryService;
import com.hoyotech.prison.service.impl.SocietyOpenService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.ObjectUpdateUtil;
import com.hoyotech.prison.util.PrisonUtil;
import com.isa.pims.basic.ServletRequestUtils;

public class SocietyOpenAction {
	
	private SocietyOpenService societyOpenService;
	private DictionaryService dictionaryService;
	private List<SocietyOpen> societyOpenlist;
	private SocietyOpen societyOpen;
	private int pageNum;
	private int limit; 
	private int totalPage;
	private int totalNum;
	private String id;
	private Date startTime;
	private String approver;
	
	private LogFactory log;
	private List<Police> policelist;
	
	/**
	 * 对社会开放记录登记信息-打印（台账）
	 * **/
	public String print() {
		societyOpen=societyOpenService.detail(id);
		return "ListPrint";
	}
	
	public void selectPolice(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode=PrisonUtil.getPrisonCode(request);
		policelist=dictionaryService.selectPolice(prisonCode);
	}
	
	/**
	 * 查询所有对社会开放记录的信息
	 * **/
	public String select() {
		HttpServletRequest request=ServletActionContext.getRequest();
		pageNum = ServletRequestUtils.getInt(request, "page","1");
		limit = ServletRequestUtils.getInt(request, "limit","20");
		String prisonCode=PrisonUtil.getPrisonCode(request);
		societyOpenlist = societyOpenService.list(startTime,approver, pageNum, limit,prisonCode);
		totalNum=societyOpenService.count(startTime,approver,prisonCode);
		totalPage=(totalNum-1)/limit+1;
		return "List";
	}
	
	/**
	 * 添加一条对社会开放记录的信息
	 * **/
	public String add() {
		HttpServletRequest request = ServletActionContext.getRequest();
		societyOpen.setPrisonCode(PrisonUtil.getPrisonCode(request));
		id = societyOpenService.add(societyOpen); //添加数据得到id
		
		
		
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(societyOpen, config.getInsert(), operate, config.getSocietyOpen(), config.getSucceed(), request);
		return "detail";
	}

	/**
	 * 查询一条对社会开放记录的信息,返回到详细页面
	 * **/
	public String detail() {
		societyOpen=societyOpenService.detail(id);
		return "Detail";
	}
	
	/**
	 * 删除一条对社会开放记录的信息
	 * **/
	public String delete() {
		societyOpenService.delete(id);
		
		// 添加日志
		SocietyOpen object = new SocietyOpen();
		object.setId(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "删除成功。";
		log.getModifyLogMessage(null, object, config.getDelete(), operate, config.getSocietyOpen(), config.getSucceed(), request);
		return "select";
	}
	
	/**
	 * 修改一条对社会开放记录
	 * **/
	public String update() {
		SocietyOpen obj = societyOpenService.detail(societyOpen.getId());
		SocietyOpen old_obj = societyOpenService.detail(societyOpen.getId());
		ObjectUpdateUtil.compareProperty(societyOpen, obj);
		
		societyOpenService.update(obj);
		id=societyOpen.getId();
		
		// 添加日志
		
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。";
		log.getModifyLogMessage(obj, old_obj, config.getUpdate(), operate, config.getSocietyOpen(), config.getSucceed(), request);
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
		societyOpen=societyOpenService.detail(id);
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

	public SocietyOpenService getSocietyOpenService() {
		return societyOpenService;
	}
	public void setSocietyOpenService(SocietyOpenService societyOpenService) {
		this.societyOpenService = societyOpenService;
	}
	public List<SocietyOpen> getSocietyOpenlist() {
		return societyOpenlist;
	}
	public void setSocietyOpenlist(List<SocietyOpen> societyOpenlist) {
		this.societyOpenlist = societyOpenlist;
	}
	public SocietyOpen getSocietyOpen() {
		return societyOpen;
	}
	public void setSocietyOpen(SocietyOpen societyOpen) {
		this.societyOpen = societyOpen;
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
	
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public String getApprover() {
		return approver;
	}
	public void setApprover(String approver) {
		this.approver = approver;
	}
	public LogFactory getLog() {
		return log;
	}
	public void setLog(LogFactory log) {
		this.log = log;
	}
	
	

}
