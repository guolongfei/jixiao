package com.hoyotech.prison.util;

public class ConfigHelper {
	private static ConfigHelper config = null;

	// 日志操作状态
	private int succeed = 1;
	private int fail = 0;
	private int error = -1;

	// 日志操作类型
	private int login = 0;
	private int insert = 1;
	private int update = 2;
	private int query = 3;
	private int delete = 4;

	// 日志操作模块

	// 被拘留人管理
	private String prisonerManage = "被拘留人";
	private String  medical= "医务人员";
	private String appealDataPass="被拘留人申诉控告等材料转递函";
	private String arraign="提解被拘留人登记";
	private String askRegistration="询问被拘留人登记";
	private String car="车辆管理";
	private String civilian="文职人员管理";
	private String contrabandGood="涉案物品";
	private String crimeKeyPass="违法犯罪线索转递函";
	private String daishou="代收财物登记";
	private String deathNotice="被拘留人死亡通知";
	private String deepCrime="深挖犯罪线索登记";
	private String detainReturn="收拘回执";
	private String detentionArea="监所区域";
	private String detentionInfo="拘室管理";
	private String doctor="所内就医登记";
	private String education="集体教育记录";
	private String emergency="应急预案演练"; 
	private String executeReturn="异地执行拘留";
	private String executionDetain="代为执行行政拘留";
	private String handleSeparate="建议另行处理通知";
	private String handOver="接班记录管理";
	private String inspect="视察检查记录";
	private String interview="会见登记";
	private String leaveExpires="请假出所到期";
	private String logistic="工勤人员信息";
	private String memcon="谈话记录";
	private String memconContent="谈话内容";
	private String organization="组织结构";
	private String outDoctor="出所就医登记";
	private String outPrison="请假出所审批";
	private String police="警务人员信息";
	private String device="装备信息";
	private String prisonerGoods="暂存物品管理";
	private String prisonHealth="被拘留人健康表";
	private String prisonInfo="拘留所管理";
	private String user="用户管理";
	private String reception="所长接待记录";
	private String refuseDetain="不予拘留通知";
	private String removeDetain="解除拘留证明";
	private String role="角色管理";
	private String safeCheck="安全检查记录";
	private String sendExamine="临时寄押审批";
	private String stopDetain="停止执行拘留";
	private String strictManage="严管登记信息";
	private String userDetention="拘室监控";
	private String userDuty="交接班管理";
	private String useWeapon="使用警械审批管理";
	private String workUnit="办案单位管理";
	private String wrongDetain="可能错误拘留通知书";
	private String meetingRecord="会议记录";
	private String analysisMetting="动态分析会议记录";
	private String handleConflict="社会矛盾化解工作记录";
	private String patrolRecord="巡视监控记录";
	private String societyOpen="对社会开放记录";
	private String talkEducation="谈话教育记录";
	private String jiangcheng="奖惩记录";
	private String riskAssess="风险评估";
	
	
	
	public static ConfigHelper getConfig() {
		if (config == null) {
			config = new ConfigHelper();
		}
		return config;
	}
	
	private ConfigHelper() {

	}
	

	public String getRiskAssess() {
		return riskAssess;
	}

	public void setRiskAssess(String riskAssess) {
		this.riskAssess = riskAssess;
	}

	public String getJiangcheng() {
		return jiangcheng;
	}

	public void setJiangcheng(String jiangcheng) {
		this.jiangcheng = jiangcheng;
	}

	public String getAnalysisMetting() {
		return analysisMetting;
	}

	public void setAnalysisMetting(String analysisMetting) {
		this.analysisMetting = analysisMetting;
	}

	public String getHandleConflict() {
		return handleConflict;
	}

	public void setHandleConflict(String handleConflict) {
		this.handleConflict = handleConflict;
	}

	public String getPatrolRecord() {
		return patrolRecord;
	}

	public void setPatrolRecord(String patrolRecord) {
		this.patrolRecord = patrolRecord;
	}

	public String getSocietyOpen() {
		return societyOpen;
	}

