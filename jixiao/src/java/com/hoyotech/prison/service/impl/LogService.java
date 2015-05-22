package com.hoyotech.prison.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hoyotech.prison.dao.impl.BasicDao;
import com.hoyotech.prison.log.Message;


public class LogService {

	private BasicDao dao;
	/**
	 * 检索日志记录
	 * **/
	public String getCondition(String name,Date time,String typeId,String typeName){
		StringBuilder sb = new StringBuilder();
		if(name != null && name.length() > 0){
			sb.append(" and userName like '%"+name+"%'");
		}
		if(time != null){
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String date=formatter.format(time);
			sb.append(" and time >='"+date+"' and time<= '"+date+" 23:59:59'");
		}
		if(typeId != null && typeId.length() > 0){
			sb.append(" and operateId =?");
		}
		if(typeName != null && typeName.length() > 0){
			sb.append(" and moduleName like '%"+typeName+"%'");
		}
		return sb.toString();
	}
	
	/**
	 * 检索日志记录的条件
	 * **/
	public List<String> getParaCondition(String name,Date time,String typeId,String typeName){
		List<String> list = new ArrayList<String>();
		
		if(typeId != null && typeId.length() > 0){
			list.add(typeId);
		}
		
		return list;
	}
	
	
	/**
	 * 查询所有日志记录
	 * **/
	public List<Message> list(String name,Date time,String typeId,String typeName,int pageNumber,int pageSize,String prisonCode){
		List<String> param = getParaCondition(name,time,typeId,typeName);
		String condition = getCondition(name,time,typeId,typeName);
		String hql = "from Message where state=1 and prisonCode="+prisonCode+condition+" order by time desc";
		return (List<Message>)dao.queryByHql(hql, param.toArray(), pageNumber, pageSize);

	}
	
	/**
	 * 查询日志记录的总数
	 * **/
	public int count(String name,Date time,String typeId,String typeName,String prisonCode){
		List<String> param = getParaCondition(name,time,typeId,typeName);
		String condition = getCondition(name,time,typeId,typeName);
		String hql = "select count(*) from Message where state=1 and prisonCode="+prisonCode+condition;
		return dao.getCount(hql, param.toArray());
	}
	
	public BasicDao getDao() {
		return dao;
	}

	public void setDao(BasicDao dao) {
		this.dao = dao;
	}
	
}

