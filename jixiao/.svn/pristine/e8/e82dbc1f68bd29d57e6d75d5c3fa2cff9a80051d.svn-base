package com.hoyotech.prison.service.impl;

import java.util.Date;
import java.util.List;

import com.hoyotech.prison.bean.ExecuteReturn;
import com.hoyotech.prison.bean.OutPrison;
import com.hoyotech.prison.dao.impl.BasicDao;
import com.hoyotech.prison.util.ObjectUpdateUtil;

public class ExecuteReturnService {

private BasicDao dao;
	
	/**
	 * 查询所有未审批异地拘留审批信息
	 * **/
	public List<ExecuteReturn> select(String prisonCode){
		String hql = "from ExecuteReturn where examine=0 and prisonCode="+prisonCode+" order by updateTime desc";
		return (List<ExecuteReturn>)dao.queryByHql(hql, new Object[]{});
	}

	/**
	 * 添加一条异地拘留审批信息
	 * **/
	public String add(ExecuteReturn info){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(info);
		info.setAddTime(new Date());
		info.setUpdateTime(new Date());
		return dao.save(info);
	}
	
	/**
	 * 查询一条异地拘留审批信息
	 * **/
	public ExecuteReturn detail(String id){
		return (ExecuteReturn)dao.detail(ExecuteReturn.class, id);
	}
	
	/**
	 * 根据被拘留人查询异地拘留审批信息
	 * **/
	public ExecuteReturn detailByPrisoner(String prisonerId){
		List<ExecuteReturn> list = (List<ExecuteReturn>)dao.queryByHql("from ExecuteReturn where prisoner.id=?", new Object[]{prisonerId});
		return list.size()>0?list.get(0):new ExecuteReturn();
	}
	
	/**
	 * 删除一条异地拘留审批信息
	 * **/
	public void delete(String id){
		String hql = "update ExecuteReturn set state=0 where id=?";
		dao.executeHql(hql, new Object[]{id});
	}
	
	/**
	 * 修改一条异地拘留审批信息
	 * **/
	public void update(ExecuteReturn info){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(info);
		info.setUpdateTime(new Date());
		dao.update(info);
	}

	/**
	 * 根据被拘留人的id查询一条请假出所信息
	 * **/
	public List<OutPrison> getOutprison(String id){
		String hql="from OutPrison where prisoner.id=? and state=1 order by addTime desc";
		return (List<OutPrison>)dao.queryByHql(hql, new Object[]{id});
	}
	
	/**
	 * 修改审批状态
	 * **/
	public void examineChange(String id,String info){
		String hql = "update ExecuteReturn set examine=? where id=?";
		dao.executeHql(hql, new Object[]{info,id});
	}
	
	public BasicDao getDao() {
		return dao;
	}

	public void setDao(BasicDao dao) {
		this.dao = dao;
	}

	
	
	
}


