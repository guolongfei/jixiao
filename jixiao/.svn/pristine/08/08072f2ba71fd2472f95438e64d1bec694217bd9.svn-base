package com.hoyotech.prison.service.impl;

import java.util.List;

import com.hoyotech.prison.bean.Prisoner;
import com.hoyotech.prison.dao.impl.BasicDao;

public class NameSearchService {
	private BasicDao dao;
	
	public List<Prisoner> getPrisonerList(String prisoncode){
		String hql = "select id,name,xLetters from Prisoner where state=1 and prisonCode=? order by xLetters";
		return (List<Prisoner>) dao.queryByHql(hql, new Object[]{prisoncode});
	}

	public BasicDao getDao() {
		return dao;
	}

	public void setDao(BasicDao dao) {
		this.dao = dao;
	}
	
}
