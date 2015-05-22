package com.hoyotech.prison.bean;

import java.util.Date;

import com.hoyotech.prison.log.PropertyName;

public class Organization {

	@PropertyName(name = "ID")
	private String id;
	@PropertyName(name = "组织机构名称")
	private String orgName;
	@PropertyName(name = "上级组织")
	private Organization parentOrg;
	@PropertyName(name = "行政区划")
	private Integer orgLevel;
	private Integer state = 1;
	@PropertyName(name = "电话")
	private String tel;
	@PropertyName(name = "电子邮箱")
	private String email;
	@PropertyName(name = "地址")
	private String address;
	@PropertyName(name = "网址")
	private String website;
	private String orgCode;
	@PropertyName(name = "描述")
	private String orgDesc;
	private Date addTime;
	private Date updateTime;
	private String path;
	private Area area;
	private int isSync = 0;// 是否同步；0：未同步；1：已同步
	
	public Organization() {
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
	
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getOrgName() {
		return this.orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public Organization getParentOrg() {
		return parentOrg;
	}

	public void setParentOrg(Organization parentOrg) {
		this.parentOrg = parentOrg;
	}

	public Integer getOrgLevel() {
		return this.orgLevel;
	}

	public void setOrgLevel(Integer orgLevel) {
		this.orgLevel = orgLevel;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getOrgCode() {
		return this.orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getOrgDesc() {
		return orgDesc;
	}

	public void setOrgDesc(String orgDesc) {
		this.orgDesc = orgDesc;
	}

	public Date getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}
	
}