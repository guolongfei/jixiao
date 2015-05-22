package com.hoyotech.prison.bean;

import java.util.Date;

import com.hoyotech.prison.log.PropertyName;

public class UserDetention {

	@PropertyName(name = "ID")
	private String id;
	private User user;
	private DetentionInfo detention;
	private int state = 1;
	private Date addTime;
	
	private int isSync = 0;// 是否同步；0：未同步；1：已同步

	public UserDetention() {
		super();
	}

	public UserDetention(User user, DetentionInfo detention) {
		super();
		this.user = user;
		this.detention = detention;
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

	public DetentionInfo getDetention() {
		return detention;
	}

	public void setDetention(DetentionInfo detention) {
		this.detention = detention;
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

}
