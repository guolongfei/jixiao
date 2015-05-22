package com.hoyotech.prison.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.hoyotech.prison.bean.SpecialScore;
import com.hoyotech.prison.dao.impl.BasicDao;

public class SpecialScoreService {
	
	private BasicDao dao;
	public BasicDao getDao() {
		return dao;
	}
	public void setDao(BasicDao dao) {
		this.dao = dao;
	}
	public void save(SpecialScore spec) {
		// TODO Auto-generated method stub
		dao.save(spec);
	}
	public int IsExistScore(String pid, int year, int season) {
		// TODO Auto-generated method stub
         List<SpecialScore> list=new ArrayList<SpecialScore>();
         String hql="from SpecialScore s where s.score_year="+year+" and s.score_season="+season+" and s.score_pid='"+pid+"'";
         list=(List<SpecialScore>) dao.queryByHql(hql, null);
		 return list.size();
         
	}
	public List<SpecialScore> showScore(String pid) {
		// TODO Auto-generated method stub
		List<SpecialScore> list=new ArrayList<SpecialScore>();
		String hql="from SpecialScore s where s.score_pid='"+pid+"' order by s.score_cmtTime";
        list=(List<SpecialScore>) dao.queryByHql(hql, null);
        return list;
	}
	public List<SpecialScore> selectScore(String pid, int scoreYear, int scoreSeason) {
		// TODO Auto-generated method stub
		List<SpecialScore> list=new ArrayList<SpecialScore>();
        String hql="from SpecialScore s where s.score_year="+scoreYear+" and s.score_season="+scoreSeason+" and s.score_pid='"+pid+"'";
        list=(List<SpecialScore>) dao.queryByHql(hql, null);
		return list;
	}

}
