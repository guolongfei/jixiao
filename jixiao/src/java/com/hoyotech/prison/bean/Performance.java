package com.hoyotech.prison.bean;

import java.util.Date;


public class Performance {
	
    private String performanceId;
    private String employeeId;
    private String performance_content;
    private Date performance_date;
    private int performance_type;  //1 表示日记载   2 表示月计划  3 表示季计划 4 表示年度工作目标  5月小结 6季汇总 7年总结
    private Integer season_type;//季度  1,2,3,4
    
	
	public Integer getSeason_type() {
		return season_type;
	}
	public void setSeason_type(Integer seasonType) {
		season_type = seasonType;
	}
	public String getPerformanceId() {
		return performanceId;
	}
	public void setPerformanceId(String performanceId) {
		this.performanceId = performanceId;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getPerformance_content() {
		return performance_content;
	}
	public void setPerformance_content(String performanceContent) {
		performance_content = performanceContent;
	}
	public Date getPerformance_date() {
		return performance_date;
	}
	public void setPerformance_date(Date performanceDate) {
		performance_date = performanceDate;
	}
	public int getPerformance_type() {
		return performance_type;
	}
	public void setPerformance_type(int performanceType) {
		performance_type = performanceType;
	}
    
	
}
