package com.hoyotech.prison.bean;



import com.hoyotech.prison.log.PropertyName;

public class UserPowerZD {

	private String id;
	
	@PropertyName(name = "支队用户ID")
	private String userId;
	
	@PropertyName(name = "支队用户权限记录")
	private String powerZD;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPowerZD() {
		return powerZD;
	}

	public void setPowerZD(String powerZD) {
		this.powerZD = powerZD;
	}
	
	
}