	public void setSocietyOpen(String societyOpen) {
		this.societyOpen = societyOpen;
	}

	public String getTalkEducation() {
		return talkEducation;
	}

	public void setTalkEducation(String talkEducation) {
		this.talkEducation = talkEducation;
	}

	public int getSucceed() {
		return succeed;
	}

	public void setSucceed(int succeed) {
		this.succeed = succeed;
	}

	public int getFail() {
		return fail;
	}

	public void setFail(int fail) {
		this.fail = fail;
	}

	public int getError() {
		return error;
	}

	public void setError(int error) {
		this.error = error;
	}

	public int getLogin() {
		return login;
	}

	public void setLogin(int login) {
		this.login = login;
	}

	public int getInsert() {
		return insert;
	}

	public void setInsert(int insert) {
		this.insert = insert;
	}

	public int getUpdate() {
		return update;
	}

	public void setUpdate(int update) {
		this.update = update;
	}

	public int getQuery() {
		return query;
	}

	public void setQuery(int query) {
		this.query = query;
	}

	public int getDelete() {
		return delete;
	}

	public void setDelete(int delete) {
		this.delete = delete;
	}

	public String getPrisonerManage() {
		return prisonerManage;
	}

	public void setPrisonerManage(String prisonerManage) {
		this.prisonerManage = prisonerManage;
	}

	public String getMedical() {
		return medical;
	}

	public void setMedical(String medical) {
		this.medical = medical;
	}

	public String getAppealDataPass() {
		return appealDataPass;
	}

	public void setAppealDataPass(String appealDataPass) {
		this.appealDataPass = appealDataPass;
	}

	public String getArraign() {
		return arraign;
	}

	public void setArraign(String arraign) {
		this.arraign = arraign;
	}

	public String getAskRegistration() {
		return askRegistration;
	}

	public void setAskRegistration(String askRegistration) {
		this.askRegistration = askRegistration;
	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}

	public String getCivilian() {
		return civilian;
	}

	public void setCivilian(String civilian) {
		this.civilian = civilian;
	}

	public String getContrabandGood() {
		return contrabandGood;
	}

	public void setContrabandGood(String contrabandGood) {
		this.contrabandGood = contrabandGood;
	}

	public String getCrimeKeyPass() {
		return crimeKeyPass;
	}

	public void setCrimeKeyPass(String crimeKeyPass) {
		this.crimeKeyPass = crimeKeyPass;
	}

	public String getDaishou() {
		return daishou;
	}

	public void setDaishou(String daishou) {
		this.daishou = daishou;
	}

	public String getDeathNotice() {
		return deathNotice;
	}

	public void setDeathNotice(String deathNotice) {
		this.deathNotice = deathNotice;
	}

	public String getDeepCrime() {
		return deepCrime;
	}

	public void setDeepCrime(String deepCrime) {
		this.deepCrime = deepCrime;
	}

	public String getDetainReturn() {
		return detainReturn;
	}

	public void setDetainReturn(String detainReturn) {
		this.detainReturn = detainReturn;
	}

	public String getDetentionArea() {
		return detentionArea;
	}

	public void setDetentionArea(String detentionArea) {
		this.detentionArea = detentionArea;
	}

	public String getDetentionInfo() {
		return detentionInfo;
	}

