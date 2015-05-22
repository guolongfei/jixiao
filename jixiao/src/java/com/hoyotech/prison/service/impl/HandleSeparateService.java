package com.hoyotech.prison.service.impl;

import java.util.Date;
import java.util.List;

import com.hoyotech.prison.bean.HandleSeparate;
import com.hoyotech.prison.dao.impl.BasicDao;

public class HandleSeparateService {

private BasicDao dao;
	
	/**
	 * 添加一条建议另行处理通知信息
	 * **/
	public String add(HandleSeparate info){
		info.setAddTime(new Date());
		info.setUpdateTime(new Date());
		return dao.save(info);
	}
	
	/**
	 * 查询一条建议另行处理通知信息
	 * **/
	public HandleSeparate detail(String id){
		return (HandleSeparate)dao.detail(HandleSeparate.class, id);
	}
	public HandleSeparate detailByPrisoner(String prisonerId){
		List<HandleSeparate> list = (List<HandleSeparate>) dao.queryByHql("from HandleSeparate where prisoner.id=?", new Object[]{prisonerId});
		return list.size()>0?list.get(0):new HandleSeparate();
	}
	/**
	 * 删除一条建议另行处理通知信息
	 * **/
	public void delete(String id){
		String hql = "update HandleSeparate set state=0 where id=?";
		dao.executeHql(hql, new Object[]{id});
	}
	
	/**
	 * 修改审批状态
	 * **/
	public void examineChange(String id,String info){
		String hql = "update HandleSeparate set examine=? where id=?";
		dao.executeHql(hql, new Object[]{info,id});
	}
	
	/**
	 * 修改一条建议另行处理通知信息
	 * **/
	public void update(HandleSeparate info){
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
