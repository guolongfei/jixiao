package com.hoyotech.prison.service.impl;

import java.util.Date;
import java.util.List;

import com.hoyotech.prison.bean.RefuseDetain;
import com.hoyotech.prison.dao.impl.BasicDao;

public class RefuseDetainService {

private BasicDao dao;
	
	/**
	 * 添加一条不予拘留通知信息
	 * **/
	public String add(RefuseDetain info){
		info.setAddTime(new Date());
		info.setUpdateTime(new Date());
		return dao.save(info);
	}
	
	/**
	 * 查询一条不予拘留通知信息
	 * **/
	public RefuseDetain detail(String id){
		return (RefuseDetain)dao.detail(RefuseDetain.class, id);
	}
	
	public RefuseDetain detailByPrisoner(String id){
		List<RefuseDetain> list = (List<RefuseDetain>)dao.queryByHql("from RefuseDetain where prisoner.id=?", new Object[]{id});
		return list.size()>0?list.get(0):new RefuseDetain();
	}
	
	/**
	 * 删除一条不予拘留通知信息
	 * **/
	public void delete(String id){
		String hql = "update RefuseDetain set state=0 where id=?";
		dao.executeHql(hql, new Object[]{id});
	}
	
	/**
	 * 修改审批状态
	 * **/
	public void examineChange(String id,String info){
		String hql = "update RefuseDetain set examine=? where id=?";
		dao.executeHql(hql, new Object[]{info,id});
	}
	
	/**
	 * 修改一条不予拘留通知信息
	 * **/
	public void update(RefuseDetain info){
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
