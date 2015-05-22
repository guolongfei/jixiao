package com.hoyotech.prison.service.impl;

import java.util.Date;
import java.util.List;

import com.hoyotech.prison.bean.DetainReturn;
import com.hoyotech.prison.dao.impl.BasicDao;

public class DetainReturnService {

private BasicDao dao;
	
	/**
	 * 添加一条执行回执信息
	 * **/
	public String add(DetainReturn info){
		info.setAddTime(new Date());
		info.setUpdateTime(new Date());
		return dao.save(info);
	}
	
	/**
	 * 查询一条执行回执信息
	 * **/
	public DetainReturn detail(String id){
		return (DetainReturn)dao.detail(DetainReturn.class, id);
	}
	
	public DetainReturn detailByPrisoner(String prisonerId){
		List<DetainReturn> list = (List<DetainReturn>) dao.queryByHql("from DetainReturn where prisoner.id=?", new Object[]{prisonerId});
		return list.size()>0?list.get(0):new DetainReturn();
	}
	
	/**
	 * 删除一条执行回执信息
	 * **/
	public void delete(String id){
		String hql = "update DetainReturn set state=0 where id=?";
		dao.executeHql(hql, new Object[]{id});
	}
	
	/**
	 * 修改审批状态
	 * **/
	public void examineChange(String id,String info){
		String hql = "update DetainReturn set examine=? where id=?";
		dao.executeHql(hql, new Object[]{info,id});
	}
	
	/**
	 * 修改一条执行回执信息
	 * **/
	public void update(DetainReturn info){
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
