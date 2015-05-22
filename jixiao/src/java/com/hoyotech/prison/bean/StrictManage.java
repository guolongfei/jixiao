package com.hoyotech.prison.bean;

import java.util.Date;

import com.hoyotech.prison.log.PropertyName;

public class StrictManage {

	@PropertyName(name = "ID")
	private String id;
	@PropertyName(name = "日期")
	private Date time;
	@PropertyName(name = "姓名")
	private Prisoner name;
	@PropertyName(name = "性别")
	private Dictionary gender; // 性别
	@PropertyName(name = "拘室")
	private String roomNum;
	@PropertyName(name = "开始严管时间")
	private Date startTime;
	@PropertyName(name = "解除严管时间")
	private Date endTime;
	@PropertyName(name = "严管理由")
	private String reason;
	@PropertyName(name = "严管方式")
	private String type;
	@PropertyName(name = "批准人")
	private Police approver;
	@PropertyName(name = "严管民警")
	private Police managePolicer;
	@PropertyName(name = "备注")
	private String remark;
	private int state = 1;
	private Date addTime;
	private Date updateTime;
	private String prisonCode;
	private int isSync = 0;// 是否同步；0：未同步；1：已同步

	public StrictManage() {

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
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public Police getApprover() {
		return approver;
	}

	public void setApprover(Police approver) {
		this.approver = approver;
	}

	public Police getManagePolicer() {
		return managePolicer;
	}

	public void setManagePolicer(Police managePolicer) {
		this.managePolicer = managePolicer;
	}

	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	
	
}
