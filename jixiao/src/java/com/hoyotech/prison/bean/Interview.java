package com.hoyotech.prison.bean;

import java.util.Date;

import com.hoyotech.prison.log.PropertyName;

public class Interview {

	@PropertyName(name = "ID")
	private String id;
	@PropertyName(name = "日期")
	private Date time;
	@PropertyName(name = "会见方式")
	private String type; 
	@PropertyName(name = "被会见人姓名")
	private Prisoner prisoner; //被会见人姓名
	@PropertyName(name = "会见人姓名")
	private String meeter; //会见人姓名
	@PropertyName(name = "与被会见人关系")
	private String relation; //与被会见人关系
	@PropertyName(name = "工作单位或家庭住址")
	private String address; //工作单位或家庭住址
	@PropertyName(name = "证件名称")
	private Document documeType; // 证件类型
	@PropertyName(name = "证件号码")
	private String documeNum; // 证件类型
	@PropertyName(name = "联系电话")
	private String telephone; 
	@PropertyName(name = "会见开始时间")
	private Date startTime;
	@PropertyName(name = "会见结束时间")
	private Date endTime;
	@PropertyName(name = "值班民警")
	private Police policer;
	@PropertyName(name = "备注")
	private String remark;
	private int state = 1;
	private Date addTime;
	private Date updateTime;
	private String prisonCode;
	private int isSync = 0;// 是否同步；0：未同步；1：已同步

	public Interview() {

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Prisoner getPrisoner() {
		return prisoner;
	}

	public void setPrisoner(Prisoner prisoner) {
		this.prisoner = prisoner;
	}

	public String getMeeter() {
		return meeter;
	}

	public void setMeeter(String meeter) {
		this.meeter = meeter;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Document getDocumeType() {
		return documeType;
	}

	public void setDocumeType(Document documeType) {
		this.documeType = documeType;
	}

	public String getDocumeNum() {
		return documeNum;
	}

	public void setDocumeNum(String documeNum) {
		this.documeNum = documeNum;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
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

	public Police getPolicer() {
		return policer;
	}

	public void setPolicer(Police policer) {
		this.policer = policer;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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
