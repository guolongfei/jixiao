package com.hoyotech.prison.bean;

import java.util.Date;

import com.hoyotech.prison.log.PropertyName;

public class UserDuty {

	@PropertyName(name = "ID")
	private String id;
	@PropertyName(name = "值班人")
	private User user;//值班人
	@PropertyName(name = "开始时间")
	private Date startTime;//开始时间
	@PropertyName(name = "结束时间")
	private Date endTime;//结束时间
	@PropertyName(name = "备注")
	private String remark;//备注
	@PropertyName(name = "是否交接")
	private int passWork = 0;//是否交接
	@PropertyName(name = "交接人")
	private User passWorker;//交接人
	private int state = 1;
	private Date addTime;
	private Date updateTime;
	private int isSync = 0;// 是否同步；0：未同步；1：已同步

	public UserDuty() {
		super();
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public int getPassWork() {
		return passWork;
	}

	public void setPassWork(int passWork) {
		this.passWork = passWork;
	}

	public User getPassWorker() {
		return passWorker;
	}

	public void setPassWorker(User passWorker) {
		this.passWorker = passWorker;
	}

}
