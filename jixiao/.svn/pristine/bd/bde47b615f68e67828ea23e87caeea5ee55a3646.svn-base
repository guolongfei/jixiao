package com.hoyotech.prison.service.impl;

import java.util.Date;
import java.util.List;

import com.hoyotech.prison.bean.DetentionInfo;
import com.hoyotech.prison.dao.impl.BasicDao;
import com.hoyotech.prison.util.ObjectUpdateUtil;

public class DetentionInfoService {
	private BasicDao dao;
	
	/**
	 * 查询拘室
	 * 
	 **/
	public List<DetentionInfo> getList(String detentionName, int pageNumber,int pageSize,String prisonCode){
		String condition = getCondition(detentionName);
		String hql = "from DetentionInfo where state=1 and prisonCode="+prisonCode+condition+" order by updateTime desc";
		
		return (List<DetentionInfo>)dao.queryByHql(hql, null, pageNumber, pageSize);
	}
	
	/**
	 * 查询拘室总数
	 **/
	public int getCount(String detentionName,String prisonCode){
		String condition = getCondition(detentionName);
		String hql = "select count(*) from DetentionInfo where state=1 and prisonCode="+prisonCode+condition;
		
		return dao.getCount(hql, null);
	}
	
	public String getCondition(String detentionName){
		StringBuilder sb = new StringBuilder();
		if(detentionName != null && detentionName.length() > 0){
			sb.append(" and detentionName like '%"+detentionName+"%'");
		}
		return sb.toString();
	}
	
	public String add(DetentionInfo obj){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(obj);
		obj.setAddTime(new Date());
		obj.setUpdateTime(new Date());
		return dao.save(obj);
	}
	
	public DetentionInfo detail(String id){
		return (DetentionInfo)dao.detail(DetentionInfo.class, id);
	}
	
	public void update(DetentionInfo obj){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(obj);
		obj.setUpdateTime(new Date());
		dao.update(obj);
	}
	
	public void delete(String id){
		String hql = "update DetentionInfo set state=0 where id=?";
		dao.executeHql(hql, new Object[]{id});
	}
	
	public BasicDao getDao() {
		return dao;
	}
	
	public void setDao(BasicDao dao) {
		this.dao = dao;
	}
	
}
