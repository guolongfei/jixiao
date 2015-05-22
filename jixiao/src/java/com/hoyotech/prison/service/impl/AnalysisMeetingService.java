package com.hoyotech.prison.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hoyotech.prison.bean.AnalysisMeeting;
import com.hoyotech.prison.dao.impl.BasicDao;
import com.hoyotech.prison.util.ObjectUpdateUtil;

public class AnalysisMeetingService {

	private BasicDao dao;
	/**
	 * 检索动态分析会议记录记录
	 * **/
	public String getCondition(String address,Date time){
		StringBuilder sb = new StringBuilder();
		if(address != null && address.length() > 0){
			sb.append(" and address like '%"+address+"%'");
		}
		if(time != null){
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String date=formatter.format(time);
			sb.append(" and startTime >=to_date('"+date+"','yyyy-MM-dd') and startTime<=to_date('"+date+" 23:59:59','yyyy-MM-dd hh24:mi:ss')");
		}
		return sb.toString();
	}
	
	/**
	 * 检索动态分析会议记录的条件
	 * **/
	public List<String> getParaCondition(String name,Date time){
		List<String> list = new ArrayList<String>();
		return list;
	}
	
	
	/**
	 * 查询动态分析会议记录
	 * **/
	public List<AnalysisMeeting> list(String address,Date time,int pageNumber,int pageSize,String prisonCode){
		List<String> param = getParaCondition(address,time);
		String condition = getCondition(address,time);
		String hql = "from AnalysisMeeting where state=1 and prisonCode="+prisonCode+condition+" order by updateTime desc";
		return (List<AnalysisMeeting>)dao.queryByHql(hql, param.toArray(), pageNumber, pageSize);

	}
	
	/**
	 * 查询动态分析会议记录的总数
	 * **/
	public int count(String address,Date time,String prisonCode){
		List<String> param = getParaCondition(address,time);
		String condition = getCondition(address,time);
		String hql = "select count(*) from AnalysisMeeting where state=1 and prisonCode="+prisonCode+condition;
		return dao.getCount(hql, param.toArray());
	}
	
	/**
	 * 添加一条动态分析会议记录
	 * **/
	public String add(AnalysisMeeting info){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(info);
		info.setAddTime(new Date());
		info.setUpdateTime(new Date());
		return dao.save(info);
	}
	
	/**
	 * 查询一条动态分析会议记录
	 * **/
	public AnalysisMeeting detail(String id){
		return (AnalysisMeeting)dao.detail(AnalysisMeeting.class, id);
	}
	
	/**
	 * 删除一条动态分析会议记录
	 * **/
	public void delete(String id){
		String hql = "update AnalysisMeeting set state=0 where id=?";
		dao.executeHql(hql, new Object[]{id});
	}
	
	/**
	 * 修改一条动态分析会议记录
	 * **/
	public void update(AnalysisMeeting info){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(info);
		info.setUpdateTime(new Date());
		dao.update(info);
	}
	
	public BasicDao getDao() {
		return dao;
	}

	public void setDao(BasicDao dao) {
		this.dao = dao;
	}
	
}
