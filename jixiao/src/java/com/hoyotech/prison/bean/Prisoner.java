package com.hoyotech.prison.bean;

import java.util.Date;

import com.hoyotech.prison.log.PropertyName;

public class Prisoner {

	private String id;
	private String noYear;
	private String noNumber;
	private String fileNumber;
	private PrisonInfo prison;
	@PropertyName(name = "编码")
	private String prisonerCode; // 被拘留人编码
	@PropertyName(name = "姓名")
	private String name; // 姓名
	@PropertyName(name = "曾用名")
	private String nickName; // 曾用名
	@PropertyName(name = "性别")
	private Dictionary gender; // 性别
	@PropertyName(name = "出生日期")
	private Date birthday; // 出生日期
	@PropertyName(name = "入所年龄")
	private String age;
	private Peoples psoples; // 名族
	private int height; // 身高
	private int footLength; // 足长
	private Document documeType; // 证件类型
	@PropertyName(name = "证件号码")
	private String documeNum; // 证件号码
	private Dictionary marryStatus; // 婚姻状况
	private Nationality nationality; // 国籍
	private Dictionary origionPlace; // 籍贯
	private Dictionary accountLocation; // 户口所在地
	@PropertyName(name = "户口所在地详细地址")
	private String detailedAccount; // 户口所在地详细地址
	private Dictionary address; // 现居住地
	@PropertyName(name = "现居住地详细地址")
	private String detailedAddress; // 现居住地详细地址
	@PropertyName(name = "工作单位")
	private String workPlace; // 工作单位
	private Dictionary educationLevel; // 文化程度
	private Career carer; // 职业
	private Dictionary status; // 身份
	private Dictionary specialStatus; // 特殊身份
	@PropertyName(name = "入所日期")
	private Date dateInprison; // 入所时间
	private Dictionary imprisonReason; // 入所原因
	private Dictionary handleType; // 办案单位类型
	private WorkUnit handleCases; // 办案单位
	@PropertyName(name = "收拘法律文书号")
	private String detenDocuNum; // 收拘法律文书号
	private Dictionary crime; // 违法行为
	@PropertyName(name = "案情")
	private String sammary; // 简要案情
	private Dictionary voucher; // 收拘凭证
	@PropertyName(name = "拘留期限:天")
	private int detenPeriod; // 拘留期限
	private Dictionary dangerLevel; // 危险等级
	private Date dateOutprison; // 出所时间
	private Date realityOutTime; //实际出所时间
	private Dictionary outprisonReson; // 出所原因
	private String releaseDocuNum; // 释放法律文书号
	@PropertyName(name = "拘室")
	private DetentionInfo detentionInfo; // 拘室
	private Dictionary managerClasses; // 人员管理类别
	private Dictionary dateCheck; // 数据核实情况
	@PropertyName(name = "采集数据人员")
	private String datagatherName; // 采集数据人员姓名
	@PropertyName(name = "核实数据民警")
	private String datacheckerName; // 核实数据民警姓名
	@PropertyName(name = "备注")
	private String remark; // 备注
	private String xLetters;
	private int state = 1;
	private Date addTime;
	private Date updateTime;
	private String prisonCode;
	private int isSync = 0;// 是否同步；0：未同步；1：已同步
	public Prisoner() {
		super();
	}
	
	
	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public String getFileNumber() {
		return fileNumber;
	}


	public void setFileNumber(String fileNumber) {
		this.fileNumber = fileNumber;
	}


	public Prisoner(String id) {
		super();
		this.id = id;
	}

	
	public Date getRealityOutTime() {
		return realityOutTime;
	}


