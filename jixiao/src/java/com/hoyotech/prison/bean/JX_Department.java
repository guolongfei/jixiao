package com.hoyotech.prison.bean;

import java.util.Date;

import com.hoyotech.prison.log.PropertyName;

public class JX_Department {

	@PropertyName(name = "ID")
	private String id;
	@PropertyName(name = "部门名称")
	private String name;
	@PropertyName(name = "上级部门ID")
	private String pid;
	@PropertyName(name = "部门等级")
	private Integer level;
	@PropertyName(name = "创建时间")
	private Date add_date;
	
	public JX_Department() {

	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Date getAdd_date() {
		return add_date;
	}

	public void setAdd_date(Date addDate) {
		add_date = addDate;
	}
}