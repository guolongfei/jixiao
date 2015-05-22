package com.hoyotech.prison.bean;

import java.math.BigDecimal;
import java.util.Date;


public class GoodItem {

	private String id;
	private String itemName;//商品名称
	private String itemUnit;//单位
	private BigDecimal itemPrice;//价格
	private int itemNum;
	private String itemCode;//条码
	private int itemType; //商品类型
	private String itemTypeName;
	private Date addTime;
	private Date updateTime;
	private String prisonCode;
	
	private int isSync = 0;// 是否同步；0：未同步；1：已同步

	/** default constructor */
	public GoodItem() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemUnit() {
		return itemUnit;
	}

	public void setItemUnit(String itemUnit) {
		this.itemUnit = itemUnit;
	}

	public BigDecimal getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(BigDecimal itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getItemNum() {
		return itemNum;
	}

	public void setItemNum(int itemNum) {
		this.itemNum = itemNum;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public int getItemType() {
		return itemType;
	}

	public void setItemType(int itemType) {
		this.itemType = itemType;
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

	public String getItemTypeName() {
		if(itemType==1){
			this.itemTypeName = "日用品";
		}else if(itemType==2){
			this.itemTypeName = "传件物品";
		}else if(itemType==3){
			this.itemTypeName = "其他";
		}
		return itemTypeName;
	}

	public void setItemTypeName(String itemTypeName) {
		if(itemType==1){
			this.itemTypeName = "日用品";
		}else if(itemType==2){
			this.itemTypeName = "传件物品";
		}else if(itemType==3){
			this.itemTypeName = "其他";
		}
	}



}