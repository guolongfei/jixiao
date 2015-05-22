package com.hoyotech.prison.bean;

import java.util.Date;

import com.hoyotech.prison.log.PropertyName;

public class Reception {

	@PropertyName(name = "ID")
	private String id;
	@PropertyName(name = "所领导姓名")
	private Police leadName;
	@PropertyName(name = "接待时间")
	private Date time;
	@PropertyName(name = "地点")
	private String address;
	@PropertyName(name = "来访人姓名")
	private String visitName;
	private Dictionary gender; // 性别
	@PropertyName(name = "年龄")
	private int age;
	@PropertyName(name = "工作单位")
	private String workAddress;
	@PropertyName(name = "电话号码")
	private String phone;
	@PropertyName(name = "反应的问题")
	private String problems;
	@PropertyName(name = "当时的答复意见")
	private String reply;
	@PropertyName(name = "事后处理情况")
	private String afterHandle;
	private int state = 1;
	private Date addTime;
	private Date updateTime;
	private String prisonCode;
	private int isSync = 0;// 是否同步；0：未同步；1：已同步

	public Reception() {

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
	public Police getLeadName() {
		return leadName;
	}

	public void setLeadName(Police leadName) {
		this.leadName = leadName;
	}

	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getVisitName() {
		return visitName;
	}
	public void setVisitName(String visitName) {
		this.visitName = visitName;
	}
	public Dictionary getGender() {
		return gender;
	}
	public void setGender(Dictionary gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getWorkAddress() {
		return workAddress;
	}
	public void setWorkAddress(String workAddress) {
		this.workAddress = workAddress;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getProblems() {
		return problems;
	}
	public void setProblems(String problems) {
		this.problems = problems;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getAfterHandle() {
		return afterHandle;
	}
	public void setAfterHandle(String afterHandle) {
		this.afterHandle = afterHandle;
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
