package com.hoyotech.prison.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hoyotech.prison.bean.Prisoner;
import com.hoyotech.prison.dao.impl.BasicDao;

public class OutRegisterService {

private BasicDao dao;
	
	/**
	 * 检索出入所登记信息
	 * **/
	public String getCondition(String name,Date time,Date birthday,String workUnit,Date inTime){
		StringBuilder sb = new StringBuilder();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		if(name != null && name.length() > 0){
			sb.append(" and name like '%"+name+"%'");
		}
		if(time != null){
			String date=formatter.format(time);
			sb.append(" and dateOutprison >=to_date('"+date+"','yyyy-MM-dd') and dateOutprison<=to_date('"+date+" 23:59:59','yyyy-MM-dd hh24:mi:ss')");
		}if(workUnit != null && workUnit.length() > 0){
			sb.append(" and handleCases.id =?");
		}
		if(birthday != null){
			String date2=formatter.format(birthday);
			sb.append(" and birthday >=to_date('"+date2+"','yyyy-MM-dd') and birthday<=to_date('"+date2+" 23:59:59','yyyy-MM-dd hh24:mi:ss')");
		}
		if(inTime != null){
			String date=formatter.format(inTime);
			sb.append(" and dateInprison >=to_date('"+date+"','yyyy-MM-dd') and dateInprison<=to_date('"+date+" 23:59:59','yyyy-MM-dd hh24:mi:ss')");
		}
		
		return sb.toString();
	}
	
	/**
	 * 检索出入所登记的条件
	 * **/
	public List<String> getParaCondition(String name,Date time,Date birthday,String workUnit,Date inTime){
		List<String> list = new ArrayList<String>();
		if(workUnit != null && workUnit.length() > 0){
			list.add(workUnit);
		}
		return list;
	}

	/**
	 * 查询所有出入所登记信息
	 * **/
	public List<Prisoner> list(String name,Date time,Date birthday,String workUnit,Date inTime,int pageNumber,int pageSize,String prisonCode){
		List<String> param = getParaCondition(name,time,birthday,workUnit,inTime);
		String condition = getCondition(name,time,birthday,workUnit,inTime);
		String hql = "from Prisoner where state=1 and prisonCode="+prisonCode+condition+" order by updateTime desc";
		return (List<Prisoner>)dao.queryByHql(hql, param.toArray(), pageNumber, pageSize);
	}

	/**
	 * 查询出入所登记信息总数
	 * **/
	public int count(String name ,Date time,Date birthday,String workUnit,Date inTime,String prisonCode){
		List<String> param = getParaCondition(name,time,birthday,workUnit,inTime);
		String condition = getCondition(name,time,birthday,workUnit,inTime);
		String hql = "select count(*) from Prisoner where state=1 and prisonCode="+prisonCode+condition;
		return dao.getCount(hql, param.toArray());
	}
	
	/**
	 * 查询一条出入所登记信息
	 * **/
	public Prisoner detail(String id){
		return (Prisoner)dao.detail(Prisoner.class, id);
	}

	public BasicDao getDao() {
		return dao;
	}

	public void setDao(BasicDao dao) {
		this.dao = dao;
	}
	
}
