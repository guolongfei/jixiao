package com.hoyotech.prison.service.impl;

import java.util.Date;
import java.util.List;

import com.hoyotech.prison.bean.Memcon;
import com.hoyotech.prison.bean.MemconContent;
import com.hoyotech.prison.dao.impl.BasicDao;
import com.hoyotech.prison.util.ObjectUpdateUtil;

public class MemconService {

	private BasicDao dao;
	
	/**
	 * 添加谈话详细
	 * @param obj
	 * @return
	 */
	public String addContent(MemconContent obj){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(obj);
		obj.setAddTime(new Date());
		obj.setUpdateTime(new Date());
		String id = dao.save(obj);
		return id;
	}
	
	/**
	 * 添加谈话记录
	 * @param obj
	 * @return
	 */
	public String addMemcon(Memcon obj){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(obj);
		obj.setAddTime(new Date());
		obj.setUpdateTime(new Date());
		String id = dao.save(obj);
		return id;
	}
	
	/**
	 * 查询谈话记录列表
	 * @param prisonerId
	 * @return
	 */
	public List<Memcon> getMemconList(String prisonerId){
		List<Memcon> list = (List<Memcon>) dao.queryByHql("from Memcon where prisoner.id=?", new Object[]{prisonerId});
		return list;
	}
	
	/**
	 * 查询谈话记录次数
	 * @param prisonerId
	 * @return
	 */
	public int getMemconCount(String prisonerId){
		int count = dao.getCount("select count(*) from Memcon where prisoner.id=?", new Object[]{prisonerId});
		return count;
	}
	
	/**
	 * 谈话记录详细信息
	 * @param memconId
	 * @return
	 */
	public Memcon detail(String memconId){
		
		return (Memcon) dao.detail(Memcon.class, memconId);
	}
	/**
	 * 查询谈话记录内容列表
	 * @param prisonerId
	 * @return
	 */
	public List<MemconContent> getContentList(String memconId){
		List<MemconContent> list = (List<MemconContent>) dao.queryByHql("from MemconContent where memcon.id=?", new Object[]{memconId});
		return list;
	}

	public BasicDao getDao() {
		return dao;
	}

	public void setDao(BasicDao dao) {
		this.dao = dao;
	}
	
}
