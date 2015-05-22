package com.hoyotech.prison.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hoyotech.prison.bean.SafeCheck;
import com.hoyotech.prison.dao.impl.BasicDao;
import com.hoyotech.prison.util.ObjectUpdateUtil;
import com.hoyotech.prison.bean.Police;

public class SafeCheckService {

	private BasicDao dao;
	/**
	 * 检索安全检查记录
	 * **/
	public String getCondition(Date time){
		StringBuilder sb = new StringBuilder();
		if(time != null ){
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String date=formatter.format(time);
			sb.append(" and time >=to_date('"+date+"','yyyy-MM-dd') and time<=to_date('"+date+" 23:59:59','yyyy-MM-dd hh24:mi:ss')");
		}
		return sb.toString();
	}
	
	/**
	 * 检索安全检查记录的条件
	 * **/
	public List<String> getParaCondition(Date time){
		List<String> list = new ArrayList<String>();
		return list;
	}
	
	
	/**
	 * 查询所有安全检查记录
	 * **/
	public List<SafeCheck> list(Date time,int pageNumber,int pageSize,String prisonCode){
		List<String> param = getParaCondition(time);
		String condition = getCondition(time);
		String hql = "from SafeCheck where state=1 and prisonCode="+prisonCode+condition+" order by updateTime desc";
		return (List<SafeCheck>)dao.queryByHql(hql, param.toArray(), pageNumber, pageSize);

	}
	
	/**
	 * 查询安全检查记录的总数
	 * **/
	public int count(Date time,String prisonCode){
		List<String> param = getParaCondition(time);
		String condition = getCondition(time);
		String hql = "select count(*) from SafeCheck where state=1 and prisonCode="+prisonCode+condition;
		return dao.getCount(hql, param.toArray());
	}
	
	/**
	 * 添加一条安全检查记录
	 * **/
	public String add(SafeCheck info){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(info);
		info.setAddTime(new Date());
		info.setUpdateTime(new Date());
		return dao.save(info);
	}
	
	/**
	 * 查询一条安全检查记录
	 * **/
	public SafeCheck detail(String id){
		return (SafeCheck)dao.detail(SafeCheck.class, id);
	}
	
	/**
	 * 删除一条安全检查记录
	 * **/
	public void delete(String id){
		String hql = "update SafeCheck set state=0 where id=?";
		dao.executeHql(hql, new Object[]{id});
	}
	
	/**
	 * 修改一条安全检查记录
	 * **/
	public void update(SafeCheck info){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(info);
		info.setUpdateTime(new Date());
		dao.update(info);
	}
	
	/*刘泉
	 * 
	 */
	public List<Police> checkPolice(){
		List<Police> list = new ArrayList<Police>();
		String hql="";
		list=dao.getHibernateTemplate().find(hql);
		return list;
	} 
	
	public BasicDao getDao() {
		return dao;
	}

	public void setDao(BasicDao dao) {
		this.dao = dao;
	}
	
}
