package com.hoyotech.prison.service.impl;

import java.util.List;

import com.hoyotech.prison.dao.impl.BasicDao;

public class MapService {

	private BasicDao dao;

	
	/**
	 * 统计性别人数
	 * **/
	public List sex(){
		String hql = "select p.gender.description as a,count(*) as b from Prisoner p group by p.gender.description";
		return dao.queryByHql(hql, new Object[]{});
	}
	
	/**
	 * 根据不同城市统计性别人数
	 * **/
	public List<Object> countCity(String id){
		String hql = "select p.gender.description as a,count(*) as b from Prisoner p where p.prisonCode in (select prisonCode from PrisonInfo where area.area.id=? ) group by p.gender.description";
		return (List<Object>)dao.queryByHql(hql, new Object[]{id});
	}
	
	/**
	 * 统计学历人数
	 * **/
	public List<Object> shenfen(){
		String hql = "select p.status.description as a,count(*) as b from Prisoner p group by p.status.description";
		return (List<Object>)dao.queryByHql(hql, new Object[]{});
	}
	
	/**
	 * 根据不同城市统计学历人数
	 * **/
	public List<Object> countShenfen(String id){
		String hql = "select p.status.description as a,count(*) as b from Prisoner p where p.prisonCode in (select prisonCode from PrisonInfo where area.area.id=? ) group by p.status.description";
		return (List<Object>)dao.queryByHql(hql, new Object[]{id});
	}
	
	/**
	 * 统计年龄段人数
	 * **/
	public List<Object> age(){
		String hql = "select nnd as d,count(*) as b from (select case when datediff(y,birthday,getdate())<=18 then '18以下'"+
		"when datediff(y,birthday,getdate())>=19 and datediff(y,birthday,getdate())<=30 then '19-30'"+
		"when datediff(y,birthday,getdate())>=31 and datediff(y,birthday,getdate())<=40 then '31-40'"+
		"when datediff(y,birthday,getdate())>40 then '40以上'"+
		"end as nnd from prisoner) a group by nnd";
		return dao.queryBySql(hql, new Object[]{});
	}
	
	/**
	 * 根据不同城市统计年龄段人数
	 * **/
	public List<Object> countAge(String id){
		String hql2 = "select nnd as d,count(*) as b from (select case when datediff(y,birthday,getdate())<=18 then '18'"+
		"when datediff(y,birthday,getdate())>=19 and datediff(y,birthday,getdate())<=30 then '19-30'"+
		"when datediff(y,birthday,getdate())>=31 and datediff(y,birthday,getdate())<=40 then '31-40'"+
		"when datediff(y,birthday,getdate())>40 then '40'"+
		"end as nnd from prisoner where prison_code in (select prison_code from PrisonInfo where area_id in (select id from area where parent_id =?))) a group by nnd";
		return dao.queryBySql(hql2, new Object[]{id});
	}
	
	public BasicDao getDao() {
		return dao;
	}

	public void setDao(BasicDao dao) {
		this.dao = dao;
	}
	
	
}
