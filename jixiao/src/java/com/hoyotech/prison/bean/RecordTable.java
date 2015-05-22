package com.hoyotech.prison.bean;

import java.util.Date;

import com.hoyotech.prison.log.PropertyName;

public class RecordTable {
	@PropertyName(name = "RECORD_ID")
	private String recordId;//考勤id
	@PropertyName(name = "POLICE_NAME")
	private JX_People peopleId;//考勤人员id
	@PropertyName(name = "RECORD_DATE")
	private Date recordDate;//考勤日期
	@PropertyName(name = "DEP_ID")
	private Integer depId;//部门id
	@PropertyName(name = "START_TIME")
	private Date startTime;//上班时间
	@PropertyName(name = "END_TIME")
	private Date endTime;//下班时间
	@PropertyName(name = "RECORD_STATE")
	private String recordState;//记录状态 （ 出勤、事假、病假、旷工、休假、迟到、早退）
	@PropertyName(name = "DATE_TYPE")
	private String dateType;//日期类型    上班日   休息日

	
	public JX_People getPeopleId() {
		return peopleId;
	}

	public void setPeopleId(JX_People peopleId) {
		this.peopleId = peopleId;
	}

	public String getRecordId() {
		return recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public Date getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}

	public Integer getDepId() {
		return depId;
	}

	public void setDepId(Integer depId) {
		this.depId = depId;
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

	public String getRecordState() {
		return recordState;
	}

	public void setRecordState(String recordState) {
		this.recordState = recordState;
	}

	public String getDateType() {
		return dateType;
	}

	public void setDateType(String dateType) {
		this.dateType = dateType;
	}

}
