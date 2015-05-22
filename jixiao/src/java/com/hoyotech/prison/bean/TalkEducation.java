package com.hoyotech.prison.bean;

import java.util.Date;

import com.hoyotech.prison.log.PropertyName;

public class TalkEducation {

	@PropertyName(name = "ID")
	private String id;
	@PropertyName(name = "谈话教育开始时间")
	private Date startTime;
	@PropertyName(name = "谈话教育结束时间")
	private Date endTime;
	@PropertyName(name = "谈话人姓名")
	private Police talker;
	@PropertyName(name = "单位")
	private String unit;
	@PropertyName(name = "被拘留人姓名")
	private String prisoner;
	@PropertyName(name="性别")
	private Dictionary gender;
	@PropertyName(name="年龄")
	private int age;
	@PropertyName(name = "入所时间")
	private Date inTime;
	@PropertyName(name = "案由")
	private String reason;
	@PropertyName(name = "谈话教育内容")
	private String content;
	@PropertyName(name = "签名")
	private String signature;
	private int state = 1;
	private Date addTime;
	private Date updateTime;
	private String prisonCode;
	private int isSync = 0;// 是否同步；0：未同步；1：已同步

	public TalkEducation() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Police getTalker() {
		return talker;
	}

	public void setTalker(Police talker) {
		this.talker = talker;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getPrisoner() {
		return prisoner;
	}

	public void setPrisoner(String prisoner) {
		this.prisoner = prisoner;
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

	public Date getInTime() {
		return inTime;
	}

	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
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

	public int getIsSync() {
		return isSync;
	}

	public void setIsSync(int isSync) {
		this.isSync = isSync;
	}
	
	
}
