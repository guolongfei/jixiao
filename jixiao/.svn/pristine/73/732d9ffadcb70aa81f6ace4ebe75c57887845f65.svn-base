package com.hoyotech.prison.bean;

import java.math.BigDecimal;
import java.util.Date;

public class SthIn {

	private String id;
	private Prisoner prisoner;
	private int inType;
	private String trans_people;//
	private String tel;
	private BigDecimal money; 
	private Date addTime;
	private Date updateTime;
	private String prisonCode;
	private String inTypeName;
	private int isSync = 0;// 是否同步；0：未同步；1：已同步

	/** default constructor */
	public SthIn() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Prisoner getPrisoner() {
		return prisoner;
	}

	public void setPrisoner(Prisoner prisoner) {
		this.prisoner = prisoner;
	}

	public int getInType() {
		return inType;
	}

	public void setInType(int inType) {
		this.inType = inType;
	}

	public String getTrans_people() {
		return trans_people;
	}

	public void setTrans_people(String trans_people) {
		this.trans_people = trans_people;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
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

	public String getInTypeName() {
		if(this.inType==1){
			inTypeName = "传件款";
		}else if(this.inType==2){
			inTypeName = "伙食费";
		}else if(this.inType==3){
			inTypeName = "保证金";
		}
		return inTypeName;
	}

	public void setInTypeName(String inTypeName) {
		this.inTypeName = inTypeName;
	}

}