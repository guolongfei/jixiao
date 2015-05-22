package com.hoyotech.prison.bean;

import java.util.Date;

import com.hoyotech.prison.log.PropertyName;

public class AnalysisMeeting {
	@PropertyName(name = "ID")
	private String id;
	@PropertyName(name = "会议开始时间")
	private Date startTime;
	@PropertyName(name = "会议结束时间")
	private Date endTime;
	@PropertyName(name = "地点")
	private String address;
	@PropertyName(name = "主持人")
	private String hoster;
	@PropertyName(name = "记录人")
	private String recorder;
	@PropertyName(name = "参与人员")
	private String attenders;
	@PropertyName(name = "内容")
	private String content;
	
	private int state=1; 
	private String prisonCode;
	private Date addTime;
	private Date updateTime;
	private int isSync = 0;// 是否同步；0：未同步；1：已同步
	
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHoster() {
		return hoster;
	}
	public void setHoster(String hoster) {
		this.hoster = hoster;
	}
	public String getRecorder() {
		return recorder;
	}
	public void setRecorder(String recorder) {
		this.recorder = recorder;
	}
	public String getAttenders() {
		return attenders;
	}
	public void setAttenders(String attenders) {
		this.attenders = attenders;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getPrisonCode() {
		return prisonCode;
	}
	public void setPrisonCode(String prisonCode) {
		this.prisonCode = prisonCode;
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
	public int getIsSync() {
		return isSync;
	}
	public void setIsSync(int isSync) {
		this.isSync = isSync;
	}
	
	
}
