package com.hoyotech.prison.service.impl;

import java.util.List;

import com.hoyotech.prison.bean.Arraign;
import com.hoyotech.prison.bean.AskRegistration;
import com.hoyotech.prison.bean.ExecuteReturn;
import com.hoyotech.prison.bean.ExecutionDetain;
import com.hoyotech.prison.bean.JiangCheng;
import com.hoyotech.prison.bean.LeaveExpires;
import com.hoyotech.prison.bean.OutPrison;
import com.hoyotech.prison.bean.SendExamine;
import com.hoyotech.prison.bean.StopDetain;
import com.hoyotech.prison.bean.UseWeapon;
import com.hoyotech.prison.dao.impl.BasicDao;

public class MainService {

	private BasicDao dao;

	/**
	 * 查询
	 * **/
	public List<Arraign> arrgin(String prisonCode){
		String hql = "from Arraign where examine=0 and state=1 and prisonCode="+prisonCode;
		return (List<Arraign>)dao.queryByHql(hql, new Object[]{});
	}

	/**
	 * 查询
	 * **/
	public List<AskRegistration> ask(String prisonCode){
		String hql = "from AskRegistration where examine=0 and state=1 and prisonCode="+prisonCode;
		return (List<AskRegistration>)dao.queryByHql(hql, new Object[]{});
	}
	
	/**
	 * 查询
	 * **/
	public List<ExecuteReturn> returns(String prisonCode){
		String hql = "from ExecuteReturn where examine=0 and state=1 and prisonCode="+prisonCode;
		return (List<ExecuteReturn>)dao.queryByHql(hql, new Object[]{});
	}
	
	/**
	 * 查询
	 * **/
	public List<ExecutionDetain> detain(String prisonCode){
		String hql = "from ExecutionDetain where examine=0 and state=1 and prisonCode="+prisonCode;
		return (List<ExecutionDetain>)dao.queryByHql(hql, new Object[]{});
	}

	/**
	 * 查询
	 * **/
	public List<JiangCheng> jiangcheng(String prisonCode){
		String hql = "from JiangCheng where examine=0 and state=1 and prisonCode="+prisonCode;
		return (List<JiangCheng>)dao.queryByHql(hql, new Object[]{});
	}
	
	/**
	 * 查询
	 * **/
	public List<LeaveExpires> leave(String prisonCode){
		String hql = "from LeaveExpires where examine=0 and state=1 and prisonCode="+prisonCode;
		return (List<LeaveExpires>)dao.queryByHql(hql, new Object[]{});
	}
	
	/**
	 * 查询
	 * **/
	public List<OutPrison> outs(String prisonCode){
		String hql = "from OutPrison where examine=0 and state=1 and prisonCode="+prisonCode;
		return (List<OutPrison>)dao.queryByHql(hql, new Object[]{});
	}
	
	/**
	 * 查询
	 * **/
	public List<SendExamine> send(String prisonCode){
		String hql = "from SendExamine where examine=0 and state=1 and prisonCode="+prisonCode;
		return (List<SendExamine>)dao.queryByHql(hql, new Object[]{});
	}
	
	/**
	 * 查询
	 * **/
	public List<StopDetain> stop(String prisonCode){
		String hql = "from StopDetain where examine=0 and state=1 and prisonCode="+prisonCode;
		return (List<StopDetain>)dao.queryByHql(hql, new Object[]{});
	}
	
	/**
	 * 查询
	 * **/
	public List<UseWeapon> weapon(String prisonCode){
		String hql = "from UseWeapon where examine=0 and state=1 and prisonCode="+prisonCode;
		return (List<UseWeapon>)dao.queryByHql(hql, new Object[]{});
	}
	
	public BasicDao getDao() {
		return dao;
	}

	public void setDao(BasicDao dao) {
		this.dao = dao;
	}
	
	
	
}
