package com.hoyotech.prison.service.impl;

import java.util.Date;
import java.util.List;

import com.hoyotech.prison.bean.PrisonerHealth;
import com.hoyotech.prison.bean.TakeMedicine;
import com.hoyotech.prison.dao.impl.BasicDao;
import com.hoyotech.prison.util.ObjectUpdateUtil;
public class PrisonerHealthService {
	private BasicDao dao;
	
	/**
	 * 添加
	 * @param obj
	 * @return
	 */
	public String add(PrisonerHealth obj){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(obj);
		obj.setAddTime(new Date());
		obj.setUpdateTime(new Date());
		String id = dao.save(obj);
		return id;
	}
	
	public PrisonerHealth detail(String id){
		return (PrisonerHealth)dao.detail(PrisonerHealth.class, id);
	}
	
	public PrisonerHealth detailByPrisoner(String prisonerId){
		List<PrisonerHealth> list = (List<PrisonerHealth>)dao.queryByHql("from PrisonerHealth where prisoner.id=?", new Object[]{prisonerId});
		return list.size()>0?list.get(0):new PrisonerHealth();
	}
	
	public void update(PrisonerHealth obj){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(obj);
		obj.setUpdateTime(new Date());
		dao.update(obj);
	}
	
	
	public void insertTakeMedic(TakeMedicine takeMedic){
		ObjectUpdateUtil.checkProperty(takeMedic);
		takeMedic.setAddTime(new Date());
		takeMedic.setUpdateTime(new Date());
		dao.save(takeMedic);
	}
	
	public void delTakeMedic(String id){
		dao.executeHql("delete from TakeMedicine where id=?", new Object[]{id});
	}
	
	public List<TakeMedicine> queryTakeMedicList(String prisonedId){
		return (List<TakeMedicine>) dao.queryByHql("from TakeMedicine where prisoner=?", new Object[]{prisonedId});
	}
	
	
	public void updateTakeMedicState(String id){
		dao.executeHql("update TakeMedicine set state=1 where id=?", new Object[]{id});
	}
	
	public int getTakeMedicTime(String time){
		return dao.queryByHql("select count(*) from TakeMedicine where startTime<? and state=0 group by prisoner", new Object[]{time}).size();
	}
	
	public BasicDao getDao() {
		return dao;
	}
	
	public void setDao(BasicDao dao) {
		this.dao = dao;
	}
}
