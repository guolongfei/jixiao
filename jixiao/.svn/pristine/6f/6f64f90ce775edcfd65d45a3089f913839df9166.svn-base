package com.hoyotech.prison.service.impl;

import java.util.List;

import com.hoyotech.prison.dao.impl.BasicDao;

public class CountService {

private BasicDao dao;

	/**
	 * 统计性别为女
	 * **/
	public List<Object> allCount(String condition){
		String hql = "select count(*) as count from prisoner where 1=1"+condition;
		return dao.queryBySql(hql, new Object[]{});
	}

	/**
	 * 统计性别为女
	 * **/
	public List<Object> woman(String condition){
		String hql = "select count(*) as sex from prisoner where gender=12"+condition;
		return dao.queryBySql(hql, new Object[]{});
	}
	
	/**
	 * 统计婚姻状况
	 * **/
	public List<Object> marry(String condition){
		String hql = "select nnd as d,count(*) as b from (select case when marry_status=14 then '已婚' "+
		"when marry_status=15 then '未婚'"+
		"when marry_status=140 then '离婚'"+
		"when marry_status=139 then '丧偶'"+
		"when marry_status!=14 and marry_status!=15 and marry_status!=139 and marry_status!=140 then '其他'"+
		"end as nnd from prisoner where 1=1"+condition+") a group by nnd";
		return dao.queryBySql(hql, new Object[]{});
	}
	
	/**
	 * 统计年龄段
	 * **/
	public List<Object> age(String condition){
		String hql = "select nnd as d,count(*) as b from (select case when age<18 then '18' when age>=18 and age<=25 then '18-25'"+
		"when age>=26 and age<=35 then '26-35'"+
		"when age>=36 and age<=60 then '36-60'"+
		"when age>60 then '60以上'"+
		"when age is NULL then '其他'"+
		"end as nnd from prisoner where 1=1"+condition+") a group by nnd";
		return dao.queryBySql(hql, new Object[]{});
	}
	
	/**
	 * 统计文化程度
	 * **/
	public List<Object> education(String condition){
		String hql = "select nnd as d,count(*) as b from (select case when education_level=198 then '文盲' "+
		"when education_level=194 then '小学'"+
		"when education_level=188 then '中学'"+
		"when education_level=170 then '大专以上'"+
		"when education_level!=198 and education_level!=194 and  education_level!=188 and education_level!=170 then '其他'"+
		"when education_level is NULL then '其他'"+
		"end as nnd from prisoner where 1=1"+condition+") a group by nnd";
		return dao.queryBySql(hql, new Object[]{});
	}
	
	/**
	 * 统计身份
	 * **/
	public List<Object> status(String condition){
		String hql = "select nnd as d,count(*) as b from (select case when status=28 then '国家公务员' "+
		"when status=29 then '企事业管理人员'"+
		"when status=31 then '工人'"+
		"when status=32 then '农民'"+
		"when status=34 then '在校学生'"+
		"when status=33 then '个体工商业者'"+
		"when status=35 then '离退休人员'"+
		"when status=36 then '无业人员'"+
		"when status!=28 and status!=29 and status!=31 and status!=32 and status!=34 and status!=33 and status!=35 and status!=36 then '其他'"+
		"when education_level is NULL then '其他'"+
		"end as nnd from prisoner where 1=1"+condition+") a group by nnd";
		return dao.queryBySql(hql, new Object[]{});
	}
	
	/**
	 * 统计国籍
	 * **/
	public List<Object> nationality(String condition){
		String hql = "select nnd as d,count(*) as b from (select case when nationality>4 then '外籍人员'"+
		"when nationality=2 or nationality=3 or nationality=4  then '港澳人员' "+
		"when nationality=1 then '中国'"+
		"end as nnd from prisoner where 1=1"+condition+") a group by nnd";
		return dao.queryBySql(hql, new Object[]{});
	}
	
	/**
	 * 统计籍贯
	 * **/
	public List<Object> jiguan(String condition){
		String hql = "select nnd as d,count(*) as b from (select case when origion_place!=215 then '外省人员' "+
		"when origion_place=215 then '省内人员' "+
		"end as nnd from prisoner where 1=1"+condition+") a group by nnd";
		return dao.queryBySql(hql, new Object[]{});
	}
	
	public BasicDao getDao() {
		return dao;
	}

	public void setDao(BasicDao dao) {
		this.dao = dao;
	}
	
	
}

