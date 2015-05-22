package com.hoyotech.prison.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hoyotech.prison.bean.SocietyOpen;
import com.hoyotech.prison.dao.impl.BasicDao;
import com.hoyotech.prison.util.ObjectUpdateUtil;

public class SocietyOpenService {

	private BasicDao dao;
	/**
	 * 检索对社会开放记录
	 * **/
	public String getCondition(Date time,String approver){
		StringBuilder sb = new StringBuilder();
		if(time != null ){
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String date=formatter.format(time);
			sb.append(" and startTime >=to_date('"+date+"','yyyy-MM-dd') and startTime<= to_date('"+date+" 23:59:59','yyyy-MM-dd hh24:mi:ss')");
		}
		if(approver != null && approver.length() > 0){
			sb.append(" and approver.name like '%"+approver+"%'");
		}
		return sb.toString();
	}
	
	/**
	 * 检索对社会开放记录的条件
	 * **/
	public List<String> getParaCondition(Date time,String approver){
		List<String> list = new ArrayList<String>();
		return list;
	}
	
	
	/**
	 * 查询所有对社会开放记录
	 * **/
	public List<SocietyOpen> list(Date time,String approver,int pageNumber,int pageSize,String prisonCode){
		List<String> param = getParaCondition(time,approver);
		String condition = getCondition(time,approver);
		String hql = "from SocietyOpen where state=1 and prisonCode="+prisonCode+condition+" order by updateTime desc";
		return (List<SocietyOpen>)dao.queryByHql(hql, param.toArray(), pageNumber, pageSize);

	}
	
	/**
	 * 查询对社会开放记录的总数
	 * **/
	public int count(Date time,String approver,String prisonCode){
		List<String> param = getParaCondition(time,approver);
		String condition = getCondition(time,approver);
		String hql = "select count(*) from SocietyOpen where state=1 and prisonCode="+prisonCode+condition;
		return dao.getCount(hql, param.toArray());
	}
	
	/**
	 * 添加一条对社会开放记录
	 * **/
	public String add(SocietyOpen info){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(info);
		info.setAddTime(new Date());
		info.setUpdateTime(new Date());
		return dao.save(info);
	}
	
	/**
	 * 查询一条对社会开放记录
	 * **/
	public SocietyOpen detail(String id){
		return (SocietyOpen)dao.detail(SocietyOpen.class, id);
	}
	
	/**
	 * 删除一条对社会开放记录
	 * **/
	public void delete(String id){
		String hql = "update SocietyOpen set state=0 where id=?";
		dao.executeHql(hql, new Object[]{id});
	}
	
	/**
	 * 修改一条对社会开放记录
	 * **/
	public void update(SocietyOpen info){
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
