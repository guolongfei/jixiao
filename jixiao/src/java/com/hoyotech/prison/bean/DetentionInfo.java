package com.hoyotech.prison.bean;

import java.util.Date;

import com.hoyotech.prison.log.PropertyName;

public class DetentionInfo {

	@PropertyName(name = "ID")
	private String id;
	private PrisonInfo prisonInfo;
	@PropertyName(name = "区域")
	private DetentionArea detentionArea;
	@PropertyName(name = "拘室编码")
	private String detentionCode;
	@PropertyName(name = "拘室名称")
	private String detentionName;
	@PropertyName(name = "容纳人数")
	private Integer capacity;
	private int state=1; //状态
	private Date addTime;
	private Date updateTime;
	private String prisonCode;
	private int isSync = 0;// 是否同步；0：未同步；1：已同步
	
	@PropertyName(name = "主管民警")
	private String chargePolice;
	@PropertyName(name = "协管民警")
	private String stewardPolice;
	@PropertyName(name = "拘室在拘人数")
	private Integer infoPrisonerNum;
	
	public Integer getInfoPrisonerNum() {
		return infoPrisonerNum;
	}

	public void setInfoPrisonerNum(Integer infoPrisonerNum) {
		this.infoPrisonerNum = infoPrisonerNum;
	}

	/** default constructor */
	public DetentionInfo() {	
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getChargePolice() {
		return chargePolice;
	}

	public void setChargePolice(String chargePolice) {
		this.chargePolice = chargePolice;
	}

	public String getStewardPolice() {
		return stewardPolice;
	}

	public void setStewardPolice(String stewardPolice) {
		this.stewardPolice = stewardPolice;
	}

	
	public int getIsSync() {
		return isSync;
	}

	public void setIsSync(int isSync) {
		this.isSync = isSync;
	}
	
	public DetentionInfo(String id) {
		super();
		this.id = id;
	}

	public PrisonInfo getPrisonInfo() {
		return this.prisonInfo;
	}

	public void setPrisonInfo(PrisonInfo prisonInfo) {
		this.prisonInfo = prisonInfo;
	}

	public DetentionArea getDetentionArea() {
		return this.detentionArea;
	}

	public void setDetentionArea(DetentionArea detentionArea) {
		this.detentionArea = detentionArea;
	}

	public String getDetentionCode() {
		return this.detentionCode;
	}

	public void setDetentionCode(String detentionCode) {
		this.detentionCode = detentionCode;
	}

	public String getDetentionName() {
		return this.detentionName;
	}

	public void setDetentionName(String detentionName) {
		this.detentionName = detentionName;
	}

	public Integer getCapacity() {
		return this.capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
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
}