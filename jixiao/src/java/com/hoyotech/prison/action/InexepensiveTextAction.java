package com.hoyotech.prison.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.InexepensiveText;
import com.hoyotech.prison.service.impl.InexepensiveTextService;

public class InexepensiveTextAction {
	
	private InexepensiveTextService inexepensiveTextService;
	
	private List<InexepensiveText> list;
	private String userId;
	private int year;
    private String name;       //用户真实姓名
    
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
		
	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public InexepensiveTextService getInexepensiveTextService() {
		return inexepensiveTextService;
	}


	public void setInexepensiveTextService(
			InexepensiveTextService inexepensiveTextService) {
		this.inexepensiveTextService = inexepensiveTextService;
	}

	
	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public List<InexepensiveText> getList() {
		return list;
	}


	public void setList(List<InexepensiveText> list) {
		this.list = list;
	}


	//展示我的考廉
	public String showMyInexepensiveText()
	{   
		userId=(String) ServletActionContext.getRequest().getSession().getAttribute("userId");
		name=(String) ServletActionContext.getRequest().getSession().getAttribute("name");
		list=inexepensiveTextService.showMyInexepensiveText(userId);
		return "myText";
	}
	//根据年份查询我的成果
	public String getMyInexepensiveText()
	{
		userId=(String) ServletActionContext.getRequest().getSession().getAttribute("userId");
		name=(String) ServletActionContext.getRequest().getSession().getAttribute("name");
		list=inexepensiveTextService.getMyInexepensiveText(userId,year);
		return "myText";
	}
	
	//展示我的考学
	public String showMyLearningText()
	{   
		userId=(String) ServletActionContext.getRequest().getSession().getAttribute("userId");
		name=(String) ServletActionContext.getRequest().getSession().getAttribute("name");
		list=inexepensiveTextService.showMyInexepensiveText(userId);
		return "myLearning";
	}
	//根据年份查询我的成果
	public String getMyLearningText()
	{
		userId=(String) ServletActionContext.getRequest().getSession().getAttribute("userId");
		name=(String) ServletActionContext.getRequest().getSession().getAttribute("name");
		list=inexepensiveTextService.getMyInexepensiveText(userId,year);
		return "myLearning";
	}
	
}
