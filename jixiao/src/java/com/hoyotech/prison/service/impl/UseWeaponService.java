package com.hoyotech.prison.service.impl;

import java.util.Date;
import java.util.List;

import com.hoyotech.prison.bean.UseWeapon;
import com.hoyotech.prison.dao.impl.BasicDao;

public class UseWeaponService {

	private BasicDao dao;

	
	
	/**
	 * 查询所有使用警械信息
	 * **/
	public List<UseWeapon> list(String prisonerId){
		String hql = "from UseWeapon where state=1 and prisoner.id=?";
		return (List<UseWeapon>)dao.queryByHql(hql, new Object[]{prisonerId});

	}
	
	/**
	 * 查询使用警械的总数
	 * **/
	public int count(String prisonerId){
		String hql = "select count(*) from UseWeapon where state=1 and prisoner.id=?";
		return dao.getCount(hql, new Object[]{prisonerId});
	}
	
	/**
	 * 添加一条使用警械信息
	 * **/
	public String add(UseWeapon info){
		info.setAddTime(new Date());
		info.setUpdateTime(new Date());
		return dao.save(info);
	}
	
	public UseWeapon detailByPrisoner(String prisonerId){
		List<UseWeapon> list = (List<UseWeapon>)dao.queryByHql("from UseWeapon where prisoner.id=?", new Object[]{prisonerId});
		return list.size()>0?list.get(0):new UseWeapon();
	}
	
	/**
	 * 查询一条使用警械信息
	 * **/
	public UseWeapon detail(String id){
		return (UseWeapon)dao.detail(UseWeapon.class, id);
	}
	
	/**
	 * 删除一条使用警械信息
	 * **/
	public void delete(String id){
		String hql = "update UseWeapon set state=0 where id=?";
		dao.executeHql(hql, new Object[]{id});
	}
	
	/**
	 * 修改审批状态
	 * **/
	public void examineChange(String id,String info){
		String hql = "update UseWeapon set examine=? where id=?";
		dao.executeHql(hql, new Object[]{info,id});
	}
	
	/**
	 * 修改一条使用警械信息
	 * **/
	public void update(UseWeapon info){
		info.setUpdateTime(new Date());
		info.setExamine("0");
		dao.update(info);
	}

	public BasicDao getDao() {
		return dao;
	}

	public void setDao(BasicDao dao) {
		this.dao = dao;
	}

	
	
	
}
