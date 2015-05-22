package com.hoyotech.prison.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hoyotech.prison.bean.DetentionArea;
import com.hoyotech.prison.dao.impl.BasicDao;
import com.hoyotech.prison.util.ObjectUpdateUtil;

public class DetentionAreaService {
	private BasicDao dao;
	
	/**
	 * 查询组织信息
	 * 
	 **/
	public List<DetentionArea> getList(String prisonId, String areaName, int pageNumber,int pageSize,String prisonCode){
		List<String> param = getParaCondition(prisonId, areaName);
		String condition = getCondition(prisonId, areaName);
		String hql = "from DetentionArea where state=1 and prisonCode="+prisonCode+condition+" order by updateTime desc";
		return (List<DetentionArea>)dao.queryByHql(hql, param.toArray(), pageNumber, pageSize);
	}
	
	/**
	 * 查询组织总数
	 **/
	public int getCount(String prisonId, String areaName,String prisonCode){
		List<String> param = getParaCondition(prisonId, areaName);
		String condition = getCondition(prisonId, areaName);
		String hql = "select count(*) from DetentionArea where state=1 and prisonCode="+prisonCode+condition;
		return dao.getCount(hql, param.toArray());
	}
	
	public String getCondition(String prisonId, String areaName){
		StringBuilder sb = new StringBuilder();
		if(prisonId != null && prisonId.length() > 0){
			sb.append(" and prison_id=?");
		}
		if(areaName != null && areaName.length() > 0){
			sb.append(" and detention_area like '%"+areaName+"%'");
		}
		return sb.toString();
	}
	
	public List<String> getParaCondition(String prisonId, String areaName){
		List<String> list = new ArrayList<String>();
		if(prisonId != null && prisonId.length() > 0){
			list.add(prisonId);
		}
//		if(areaName != null && areaName.length() > 0){
//			list.add(areaName);
//		}
		return list;
	}
	
	/**
	 * 添加区域
	 **/
	public String add(DetentionArea obj){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(obj);
		obj.setAddTime(new Date());
		obj.setUpdateTime(new Date());
		return dao.save(obj);
	}
	
	public DetentionArea detail(String id){
		return (DetentionArea)dao.detail(DetentionArea.class, id);
	}
	
	public void update(DetentionArea obj){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(obj);
		obj.setUpdateTime(new Date());
		dao.update(obj);
	}
	
	public void delete(String id){
		String hql = "update DetentionArea set state=0 where id=?";
		dao.executeHql(hql, new Object[]{id});
	}
	
	public BasicDao getDao() {
		return dao;
	}
	
	public void setDao(BasicDao dao) {
		this.dao = dao;
	}
	
}
