package com.hoyotech.prison.service.impl;

import java.util.Date;
import java.util.List;

import com.hoyotech.prison.bean.AppealDataPass;
import com.hoyotech.prison.dao.impl.BasicDao;

public class AppealDataPassService {

private BasicDao dao;
	
	/**
	 * 添加一条被拘留人申诉控告等材料转递函信息
	 * **/
	public String add(AppealDataPass info){
		info.setAddTime(new Date());
		info.setUpdateTime(new Date());
		return dao.save(info);
	}
	
	/**
	 * 查询一条被拘留人申诉控告等材料转递函信息
	 * **/
	public AppealDataPass detail(String id){
		return (AppealDataPass)dao.detail(AppealDataPass.class, id);
	}
	
	public AppealDataPass detailByPrisoner(String prisonerId){
		List<AppealDataPass> list = (List<AppealDataPass>)dao.queryByHql("from AppealDataPass where prisoner.id=?", new Object[]{prisonerId});
		return list.size()>0?list.get(0):new AppealDataPass();
	}
	
	/**
	 * 删除一条被拘留人申诉控告等材料转递函信息
	 * **/
	public void delete(String id){
		String hql = "update AppealDataPass set state=0 where id=?";
		dao.executeHql(hql, new Object[]{id});
	}
	
	/**
	 * 修改一条被拘留人申诉控告等材料转递函信息
	 * **/
	public void update(AppealDataPass info){
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
