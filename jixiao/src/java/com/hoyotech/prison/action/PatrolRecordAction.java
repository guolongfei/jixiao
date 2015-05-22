package com.hoyotech.prison.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.PatrolRecord;
import com.hoyotech.prison.bean.Police;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.DictionaryService;
import com.hoyotech.prison.service.impl.PatrolRecordService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.ObjectUpdateUtil;
import com.hoyotech.prison.util.PrisonUtil;
import com.isa.pims.basic.ServletRequestUtils;

public class PatrolRecordAction {
	private PatrolRecordService patrolRecordService;
	private DictionaryService dictionaryService;
	private List<PatrolRecord> patrolRecordlist;
	private PatrolRecord patrolRecord;
	private int pageNum;
	private int limit; 
	private int totalPage;
	private int totalNum;
	private String id;
	private String watch; //姓名
	private Date time; //职称
	
	private LogFactory log;
	private List<Police> policelist;
	
	/**
	 * 巡视监控记录信息-打印（台账）
	 * **/
	public String print() {
		patrolRecord=patrolRecordService.detail(id);

		return "ListPrint";
	}
	
	public void selectPolice(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode=PrisonUtil.getPrisonCode(request);
		policelist=dictionaryService.selectPolice(prisonCode);
	}
	
	/**
	 * 查询所有巡视监控记录的信息
	 * **/
	public String select() {
		HttpServletRequest request=ServletActionContext.getRequest();
		pageNum = ServletRequestUtils.getInt(request, "page","1");
		limit = ServletRequestUtils.getInt(request, "limit","20");
		String prisonCode=PrisonUtil.getPrisonCode(request);
		patrolRecordlist = patrolRecordService.list(watch, time, pageNum, limit,prisonCode);
		totalNum=patrolRecordService.count(watch, time,prisonCode);
		totalPage=(totalNum-1)/limit+1;
		return "List";
	}
	
	/**
	 * 添加一条巡视监控记录的信息
	 * **/
	public String add() {
		HttpServletRequest request = ServletActionContext.getRequest();
		patrolRecord.setPrisonCode(PrisonUtil.getPrisonCode(request));
		id = patrolRecordService.add(patrolRecord); //添加数据得到id
		
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(patrolRecord, config.getInsert(), operate, config.getPatrolRecord(), config.getSucceed(), request);
		return "detail";
	}

	/**
	 * 查询一条巡视监控记录的信息,返回到详细页面
	 * **/
	public String detail() {
		patrolRecord=patrolRecordService.detail(id);
		return "Detail";
	}
	
	/**
	 * 删除一条巡视监控记录的信息
	 * **/
	public String delete() {
		patrolRecordService.delete(id);
		
		// 添加日志
		PatrolRecord object = new PatrolRecord();
		object.setId(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "删除成功。";
		log.getModifyLogMessage(null, object, config.getDelete(), operate, config.getPatrolRecord(), config.getSucceed(), request);
		return "select";
	}
	
	/**
	 * 修改一条巡视监控记录
	 * **/
	public String update() {
		PatrolRecord obj = patrolRecordService.detail(patrolRecord.getId());
		PatrolRecord old_obj = patrolRecordService.detail(patrolRecord.getId());
		ObjectUpdateUtil.compareProperty(patrolRecord, obj);
		
		patrolRecordService.update(obj);
		id=patrolRecord.getId();
		
		// 添加日志
		
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。";
		log.getModifyLogMessage(obj, old_obj, config.getUpdate(), operate, config.getPatrolRecord(), config.getSucceed(), request);
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
		patrolRecord=patrolRecordService.detail(id);
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

	public PatrolRecordService getPatrolRecordService() {
		return patrolRecordService;
	}

	public void setPatrolRecordService(PatrolRecordService patrolRecordService) {
		this.patrolRecordService = patrolRecordService;
	}

	public List<PatrolRecord> getPatrolRecordlist() {
		return patrolRecordlist;
	}

	public void setPatrolRecordlist(List<PatrolRecord> patrolRecordlist) {
		this.patrolRecordlist = patrolRecordlist;
	}

	public PatrolRecord getPatrolRecord() {
		return patrolRecord;
	}

	public void setPatrolRecord(PatrolRecord patrolRecord) {
		this.patrolRecord = patrolRecord;
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

	

	public String getWatch() {
		return watch;
	}

	public void setWatch(String watch) {
		this.watch = watch;
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
	
}