	public void setDetentionInfo(String detentionInfo) {
		this.detentionInfo = detentionInfo;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getEmergency() {
		return emergency;
	}

	public void setEmergency(String emergency) {
		this.emergency = emergency;
	}

	public String getExecuteReturn() {
		return executeReturn;
	}

	public void setExecuteReturn(String executeReturn) {
		this.executeReturn = executeReturn;
	}

	public String getExecutionDetain() {
		return executionDetain;
	}

	public void setExecutionDetain(String executionDetain) {
		this.executionDetain = executionDetain;
	}

	public String getHandleSeparate() {
		return handleSeparate;
	}

	public void setHandleSeparate(String handleSeparate) {
		this.handleSeparate = handleSeparate;
	}

	public String getHandOver() {
		return handOver;
	}

	public void setHandOver(String handOver) {
		this.handOver = handOver;
	}

	public String getInspect() {
		return inspect;
	}

	public void setInspect(String inspect) {
		this.inspect = inspect;
	}

	public String getInterview() {
		return interview;
	}

	public void setInterview(String interview) {
		this.interview = interview;
	}

	public String getLeaveExpires() {
		return leaveExpires;
	}

	public void setLeaveExpires(String leaveExpires) {
		this.leaveExpires = leaveExpires;
	}

	public String getLogistic() {
		return logistic;
	}

	public void setLogistic(String logistic) {
		this.logistic = logistic;
	}

	public String getMemcon() {
		return memcon;
	}

	public void setMemcon(String memcon) {
		this.memcon = memcon;
	}

	public String getMemconContent() {
		return memconContent;
	}

	public void setMemconContent(String memconContent) {
		this.memconContent = memconContent;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getOutDoctor() {
		return outDoctor;
	}

	public void setOutDoctor(String outDoctor) {
		this.outDoctor = outDoctor;
	}

	public String getOutPrison() {
		return outPrison;
	}

	public void setOutPrison(String outPrison) {
		this.outPrison = outPrison;
	}

	public String getPolice() {
		return police;
	}

	public void setPolice(String police) {
		this.police = police;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getPrisonerGoods() {
		return prisonerGoods;
	}

	public void setPrisonerGoods(String prisonerGoods) {
		this.prisonerGoods = prisonerGoods;
	}

	public String getPrisonHealth() {
		return prisonHealth;
	}

	public void setPrisonHealth(String prisonHealth) {
		this.prisonHealth = prisonHealth;
	}

	public String getPrisonInfo() {
		return prisonInfo;
	}

	public void setPrisonInfo(String prisonInfo) {
		this.prisonInfo = prisonInfo;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getReception() {
		return reception;
	}

	public void setReception(String reception) {
		this.reception = reception;
	}

	public String getRefuseDetain() {
		return refuseDetain;
	}

	public void setRefuseDetain(String refuseDetain) {
		this.refuseDetain = refuseDetain;
	}

	public String getRemoveDetain() {
		return removeDetain;
	}

	public void setRemoveDetain(String removeDetain) {
		this.removeDetain = removeDetain;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSafeCheck() {
		return safeCheck;
	}

	public void setSafeCheck(String safeCheck) {
		this.safeCheck = safeCheck;
	}

	public String getSendExamine() {
		return sendExamine;
	}

	public void setSendExamine(String sendExamine) {
		this.sendExamine = sendExamine;
	}

	public String getStopDetain() {
		return stopDetain;
	}

	public void setStopDetain(String stopDetain) {
		this.stopDetain = stopDetain;
	}

	public String getStrictManage() {
		return strictManage;
	}

	public void setStrictManage(String strictManage) {
		this.strictManage = strictManage;
	}

	public String getUserDetention() {
		return userDetention;
	}

	public void setUserDetention(String userDetention) {
		this.userDetention = userDetention;
	}

	public String getUserDuty() {
		return userDuty;
	}

	public void setUserDuty(String userDuty) {
		this.userDuty = userDuty;
	}

	public String getUseWeapon() {
		return useWeapon;
	}

	public void setUseWeapon(String useWeapon) {
		this.useWeapon = useWeapon;
	}

	public String getWorkUnit() {
		return workUnit;
	}

	public void setWorkUnit(String workUnit) {
		this.workUnit = workUnit;
	}

	public String getWrongDetain() {
		return wrongDetain;
	}

	public void setWrongDetain(String wrongDetain) {
		this.wrongDetain = wrongDetain;
	}

	public String getMeetingRecord() {
		return meetingRecord;
	}

	public void setMeetingRecord(String meetingRecord) {
		this.meetingRecord = meetingRecord;
	}

	public static void setConfig(ConfigHelper config) {
		ConfigHelper.config = config;
	}
	
	
	
}
