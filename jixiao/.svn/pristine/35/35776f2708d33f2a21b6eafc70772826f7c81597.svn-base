package com.hoyotech.prison.service.impl;

import java.util.Date;
import java.util.List;

import com.hoyotech.prison.bean.WrongDetain;
import com.hoyotech.prison.dao.impl.BasicDao;

public class WrongDetainService {

private BasicDao dao;
	
	/**
	 * 添加一条可能错误拘留信息
	 * **/
	public String add(WrongDetain info){
		info.setAddTime(new Date());
		info.setUpdateTime(new Date());
		return dao.save(info);
	}
	
	/**
	 * 查询一条可能错误拘留信息
	 * **/
	public WrongDetain detail(String id){
		return (WrongDetain)dao.detail(WrongDetain.class, id);
	}
	
	public WrongDetain detailByPrisoner(String prisonerId){
		List<WrongDetain> list = (List<WrongDetain>) dao.queryByHql("from WrongDetain where prisoner.id=?", new Object[]{prisonerId});
		return list.size()>0?list.get(0):new WrongDetain();
	}
	/**
	 * 删除一条可能错误拘留信息
	 * **/
	public void delete(String id){
		String hql = "update WrongDetain set state=0 where id=?";
		dao.executeHql(hql, new Object[]{id});
	}
	
	/**
	 * 修改审批状态
	 * **/
	public void examineChange(String id,String info){
		String hql = "update WrongDetain set examine=? where id=?";
		dao.executeHql(hql, new Object[]{info,id});
	}
	
	/**
	 * 修改一条可能错误拘留信息
	 * **/
	public void update(WrongDetain info){
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
