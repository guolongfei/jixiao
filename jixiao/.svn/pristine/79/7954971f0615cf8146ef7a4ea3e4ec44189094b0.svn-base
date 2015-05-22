package com.hoyotech.prison.service.impl;

import java.util.Date;
import java.util.List;

import com.hoyotech.prison.bean.SendExamine;
import com.hoyotech.prison.dao.impl.BasicDao;
import com.hoyotech.prison.dao.impl.DictionaryDao;
import com.hoyotech.prison.util.ObjectUpdateUtil;

public class SendExamineService {

	private BasicDao dao;
	private DictionaryDao dictionaryDao;
	
	/**
	 * 添加
	 * @param obj
	 * @return
	 */
	public String add(SendExamine obj){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(obj);
		obj.setAddTime(new Date());
		obj.setUpdateTime(new Date());

		String id = dao.save(obj);
		return id;
	}
	
	/**
	 * 查询详细信息
	 * @param prisonerId
	 * @return
	 */
	public SendExamine detail(String id){
		return (SendExamine) dao.detail(SendExamine.class, id);
	}
	
	/**
	 * 查询详细信息
	 * @param prisonerId
	 * @return
	 */
	public SendExamine detailByPrisoner(String prisonerId){
		List<SendExamine> list = (List<SendExamine>)dao.queryByHql("from SendExamine where prisoner.id=?", new Object[]{prisonerId});
		return list.size()>0?list.get(0):null;
	}
	
	/**
	 * 修改一条信息
	 * **/
	public void update(SendExamine info){
		ObjectUpdateUtil.checkProperty(info);
		info.setUpdateTime(new Date());
		dao.update(info);
	}
	
	/**
	 * 修改审批状态
	 * **/
	public void examineChange(String id,String info){
		String hql = "update SendExamine set examine=? where id=?";
		dao.executeHql(hql, new Object[]{info,id});
	}
	
	public DictionaryDao getDictionaryDao() {
		return dictionaryDao;
	}
	public void setDictionaryDao(DictionaryDao dictionaryDao) {
		this.dictionaryDao = dictionaryDao;
	}

	public BasicDao getDao() {
		return dao;
	}

	public void setDao(BasicDao dao) {
		this.dao = dao;
	}
	

}
