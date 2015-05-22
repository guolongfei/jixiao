package com.hoyotech.prison.service.impl;

import java.util.List;

import com.hoyotech.prison.bean.FailureAlarm;
import com.hoyotech.prison.dao.impl.BasicDao;

public class FailureAlarmService {

	private BasicDao dao;
	
	/**
	 * 查询所有报警故障信息
	 * **/
	public List<FailureAlarm> list(int pageNumber,int pageSize){
		String hql = "from FailureAlarm";
		return (List<FailureAlarm>)dao.queryByHql(hql, new Object[]{},pageNumber,pageSize);
	}

	/**
	 * 查询报警故障的总数
	 * **/
	public int count(){
		String hql = "select count(*) from FailureAlarm";
		return dao.getCount(hql, new Object[]{});
	}
	
	/**
	 * 查询一条报警故障信息
	 * **/
	public FailureAlarm detail(String id){
		return (FailureAlarm)dao.detail(FailureAlarm.class, id);
	}

	public BasicDao getDao() {
		return dao;
	}

	public void setDao(BasicDao dao) {
		this.dao = dao;
	}
	
}
