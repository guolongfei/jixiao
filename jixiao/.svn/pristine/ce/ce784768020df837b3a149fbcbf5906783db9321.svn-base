package com.hoyotech.prison.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hoyotech.prison.bean.Inspect;
import com.hoyotech.prison.dao.impl.BasicDao;
import com.hoyotech.prison.util.ObjectUpdateUtil;

public class InspectService {

	private BasicDao dao;
	/**
	 * 检索视察检查记录
	 * **/
	public String getCondition(String name,String titles,String workstatus,String gender){
		StringBuilder sb = new StringBuilder();
		if(name != null && name.length() > 0){
			sb.append(" and name like '%"+name+"%'");
		}
		if(titles != null && titles.length() > 0){
			sb.append(" and title like '%"+titles+"%'");
		}
		if(workstatus != null && workstatus.length() > 0){
			sb.append(" and workStaus.id=?");
		}
		if(gender != null && gender.length() > 0){
			sb.append(" and gender.id=?");
		}
		return sb.toString();
	}
	
	/**
	 * 检索视察检查记录的条件
	 * **/
	public List<String> getParaCondition(String name,String titles,String workstatus,String gender){
		List<String> list = new ArrayList<String>();
//		if(name != null && name.length() > 0){
//			list.add(name);
//		}
//		if(titles != null && titles.length() > 0){
//			list.add(titles);
//		}
		if(workstatus != null && workstatus.length() > 0){
			list.add(workstatus);
		}
		if(gender != null && gender.length() > 0){
			list.add(gender);
		}
		return list;
	}
	
	
	/**
	 * 查询所有视察检查记录
	 * **/
	public List<Inspect> list(String name,String titles,String workstatus,String gender,int pageNumber,int pageSize,String prisonCode){
		List<String> param = getParaCondition(name,titles,workstatus,gender);
		String condition = getCondition(name,titles,workstatus,gender);
		String hql = "from Inspect where state=1 and prisonCode="+prisonCode+condition+" order by updateTime desc";
		return (List<Inspect>)dao.queryByHql(hql, param.toArray(), pageNumber, pageSize);
	}
	
	/**
	 * 查询安全视察记录的总数
	 * **/
	public int count(String name,String titles,String workstatus,String gender,String prisonCode){
		List<String> param = getParaCondition(name,titles,workstatus,gender);
		String condition = getCondition(name,titles,workstatus,gender);
		String hql = "select count(*) from Inspect where state=1 and prisonCode="+prisonCode+condition;
		return dao.getCount(hql, param.toArray());
	}
	
	/**
	 * 添加一条视察检查记录
	 * **/
	public String add(Inspect info){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(info);
		info.setAddTime(new Date());
		info.setUpdateTime(new Date());
		return dao.save(info);
	}
	
	/**
	 * 查询一条视察检查记录
	 * **/
	public Inspect detail(String id){
		return (Inspect)dao.detail(Inspect.class, id);
	}
	
	/**
	 * 删除一条视察检查记录
	 * **/
	public void delete(String id){
		String hql = "update Inspect set state=0 where id=?";
		dao.executeHql(hql, new Object[]{id});
	}
	
	/**
	 * 修改一条视察检查记录
	 * **/
	public void update(Inspect info){
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
