package com.hoyotech.prison.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hoyotech.prison.bean.UserDuty;
import com.hoyotech.prison.dao.impl.BasicDao;
import com.hoyotech.prison.util.ObjectUpdateUtil;

public class UserDutyService {
	private BasicDao dao;
	
	public int countNotPassWork(String prisonId){
		String hql = "select count(*) from UserDuty where state=1 and user.prison.id=? and passWork=0";
		Long count = (Long) dao.queryByHqlReturnUnique(hql, new Object[]{prisonId});
		return count.intValue();
	}
	
	/**
	 * 查询交接班记录
	 * @param prisonId
	 * @param userId
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public List<UserDuty> getList(String prisonId, String startTime, String endTime, String name,String isPassWork, int pageNumber,int pageSize){
		String condition = this.getConditionString(prisonId, startTime, endTime, name, isPassWork);
		List<Object> paras = this.getConditionList(prisonId, startTime, endTime, name, isPassWork);
		String hql = "from UserDuty where state=1"+condition+" order by updateTime desc";
		List<UserDuty> list = (List<UserDuty>) dao.queryByHql(hql, paras.toArray(), pageNumber, pageSize);
		return list;
	}
	
	/**
	 * 查询交接班记录总数
	 * @param prisonId
	 * @param userId
	 * @return
	 */
	public int getCount(String prisonId, String startTime, String endTime, String name,String isPassWork){
		String condition = this.getConditionString(prisonId, startTime, endTime, name, isPassWork);
		List<Object> paras = this.getConditionList(prisonId, startTime, endTime, name, isPassWork);
		String hql = "select count(*) from UserDuty where state=1"+condition;
		int count = dao.getCount(hql, paras.toArray());
		return count;
		
	}
	
	List<Object> getConditionList(String prisonId, String startTime, String endTime, String name,String isPassWork){
		List<Object> list = new ArrayList<Object>();
		if(prisonId != null && !"".equals(prisonId)){
			list.add(prisonId);
		}
		if(startTime != null && !"".equals(startTime)){
			list.add(startTime);
		}
		if(endTime != null && !"".equals(endTime)){
			list.add(endTime);
		}
		if(isPassWork != null && !"".equals(isPassWork)){
			list.add(isPassWork);
		}
		return list;
	}
	
	String getConditionString(String prisonId, String startTime, String endTime, String name, String isPassWork){
		StringBuilder condition = new StringBuilder();
		if(prisonId != null && !"".equals(prisonId)){
			condition.append(" and user.prison.id=?");
		}
		if(startTime != null && !"".equals(startTime)){
			condition.append(" and endTime>=?");
		}
		if(endTime != null && !"".equals(endTime)){
			condition.append(" and startTime<=?");
		}
		if(name != null && !"".equals(name)){
			condition.append(" and user.name like '%"+name+"%'");
		}
		if(isPassWork != null && !"".equals(isPassWork)){
			condition.append(" and passWork=?");
		}
		return condition.toString();
	}
	
	/**
	 * 添加
	 * @param obj
	 * @return
	 */
	public String add(UserDuty obj){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(obj);
		obj.setAddTime(new Date());
		obj.setUpdateTime(new Date());
		return dao.save(obj);
	}
	
	/**
	 * 修改
	 * @param obj
	 * @return
	 */
	public void update(UserDuty obj){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(obj);
		obj.setUpdateTime(new Date());
		dao.update(obj);
	}
	
	/**
	 * 详细
	 * @param userId
	 */
	public UserDuty detail(String id){
		return (UserDuty) dao.detail(UserDuty.class, id);
	}
	
	public void passWork(String id, String userId){
		dao.executeHql("update UserDuty set passWork=1, passWorker.id=? where id=?", new Object[]{userId, id});
	}
	
	public BasicDao getDao() {
		return dao;
	}
	
	public void setDao(BasicDao dao) {
		this.dao = dao;
	}
	
}
