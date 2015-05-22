package com.hoyotech.prison.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hoyotech.prison.bean.Emergency;
import com.hoyotech.prison.dao.impl.BasicDao;
import com.hoyotech.prison.util.ObjectUpdateUtil;

public class EmergencyService {

	private BasicDao dao;
	/**
	 * 检索应急预案演练记录
	 * **/
	public String getCondition(String name,Date time){
		StringBuilder sb = new StringBuilder();
		if(name != null && name.length() > 0){
			sb.append(" and commander like '%"+name+"%'");
		}
		if(time != null){
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String date=formatter.format(time);
			sb.append(" and time >=to_date('"+date+"','yyyy-MM-dd') and time<= to_date('"+date+" 23:59:59','yyyy-MM-dd hh24:mi:ss')");
		}
		
		return sb.toString();
	}
	
	/**
	 * 检索代应急预案演练记录的条件
	 * **/
	public List<String> getParaCondition(String name,Date time){
		List<String> list = new ArrayList<String>();
		return list;
	}
	
	
	/**
	 * 查询所有应急预案演练记录
	 * **/
	public List<Emergency> list(String name,Date time,int pageNumber,int pageSize,String prisonCode){
		List<String> param = getParaCondition(name,time);
		String condition = getCondition(name,time);
		String hql = "from Emergency where state=1 and prisonCode="+prisonCode+condition+" order by updateTime desc";
		return (List<Emergency>)dao.queryByHql(hql, param.toArray(), pageNumber, pageSize);

	}
	
	/**
	 * 查询应急预案演练记录的总数
	 * **/
	public int count(String name,Date time ,String prisonCode){
		List<String> param = getParaCondition(name,time);
		String condition = getCondition(name,time);
		String hql = "select count(*) from Emergency where state=1 and prisonCode="+prisonCode+condition;
		return dao.getCount(hql, param.toArray());
	}
	
	/**
	 * 添加一条应急预案演练记录
	 * **/
	public String add(Emergency info){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(info);
		info.setAddTime(new Date());
		info.setUpdateTime(new Date());
		return dao.save(info);
	}
	
	/**
	 * 查询一条应急预案演练记录
	 * **/
	public Emergency detail(String id){
		return (Emergency)dao.detail(Emergency.class, id);
	}
	
	/**
	 * 删除一条应急预案演练记录
	 * **/
	public void delete(String id){
		String hql = "update Emergency set state=0 where id=?";
		dao.executeHql(hql, new Object[]{id});
	}
	
	/**
	 * 修改一条应急预案演练记录
	 * **/
	public void update(Emergency info){
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
