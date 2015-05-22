package com.hoyotech.prison.bean;

import java.util.Date;

import com.hoyotech.prison.log.PropertyName;

public class OutPrison {

	@PropertyName(name = "ID")
	private String id;
	private String noYear;
	@PropertyName(name = "流水号")
	private String noNumber;
	@PropertyName(name = "请假开始时间")
	private Date startTime;
	@PropertyName(name = "请假结束时间")
	private Date endTime;
	@PropertyName(name = "请假事由")
	private String outReason;
	@PropertyName(name = "经办人")
	private Police operator;
	@PropertyName(name = "审批人")
	private Police approver;
	@PropertyName(name = "填发日期")
	private Date writeTime;
	@PropertyName(name = "担保人")
	private String security;
	@PropertyName(name = "担保人地址")
	private String securityAddress;
	@PropertyName(name = "担保人身份证号码")
	private String secuIdnum;
	@PropertyName(name = "担保人电话")
	private String phone;
	@PropertyName(name = "保证金")
	private Integer bail;
	private String examine="0";
	private int state=1;
	private Date addTime;
	private Date updateTime;
	private String prisonCode;
	private Prisoner prisoner;
	
	private int isSync = 0;// 是否同步；0：未同步；1：已同步

	public OutPrison() {

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
	public String getExamine() {
		return examine;
	}
	public void setExamine(String examine) {
		this.examine = examine;
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
	public String getOutReason() {
		return outReason;
	}
	public void setOutReason(String outReason) {
		this.outReason = outReason;
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
	public String getSecurity() {
		return security;
	}
	public void setSecurity(String security) {
		this.security = security;
	}
	public String getSecurityAddress() {
		return securityAddress;
	}
	public void setSecurityAddress(String securityAddress) {
		this.securityAddress = securityAddress;
	}
	public String getSecuIdnum() {
		return secuIdnum;
	}
	public void setSecuIdnum(String secuIdnum) {
		this.secuIdnum = secuIdnum;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getBail() {
		return bail;
	}
	public void setBail(Integer bail) {
		this.bail = bail;
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
	public Prisoner getPrisoner() {
		return prisoner;
	}
	public void setPrisoner(Prisoner prisoner) {
		this.prisoner = prisoner;
	}
	
	
}
