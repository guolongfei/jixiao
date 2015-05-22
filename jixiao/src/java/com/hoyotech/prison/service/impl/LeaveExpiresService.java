package com.hoyotech.prison.service.impl;

import java.util.Date;
import java.util.List;

import com.hoyotech.prison.bean.LeaveExpires;
import com.hoyotech.prison.dao.impl.BasicDao;
import com.hoyotech.prison.util.ObjectUpdateUtil;

public class LeaveExpiresService {

private BasicDao dao;

	/**
	 * 查询所有请假出所到期通知信息
	 * **/
	public List<LeaveExpires> list(String prisonerId, String prisonCode){
		String hql = "from LeaveExpires where state=1 and outprison.prisoner.id=? and prisonCode="+prisonCode+" order by updateTime desc";
		return (List<LeaveExpires>)dao.queryByHql(hql, new Object[]{prisonerId});
	}
	
	/**
	 * 查询请假出所到期通知的总数
	 * **/
	public int count(String prisonerId, String prisonCode){
		String hql = "select count(*) from LeaveExpires where state=1 and outprison.prisoner.id=? and prisonCode="+prisonCode;
		return dao.getCount(hql, new Object[]{prisonerId});
	}
	
	/**
	 * 添加一条请假出所到期通知信息
	 * **/
	public String add(LeaveExpires info){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(info);
		info.setAddTime(new Date());
		info.setUpdateTime(new Date());
		return dao.save(info);
	}
	
	/**
	 * 查询一条请假出所到期通知信息
	 * **/
	public LeaveExpires detail(String id){
		return (LeaveExpires)dao.detail(LeaveExpires.class, id);
	}
	
	/**
	 * 删除一条请假出所到期通知信息
	 * **/
	public void delete(String id){
		String hql = "update LeaveExpires set state=0 where id=?";
		dao.executeHql(hql, new Object[]{id});
	}
	
	/**
	 * 修改一条请假出所到期通知信息
	 * **/
	public void update(LeaveExpires info){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(info);
		info.setUpdateTime(new Date());
		info.setExamine("0");
		dao.update(info);
	}
	/**
	 * 修改审批状态
	 * **/
	public void examineChange(String id,String info){
		LeaveExpires le=(LeaveExpires)dao.detail(LeaveExpires.class, id);
		String hql = "update LeaveExpires set examine=? where id=?";
		if(info.equals("1")&&le.getCondition().equals("按时回所继续执行")){
			String hql2 = "update Prisoner set state=1 where id = (select prisoner.id from OutPrison where id=(select outprison.id from LeaveExpires where id=?))";
			dao.executeHql(hql2, new Object[]{id});
		}
		dao.executeHql(hql, new Object[]{info,id});
	}
	
	public BasicDao getDao() {
		return dao;
	}

	public void setDao(BasicDao dao) {
		this.dao = dao;
	}
}


