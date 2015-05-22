package com.hoyotech.prison.service.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hoyotech.prison.bean.Police;
import com.hoyotech.prison.dao.impl.BasicDao;
import com.hoyotech.prison.util.ChineseCharToEn;
import com.hoyotech.prison.util.ObjectUpdateUtil;

public class PoliceService {
	private BasicDao dao;
	
	/**
	 * 查询警员信息
	 * 
	 **/
	public List<Police> getList(String policeCode, String policeName, String policeState, String policeLevel,String workState, int pageNumber,int pageSize,String prisonCode){
		List<String> param = getParaCondition(policeCode, policeName, policeState, policeLevel,workState);
		String condition = getCondition(policeCode, policeName, policeState, policeLevel,workState);
		String hql = "from Police where state!=0 and prisonCode="+prisonCode+condition+" order by updateTime desc";
		return (List<Police>)dao.queryByHql(hql, param.toArray(), pageNumber, pageSize);
	}
	
	/**
	 * 查询警员总数
	 **/
	public int getCount(String policeNumber, String name, String gender, String peoples,String workState,String prisonCode){
		List<String> param = getParaCondition(policeNumber, name, gender, peoples,workState);
		String condition = getCondition(policeNumber, name, gender, peoples,workState);
		
		String hql = "select count(*) from Police where state!=0 and prisonCode="+prisonCode+condition;
		
		return dao.getCount(hql, param.toArray());
	}
	
	public String getCondition(String policeNumber, String name, String gender, String peoples,String workState){
		StringBuilder sb = new StringBuilder();
		if(policeNumber != null && policeNumber.length() > 0){
			sb.append(" and policeNumber=?");
		}
		if(name != null && name.length() > 0){
			sb.append(" and name like '%"+name+"%'");
		}
		if(gender != null && gender.length() > 0){
			sb.append(" and gender.id=?");
		}
		if(peoples != null && peoples.length() > 0){
			sb.append(" and peoples.id=?");
		}
		if(workState != null && workState.length() > 0){
			sb.append(" and state=?");
		}
		return sb.toString();
	}
	
	public List<String> getParaCondition(String policeNumber, String name, String gender, String peoples,String workState){
		List<String> list = new ArrayList<String>();
		if(policeNumber != null && policeNumber.length() > 0){
			list.add(policeNumber);
		}
//		if(name != null && name.length() > 0){
//			list.add(name);
//		}
		if(gender != null && gender.length() > 0){
			list.add(gender);
		}
		if(peoples != null && peoples.length() > 0){
			list.add(peoples);
		}
		if(workState != null && workState.length() > 0){
			list.add(workState);
		}
		return list;
	}
	
	public String add(Police obj){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(obj);
		this.createCode(obj);
		obj.setUpdateTime(new Date());
		obj.setAddTime(new Date());
		
		ChineseCharToEn cte = new ChineseCharToEn();   
		String en=cte.getAllFirstLetter(obj.getName()).toUpperCase();
		obj.setLetters(en);
		return dao.save(obj);
	}
	
	/*
	 * 添加虚拟警员（用于支队权限帐号绑定）
	 * */
	public String addZD(Police obj){
		obj.setState(1);		
		obj.setUpdateTime(new Date());
		obj.setAddTime(new Date());
		
		ChineseCharToEn cte = new ChineseCharToEn();   
		String en=cte.getAllFirstLetter(obj.getName()).toUpperCase();
		obj.setLetters(en);
		return dao.save(obj);
	}
	
	public void createCode(Police obj){
		String prisonCode = obj.getPrisonCode();
		String hql = "select count(*) from Police where prisonCode=?";
		long count = (Long)dao.queryByHqlReturnUnique(hql, new Object[]{prisonCode});
		count++;
		DecimalFormat format = new DecimalFormat("000");
		String policeNumber = prisonCode + format.format(count);
		obj.setPoliceNumber(policeNumber);
	}
	
	public void update(Police obj){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(obj);
		obj.setUpdateTime(new Date());
		
		ChineseCharToEn cte = new ChineseCharToEn();   
		String en=cte.getAllFirstLetter(obj.getName()).toUpperCase();
		obj.setLetters(en);
		dao.update(obj);
	}
	
	public Police detail(String id){
		return (Police)dao.detail(Police.class, id);
	}
	
	public void delete(String id){
		String hql = "update Police set state=0 where id=?";
		dao.executeHql(hql, new Object[]{id});
	}
	
	public BasicDao getDao() {
		return dao;
	}
	
	public void setDao(BasicDao dao) {
		this.dao = dao;
	}
	
}
