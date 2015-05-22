package com.hoyotech.prison.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hoyotech.prison.bean.Doctor;
import com.hoyotech.prison.dao.impl.BasicDao;
import com.hoyotech.prison.util.ObjectUpdateUtil;

public class DoctorService {

	private BasicDao dao;
	/**
	 * 检索所内就医登记信息
	 * **/
	public String getCondition(String name,Date time){
		StringBuilder sb = new StringBuilder();
		if(name != null && name.length() > 0){
			sb.append(" and name.name like '%"+name+"%'");
		}
		if(time != null){
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String date=formatter.format(time);
			sb.append(" and time >=to_date('"+date+"','yyyy-MM-dd') and time<= to_date('"+date+" 23:59:59','yyyy-MM-dd hh24:mi:ss')");
		}
		return sb.toString();
	}
	
	/**
	 * 检索所内就医登记的条件
	 * **/
	public List<String> getParaCondition(String name,Date time){
		List<String> list = new ArrayList<String>();
		return list;
	}
	
	
	/**
	 * 查询所有所内就医登记信息
	 * **/
	public List<Doctor> list(String name,Date time,int pageNumber,int pageSize,String prisonCode){
		List<String> param = getParaCondition(name,time);
		String condition = getCondition(name,time);
		String hql = "from Doctor where state=1 and prisonCode="+prisonCode+condition+" order by updateTime desc";
		return (List<Doctor>)dao.queryByHql(hql, param.toArray(), pageNumber, pageSize);

	}
	
	/**
	 * 查询所内就医登记的总数
	 * **/
	public int count(String name,Date time,String prisonCode){
		List<String> param = getParaCondition(name,time);
		String condition = getCondition(name,time);
		String hql = "select count(*) from Doctor where state=1 and prisonCode="+prisonCode+condition;
		return dao.getCount(hql, param.toArray());
	}
	
	/**
	 * 添加一条所内就医登记信息
	 * **/
	public String add(Doctor info){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(info);
		info.setAddTime(new Date());
		info.setUpdateTime(new Date());
		return dao.save(info);
	}
	
	/**
	 * 查询一条所内就医登记信息
	 * **/
	public Doctor detail(String id){
		return (Doctor)dao.detail(Doctor.class, id);
	}
	
	/**
	 * 删除一条所内就医登记信息
	 * **/
	public void delete(String id){
		String hql = "update Doctor set state=0 where id=?";
		dao.executeHql(hql, new Object[]{id});
	}
	
	/**
	 * 修改一条所内就医登记信息
	 * **/
	public void update(Doctor info){
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
