package com.hoyotech.prison.service.impl;

import java.util.Date;
import java.util.List;

import com.hoyotech.prison.bean.ExecutionDetain;
import com.hoyotech.prison.bean.OutPrison;
import com.hoyotech.prison.dao.impl.BasicDao;
import com.hoyotech.prison.util.ObjectUpdateUtil;

public class ExecutionDetainService {

	private BasicDao dao;

	/**
	 * 查询所有未审批的提解被拘留人登记信息
	 * **/
	public List<ExecutionDetain> select(String prisonCode){
		String hql = "from ExecutionDetain where examine=0 and state=1 and prisonCode="+prisonCode+" order by updateTime desc";
		return (List<ExecutionDetain>)dao.queryByHql(hql, new Object[]{});
	
	}
	
	/**
	 * 添加一条代为执行拘留信息
	 * **/
	public String add(ExecutionDetain info){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(info);
		info.setUpdateTime(new Date());
		info.setAddTime(new Date());
		return dao.save(info);
	}
	
	public ExecutionDetain detailByPrisoner(String prisonerId){
		List<ExecutionDetain> list = (List<ExecutionDetain>)dao.queryByHql("from ExecutionDetain where prisoner.id=?", new Object[]{prisonerId});
		return list.size()>0?list.get(0):new ExecutionDetain();
	}
	
	/**
	 * 查询一条代为执行拘留信息
	 * **/
	public ExecutionDetain detail(String id){
		return (ExecutionDetain)dao.detail(ExecutionDetain.class, id);
	}
	
	/**
	 * 删除一条代为执行拘留信息
	 * **/
	public void delete(String id){
		String hql = "update ExecutionDetain set state=0 where id=?";
		dao.executeHql(hql, new Object[]{id});
	}
	
	/**
	 * 修改一条代为执行拘留信息
	 * **/
	public void update(ExecutionDetain info){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(info);
		info.setExamine("0");
		info.setUpdateTime(new Date());
		dao.update(info);
	}

	/**
	 * 根据被拘留人的id查询一条请假出所信息
	 * **/
	public List<OutPrison> getOutprison(String id){
		String hql="from Execution where prisoner.id=? and state=1 order by addTime desc";
		return (List<OutPrison>)dao.queryByHql(hql, new Object[]{id});
	}
	/**
	 * 修改审批状态
	 * **/
	public void examineChange(String id,String info){
		String hql = "update ExecutionDetain set examine=? where id=?";
		dao.executeHql(hql, new Object[]{info,id});
	}
	
	public BasicDao getDao() {
		return dao;
	}

	public void setDao(BasicDao dao) {
		this.dao = dao;
	}
}


