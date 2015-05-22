package com.hoyotech.prison.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.hoyotech.prison.log.PropertyName;

public class Role {

	@PropertyName(name = "ID")
	private String id;
	@PropertyName(name = "角色")
	private String role;
	@PropertyName(name = "描述")
	private String explain;
	@PropertyName(name = "权限")
	private Set<RolePermission> rolePer = new HashSet<RolePermission>();
	private String organizeType;
	@PropertyName(name = "是否可用")
	private String mark; // 是否启用
	private int state=1;
	private Date addTime;
	private Date updateTime;
	private String prisonCode;
	
	private int isSync = 0;// 是否同步；0：未同步；1：已同步

	public Role() {

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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}
	public Set<RolePermission> getRolePer() {
		return rolePer;
	}
	public void setRolePer(Set<RolePermission> rolePer) {
		this.rolePer = rolePer;
	}
	public String getOrganizeType() {
		return organizeType;
	}
	public void setOrganizeType(String organizeType) {
		this.organizeType = organizeType;
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
	public String getPrisonCode() {
		return prisonCode;
	}
	public void setPrisonCode(String prisonCode) {
		this.prisonCode = prisonCode;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	
}