	public void setRealityOutTime(Date realityOutTime) {
		this.realityOutTime = realityOutTime;
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
	public String getxLetters() {
		return xLetters;
	}

	public void setxLetters(String xLetters) {
		this.xLetters = xLetters;
	}

	public PrisonInfo getPrison() {
		return prison;
	}

	public void setPrison(PrisonInfo prison) {
		this.prison = prison;
	}

	public String getPrisonerCode() {
		return prisonerCode;
	}

	public void setPrisonerCode(String prisonerCode) {
		this.prisonerCode = prisonerCode;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Dictionary getGender() {
		return gender;
	}

	public void setGender(Dictionary gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Peoples getPsoples() {
		return psoples;
	}

	public void setPsoples(Peoples psoples) {
		this.psoples = psoples;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getFootLength() {
		return footLength;
	}

	public void setFootLength(int footLength) {
		this.footLength = footLength;
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

	public Dictionary getMarryStatus() {
		return marryStatus;
	}

	public void setMarryStatus(Dictionary marryStatus) {
		this.marryStatus = marryStatus;
	}

	public Nationality getNationality() {
		return nationality;
	}

	public void setNationality(Nationality nationality) {
		this.nationality = nationality;
	}

	public Dictionary getOrigionPlace() {
		return origionPlace;
	}

	public void setOrigionPlace(Dictionary origionPlace) {
		this.origionPlace = origionPlace;
	}

	public Dictionary getAccountLocation() {
		return accountLocation;
	}

	public void setAccountLocation(Dictionary accountLocation) {
		this.accountLocation = accountLocation;
	}

	public String getDetailedAccount() {
		return detailedAccount;
	}

	public void setDetailedAccount(String detailedAccount) {
		this.detailedAccount = detailedAccount;
	}

	public Dictionary getAddress() {
		return address;
	}

	public void setAddress(Dictionary address) {
		this.address = address;
	}

	public String getDetailedAddress() {
		return detailedAddress;
	}

	public void setDetailedAddress(String detailedAddress) {
		this.detailedAddress = detailedAddress;
	}

	public String getWorkPlace() {
		return workPlace;
	}

	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}

	public Dictionary getEducationLevel() {
		return educationLevel;
	}

	public void setEducationLevel(Dictionary educationLevel) {
		this.educationLevel = educationLevel;
	}

	public Career getCarer() {
		return carer;
	}

	public void setCarer(Career carer) {
		this.carer = carer;
	}

	public Dictionary getStatus() {
		return status;
	}

	public void setStatus(Dictionary status) {
		this.status = status;
	}

	public Dictionary getSpecialStatus() {
		return specialStatus;
	}

	public void setSpecialStatus(Dictionary specialStatus) {
		this.specialStatus = specialStatus;
	}

	public Date getDateInprison() {
		return dateInprison;
	}

	public void setDateInprison(Date dateInprison) {
		this.dateInprison = dateInprison;
	}

	public Dictionary getImprisonReason() {
		return imprisonReason;
	}

	public void setImprisonReason(Dictionary imprisonReason) {
		this.imprisonReason = imprisonReason;
	}

	public Dictionary getHandleType() {
		return handleType;
	}

	public void setHandleType(Dictionary handleType) {
		this.handleType = handleType;
	}

	public WorkUnit getHandleCases() {
		return handleCases;
	}

	public void setHandleCases(WorkUnit handleCases) {
		this.handleCases = handleCases;
	}

	public String getDetenDocuNum() {
		return detenDocuNum;
	}

	public void setDetenDocuNum(String detenDocuNum) {
		this.detenDocuNum = detenDocuNum;
	}

	public Dictionary getCrime() {
		return crime;
	}

	public void setCrime(Dictionary crime) {
		this.crime = crime;
	}

	public String getSammary() {
		return sammary;
	}

	public void setSammary(String sammary) {
		this.sammary = sammary;
	}

	public Dictionary getVoucher() {
		return voucher;
	}

	public void setVoucher(Dictionary voucher) {
		this.voucher = voucher;
	}

	public int getDetenPeriod() {
		return detenPeriod;
	}

	public void setDetenPeriod(int detenPeriod) {
		this.detenPeriod = detenPeriod;
	}

	public Dictionary getDangerLevel() {
		return dangerLevel;
	}

	public void setDangerLevel(Dictionary dangerLevel) {
		this.dangerLevel = dangerLevel;
	}

	public Date getDateOutprison() {
		return dateOutprison;
	}

	public void setDateOutprison(Date dateOutprison) {
		this.dateOutprison = dateOutprison;
	}

	public Dictionary getOutprisonReson() {
		return outprisonReson;
	}

	public void setOutprisonReson(Dictionary outprisonReson) {
		this.outprisonReson = outprisonReson;
	}

	public String getReleaseDocuNum() {
		return releaseDocuNum;
	}

	public void setReleaseDocuNum(String releaseDocuNum) {
		this.releaseDocuNum = releaseDocuNum;
	}

	public DetentionInfo getDetentionInfo() {
		return detentionInfo;
	}

	public void setDetentionInfo(DetentionInfo detentionInfo) {
		this.detentionInfo = detentionInfo;
	}

	public Dictionary getManagerClasses() {
		return managerClasses;
	}

	public void setManagerClasses(Dictionary managerClasses) {
		this.managerClasses = managerClasses;
	}

	public Dictionary getDateCheck() {
		return dateCheck;
	}

	public void setDateCheck(Dictionary dateCheck) {
		this.dateCheck = dateCheck;
	}

	public String getDatagatherName() {
		return datagatherName;
	}

	public void setDatagatherName(String datagatherName) {
		this.datagatherName = datagatherName;
	}

	public String getDatacheckerName() {
		return datacheckerName;
	}

	public void setDatacheckerName(String datacheckerName) {
		this.datacheckerName = datacheckerName;
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
}
