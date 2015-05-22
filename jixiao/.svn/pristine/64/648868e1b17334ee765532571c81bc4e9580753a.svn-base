package com.hoyotech.prison.service.impl;

import java.util.Date;
import java.util.List;
import com.hoyotech.prison.bean.PrisonInfo;
import com.hoyotech.prison.bean.UserPowerZD;
import com.hoyotech.prison.bean.User;
import com.hoyotech.prison.dao.impl.BasicDao;
import com.hoyotech.prison.util.ObjectUpdateUtil;

public class LoginService {

	private BasicDao dao;

	public User getUserByName(String username){
		String hql="from User where username=? and state=1";
		User user=(User)dao.queryByHqlReturnUnique(hql, new Object[]{username});
		return user;
	}
	
	public int getPrisonState(String prisonCode){
		String hql="from PrisonInfo where prisonCode=?";
		PrisonInfo info= (PrisonInfo)dao.queryByHqlReturnUnique(hql, new Object[]{prisonCode});
		return info.getState();
	}
	
	public void updateLoginTime(User user){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(user);
		user.setLoginTime(new Date());
		dao.update(user);
	
	}
	
	public UserPowerZD getPrisonInfoListZD(String uid){
		return (UserPowerZD)dao.queryByHqlReturnUnique("from UserPowerZD where userId=?", new Object[]{uid});
	}
	
	public BasicDao getDao() {
		return dao;
	}

	public void setDao(BasicDao dao) {
		this.dao = dao;
	}
	
	
	
	
}
