package com.hoyotech.prison.bean;

import java.util.Date;

public class FailureAlarm {

	private String id;
	private int eventId;
	private Date alarmTime;
	private String alarmDevName;
	private int alarmType;
	private int alarmDevType;
	private int alarmState;
	private int alarmDevId;
	private String alarmJpgPath1;
	private String alarmJpgPath2;
	private String alarmMessage;
	private int alarmChannelId;
	private int alarmLevel;
	private String alarmPosXY;
	private String alarmAuther;
	private int alarmServerId;
	private String dealPerson;
	private Date dealTime;
	private String dealResult;
	private int reporting;
	private int reportingOrgId;
	private String reportingAuther;
	private Date reportingTime;
	private String reportingMessage;
	private String alarmObject;
	private String reserve1;
	private String reserve2;
	private String reserve3;
	private int isSync = 0;// 是否同步；0：未同步；1：已同步

	public FailureAlarm() {

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
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public Date getAlarmTime() {
		return alarmTime;
	}
	public void setAlarmTime(Date alarmTime) {
		this.alarmTime = alarmTime;
	}
	public String getAlarmDevName() {
		return alarmDevName;
	}
	public void setAlarmDevName(String alarmDevName) {
		this.alarmDevName = alarmDevName;
	}
	public int getAlarmType() {
		return alarmType;
	}
	public void setAlarmType(int alarmType) {
		this.alarmType = alarmType;
	}
	public int getAlarmDevType() {
		return alarmDevType;
	}
	public void setAlarmDevType(int alarmDevType) {
		this.alarmDevType = alarmDevType;
	}
	public int getAlarmState() {
		return alarmState;
	}
	public void setAlarmState(int alarmState) {
		this.alarmState = alarmState;
	}
	public int getAlarmDevId() {
		return alarmDevId;
	}
	public void setAlarmDevId(int alarmDevId) {
		this.alarmDevId = alarmDevId;
	}
	public String getAlarmJpgPath1() {
		return alarmJpgPath1;
	}
	public void setAlarmJpgPath1(String alarmJpgPath1) {
		this.alarmJpgPath1 = alarmJpgPath1;
	}
	public String getAlarmJpgPath2() {
		return alarmJpgPath2;
	}
	public void setAlarmJpgPath2(String alarmJpgPath2) {
		this.alarmJpgPath2 = alarmJpgPath2;
	}
	public String getAlarmMessage() {
		return alarmMessage;
	}
	public void setAlarmMessage(String alarmMessage) {
		this.alarmMessage = alarmMessage;
	}
	public int getAlarmChannelId() {
		return alarmChannelId;
	}
	public void setAlarmChannelId(int alarmChannelId) {
		this.alarmChannelId = alarmChannelId;
	}
	public int getAlarmLevel() {
		return alarmLevel;
	}
	public void setAlarmLevel(int alarmLevel) {
		this.alarmLevel = alarmLevel;
	}
	public String getAlarmPosXY() {
		return alarmPosXY;
	}
	public void setAlarmPosXY(String alarmPosXY) {
		this.alarmPosXY = alarmPosXY;
	}
	public String getAlarmAuther() {
		return alarmAuther;
	}
	public void setAlarmAuther(String alarmAuther) {
		this.alarmAuther = alarmAuther;
	}
	public int getAlarmServerId() {
		return alarmServerId;
	}
	public void setAlarmServerId(int alarmServerId) {
		this.alarmServerId = alarmServerId;
	}
	public String getDealPerson() {
		return dealPerson;
	}
	public void setDealPerson(String dealPerson) {
		this.dealPerson = dealPerson;
	}
	public Date getDealTime() {
		return dealTime;
	}
	public void setDealTime(Date dealTime) {
		this.dealTime = dealTime;
	}
	public String getDealResult() {
		return dealResult;
	}
	public void setDealResult(String dealResult) {
		this.dealResult = dealResult;
	}
	public int getReporting() {
		return reporting;
	}
	public void setReporting(int reporting) {
		this.reporting = reporting;
	}
	public int getReportingOrgId() {
		return reportingOrgId;
	}
	public void setReportingOrgId(int reportingOrgId) {
		this.reportingOrgId = reportingOrgId;
	}
	public String getReportingAuther() {
		return reportingAuther;
	}
	public void setReportingAuther(String reportingAuther) {
		this.reportingAuther = reportingAuther;
	}
	public Date getReportingTime() {
		return reportingTime;
	}
	public void setReportingTime(Date reportingTime) {
		this.reportingTime = reportingTime;
	}
	public String getReportingMessage() {
		return reportingMessage;
	}
	public void setReportingMessage(String reportingMessage) {
		this.reportingMessage = reportingMessage;
	}
	public String getAlarmObject() {
		return alarmObject;
	}
	public void setAlarmObject(String alarmObject) {
		this.alarmObject = alarmObject;
	}
	public String getReserve1() {
		return reserve1;
	}
	public void setReserve1(String reserve1) {
		this.reserve1 = reserve1;
	}
	public String getReserve2() {
		return reserve2;
	}
	public void setReserve2(String reserve2) {
		this.reserve2 = reserve2;
	}
	public String getReserve3() {
		return reserve3;
	}
	public void setReserve3(String reserve3) {
		this.reserve3 = reserve3;
	}
	
	
	
}
