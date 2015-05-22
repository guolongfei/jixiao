package com.hoyotech.prison.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hoyotech.prison.bean.Achievement;
import com.hoyotech.prison.bean.JX_User;
import com.hoyotech.prison.bean.MessageReleases;
import com.hoyotech.prison.bean.User;
import com.hoyotech.prison.dao.impl.BasicDao;

public class AchievementService {
	
	private BasicDao dao;
	public BasicDao getDao() {
		return dao;
	}
	public void setDao(BasicDao dao) {
		this.dao = dao;
	}
	public List<Achievement> showMyAchieve(String userId) {
		// TODO Auto-generated method stub
		List<Achievement> list=new ArrayList<Achievement>();
		String hql="from Achievement where u.id=? order by achievement_recordTime desc";
        //list = (List<Achievement>)dao.queryByHql(hql,new Object[] {userId});
        return (List<Achievement>)dao.queryByHql(hql,new Object[] {userId});
	}
	public void addAchieve(String userId, String content) {
		// TODO Auto-generated method stub
		Achievement a=new Achievement();
		a.setAchievement_content(content);
		a.setAchievement_recordTime(new Date());
		JX_User u=new JX_User();
		u.setId(userId);
		a.setU(u);
		dao.save(a);
	}
	public List<Achievement> getAchieveByYear(String userId, int year) {
		// TODO Auto-generated method stub
		List<Achievement> list=new ArrayList<Achievement>();
		String hql="from Achievement where u.id='"+userId+"' and to_char(achievement_recordTime,'yyyy')='"+year+"' order by achievement_recordTime desc";
		return (List<Achievement>)dao.queryByHql(hql,new Object[] {});
	}

}
