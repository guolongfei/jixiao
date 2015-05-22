package com.hoyotech.prison.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.hoyotech.prison.log.PropertyName;

public class JX_Role {

	@PropertyName(name = "ID")
	private String id;
	@PropertyName(name = "角色名")
	private String name;
	@PropertyName(name = "所属部门")
	private String department_id;
	@PropertyName(name = "权限")
	private Set<JX_RolePermission> rolePer = new HashSet<JX_RolePermission>();
	@PropertyName(name = "添加时间")
	private Date add_date;	

	public JX_Role() {

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

	public String getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(String departmentId) {
		department_id = departmentId;
	}

	public Set<JX_RolePermission> getRolePer() {
		return rolePer;
	}

	public void setRolePer(Set<JX_RolePermission> rolePer) {
		this.rolePer = rolePer;
	}

	public Date getAdd_date() {
		return add_date;
	}

	public void setAdd_date(Date addDate) {
		add_date = addDate;
	}



}
