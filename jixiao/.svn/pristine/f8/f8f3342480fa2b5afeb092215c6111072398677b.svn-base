package com.hoyotech.prison.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.hoyotech.prison.log.PropertyName;

public class User {

	@PropertyName(name = "ID")
	private String id;
	@PropertyName(name = "姓名")
	private Police name; // 姓名
	@PropertyName(name = "登录账号")
	private String username; // 登录账号
	@PropertyName(name = "登录密码")
	private String password;// 登录密码
	@PropertyName(name = "性别")
	private Dictionary usersex; // 性别
	@PropertyName(name = "出生日期")
	private Date userBirthday; // 生日
	@PropertyName(name = "职位")
	private String userZw; // 职位
	@PropertyName(name = "职称")
	private String userZc; // 职称
	@PropertyName(name = "学历")
	private Dictionary degree; // 学历
	@PropertyName(name = "政治面貌")
	private Dictionary polity; // 政治面貌
	@PropertyName(name = "电话")
	private String phone; // 电话
	@PropertyName(name = "手机1")
	private String mobile1; // 手机1
	private String mobile2; // 手机2
	private String qq; // QQ
	private String msn; // msn
	private String email; // 邮件地址
	private String address; // 通信地址
	private String zipCode; // 邮编
	@PropertyName(name = "是否启用")
	private String mark; // 是否启用
	private Date loginTime; // 登录时间
	private String organizeType;// 账号级别
	private Set<UserRole> roles = new HashSet<UserRole>();
	private int state = 1;
	private Date addTime;
	private Date updateTime;
	public String getPasswordJS() {
		return PasswordJS;
	}

	public void setPasswordJS(String passwordJS) {
		PasswordJS = passwordJS;
	}

	private String prisonCode;
	private PrisonInfo prison;
	private String PasswordJS;//存入拘留所密码
	
	private int isSync = 0;// 是否同步；0：未同步；1：已同步

	public User() {
		super();
	}

	public User(String id) {
		super();
		this.id = id;
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

	public PrisonInfo getPrison() {
		return prison;
	}

	public void setPrison(PrisonInfo prison) {
		this.prison = prison;
	}

	public Set<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
	}

	public String getOrganizeType() {
		return organizeType;
	}

	public void setOrganizeType(String organizeType) {
		this.organizeType = organizeType;
	}
	

	public Police getName() {
		return name;
	}

	public void setName(Police name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Dictionary getUsersex() {
		return usersex;
	}

	public void setUsersex(Dictionary usersex) {
		this.usersex = usersex;
	}

	public Date getUserBirthday() {
		return userBirthday;
	}

	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}

	public String getUserZw() {
		return userZw;
	}

	public void setUserZw(String userZw) {
		this.userZw = userZw;
	}

	public String getUserZc() {
		return userZc;
	}

	public void setUserZc(String userZc) {
		this.userZc = userZc;
	}

	public Dictionary getDegree() {
		return degree;
	}

	public void setDegree(Dictionary degree) {
		this.degree = degree;
	}

	public Dictionary getPolity() {
		return polity;
	}

	public void setPolity(Dictionary polity) {
		this.polity = polity;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile1() {
		return mobile1;
	}

	public void setMobile1(String mobile1) {
		this.mobile1 = mobile1;
	}

	public String getMobile2() {
		return mobile2;
	}

	public void setMobile2(String mobile2) {
		this.mobile2 = mobile2;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getMsn() {
		return msn;
	}

	public void setMsn(String msn) {
		this.msn = msn;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
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

}
