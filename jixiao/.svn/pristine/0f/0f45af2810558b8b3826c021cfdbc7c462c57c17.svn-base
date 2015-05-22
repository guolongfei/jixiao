package com.hoyotech.prison.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hoyotech.prison.bean.Arraign;
import com.hoyotech.prison.bean.AskRegistration;
import com.hoyotech.prison.dao.impl.BasicDao;

public class AskRegistrationService {

private BasicDao dao;
	

	/**
	 * 检索询问登记信息信息
	 * **/
	public String getCondition(String name,Date time){
		StringBuilder sb = new StringBuilder();
		if(name != null && name.length() > 0){
			sb.append(" and prisoner.name like '%"+name+"%'");
		}
		if(time != null){
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String date2=formatter.format(time);
			sb.append(" and startTime >=to_date('"+date2+"','yyyy-MM-dd')  and startTime<= to_date('"+date2+"','yyyy-MM-dd') ");
		}
		return sb.toString();
	}
	
	/**
	 * 检索询问登记信息的条件
	 * **/
	public List<String> getParaCondition(String name,Date time){
		List<String> list = new ArrayList<String>();
		return list;
	}
	
	/**
	 * 查询所有询问登记信息（台账）
	 * **/
	public List<AskRegistration> list_tz(String name,Date time,String prisonCode,int pageNumber,int pageSize){
		List<String> param = getParaCondition(name,time);
		String condition = getCondition(name,time);
		String hql = "from AskRegistration where state=1 and prisonCode="+prisonCode+condition+" order by updateTime desc";
		return (List<AskRegistration>)dao.queryByHql(hql, new Object[]{},pageNumber,pageSize);
	}

	/**
	 * 查询询问登记信息总数（台账）
	 * **/
	public int count_tz(String name,Date time,String prisonCode){
		List<String> param = getParaCondition(name,time);
		String condition = getCondition(name,time);
		String hql = "select count(*) from AskRegistration where state=1 and prisonCode="+prisonCode+condition;
		return dao.getCount(hql, new Object[]{});
	}
	
	/**
	 * 查询所有提解登记信息（台账）
	 * **/
	public List<Arraign> arraign_tz(String name,Date time,String prisonCode,int pageNumber,int pageSize){
		List<String> param = getParaCondition(name,time);
		String condition = getCondition(name,time);
		String hql = "from Arraign where state=1 and prisonCode="+prisonCode+condition+" order by updateTime desc";
		return (List<Arraign>)dao.queryByHql(hql, new Object[]{},pageNumber,pageSize);
	}

	/**
	 * 查询提解登记信息总数（台账）
	 * **/
	public int count_arr(String name,Date time,String prisonCode){
		List<String> param = getParaCondition(name,time);
		String condition = getCondition(name,time);
		String hql = "select count(*) from Arraign where state=1 and prisonCode="+prisonCode+condition;
		return dao.getCount(hql, new Object[]{});
	}

	/**
	 * 查询所有未审批询问被拘留人登记信息
	 * **/
	public List<AskRegistration> select(String prisonCode){
		String hql = "from AskRegistration where examine=0 and state=1 and prisonCode="+prisonCode+" order by updateTime desc";
		return (List<AskRegistration>)dao.queryByHql(hql, new Object[]{});
	}
	
	/**
	 * 查询所有询问被拘留人登记信息
	 * **/
	public List<AskRegistration> list(String prisonerId, String prisonCode){
		String hql = "from AskRegistration where state=1 and prisoner.id=? and prisonCode="+prisonCode+" order by updateTime desc";
		return (List<AskRegistration>)dao.queryByHql(hql, new Object[]{prisonerId});
	}
	
	/**
	 * 查询询问被拘留人登记的总数
	 * **/
	public int count(int prisonerId, String prisonCode){
		String hql = "select count(*) from AskRegistration where state=1 and prisoner.id=? and prisonCode="+prisonCode;
		return dao.getCount(hql, new Object[]{prisonerId});
	}
	
	/**
	 * 添加一条询问被拘留人登记信息
	 * **/
	public String add(AskRegistration info){
		info.setAddTime(new Date());
		info.setUpdateTime(new Date());
		return dao.save(info);
	}
	
	/**
	 * 查询一条询问被拘留人登记信息
	 * **/
	public AskRegistration detail(String id){
		return (AskRegistration)dao.detail(AskRegistration.class, id);
	}
	
	/**
	 * 删除一条询问被拘留人登记信息
	 * **/
	public void delete(String id){
		String hql = "update AskRegistration set state=0 where id=?";
		dao.executeHql(hql, new Object[]{id});
	}
	
	/**
	 * 修改审批状态
	 * **/
	public void examineChange(String id,String info){
		String hql = "update AskRegistration set examine=? where id=?";
		dao.executeHql(hql, new Object[]{info,id});
	}
	
	/**
	 * 修改一条询问被拘留人登记信息
	 * **/
	public void update(AskRegistration info){
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
