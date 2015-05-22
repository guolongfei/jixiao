package com.hoyotech.prison.action;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.FailureAlarm;
import com.hoyotech.prison.service.impl.FailureAlarmService;
import com.isa.pims.basic.ServletRequestUtils;

public class FailureAlarmAction {

	FailureAlarmService failureAlarmService;
	private List<FailureAlarm> alarms;
	private FailureAlarm failureAlarm;
	private int pageNum;
	private int limit; 
	private int totalPage;
	private int totalNum;
	private String id;
	/**
	 * 查询所有报警故障的信息
	 * **/
	public String select() {
		HttpServletRequest request=ServletActionContext.getRequest();
		pageNum = ServletRequestUtils.getInt(request, "page","1");
		limit = ServletRequestUtils.getInt(request, "limit","20");
		alarms=failureAlarmService.list(pageNum, limit);
		totalNum=failureAlarmService.count();
		totalPage=(totalNum-1)/limit+1;
		return "List";
	}

	/**
	 * 查询一条报警故障的信息,返回到详细页面
	 * **/
	public String detail() {
		failureAlarm=failureAlarmService.detail(id);
		return "Detail";
	}

	public FailureAlarmService getFailureAlarmService() {
		return failureAlarmService;
	}

	public void setFailureAlarmService(FailureAlarmService failureAlarmService) {
		this.failureAlarmService = failureAlarmService;
	}

	public List<FailureAlarm> getAlarms() {
		return alarms;
	}

	public void setAlarms(List<FailureAlarm> alarms) {
		this.alarms = alarms;
	}

	public FailureAlarm getFailureAlarm() {
		return failureAlarm;
	}

	public void setFailureAlarm(FailureAlarm failureAlarm) {
		this.failureAlarm = failureAlarm;
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
	
	
	
}
