package com.hoyotech.prison.bean;

public class Quarter {
	
	private String quarterId;
	private String year;//年份
	private String quarter;//季度
	private String startTime;//开始时间
	private String endTime;//结束时间
	
	
	public String getQuarterId() {
		return quarterId;
	}
	public void setQuarterId(String quarterId) {
		this.quarterId = quarterId;
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
}
