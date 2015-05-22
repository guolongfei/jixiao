package com.hoyotech.prison.bean;

import java.util.Date;

public class Evaluation {
	private String evaluation_id;
	private Integer lastscore;
	private String employee_id;
	private Date evaluation_time;
	private Integer evaluation_type;
	private Date evaluation_begintime;
	private String evaluation_content;
	
	
	public String getEvaluation_content() {
		return evaluation_content;
	}
	public void setEvaluation_content(String evaluationContent) {
		evaluation_content = evaluationContent;
	}
	public Date getEvaluation_begintime() {
		return evaluation_begintime;
	}
	public void setEvaluation_begintime(Date evaluationBegintime) {
		evaluation_begintime = evaluationBegintime;
	}
	public String getEvaluation_id() {
		return evaluation_id;
	}
	public void setEvaluation_id(String evaluationId) {
		evaluation_id = evaluationId;
	}
	public Integer getLastscore() {
		return lastscore;
	}
	public void setLastscore(Integer lastscore) {
		this.lastscore = lastscore;
	}
	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employeeId) {
		employee_id = employeeId;
	}
	public Date getEvaluation_time() {
		return evaluation_time;
	}
	public void setEvaluation_time(Date evaluationTime) {
		evaluation_time = evaluationTime;
	}
	public Integer getEvaluation_type() {
		return evaluation_type;
	}
	public void setEvaluation_type(Integer evaluationType) {
		evaluation_type = evaluationType;
	}
	
	


}
