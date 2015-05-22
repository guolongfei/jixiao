package com.hoyotech.prison.service.impl;

import java.util.List;

import com.hoyotech.prison.bean.Quarter;
import com.hoyotech.prison.dao.impl.BasicDao;

public class QuarterService {
	private BasicDao dao;
	
	//添加季度考核时间
	public void addQuarterTime(String year,String quarter,String startTime,String endTime){
		Quarter qt = new Quarter();
		qt.setYear(year);
		qt.setQuarter(quarter);
		qt.setStartTime(startTime);
		qt.setEndTime(endTime);
		dao.save(qt);
	}
	//显示季度考核详情
	@SuppressWarnings("unchecked")
	public List<Quarter> getTime(){
		String hql = "from Quarter";
		return (List<Quarter>) dao.queryByHql(hql, new Object[]{});
	}
	//根据Id查询季度考核时间
	@SuppressWarnings("unchecked")
	public List<Quarter> queryTime(String quarterId){
		String hql = "from Quarter where quarterId='"+quarterId+"'";
		return (List<Quarter>) dao.queryByHql(hql, new Object[]{});
	}
	//修改季度考核时间
	public void updateTime(String quarterId,String year,String quarter,String startTime,String endTime){
		String hql = "update Quarter set year='"+year+"',quarter='"+quarter+"',startTime='"+startTime+"',endTime='"+endTime+"' where quarterId='"+quarterId+"'";
		dao.executeHql(hql,new Object[]{});
	}
	public void setDao(BasicDao dao) {
		this.dao = dao;
	}

	public BasicDao getDao() {
		return dao;
	}
}
