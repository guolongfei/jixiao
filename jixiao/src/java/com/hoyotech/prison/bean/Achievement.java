package com.hoyotech.prison.bean;

import java.util.Date;

public class Achievement {
	
	private String achievement_id;          //成果ID
	private JX_User u;                         //用来与用户表关联
	private String achievement_content;     //成果内容
	private Date achievement_recordTime;  //成果记录时间
	public String getAchievement_id() {
		return achievement_id;
	}
	public void setAchievement_id(String achievementId) {
		achievement_id = achievementId;
	}
	public JX_User getU() {
		return u;
	}
	public void setU(JX_User u) {
		this.u = u;
	}
	public String getAchievement_content() {
		return achievement_content;
	}
	public void setAchievement_content(String achievementContent) {
		achievement_content = achievementContent;
	}
	public Date getAchievement_recordTime() {
		return achievement_recordTime;
	}
	public void setAchievement_recordTime(Date achievementRecordTime) {
		achievement_recordTime = achievementRecordTime;
	}
	
	

}
