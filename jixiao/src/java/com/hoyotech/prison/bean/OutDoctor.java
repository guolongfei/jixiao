package com.hoyotech.prison.bean;

import java.util.Date;

import com.hoyotech.prison.log.PropertyName;

public class OutDoctor {

	@PropertyName(name = "ID")
	private String id;
	@PropertyName(name = "姓名")
	private Prisoner name;
	@PropertyName(name = "性别")
	private Dictionary gender; // 性别
	@PropertyName(name = "拘室")
	private String roomNum;
	@PropertyName(name = "拘留期限")
	private String deadline;
	@PropertyName(name = "主要症状")
	private String content;
	@PropertyName(name = "批准人")
	private Police approver;
	@PropertyName(name = "监管民警")
	private Police policer;
	@PropertyName(name = "就诊医院")
	private String hospital;
	@PropertyName(name = "就诊情况")
	private String handle;
	@PropertyName(name = "出所时间")
	private Date outTime;
	@PropertyName(name = "回所时间")
	private Date backTime;
	private int state = 1;
	private Date addTime;
	private Date updateTime;
	private String prisonCode;
	private int isSync = 0;// 是否同步；0：未同步；1：已同步

	public OutDoctor() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getIsSync() {
		return isSync;
	}

	public void setIsSync(int isSync) {
		this.isSync = isSync;
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

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public Prisoner getName() {
		return name;
	}

	public void setName(Prisoner name) {
		this.name = name;
	}

	public Dictionary getGender() {
		return gender;
	}
	public void setGender(Dictionary gender) {
		this.gender = gender;
	}
	public String getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Police getApprover() {
		return approver;
	}

	public void setApprover(Police approver) {
		this.approver = approver;
	}

	public Police getPolicer() {
		return policer;
	}

	public void setPolicer(Police policer) {
		this.policer = policer;
	}

	public String getHospital() {
		return hospital;
	}
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
	public String getHandle() {
		return handle;
	}
	public void setHandle(String handle) {
		this.handle = handle;
	}
	public Date getOutTime() {
		return outTime;
	}
	public void setOutTime(Date outTime) {
		this.outTime = outTime;
	}
	public Date getBackTime() {
		return backTime;
	}
	public void setBackTime(Date backTime) {
		this.backTime = backTime;
	}
	
	
}
