package com.hoyotech.prison.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hoyotech.prison.bean.DeepCrime;
import com.hoyotech.prison.dao.impl.BasicDao;
import com.hoyotech.prison.util.ObjectUpdateUtil;

public class DeepCrimeService {

	private BasicDao dao;
	/**
	 * 检索深挖犯罪线索登记信息
	 * **/
	public String getCondition(String name,Date time,String neixing){
		StringBuilder sb = new StringBuilder();
		if(name != null && name.length() > 0){
			sb.append(" and name.name like '%"+name+"%'");
		}
		if(time != null){
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String date=formatter.format(time);
			sb.append(" and time >=to_date('"+date+"','yyyy-MM-dd') and time<= to_date('"+date+" 23:59:59','yyyy-MM-dd hh24:mi:ss')");
		}
		if(neixing != null && neixing.length() > 0){
			sb.append(" and type=?");
		}
		return sb.toString();
	}
	
	/**
	 * 检索深挖犯罪线索登记的条件
	 * **/
	public List<String> getParaCondition(String name,Date time,String neixing){
		List<String> list = new ArrayList<String>();
		if(neixing != null && neixing.length() > 0){
			list.add(neixing);
		}
		return list;
	}
	
	
	/**
	 * 查询所有深挖犯罪线索登记信息
	 * **/
	public List<DeepCrime> list(String name,Date time,String neixing,int pageNumber,int pageSize,String prisonCode){
		List<String> param = getParaCondition(name,time,neixing);
		String condition = getCondition(name,time,neixing);
		String hql = "from DeepCrime where state=1 and prisonCode="+prisonCode+condition+" order by updateTime desc";
		return (List<DeepCrime>)dao.queryByHql(hql, param.toArray(), pageNumber, pageSize);

	}
	
	/**
	 * 查询深挖犯罪线索登记的总数
	 * **/
	public int count(String name,Date time,String neixing,String prisonCode){
		List<String> param = getParaCondition(name,time,neixing);
		String condition = getCondition(name,time,neixing);
		String hql = "select count(*) from DeepCrime where state=1 and prisonCode="+prisonCode+condition;
		return dao.getCount(hql, param.toArray());
	}
	
	/**
	 * 添加一条深挖犯罪线索登记信息
	 * **/
	public String add(DeepCrime info){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(info);
		info.setAddTime(new Date());
		info.setUpdateTime(new Date());
		return dao.save(info);
	}
	
	/**
	 * 查询一条深挖犯罪线索登记信息
	 * **/
	public DeepCrime detail(String id){
		return (DeepCrime)dao.detail(DeepCrime.class, id);
	}
	
	/**
	 * 删除一条深挖犯罪线索登记信息
	 * **/
	public void delete(String id){
		String hql = "update DeepCrime set state=0 where id=?";
		dao.executeHql(hql, new Object[]{id});
	}
	
	/**
	 * 修改一条深挖犯罪线索登记信息
	 * **/
	public void update(DeepCrime info){
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
