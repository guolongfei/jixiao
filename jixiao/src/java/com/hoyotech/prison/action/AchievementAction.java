package com.hoyotech.prison.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.Achievement;
import com.hoyotech.prison.service.impl.AchievementService;

public class AchievementAction {
	
	private AchievementService achievementService;
	private List<Achievement> list;
	private String userId; 
	private String content;    //成果内容
	private int year;          //年份
    


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public AchievementService getAchievementService() {
		return achievementService;
	}

	public void setAchievementService(AchievementService achievementService) {
		this.achievementService = achievementService;
	}

	public List<Achievement> getList() {
		return list;
	}

	public void setList(List<Achievement> list) {
		this.list = list;
	}

	//展示我的成果列表
	public String showMyAchieve()
	{
		userId=(String) ServletActionContext.getRequest().getSession().getAttribute("userId");
		list=achievementService.showMyAchieve(userId);
		return "getAchieve";
	}
	
	//新增我的成果
	public String addAchieve() throws UnsupportedEncodingException
	{		
		
		userId=(String) ServletActionContext.getRequest().getSession().getAttribute("userId");
		content=URLDecoder.decode(content,"UTF-8");
		achievementService.addAchieve(userId,content);
		return showMyAchieve();
	}
	
	//根据年份查询我的成果
	public String getAchieveByYear()
	{
		userId=(String) ServletActionContext.getRequest().getSession().getAttribute("userId");
		list=achievementService.getAchieveByYear(userId,year);
		return "getAchieve";
	}

}
