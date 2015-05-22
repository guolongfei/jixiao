package com.hoyotech.prison.bean;

import java.util.Date;

import com.hoyotech.prison.log.PropertyName;

public class Doctor {

	@PropertyName(name = "ID")
	private String id;
	@PropertyName(name = "就诊日期")
	private Date time;
	@PropertyName(name = "姓名")
	private Prisoner name;
	@PropertyName(name="性别")
	private Dictionary gender;
	@PropertyName(name = "拘室")
	private String roomNum;
	@PropertyName(name = "主要症状")
	private String content;
	@PropertyName(name = "诊疗措施")
	private String measures;
	@PropertyName(name = "被拘留人签字")
	private String prisonerName;
	@PropertyName(name = "医生签字")
	private Medical doctorName;
	private int state = 1;
	private Date addTime;
	private Date updateTime;
	private String prisonCode;
	private int isSync = 0;// 是否同步；0：未同步；1：已同步

	public Doctor() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
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

	public String getMeasures() {
		return measures;
	}

	public void setMeasures(String measures) {
		this.measures = measures;
	}
	
	public String getPrisonerName() {
		return prisonerName;
	}

	public void setPrisonerName(String prisonerName) {
		this.prisonerName = prisonerName;
	}

	public Medical getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(Medical doctorName) {
		this.doctorName = doctorName;
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
