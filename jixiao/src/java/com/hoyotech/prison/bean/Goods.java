package com.hoyotech.prison.bean;

import java.util.Date;

public class Goods {

	private String id;
	private Prisoner prisoner;
	private String goodsNumber;//编号
	private String goodsName;//民称
	private String goodsNorms;//规格
	private String goodsQuantity;//数量
	private String goodsFeature;//特征
	private String goodsRemark;//备注
	private int state=1; //状态
	private Date addTime;
	private Date updateTime;
	private String prisonCode;
	
	private int isSync = 0;// 是否同步；0：未同步；1：已同步

	/** default constructor */
	public Goods() {
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

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsNumber() {
		return goodsNumber;
	}

	public void setGoodsNumber(String goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

	public String getGoodsNorms() {
		return goodsNorms;
	}

	public void setGoodsNorms(String goodsNorms) {
		this.goodsNorms = goodsNorms;
	}

	public String getGoodsQuantity() {
		return goodsQuantity;
	}

	public void setGoodsQuantity(String goodsQuantity) {
		this.goodsQuantity = goodsQuantity;
	}

	public String getGoodsFeature() {
		return goodsFeature;
	}

	public void setGoodsFeature(String goodsFeature) {
		this.goodsFeature = goodsFeature;
	}

	public String getGoodsRemark() {
		return goodsRemark;
	}

	public void setGoodsRemark(String goodsRemark) {
		this.goodsRemark = goodsRemark;
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

}