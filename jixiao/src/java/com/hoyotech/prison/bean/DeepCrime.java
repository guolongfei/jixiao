package com.hoyotech.prison.bean;

import java.util.Date;

import com.hoyotech.prison.log.PropertyName;

public class DeepCrime {

	@PropertyName(name = "ID")
	private String id;
	@PropertyName(name = "日期")
	private Date time; //日期
	@PropertyName(name = "检举人")
	private Prisoner name; //检举人
	@PropertyName(name = "民警")
	private String policer; //民警
	@PropertyName(name = "简要内容")
	private String content; //简要内容
	@PropertyName(name = "审核人")
	private String checker; //审核人
	@PropertyName(name = "转递日期")
	private Date passTime; //转递日期
	@PropertyName(name = "办案单位")
	private String unit; //办案单位
	@PropertyName(name = "反馈日期")
	private Date backTime; //反馈日期
	@PropertyName(name = "刑事案件")
	private int caseCount;
	@PropertyName(name = "抓捕")
	private int chase;
	@PropertyName(name = "发现")
	private int find;
	@PropertyName(name = "追脏")
	private int money;
	private int state = 1;
	private Date addTime;
	private Date updateTime;
	private String prisonCode;
	private int isSync = 0;// 是否同步；0：未同步；1：已同步

	public DeepCrime() {

	}

	public Prisoner getName() {
		return name;
	}

	public void setName(Prisoner name) {
		this.name = name;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getChecker() {
		return checker;
	}

	public void setChecker(String checker) {
		this.checker = checker;
	}

	public Date getPassTime() {
		return passTime;
	}

	public void setPassTime(Date passTime) {
		this.passTime = passTime;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Date getBackTime() {
		return backTime;
	}

	public void setBackTime(Date backTime) {
		this.backTime = backTime;
	}

	public int getCaseCount() {
		return caseCount;
	}

	public void setCaseCount(int caseCount) {
		this.caseCount = caseCount;
	}

	public int getChase() {
		return chase;
	}

	public void setChase(int chase) {
		this.chase = chase;
	}

	public int getFind() {
		return find;
	}

	public void setFind(int find) {
		this.find = find;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getPolicer() {
		return policer;
	}

	public void setPolicer(String policer) {
		this.policer = policer;
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
