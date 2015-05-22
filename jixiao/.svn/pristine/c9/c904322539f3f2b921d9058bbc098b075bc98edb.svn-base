package com.hoyotech.prison.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hoyotech.prison.bean.Logistic;
import com.hoyotech.prison.dao.impl.BasicDao;
import com.hoyotech.prison.dao.impl.DictionaryDao;
import com.hoyotech.prison.util.ObjectUpdateUtil;

public class LogisticService {

	private BasicDao dao;
	DictionaryDao dictionaryDao;
	
	
	/**
	 * 检索工勤人员信息
	 * **/
	public String getCondition(String name,String gender,String education,String workState){
		StringBuilder sb = new StringBuilder();
		if(name != null && name.length() > 0){
			sb.append(" and name like '%"+name+"%'");
		}
		if(gender != null && gender.length() > 0){
			sb.append(" and gender.id = ?");
		}
		if(education != null && education.length() > 0){
			sb.append(" and eduBackground.id = ?");
		}
		if(workState != null && workState.length() > 0){
			sb.append(" and state = ?");
		}
		return sb.toString();
	}
	
	/**
	 * 检索工勤人员的条件
	 * **/
	public List<String> getParaCondition(String name,String gender,String education,String workState){
		List<String> list = new ArrayList<String>();
		if(gender != null && gender.length() > 0){
			list.add(gender);
		}
		if(education != null && education.length() > 0){
			list.add(education);
		}
		if(workState != null && workState.length() > 0){
			list.add(workState);
		}
		return list;
	}
	
	
	/**
	 * 查询所有工勤人员信息
	 * **/
	public List<Logistic> alllogistic(String name,String gender,String education,String workState,int pageNumber,int pageSize,String prisonCode){
		List<String> param = getParaCondition(name,gender,education,workState);
		String condition = getCondition(name,gender,education,workState);
		String hql = "from Logistic where state!=0 and prisonCode="+prisonCode+condition+" order by updateTime desc";
		return (List<Logistic>)dao.queryByHql(hql, param.toArray(), pageNumber, pageSize);

	}
	
	/**
	 * 查询文职工勤人员的总数
	 * **/
	public int countLogistic(String name,String gender,String education,String workState,String prisonCode){
		List<String> param = getParaCondition(name,gender,education,workState);
		String condition = getCondition(name,gender,education,workState);
		String hql = "select count(*) from Logistic where state!=0 and prisonCode="+prisonCode+condition;
		return dao.getCount(hql, param.toArray());
	}
	
	/**
	 * 添加一条工勤人员信息
	 * **/
	public String addLogistic(Logistic info){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(info);
		info.setAddTime(new Date());
		info.setUpdateTime(new Date());
		return dao.save(info);
	}
	
	/**
	 * 查询一条工勤人员信息
	 * **/
	public Logistic logiDetail(String id){
		return (Logistic)dao.detail(Logistic.class, id);
	}
	
	/**
	 * 删除一条工勤人员信息
	 * **/
	public void logiDel(String id){
		String hql = "update Logistic set state=0 where id=?";
		dao.executeHql(hql, new Object[]{id});
	}
	
	/**
	 * 修改一条工勤人员信息
	 * **/
	public void logiUpdate(Logistic info){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(info);
		dao.update(info);
	}
	
	public BasicDao getDao() {
		return dao;
	}

	public void setDao(BasicDao dao) {
		this.dao = dao;
	}

	public DictionaryDao getDictionaryDao() {
		return dictionaryDao;
	}

	public void setDictionaryDao(DictionaryDao dictionaryDao) {
		this.dictionaryDao = dictionaryDao;
	}
	
	
}


