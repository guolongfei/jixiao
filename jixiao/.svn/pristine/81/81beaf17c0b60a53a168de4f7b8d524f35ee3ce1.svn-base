package com.hoyotech.prison.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hoyotech.prison.bean.HandleConflict;
import com.hoyotech.prison.dao.impl.BasicDao;
import com.hoyotech.prison.util.ObjectUpdateUtil;

public class HandleConflictService {
	private BasicDao dao;
	/**
	 * 检索社会矛盾化解记录
	 * **/
	public String getCondition(String name,Date time){
		StringBuilder sb = new StringBuilder();
		if(name != null && name.length() > 0){
			sb.append(" and recorder like '%"+name+"%'");
		}
		if(time != null){
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String date=formatter.format(time);
			sb.append(" and time >=to_date('"+date+"','yyyy-MM-dd') and time<=to_date('"+date+" 23:59:59','yyyy-MM-dd hh24:mi:ss')");
		}
		return sb.toString();
	}
	
	/**
	 * 检索社会矛盾化解记录的条件
	 * **/
	public List<String> getParaCondition(String name,Date time){
		List<String> list = new ArrayList<String>();
		return list;
	}
	
	
	/**
	 * 查询所有社会矛盾化解记录
	 * **/
	public List<HandleConflict> list(String name,Date time,int pageNumber,int pageSize,String prisonCode){
		List<String> param = getParaCondition(name,time);
		String condition = getCondition(name,time);
		String hql = "from HandleConflict where state=1 and prisonCode="+prisonCode+condition+" order by updateTime desc";
		return (List<HandleConflict>)dao.queryByHql(hql, param.toArray(), pageNumber, pageSize);

	}
	
	/**
	 * 查询社会矛盾化解记录的总数
	 * **/
	public int count(String name,Date time,String prisonCode){
		List<String> param = getParaCondition(name,time);
		String condition = getCondition(name,time);
		String hql = "select count(*) from HandleConflict where state=1 and prisonCode="+prisonCode+condition;
		return dao.getCount(hql, param.toArray());
	}
	
	/**
	 * 添加一条社会矛盾化解记录
	 * **/
	public String add(HandleConflict info){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(info);
		info.setAddTime(new Date());
		info.setUpdateTime(new Date());
		return dao.save(info);
	}
	
	/**
	 * 查询一条社会矛盾化解记录
	 * **/
	public HandleConflict detail(String id){
		return (HandleConflict)dao.detail(HandleConflict.class, id);
	}
	
	/**
	 * 删除一条社会矛盾化解记录
	 * **/
	public void delete(String id){
		String hql = "update HandleConflict set state=0 where id=?";
		dao.executeHql(hql, new Object[]{id});
	}
	
	/**
	 * 修改一条社会矛盾化解记录
	 * **/
	public void update(HandleConflict info){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(info);
		info.setUpdateTime(new Date());
		dao.update(info);
	}
	
	public BasicDao getDao() {
		return dao;
	}

	public void setDao(BasicDao dao) {
		this.dao = dao;
	}
	
}
