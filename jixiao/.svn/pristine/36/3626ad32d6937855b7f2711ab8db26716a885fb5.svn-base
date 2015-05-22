package com.hoyotech.prison.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hoyotech.prison.bean.Medical;
import com.hoyotech.prison.dao.impl.BasicDao;
import com.hoyotech.prison.dao.impl.DictionaryDao;
import com.hoyotech.prison.util.ChineseCharToEn;
import com.hoyotech.prison.util.ObjectUpdateUtil;

public class MedicalService {

	private BasicDao dao;
	DictionaryDao dictionaryDao;
	
	
	/**
	 * 检索医务人员信息
	 * **/
	public String getCondition(String name,String titles,String workstatus,String gender,String workState){
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
		if(workState != null && workState.length() > 0){
			sb.append(" and state=?");
		}
		return sb.toString();
	}
	
	/**
	 * 检索医务人员的条件
	 * **/
	public List<String> getParaCondition(String name,String titles,String workstatus,String gender,String workState){
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
		if(workState != null && workState.length() > 0){
			list.add(workState);
		}
		return list;
	}
	
	
	/**
	 * 查询所有医务人员信息
	 * **/
	public List<Medical> allmedical(String name,String titles,String workstatus,String gender,String workState,int pageNumber,int pageSize,String prisonCode){
		List<String> param = getParaCondition(name,titles,workstatus,gender,workState);
		String condition = getCondition(name,titles,workstatus,gender,workState);
		String hql = "from Medical where state!=0 and prisonCode="+prisonCode+condition+" order by updateTime desc";
		return (List<Medical>)dao.queryByHql(hql, param.toArray(), pageNumber, pageSize);

	}
	
	/**
	 * 查询医务人员的总数
	 * **/
	public int countMedical(String name,String titles,String workstatus,String gender,String workState,String prisonCode){
		List<String> param = getParaCondition(name,titles,workstatus,gender,workState);
		String condition = getCondition(name,titles,workstatus,gender,workState);
		String hql = "select count(*) from Medical where state!=0 and prisonCode="+prisonCode+condition;
		return dao.getCount(hql, param.toArray());
	}
	
	/**
	 * 添加一条医务人员信息
	 * **/
	public String addMedical(Medical info){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(info);
		info.setAddTime(new Date());
		info.setUpdateTime(new Date());
		
		ChineseCharToEn cte = new ChineseCharToEn();   
		String en=cte.getAllFirstLetter(info.getName()).toUpperCase();
		info.setLetters(en);
		return dao.save(info);
	}
	
	/**
	 * 查询一条医务人员信息
	 * **/
	public Medical medicalDetail(String id){
		return (Medical)dao.detail(Medical.class, id);
	}
	
	/**
	 * 删除一条医务人员信息
	 * **/
	public void medDel(String id){
		String hql = "update Medical set state=0 where id=?";
		dao.executeHql(hql, new Object[]{id});
	}
	
	/**
	 * 修改一条医务人员信息
	 * **/
	public void medUpdate(Medical info){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(info);
		info.setUpdateTime(new Date());
		
		ChineseCharToEn cte = new ChineseCharToEn();   
		String en=cte.getAllFirstLetter(info.getName()).toUpperCase();
		info.setLetters(en);
		dao.update(info);
	}
	
	public BasicDao getDao() {
		return dao;
	}

	public void setDao(BasicDao dao) {
		this.dao = dao;
	}

	public DictionaryDao getDictionaryDao() {
		return dictionaryDao;
	}

	public void setDictionaryDao(DictionaryDao dictionaryDao) {
		this.dictionaryDao = dictionaryDao;
	}
	
	
}
