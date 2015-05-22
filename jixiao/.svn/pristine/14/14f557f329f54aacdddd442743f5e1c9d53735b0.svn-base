package com.hoyotech.prison.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.hoyotech.prison.bean.InexepensiveText;
import com.hoyotech.prison.dao.impl.BasicDao;

public class InexepensiveTextService {
	
	private BasicDao dao;
	public BasicDao getDao() {
		return dao;
	}
	public void setDao(BasicDao dao) {
		this.dao = dao;
	}
	
	public List<InexepensiveText> showMyInexepensiveText(String userId) {
		// TODO Auto-generated method stub
		List<InexepensiveText> list=new ArrayList<InexepensiveText>();
		String hql="from InexepensiveText where u.id=? order by text_time desc";
        //list = (List<Achievement>)dao.queryByHql(hql,new Object[] {userId});
        return (List<InexepensiveText>)dao.queryByHql(hql,new Object[] {userId});
	}
	public List<InexepensiveText> getMyInexepensiveText(String userId, int year) {
		// TODO Auto-generated method stub
		List<InexepensiveText> list=new ArrayList<InexepensiveText>();
		String hql="from InexepensiveText where u.id='"+userId+"' and to_char(text_time,'yyyy')='"+year+"' order by text_time desc";
		return (List<InexepensiveText>)dao.queryByHql(hql,new Object[] {});
	}

}
