package com.hoyotech.prison.service.impl;

import java.util.Date;
import java.util.List;

import com.hoyotech.prison.bean.CrimeKeyPass;
import com.hoyotech.prison.dao.impl.BasicDao;

public class CrimeKeyPassService {

private BasicDao dao;
	
	/**
	 * 查询所有违法犯罪线索转递函信息
	 * **/
	public List<CrimeKeyPass> list(String prisonerId, String prisonCode){
		String hql = "from CrimeKeyPass where state=1 and prisoner.id=? and prisonCode="+prisonCode;
		return (List<CrimeKeyPass>)dao.queryByHql(hql, new Object[]{prisonerId});

	}
	
	/**
	 * 查询违法犯罪线索转递函的总数
	 * **/
	public int count(String prisonerId, String prisonCode){
		String hql = "select count(*) from CrimeKeyPass where state=1 and prisoner.id=? and prisonCode="+prisonCode;
		return dao.getCount(hql, new Object[]{prisonerId});
	}
	
	/**
	 * 添加一条违法犯罪线索转递函信息
	 * **/
	public String add(CrimeKeyPass info){
		info.setAddTime(new Date());
		info.setUpdateTime(new Date());
		return dao.save(info);
	}
	
	public CrimeKeyPass detailByPrisoner(String prisonerId){
		List<CrimeKeyPass> list = (List<CrimeKeyPass>)dao.queryByHql("from CrimeKeyPass where prisoner.id=?", new Object[]{prisonerId});
		return list.size()>0?list.get(0):new CrimeKeyPass();
	}
	
	/**
	 * 查询一条违法犯罪线索转递函信息
	 * **/
	public CrimeKeyPass detail(String id){
		return (CrimeKeyPass)dao.detail(CrimeKeyPass.class, id);
	}
	
	/**
	 * 删除一条违法犯罪线索转递函信息
	 * **/
	public void delete(String id){
		String hql = "update CrimeKeyPass set state=0 where id=?";
		dao.executeHql(hql, new Object[]{id});
	}
	
	/**
	 * 修改审批状态
	 * **/
	public void examineChange(String id,String info){
		String hql = "update CrimeKeyPass set examine=? where id=?";
		dao.executeHql(hql, new Object[]{info,id});
	}
	
	/**
	 * 修改一条违法犯罪线索转递函信息
	 * **/
	public void update(CrimeKeyPass info){
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
