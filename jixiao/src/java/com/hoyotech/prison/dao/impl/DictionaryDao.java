package com.hoyotech.prison.dao.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hoyotech.prison.bean.Career;
import com.hoyotech.prison.bean.Dictionary;
import com.hoyotech.prison.bean.Document;
import com.hoyotech.prison.bean.Medical;
import com.hoyotech.prison.bean.Nationality;
import com.hoyotech.prison.bean.Peoples;
import com.hoyotech.prison.bean.Police;
import com.hoyotech.prison.bean.Prisoner;
import com.hoyotech.prison.bean.WorkUnit;

public class DictionaryDao extends HibernateDaoSupport {

	
	/** 
	 *查询被拘留人下拉列表
	 *
	 * **/
	public List<Prisoner> selectPrisoner(String prisonCode){
		String hql = "from Prisoner where state=1 and prisonCode="+prisonCode+" order by updateTime desc";
		return getHibernateTemplate().find(hql);	
	}
	
	/** 
	 *查询民警人员列表
	 *
	 * **/
	public List<Police> selectPolice(String prisonCode){
		HttpServletRequest request = ServletActionContext.getRequest();
		String type=(String)request.getSession().getAttribute("orgType");
		String hql="";
		if("2".equals(type)){
			 hql = "from Police where state=1 order by updateTime desc";
		}else{
			 hql = "from Police where state=1 and prisonCode="+prisonCode+" order by updateTime desc";
		}
		return getHibernateTemplate().find(hql);	
	}
	
	/** 
	 *查询医务人员列表
	 *
	 * **/
	public List<Medical> selectMedical(String prisonCode){
		String hql = "from Medical where state=1 and prisonCode="+prisonCode+" order by updateTime desc";
		return getHibernateTemplate().find(hql);	
	}
	
	/** 
	 *查询工作单位列表
	 *
	 * **/
	public List<WorkUnit> selectworkUnit(String prisonCode){
		String hql = "from WorkUnit where state=1 and prisonCode="+prisonCode+" order by path asc";
		return getHibernateTemplate().find(hql);
	}
	
	/** 
	 *查询拘留所等级列表,规模列表
	 *
	 * **/
	public List<Dictionary> selectDictionary(int type){
		if(type==5){
			return getHibernateTemplate().find("from Dictionary d where d.type=? and id in (198,194,188,182,175,171,19,16)",type);
		}else if(type==9)
		{
			return getHibernateTemplate().find("from Dictionary d where d.type=? order by code desc",type);			
		}else{
			return getHibernateTemplate().find("from Dictionary d where d.type=?",type);
		}
	}
	/** 
	 *查询民族列表
	 *
	 * **/
	public List<Peoples> selectPeoples(int type){
		return getHibernateTemplate().find("from Peoples d where d.type=?",type);	
	}
	/** 
	 *查询职业列表
	 *
	 * **/
	public List<Career> selectCareer(int type){
		return getHibernateTemplate().find("from Career d where d.type=?",type);
	}
	/** 
	 *查询证件类型列表
	 *
	 * **/
	public List<Document> selectDocument(int type){
		return getHibernateTemplate().find("from Document d where d.type=?",type);	
	}
	/** 
	 *查询国籍列表
	 *
	 * **/
	public List<Nationality> selectNationality(int type){
		return getHibernateTemplate().find("from Nationality d where d.type=?",type);	
	}
}
