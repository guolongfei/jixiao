package com.hoyotech.prison.bean;

import java.util.Date;

import com.hoyotech.prison.log.PropertyName;

public class UseWeapon {

	@PropertyName(name = "ID")
	private String id;
	@PropertyName(name = "警械的名称")
	private String weaponName;
	@PropertyName(name = "使用开始时间")
	private Date startTime;
	@PropertyName(name = "使用结束时间")
	private Date endTime;
	@PropertyName(name = "原因")
	private String useReason;
	private String delayReason;
	private String dayNum;
	private Date removeTime;
	private String examine="0";
	private int state=1;
	private Date addTime;
	private Date updateTime;
	private String prisonCode;
	private Prisoner prisoner;
	private int isSync = 0;// 是否同步；0：未同步；1：已同步

	public UseWeapon() {

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
	public String getWeaponName() {
		return weaponName;
	}
	public void setWeaponName(String weaponName) {
		this.weaponName = weaponName;
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
	public String getUseReason() {
		return useReason;
	}
	public void setUseReason(String useReason) {
		this.useReason = useReason;
	}
	public String getDelayReason() {
		return delayReason;
	}
	public void setDelayReason(String delayReason) {
		this.delayReason = delayReason;
	}
	public String getDayNum() {
		return dayNum;
	}
	public void setDayNum(String dayNum) {
		this.dayNum = dayNum;
	}
	public Date getRemoveTime() {
		return removeTime;
	}
	public void setRemoveTime(Date removeTime) {
		this.removeTime = removeTime;
	}
	public String getExamine() {
		return examine;
	}
	public void setExamine(String examine) {
		this.examine = examine;
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
