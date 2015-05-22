package com.hoyotech.prison.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hoyotech.prison.bean.HandOver;
import com.hoyotech.prison.dao.impl.BasicDao;
import com.hoyotech.prison.util.ObjectUpdateUtil;

public class HandOverService {

	private BasicDao dao;
	/**
	 * 检索值班记录信息
	 * **/
	public String getCondition(String name,Date time){
		StringBuilder sb = new StringBuilder();
		if(name != null && name.length() > 0){
			sb.append(" and dutyName.name like '%"+name+"%'");
		}
		if(time != null){
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String date=formatter.format(time);
			sb.append(" and time >=to_date('"+date+"','yyyy-mm-dd') and time<=to_date( '"+date+" 23:59:59','yyyy-mm-dd hh24:mi:ss')");
		}
		
		
		return sb.toString();
	}
	
	/**
	 * 检索值班记录的条件
	 * **/
	public List<String> getParaCondition(String name,Date time){
		List<String> list = new ArrayList<String>();
		return list;
	}
	
	
	/**
	 * 查询所有值班记录信息
	 * **/
	public List<HandOver> list(String name,Date time,int pageNumber,int pageSize,String prisonCode){
		List<String> param = getParaCondition(name,time);
		String condition = getCondition(name,time);
		String hql = "from HandOver where state!=0 and prisonCode="+prisonCode+condition+" order by updateTime desc";
		return (List<HandOver>)dao.queryByHql(hql, param.toArray(), pageNumber, pageSize);

	}
	
	/**
	 * 查询值班记录的总数
	 * **/
	public int count(String name,Date time,String prisonCode){
		List<String> param = getParaCondition(name,time);
		String condition = getCondition(name,time);
		String hql = "select count(*) from HandOver where state!=0 and prisonCode="+prisonCode+condition;
		return dao.getCount(hql, param.toArray());
	}
	
	/**
	 * 查询值班期间入所人数
	 * **/
	public int inToday(String addTime,String date,String prisonCode){
		String hql = "select count(*) from Prisoner where state!=0 and dateInprison>= to_date('"+addTime+"','yyyy-MM-dd') and dateInprison< to_date('"+date+" 23:59:59','yyyy-MM-dd hh24:mi:ss') and prisonCode="+prisonCode;
		return dao.getCount(hql, new Object[]{});
	}
	
	/**
	 * 查询值班期间出所人数
	 * **/
	public int outToday(String addTime,String date,String prisonCode){
		String hql = "select count(*) from Prisoner where state!=0 and realityOutTime>= to_date('"+addTime+"','yyyy-MM-dd') and realityOutTime< to_date('"+date+" 23:59:59','yyyy-MM-dd hh24:mi:ss') and prisonCode="+prisonCode;
		return dao.getCount(hql, new Object[]{});
	}
	
	/**
	 * 查询值班期间在拘人数
	 * **/
	public int zaiju(String prisonCode){
		String hql = "select count(*) from Prisoner where state=1 and prisonCode="+prisonCode;
		return dao.getCount(hql, new Object[]{});
	}
	
	/**
	 * 添加一条值班记录信息(管理员进入时报错,原因在于管理员无上级领导)
	 * **/
	public String add(HandOver info){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(info);
		info.setAddTime(new Date());
		info.setUpdateTime(new Date());
		return dao.save(info);
	}
	
	/**
	 * 查询一条值班记录信息
	 * **/
	public HandOver detail(String id){
		return (HandOver)dao.detail(HandOver.class, id);
	}
	
	/**
	 * 删除一条值班记录信息
	 * **/
	public void delete(String id){
		String hql = "update HandOver set state=0 where id=?";
		dao.executeHql(hql, new Object[]{id});
	}
	
	/**
	 * 修改一条值班记录信息
	 * **/
	public void update(HandOver info){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(info);
		info.setUpdateTime(new Date());
		dao.update(info);
	}
	
	/**
	 * 确认接班
	 * **/
	public HandOver examineChange(String id,String userId,String date){
		HandOver num=(HandOver)dao.detail(HandOver.class, id);
		
		//String hql = "update HandOver set state=2,jiebanren.id=?,time=? where id=?";
		String hql = "update HandOver set state=2,jiebanren='"+userId+"'," +
				"time=to_date('"+date+"','yyyy-MM-dd hh24:mi:ss') where id='"+id+"'";
		
		//dao.executeHql(hql, new Object[]{userId,"to_date('"+date+"','yyyy-MM-dd')","'"+id+"'"});
		dao.executeHql(hql, null);
		return num;
		//return num.getJiaobanNum();
	}
	
	/**
	 * 查询一条值班记录信息
	 * **/
	public List<HandOver> listCount(String prisonCode){
		//String hql = "from HandOver where state=1 and prisonCode="+prisonCode +" order by ";
		String hql = "from HandOver where state=1 and prisonCode="+prisonCode +" order by update_time desc";
		return (List<HandOver>)dao.queryByHql(hql, new Object[]{});
	}
	
	public BasicDao getDao() {
		return dao;
	}

	public void setDao(BasicDao dao) {
		this.dao = dao;
	}
	
}

