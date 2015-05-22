package com.hoyotech.prison.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class PrisonerGoods {

	private String id;
	private String noYear; // 编号.年
	private String noNumber; // 编号.流水号
	private Prisoner prisoner;
	private String cashRMB; //现金.人民币
	private String cashForeign;//现金.外币
	private Police inPrisonHandlePolice;// 入所经办民警
	private Date inPrisonHandleDate;// 入所经办时间
	private Police outPrisonHandlePolice;// 出所经办民警
	private Date outPrisonHandleDate;// 出所经办时间
	private Set<Goods> goods = new HashSet<Goods>(0);// 涉案物品集合
	
	private int state=1; //状态
	private Date addTime;
	private Date updateTime;
	private String prisonCode;
	private int isSync = 0;// 是否同步；0：未同步；1：已同步

	/** default constructor */
	public PrisonerGoods() {
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
		return this.prisoner;
	}

	public void setPrisoner(Prisoner prisoner) {
		this.prisoner = prisoner;
	}

	public String getNoYear() {
		return noYear;
	}

	public void setNoYear(String noYear) {
		this.noYear = noYear;
	}

	public String getNoNumber() {
		return noNumber;
	}

	public void setNoNumber(String noNumber) {
		this.noNumber = noNumber;
	}

	public String getCashRMB() {
		return cashRMB;
	}

	public void setCashRMB(String cashRMB) {
		this.cashRMB = cashRMB;
	}

	public String getCashForeign() {
		return cashForeign;
	}

	public void setCashForeign(String cashForeign) {
		this.cashForeign = cashForeign;
	}

	public Police getInPrisonHandlePolice() {
		return inPrisonHandlePolice;
	}

	public void setInPrisonHandlePolice(Police inPrisonHandlePolice) {
		this.inPrisonHandlePolice = inPrisonHandlePolice;
	}

	public Date getInPrisonHandleDate() {
		return inPrisonHandleDate;
	}

	public void setInPrisonHandleDate(Date inPrisonHandleDate) {
		this.inPrisonHandleDate = inPrisonHandleDate;
	}

	public Police getOutPrisonHandlePolice() {
		return outPrisonHandlePolice;
	}

	public void setOutPrisonHandlePolice(Police outPrisonHandlePolice) {
		this.outPrisonHandlePolice = outPrisonHandlePolice;
	}

	public Date getOutPrisonHandleDate() {
		return outPrisonHandleDate;
	}

	public void setOutPrisonHandleDate(Date outPrisonHandleDate) {
		this.outPrisonHandleDate = outPrisonHandleDate;
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

	public Set<Goods> getGoods() {
		return goods;
	}

	public void setGoods(Set<Goods> goods) {
		this.goods = goods;
	}
}