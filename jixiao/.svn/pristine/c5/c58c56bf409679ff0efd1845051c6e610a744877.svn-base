package com.hoyotech.prison.service.impl;

import java.util.Date;
import java.util.List;

import com.hoyotech.prison.bean.JiangCheng;
import com.hoyotech.prison.dao.impl.BasicDao;

public class JiangChengService {

private BasicDao dao;
	
	/**
	 * 查询所有奖惩登记信息
	 * **/
	public List<JiangCheng> list(String prisonerId, String prisonCode){
		String hql = "from JiangCheng where state=1 and prisoner.id=? and prisonCode="+prisonCode+" order by updateTime desc";
		return (List<JiangCheng>)dao.queryByHql(hql, new Object[]{prisonerId});

	}
	
	/**
	 * 查询奖惩登记的总数
	 * **/
	public int count(String prisonerId, String prisonCode){
		String hql = "select count(*) from JiangCheng where state=1 and prisoner.id=? and prisonCode="+prisonCode;
		return dao.getCount(hql, new Object[]{prisonerId});
	}
	
	/**
	 * 添加一条奖惩登记信息
	 * **/
	public String add(JiangCheng info){
		info.setAddTime(new Date());
		info.setUpdateTime(new Date());
		return dao.save(info);
	}
	
	/**
	 * 查询一条奖惩登记信息
	 * **/
	public JiangCheng detail(String id){
		return (JiangCheng)dao.detail(JiangCheng.class, id);
	}
	
	public JiangCheng detailByPrisoner(String prisonerId){
		List<JiangCheng> list = (List<JiangCheng>)dao.queryByHql("from JiangCheng where prisoner.id=? order by updateTime desc", new Object[]{prisonerId});
		return list.size()>0?list.get(0):new JiangCheng();
	}
	
	/**
	 * 删除一条提奖惩登记信息
	 * **/
	public void delete(String id){
		String hql = "update JiangCheng set state=0 where id=?";
		dao.executeHql(hql, new Object[]{id});
	}
	
	/**
	 * 修改审批状态
	 * **/
	public void examineChange(String id,String info){
		String hql = "update JiangCheng set examine=? where id=?";
		dao.executeHql(hql, new Object[]{info,id});
	}
	
	/**
	 * 修改一条奖惩登记信息
	 * **/
	public void update(JiangCheng info){
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
