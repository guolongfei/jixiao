package com.hoyotech.prison.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hoyotech.prison.bean.MeetingRecord;
import com.hoyotech.prison.dao.impl.BasicDao;
import com.hoyotech.prison.util.ObjectUpdateUtil;

public class MeetingRecordService {

	private BasicDao dao;
	/**
	 * 检索所务会议及动态分析会议记录记录
	 * **/
	public String getCondition(String address,Date time){
		StringBuilder sb = new StringBuilder();
		if(address != null && address.length() > 0){
			sb.append(" and address like '%"+address+"%'");
		}
		if(time != null){
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String date=formatter.format(time);
			sb.append(" and time >='"+date+"' and time<= '"+date+" 23:59:59'");
		}
		return sb.toString();
	}
	
	/**
	 * 检索所务会议及动态分析会议记录的条件
	 * **/
	public List<String> getParaCondition(String name,Date time){
		List<String> list = new ArrayList<String>();
		return list;
	}
	
	
	/**
	 * 查询所务会议及动态分析会议记录
	 * **/
	public List<MeetingRecord> list(String address,Date time,int pageNumber,int pageSize,String prisonCode){
		List<String> param = getParaCondition(address,time);
		String condition = getCondition(address,time);
		String hql = "from MeetingRecord where state=1 and prisonCode="+prisonCode+condition+" order by updateTime desc";
		return (List<MeetingRecord>)dao.queryByHql(hql, param.toArray(), pageNumber, pageSize);

	}
	
	/**
	 * 查询所务会议及动态分析会议记录的总数
	 * **/
	public int count(String address,Date time,String prisonCode){
		List<String> param = getParaCondition(address,time);
		String condition = getCondition(address,time);
		String hql = "select count(*) from MeetingRecord where state=1 and prisonCode="+prisonCode+condition;
		return dao.getCount(hql, param.toArray());
	}
	
	/**
	 * 添加一条所务会议及动态分析会议记录
	 * **/
	public String add(MeetingRecord info){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(info);
		info.setAddTime(new Date());
		info.setUpdateTime(new Date());
		return dao.save(info);
	}
	
	/**
	 * 查询一条所务会议及动态分析会议记录
	 * **/
	public MeetingRecord detail(String id){
		return (MeetingRecord)dao.detail(MeetingRecord.class, id);
	}
	
	/**
	 * 删除一条所务会议及动态分析会议记录
	 * **/
	public void delete(String id){
		String hql = "update MeetingRecord set state=0 where id=?";
		dao.executeHql(hql, new Object[]{id});
	}
	
	/**
	 * 修改一条所务会议及动态分析会议记录
	 * **/
	public void update(MeetingRecord info){
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
