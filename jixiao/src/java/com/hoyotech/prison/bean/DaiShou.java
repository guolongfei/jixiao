package com.hoyotech.prison.bean;

import java.util.Date;

import com.hoyotech.prison.log.PropertyName;

public class DaiShou {

	@PropertyName(name = "ID")
	private String id;
	private Prisoner prisoner;
	@PropertyName(name = "送物人姓名")
	private String sender;
	@PropertyName(name = "送物时间")
	private Date sendTime;
	@PropertyName(name = "财务种类")
	private String property;
	@PropertyName(name = "财物去向")
	private String quxiang;
	@PropertyName(name = "代收民警")
	private Police policer;
	@PropertyName(name = "保管人")
	private Police keeper;
	private String remark;
	private int state = 1;
	private Date addTime;
	private Date updateTime;
	private String prisonCode;
	
	private int isSync = 0;// 是否同步；0：未同步；1：已同步

	public DaiShou() {

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
	
	public Prisoner getPrisoner() {
		return prisoner;
	}

	public void setPrisoner(Prisoner prisoner) {
		this.prisoner = prisoner;
	}

	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	public String getQuxiang() {
		return quxiang;
	}
	public void setQuxiang(String quxiang) {
		this.quxiang = quxiang;
	}
	
	public Police getPolicer() {
		return policer;
	}

	public void setPolicer(Police policer) {
		this.policer = policer;
	}

	public Police getKeeper() {
		return keeper;
	}

	public void setKeeper(Police keeper) {
		this.keeper = keeper;
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
	
	
}
