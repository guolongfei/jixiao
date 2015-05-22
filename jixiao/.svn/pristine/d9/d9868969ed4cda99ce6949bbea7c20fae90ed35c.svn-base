package com.hoyotech.prison.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TakeMedicine {
	private String id;
	private String startTime;
	private DrugManage drugManage;
	private String remarks;
	private String prisoner;
	
	private int state;
	private Date updateTime;
	private Date addTime;
	private String prisonCode;
	private int isSync=1;
	private String startTimeReal;
	public TakeMedicine(){
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}


	public DrugManage getDrugManage() {
		return drugManage;
	}

	public void setDrugManage(DrugManage drugManage) {
		this.drugManage = drugManage;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getPrisoner() {
		return prisoner;
	}

	public void setPrisoner(String prisoner) {
		this.prisoner = prisoner;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
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

	public String getStartTimeReal() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date d = new Date();
		d.setTime(Long.parseLong(startTime)*1000);
		return sdf.format(d);
	}

	public void setStartTimeReal(String startTimeReal) {
		this.startTimeReal = startTimeReal;
	}
	
	
}
