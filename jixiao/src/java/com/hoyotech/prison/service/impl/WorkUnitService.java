package com.hoyotech.prison.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hoyotech.prison.bean.WorkUnit;
import com.hoyotech.prison.dao.impl.BasicDao;
import com.hoyotech.prison.util.ChineseCharToEn;
import com.hoyotech.prison.util.ObjectUpdateUtil;

public class WorkUnitService {

	private BasicDao dao;
	/**
	 * 检索办案单位信息
	 * **/
	public String getCondition(String unit){
		StringBuilder sb = new StringBuilder();
		if(unit != null && unit.length() > 0){
			sb.append(" and unitName like '%"+unit+"%'");
		}
		
		return sb.toString();
	}
	
	/**
	 * 检索办案单位的条件
	 * **/
	public List<String> getParaCondition(String unit){
		List<String> list = new ArrayList<String>();
//		if(name != null && name.length() > 0){
//			list.add(name);
//		}
//		if(titles != null && titles.length() > 0){
//			list.add(titles);
//		}
//		if(unit != null && unit.length() > 0){
//			list.add(unit);
//		}
		return list;
	}
	
	/**
	 * 查询所有办案单位的上级单位
	 * **/
	public List<WorkUnit> highWorkunit(String prisonCode){
		String hql = "from WorkUnit where state=1 and prisonCode="+prisonCode+" order by path asc";
		List<WorkUnit> list=(List<WorkUnit>)dao.queryByHql(hql, new Object[]{});
		
		for(WorkUnit org : list){
			org.setUnitName(getPath(org.getLevel())+"|-"+org.getUnitName());
		}
		return list;
	}
	
	private String getPath(int level){
		StringBuilder path = new StringBuilder("");
		for(int i=1; i<level; i++){
			path.append("　");
		}
		return path.toString();
	}
	
	/**
	 * 查询所有办案单位信息
	 * **/
	public List<WorkUnit> list(String unit,int pageNumber,int pageSize,String prisonCode){
		List<String> param = getParaCondition(unit);
		String condition = getCondition(unit);
		String hql = "from WorkUnit where state=1 and prisonCode="+prisonCode+condition+" order by updateTime desc";
		return (List<WorkUnit>)dao.queryByHql(hql, param.toArray(), pageNumber, pageSize);

	}
	
	/**
	 * 查询办案单位的总数
	 * **/
	public int count(String unit,String prisonCode){
		List<String> param = getParaCondition(unit);
		String condition = getCondition(unit);
		String hql = "select count(*) from WorkUnit where state=1 and prisonCode="+prisonCode+condition;
		return dao.getCount(hql, param.toArray());
	}
	
	public void newPath(WorkUnit info){
		int newLevel = 1;
		String newPath = "";
		if(info.getParentUnit() != null){
			WorkUnit parent = (WorkUnit) dao.detail(WorkUnit.class, info.getParentUnit().getId());
			newLevel = parent.getLevel() + 1;
			newPath = parent.getPath()+info.getId()+"-";
		}else{
			newPath = "-"+info.getId()+"-";
		}
		info.setLevel(newLevel);
		info.setPath(newPath);
	}
	
	
	/**
	 * 添加一条办案单位信息
	 * **/
	public String add(WorkUnit info){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(info);
		info.setAddTime(new Date());
		info.setUpdateTime(new Date());
		ChineseCharToEn cte = new ChineseCharToEn();   
		String en=cte.getAllFirstLetter(info.getUnitName()).toUpperCase();
		info.setLetters(en);
		String id=dao.save(info);
		info.setId(id);
		
		newPath(info);
		dao.update(info);
		return id;
	}
	
	/**
	 * 查询一条办案单位信息
	 * **/
	public WorkUnit detail(String id){
		return (WorkUnit)dao.detail(WorkUnit.class, id);
	}
	
	/**
	 * 删除一条办案单位信息
	 * **/
	public void delete(String id){
		String hql = "update WorkUnit set state=0 where id=?";
		dao.executeHql(hql, new Object[]{id});
	}
	
	/**
	 * 修改一条办案单位信息
	 * **/
	public void update(WorkUnit info){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(info);
		info.setUpdateTime(new Date());
		ChineseCharToEn cte = new ChineseCharToEn();   
		String en=cte.getAllFirstLetter(info.getUnitName()).toUpperCase();
		info.setLetters(en);
		
		newPath(info);
		dao.update(info);
	}
	
	public BasicDao getDao() {
		return dao;
	}

	public void setDao(BasicDao dao) {
		this.dao = dao;
	}
	
}

