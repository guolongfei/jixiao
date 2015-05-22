package com.hoyotech.prison.bean;

import java.util.Date;

import com.hoyotech.prison.log.PropertyName;

public class Police {

	@PropertyName(name = "ID")
	private String id;
	@PropertyName(name = "姓名")
	private String name;
	@PropertyName(name = "警员编号")
	private String number;
	@PropertyName(name = "警号")
	private String policeNumber;//警号
	@PropertyName(name = "出生日期")
	private Date birthday;//出生日期
	@PropertyName(name = "身份证号")
	private String IDNumber;//身份证号
	@PropertyName(name = "性别")
	private Dictionary gender;//性别
	@PropertyName(name = "民族")
	private Peoples peoples;//民族
	@PropertyName(name = "政治面貌")
	private Dictionary politicalStatus;//政治面貌
	@PropertyName(name = "教育水平")
	private Dictionary educational;//教育水平
	@PropertyName(name = "职位")
	private Dictionary post;//职位
	@PropertyName(name = "籍贯")
	private Dictionary originPlace;//籍贯
	@PropertyName(name = "状态")
	private Dictionary status;//状态
	@PropertyName(name = "警衔")
	private String policeRank;//警衔
	@PropertyName(name = "行政级别")
	private String adminLevel;//行政级别
	@PropertyName(name = "技术职称")
	private String techTitle;//技术职称
	@PropertyName(name = "工作年限")
	private String workPeriod;//工作年限
	@PropertyName(name = "入党时间")
	private Date partyTime;//入党时间
	private Integer state = 1;
	private String letters;
	private Date addTime;
	private Date updateTime;
	private String prisonCode;
	private Integer isSync = 0;// 是否同步；0：未同步；1：已同步

	public Integer getIsSync() {
		return isSync;
	}


	public void setIsSync(Integer isSync) {
		this.isSync = isSync;
	}


	public Police() {

	}


	public String getLetters() {
		return letters;
	}




	public void setLetters(String letters) {
		this.letters = letters;
	}




	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPoliceNumber() {
		return policeNumber;
	}

	public void setPoliceNumber(String policeNumber) {
		this.policeNumber = policeNumber;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getIDNumber() {
		return IDNumber;
	}

	public void setIDNumber(String iDNumber) {
		IDNumber = iDNumber;
	}

	public Dictionary getGender() {
		return gender;
	}

	public void setGender(Dictionary gender) {
		this.gender = gender;
	}

	public Peoples getPeoples() {
		return peoples;
	}

	public void setPeoples(Peoples peoples) {
		this.peoples = peoples;
	}

	public Dictionary getPoliticalStatus() {
		return politicalStatus;
	}

	public void setPoliticalStatus(Dictionary politicalStatus) {
		this.politicalStatus = politicalStatus;
	}

	public Dictionary getEducational() {
		return educational;
	}

	public void setEducational(Dictionary educational) {
		this.educational = educational;
	}

	public Dictionary getPost() {
		return post;
	}

	public void setPost(Dictionary post) {
		this.post = post;
	}

	public Dictionary getOriginPlace() {
		return originPlace;
	}

	public void setOriginPlace(Dictionary originPlace) {
		this.originPlace = originPlace;
	}

	public String getPoliceRank() {
		return policeRank;
	}

	public void setPoliceRank(String policeRank) {
		this.policeRank = policeRank;
	}

	public Dictionary getStatus() {
		return status;
	}

	public void setStatus(Dictionary status) {
		this.status = status;
	}

	public String getAdminLevel() {
		return adminLevel;
	}

	public void setAdminLevel(String adminLevel) {
		this.adminLevel = adminLevel;
	}

	public String getTechTitle() {
		return techTitle;
	}

	public void setTechTitle(String techTitle) {
		this.techTitle = techTitle;
	}

	public String getWorkPeriod() {
		return workPeriod;
	}

	public void setWorkPeriod(String workPeriod) {
		this.workPeriod = workPeriod;
	}

	public Date getPartyTime() {
		return partyTime;
	}

	public void setPartyTime(Date partyTime) {
		this.partyTime = partyTime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
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