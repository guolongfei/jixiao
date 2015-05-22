package com.hoyotech.prison.bean;

import java.util.Date;

import com.hoyotech.prison.log.PropertyName;

public class Memcon {

	@PropertyName(name = "ID")
	private String id;
	@PropertyName(name = "被询问人")
	private Prisoner prisoner;// 被询问人
	@PropertyName(name = "询问人")
	private Police questioner; // 询问人
	@PropertyName(name = "谈话时间")
	private Date talkTime; // 谈话时间
	@PropertyName(name = "备注")
	private String remark;//备注
	private int state = 1; // 状态
	private Date addTime; // 添加时间
	private Date updateTime; // 修改时间
	private String prisonCode; // 拘留所编码
	private int isSync = 0;// 是否同步；0：未同步；1：已同步

	public Memcon() {
		super();
	}

	public Memcon(String id) {
		super();
		this.id = id;
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

	public Prisoner getPrisoner() {
		return prisoner;
	}

	public void setPrisoner(Prisoner prisoner) {
		this.prisoner = prisoner;
	}

	public Police getQuestioner() {
		return questioner;
	}

	public void setQuestioner(Police questioner) {
		this.questioner = questioner;
	}

	public Date getTalkTime() {
		return talkTime;
	}

	public void setTalkTime(Date talkTime) {
		this.talkTime = talkTime;
	}

	public String getPrisonCode() {
		return prisonCode;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
