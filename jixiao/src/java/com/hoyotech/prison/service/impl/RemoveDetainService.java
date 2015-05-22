package com.hoyotech.prison.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.hoyotech.prison.bean.RemoveDetain;
import com.hoyotech.prison.dao.impl.BasicDao;

public class RemoveDetainService {

private BasicDao dao;
	
	/**
	 * 添加一条解除拘留信息
	 * **/
	public String add(RemoveDetain info){
		info.setAddTime(new Date());
		info.setUpdateTime(new Date());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String time=formatter.format(info.getWriteTime());
//		String hql = "update Prisoner set outprisonReson.id=?,state=3,realityOutTime=? where id=?";
//		dao.executeHql(hql, new Object[]{info.getRemoveReason().getId(),"to_date('"+time+"','yyyy-MM-dd')","'"+info.getPrisoner().getId()+"'"});
		String hql = "update Prisoner set outprisonReson.id='"+info.getRemoveReason().getId()+"',state=3,realityOutTime="+
		"to_date('"+time+"','yyyy-MM-dd')"+" where id='"+info.getPrisoner().getId()+"'";
		dao.executeHql(hql, new Object[]{});
		return dao.save(info);
	}
	
	/**
	 * 查询一条解除拘留信息
	 * **/
	public RemoveDetain detail(String id){
		return (RemoveDetain)dao.detail(RemoveDetain.class, id);
	}
	
	/**
	 * 删除一条解除拘留信息
	 * **/
	public void delete(String id){
		String hql = "update RemoveDetain set state=0 where id=?";
		dao.executeHql(hql, new Object[]{id});
	}
	
	/**
	 * 修改审批状态
	 * **/
	public void examineChange(String id,String info){
		String hql = "update RemoveDetain set examine=? where id=?";
		dao.executeHql(hql, new Object[]{info,id});
	}
	
	public RemoveDetain detailByPrisoner(String prisonerId){
		List<RemoveDetain> list = (List<RemoveDetain>)dao.queryByHql("from RemoveDetain where prisoner.id=?", new Object[]{prisonerId});
		return list.size()>0?list.get(0):new RemoveDetain();
	}
	
	/**
	 * 修改一条解除拘留信息
	 * **/
	public void update(RemoveDetain info){
		info.setUpdateTime(new Date());
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String time=formatter.format(info.getWriteTime());
		//String hql = "update Prisoner set outprisonReson.id=?,state=3,realityOutTime=? where id=?";
		String hql = "update Prisoner set outprisonReson.id='"+info.getRemoveReason().getId()+"',state=3,realityOutTime="+
		"to_date('"+time+"','yyyy-MM-dd')"+" where id='"+info.getPrisoner().getId()+"'";
		System.out.println("=============="+hql);
		//dao.executeHql(hql, new Object[]{info.getRemoveReason().getId(),"to_date('"+time+"','yyyy-MM-dd')",info.getPrisoner().getId()});
		dao.executeHql(hql, new Object[]{});
		dao.update(info);
	}

	public BasicDao getDao() {
		return dao;
	}

	public void setDao(BasicDao dao) {
		this.dao = dao;
	}
	
}
