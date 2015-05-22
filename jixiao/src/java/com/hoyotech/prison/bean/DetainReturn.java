package com.hoyotech.prison.bean;

import java.util.Date;

import com.hoyotech.prison.log.PropertyName;

public class DetainReturn {

	@PropertyName(name = "ID")
	private String id;
	private String noYear;
	@PropertyName(name = "流水号")
	private String noNumber;
	@PropertyName(name = "送拘人")
	private String sender;
	@PropertyName(name = "拘留所经办人")
	private Police operator;
	private Prisoner prisoner;
	private int state=1;
	private Date addTime;
	private Date updateTime;
	private String prisonCode;
	private int isSync = 0;// 是否同步；0：未同步；1：已同步

	public DetainReturn() {

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
	public String getNoYear() {
		return noYear;
	}
	public void setNoYear(String noYear) {
		this.noYear = noYear;
	}
	public String getNoNumber() {
		return noNumber;
	}
	public void setNoNumber(String noNumber) {
		this.noNumber = noNumber;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	
	public Police getOperator() {
		return operator;
	}

	public void setOperator(Police operator) {
		this.operator = operator;
	}

	public Prisoner getPrisoner() {
		return prisoner;
	}
	public void setPrisoner(Prisoner prisoner) {
		this.prisoner = prisoner;
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
