package com.hoyotech.prison.bean;

import java.util.Date;
import com.hoyotech.prison.log.PropertyName;

public class PrisonInfo {

	@PropertyName(name = "ID")
	private String id;
	@PropertyName(name = "拘留所编码")
	private String prisonCode; // 拘留所编码
	@PropertyName(name = "拘留所公安机关代码")
	private String publicSecurityOrganCode; // 拘留所公安机关代码
	@PropertyName(name = "拘留所名称")
	private String prisonName; // 拘留所名称
	private Area area;// 所在行政区域
	@PropertyName(name = "详细地址")
	private String address; // 所在地详细地址
	@PropertyName(name = "电话")
	private String telephone; // 电话
	@PropertyName(name = "传真")
	private String fax; // 传真
	@PropertyName(name = "邮政编码")
	private int zipCode; // 邮政编码
	@PropertyName(name = "电子信箱")
	private String email; // 电子信箱
	@PropertyName(name = "主要负责人姓名")
	private String prisonheadsName; // 主要负责人姓名
	@PropertyName(name = "拘留所等级")
	private Dictionary prisonLevel; // 拘留所等级
	@PropertyName(name = "拘留所规模")
	private Dictionary prisonSize; // 拘留所规模
	@PropertyName(name = "民警总数")
	private int policeNum; // 民警总数
	@PropertyName(name = "编制人数")
	private int preparationNum; // 编制人数
	@PropertyName(name = "拘室数")
	private int cellNum; // 拘室数
	@PropertyName(name = "设计容量")
	private int designCapacity; // 设计容量
	private int state = 1;
	private Date addTime;
	private Date updateTime;
	private Organization org; //组织结构
	private byte[] prisonImage;//拘留所风貌图片
	
	
	

	public byte[] getPrisonImage() {
		return prisonImage;
	}

	public void setPrisonImage(byte[] prisonImage) {
		this.prisonImage = prisonImage;
	}

	private int isSync = 0;// 是否同步；0：未同步；1：已同步
	
	public PrisonInfo() {
		super();
	}
	
	public PrisonInfo(String id) {
		super();
		this.id = id;
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

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPrisonCode() {
		return prisonCode;
	}

	public void setPrisonCode(String prisonCode) {
		this.prisonCode = prisonCode;
	}

	public String getPublicSecurityOrganCode() {
		return publicSecurityOrganCode;
	}

	public void setPublicSecurityOrganCode(String publicSecurityOrganCode) {
		this.publicSecurityOrganCode = publicSecurityOrganCode;
	}

	public String getPrisonName() {
		return prisonName;
	}

	public void setPrisonName(String prisonName) {
		this.prisonName = prisonName;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPrisonheadsName() {
		return prisonheadsName;
	}

	public void setPrisonheadsName(String prisonheadsName) {
		this.prisonheadsName = prisonheadsName;
	}

	public Dictionary getPrisonLevel() {
		return prisonLevel;
	}

	public void setPrisonLevel(Dictionary prisonLevel) {
		this.prisonLevel = prisonLevel;
	}

	public Dictionary getPrisonSize() {
		return prisonSize;
	}

	public void setPrisonSize(Dictionary prisonSize) {
		this.prisonSize = prisonSize;
	}

	public int getPoliceNum() {
		return policeNum;
	}

	public void setPoliceNum(int policeNum) {
		this.policeNum = policeNum;
	}

	public int getPreparationNum() {
		return preparationNum;
	}

	public void setPreparationNum(int preparationNum) {
		this.preparationNum = preparationNum;
	}

	public int getCellNum() {
		return cellNum;
	}

	public void setCellNum(int cellNum) {
		this.cellNum = cellNum;
	}

	public int getDesignCapacity() {
		return designCapacity;
	}

	public void setDesignCapacity(int designCapacity) {
		this.designCapacity = designCapacity;
	}

	public Organization getOrg() {
		return org;
	}

	public void setOrg(Organization org) {
		this.org = org;
	}

	public int getIsSync() {
		return isSync;
	}

	public void setIsSync(int isSync) {
		this.isSync = isSync;
	}

}
