package com.hoyotech.prison.bean;

import java.util.Date;

import com.hoyotech.prison.log.PropertyName;

public class HandOver {

	@PropertyName(name = "ID")
	private String id;
	@PropertyName(name = "交班时间")
	private Date time;
	@PropertyName(name = "值班人姓名")
	private Police dutyName;
	@PropertyName(name = "带班所领导")
	private Police dutyLeader;
	@PropertyName(name = "接班总人数")
	private int jiebanNum;
	@PropertyName(name = "入所人数")
	private int inNum;
	@PropertyName(name = "出所人数")
	private int outNum;
	@PropertyName(name = "交班总人数")
	private int jiaobanNum;
	@PropertyName(name = "监控巡视情况")
	private String monitorContent;
	@PropertyName(name = "工作记事")
	private String workRecord;
	@PropertyName(name = "带班所领导批示")
	private String instructions;
	@PropertyName(name = "交班移交事项")
	private String matters;
	@PropertyName(name = "接班人姓名")
	private Police jiebanren;
	private int state = 1;
	private Date addTime;
	private Date updateTime;
	private String prisonCode;
	
	private int isSync = 0;// 是否同步；0：未同步；1：已同步
	
	//刘泉
	@PropertyName(name="值班医生")
	private String dutyDoctor;
	@PropertyName(name="值班管教")
	private String dutyManager;
	@PropertyName(name="值班巡视")
	private String dutyOnbudsman;

	public HandOver() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDutyDoctor() {
		return dutyDoctor;
	}

	public void setDutyDoctor(String dutyDoctor) {
		this.dutyDoctor = dutyDoctor;
	}

	public String getDutyManager() {
		return dutyManager;
	}

	public void setDutyManager(String dutyManager) {
		this.dutyManager = dutyManager;
	}

	public String getDutyOnbudsman() {
		return dutyOnbudsman;
	}

	public void setDutyOnbudsman(String dutyOnbudsman) {
		this.dutyOnbudsman = dutyOnbudsman;
	}
	
	public int getIsSync() {
		return isSync;
	}
	public void setIsSync(int isSync) {
		this.isSync = isSync;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	public Police getDutyName() {
		return dutyName;
	}

	public void setDutyName(Police dutyName) {
		this.dutyName = dutyName;
	}

	public Police getDutyLeader() {
		return dutyLeader;
	}

	public void setDutyLeader(Police dutyLeader) {
		this.dutyLeader = dutyLeader;
	}

	public Police getJiebanren() {
		return jiebanren;
	}

	public void setJiebanren(Police jiebanren) {
		this.jiebanren = jiebanren;
	}

	public int getJiebanNum() {
		return jiebanNum;
	}
	public void setJiebanNum(int jiebanNum) {
		this.jiebanNum = jiebanNum;
	}
	public int getInNum() {
		return inNum;
	}
	public void setInNum(int inNum) {
		this.inNum = inNum;
	}
	public int getOutNum() {
		return outNum;
	}
	public void setOutNum(int outNum) {
		this.outNum = outNum;
	}
	public int getJiaobanNum() {
		return jiaobanNum;
	}
	public void setJiaobanNum(int jiaobanNum) {
		this.jiaobanNum = jiaobanNum;
	}
	public String getMonitorContent() {
		return monitorContent;
	}
	public void setMonitorContent(String monitorContent) {
		this.monitorContent = monitorContent;
	}
	public String getWorkRecord() {
		return workRecord;
	}
	public void setWorkRecord(String workRecord) {
		this.workRecord = workRecord;
	}
	public String getInstructions() {
		return instructions;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	public String getMatters() {
		return matters;
	}
	public void setMatters(String matters) {
		this.matters = matters;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getPrisonCode() {
		return prisonCode;
	}
	public void setPrisonCode(String prisonCode) {
		this.prisonCode = prisonCode;
	}
	
	
}
