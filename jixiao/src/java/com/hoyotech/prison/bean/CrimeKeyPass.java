package com.hoyotech.prison.bean;

import java.util.Date;

import com.hoyotech.prison.log.PropertyName;

public class CrimeKeyPass {

	@PropertyName(name = "ID")
	private String id;
	private String noYear;
	@PropertyName(name = "流水号")
	private String noNumber;
	@PropertyName(name = "接收单位")
	private String acceptUnit;
	@PropertyName(name = "传递内容")
	private String crimekey;
	@PropertyName(name = "经办人")
	private Police operator;
	@PropertyName(name = "批准人")
	private Police approver;
	@PropertyName(name = "填发时间")
	private Date writeTime;
	private Prisoner prisoner;
	private int state=1;
	private Date addTime;
	private Date updateTime;
	private String prisonCode;
	private int isSync = 0;// 是否同步；0：未同步；1：已同步

	public CrimeKeyPass() {

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
	public String getAcceptUnit() {
		return acceptUnit;
	}
	public void setAcceptUnit(String acceptUnit) {
		this.acceptUnit = acceptUnit;
	}
	public String getCrimekey() {
		return crimekey;
	}
	public void setCrimekey(String crimekey) {
		this.crimekey = crimekey;
	}
	
	public Police getOperator() {
		return operator;
	}

	public void setOperator(Police operator) {
		this.operator = operator;
	}

	public Police getApprover() {
		return approver;
	}

	public void setApprover(Police approver) {
		this.approver = approver;
	}

	public Date getWriteTime() {
		return writeTime;
	}
	public void setWriteTime(Date writeTime) {
		this.writeTime = writeTime;
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
