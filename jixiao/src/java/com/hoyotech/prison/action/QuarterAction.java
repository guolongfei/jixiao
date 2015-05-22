package com.hoyotech.prison.action;

import java.util.List;

import com.hoyotech.prison.bean.Quarter;
import com.hoyotech.prison.service.impl.QuarterService;

public class QuarterAction {
	
	private QuarterService quarterService;
	private String quarterId;
	private String year;//年份
	private String quarter;//季度
	private String startTime;//开始时间
	private	String endTime;//截止时间
	private List<Quarter> list;
	
	public String getQuarterTime(){
		if(year!=null&&!year.equals("")){
			quarterService.addQuarterTime(year, quarter, startTime, endTime);
			year="";
		}
		list = quarterService.getTime();		
		return "quarterList";
	}
	public String queryTime(){
		list = quarterService.queryTime(quarterId);
		return "queryTime";
	}
	
	public String updateTime(){
		quarterService.updateTime(quarterId, year, quarter, startTime, endTime);
		list = quarterService.getTime();
		year="";
		return "quarterList";
	}
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getQuarter() {
		return quarter;
	}
	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public QuarterService getQuarterService() {
		return quarterService;
	}
	public void setQuarterService(QuarterService quarterService) {
		this.quarterService = quarterService;
	}

	public void setList(List<Quarter> list) {
		this.list = list;
	}

	public List<Quarter> getList() {
		return list;
	}

	public void setQuarterId(String quarterId) {
		this.quarterId = quarterId;
	}

	public String getQuarterId() {
		return quarterId;
	}
	
}
