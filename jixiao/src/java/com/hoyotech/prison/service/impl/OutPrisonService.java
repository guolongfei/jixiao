package com.hoyotech.prison.service.impl;

import java.util.Date;
import java.util.List;

import com.hoyotech.prison.bean.OutPrison;
import com.hoyotech.prison.dao.impl.BasicDao;
import com.hoyotech.prison.util.ObjectUpdateUtil;

public class OutPrisonService {

private BasicDao dao;
	
	/**
	 * 查询所有请假出所审批信息
	 * **/
	public List<OutPrison> list(String prisonerId, String prisonCode){
		String hql = "from OutPrison where state=1 and prisoner.id=? and prisonCode="+prisonCode+" order by updateTime desc";
		return (List<OutPrison>)dao.queryByHql(hql, new Object[]{prisonerId});

	}
	
	/**
	 * 查询请假出所审批的总数
	 * **/
	public int count(String prisonerId, String prisonCode){
		String hql = "select count(*) from OutPrison where state=1 and prisoner.id=? and prisonCode="+prisonCode;
		return dao.getCount(hql, new Object[]{prisonerId});
	}
	
	/**
	 * 添加一条请假出所审批信息
	 * **/
	public String add(OutPrison info){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(info);
		info.setAddTime(new Date());
		info.setUpdateTime(new Date());
		
		return dao.save(info);
	}
	
	/**
	 * 查询一条请假出所审批信息
	 * **/
	public OutPrison detail(String id){
		return (OutPrison)dao.detail(OutPrison.class, id);
	}
	
	/**
	 * 获取最后一条请假信息
	 * @param id
	 * @return
	 */
	public OutPrison getLastOutprison(String prisonerId){
		String hql = "from OutPrison where state=1 and prisoner.id=? order by id desc";
		List<OutPrison> list = (List<OutPrison>) dao.queryByHql(hql, new Object[]{prisonerId});
		return list.size()>0?list.get(0):null;
	}

	/**
	 * 删除一条请假出所审批信息
	 * **/
	public void delete(String id){
		String hql = "update OutPrison set state=0 where id=?";
		dao.executeHql(hql, new Object[]{id});
	}
	
	/**
	 * 修改一条请假出所审批信息
	 * **/
	public void update(OutPrison info){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(info);
		info.setExamine("0");
		info.setUpdateTime(new Date());
		String hql = "update Prisoner set state=2 where id=?";
		dao.executeHql(hql, new Object[]{info.getPrisoner().getId()});
		dao.update(info);
	}
	/**
	 * 修改审批状态
	 * **/
	public void examineChange(String id,String info){
		String hql = "update OutPrison set examine=? where id=?";
		if(info.equals("1")){
			String hql2 = "update Prisoner set state=2 where id= (select prisoner.id from OutPrison where id=?)";
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


