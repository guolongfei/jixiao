package com.hoyotech.prison.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hoyotech.prison.log.PropertyName;

public class DetentionArea {

	@PropertyName(name = "ID")
	private String id;
	private PrisonInfo prisonInfo;
	@PropertyName(name = "区域编码")
	private String areaCode;
	@PropertyName(name = "区域名称")
	private String detentionArea;
	@PropertyName(name = "描述")
	private String detentionDesc;
	private int state=1; //状态
	private Date addTime;
	private Date updateTime;
	private String prisonCode;
	private List<DetentionInfo> detentionInfoList = new ArrayList<DetentionInfo>(0);
	
	private int isSync = 0;// 是否同步；0：未同步；1：已同步
	
	@PropertyName(name="区域在拘人数")
	private Integer areaPrisonerNum;

	public Integer getAreaPrisonerNum() {
		return areaPrisonerNum;
	}

	public void setAreaPrisonerNum(Integer areaPrisonerNum) {
		this.areaPrisonerNum = areaPrisonerNum;
	}

	public DetentionArea() {
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

	public PrisonInfo getPrisonInfo() {
		return this.prisonInfo;
	}

	public void setPrisonInfo(PrisonInfo prisonInfo) {
		this.prisonInfo = prisonInfo;
	}

	public String getAreaCode() {
		return this.areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getDetentionArea() {
		return this.detentionArea;
	}

	public void setDetentionArea(String detentionArea) {
		this.detentionArea = detentionArea;
	}

	public String getDetentionDesc() {
		return this.detentionDesc;
	}

	public void setDetentionDesc(String detentionDesc) {
		this.detentionDesc = detentionDesc;
	}

	public Date getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getPrisonCode() {
		return this.prisonCode;
	}

	public void setPrisonCode(String prisonCode) {
		this.prisonCode = prisonCode;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public List<DetentionInfo> getDetentionInfoList() {
		return detentionInfoList;
	}

	public void setDetentionInfoList(List<DetentionInfo> detentionInfoList) {
		this.detentionInfoList = detentionInfoList;
	}

}