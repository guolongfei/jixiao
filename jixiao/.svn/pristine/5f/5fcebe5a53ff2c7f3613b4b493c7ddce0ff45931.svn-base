package com.hoyotech.prison.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.hoyotech.prison.bean.DrugManage;
import com.hoyotech.prison.bean.DrugType;
import com.hoyotech.prison.dao.impl.BasicDao;
import com.hoyotech.prison.util.ObjectUpdateUtil;

public class MedicalTreatmentService {
	private BasicDao dao;

	/**
	 * 获取药品类别翻页list
	 * @param drugtype
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 * @createDate 2014年12月24日
	 * @author mw
	 */
	public List<DrugType> queryDrugTypeByLimit(DrugType drugtype,int pageNumber,int pageSize){
		return (List<DrugType>) dao.queryByHql("from DrugType where prisonCode=? "+ getCondition(drugtype.getTypeName())+" order by updateTime desc", new Object[]{drugtype.getPrisonCode()}, pageNumber, pageSize);
	}
	/**
	 * 药品类别总数
	 * @param drugtype
	 * @return
	 * @createDate 2014年12月24日
	 * @author mw
	 */
	public int queryDurgTypeCount(DrugType drugtype){
		return dao.getCount("select count(*) from DrugType where prisonCode=? "+ getCondition(drugtype.getTypeName()), new Object[]{drugtype.getPrisonCode()});
	}
	
	/**
	 * 添加药品类别
	 * @param drugtype
	 * @createDate 2014年12月24日
	 * @author mw
	 */
	public void addDrugType(DrugType drugtype){
		ObjectUpdateUtil.checkProperty(drugtype);
		drugtype.setAddTime(new Date());
		drugtype.setUpdateTime(new Date());
		dao.save(drugtype);
	}
	
	public DrugType getDrugType(String id){
		return (DrugType) dao.detail(DrugType.class, id);
	}
	
	public DrugManage getDrug(String id){
		return (DrugManage) dao.detail(DrugManage.class, id);
	}
	/**
	 * 删除药品类别
	 * @param id
	 * @createDate 2014年12月24日
	 * @author mw
	 */
	public void modifyType(DrugType drugtype){
		DrugType oldtype = (DrugType) dao.detail(DrugType.class, drugtype.getId());
		oldtype.setTypeName(drugtype.getTypeName());
		oldtype.setUpdateTime(new Date());
		dao.update(oldtype);
	}
	
	public List<DrugType> getDrugTypeList(String prisonCode){
		return (List<DrugType>) dao.queryByHql("from DrugType where prisonCode=? order by updateTime desc", new Object[]{prisonCode});
	}
	
	public List<DrugManage> getDrugList(String prisonCode){
		return (List<DrugManage>) dao.queryByHql("from DrugManage where prisonCode=? order by updateTime desc", new Object[]{prisonCode});

	}
	
	private String getCondition(String typename){
		String condition = "";
		if(StringUtils.isNotBlank(typename)){
			condition += " and typeName='"+typename+"'";
		}
		return condition;
	}
	
	/**
	 * 药品list
	 * @param drugmanage
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 * @createDate 2014年12月24日
	 * @author mw
	 */
	public List<DrugManage> queryDrugListByLimit(DrugManage drugmanage,int pageNumber,int pageSize){
		return (List<DrugManage>) dao.queryByHql("from DrugManage where prisonCode=? "+getDrugCondition(drugmanage.getDrugName())+" order by updateTime desc", new Object[]{drugmanage.getPrisonCode()}, pageNumber, pageSize);
	}
	/**
	 * 获取药品数量
	 * @param drugmanage
	 * @return
	 * @createDate 2014年12月24日
	 * @author mw
	 */
	public int quertDrugListCount(DrugManage drugmanage){
		return dao.getCount("select count(*)  from DrugManage where prisonCode=? "+getDrugCondition(drugmanage.getDrugName()), new Object[]{drugmanage.getPrisonCode()});
	}
	
	public void addDrug(DrugManage drugmanage){
		ObjectUpdateUtil.checkProperty(drugmanage);
		drugmanage.setAddTime(new Date());
		drugmanage.setUpdateTime(new Date());
		dao.save(drugmanage);
	}
	
	public void modifyDrug(DrugManage drugmanage){
		DrugManage old = (DrugManage) dao.detail(DrugManage.class, drugmanage.getId());
		old.setDrugName(drugmanage.getDrugName());
		old.setBatch(drugmanage.getBatch());
		old.getDrugType().setId(drugmanage.getDrugType().getId());
		old.setUpdateTime(new Date());
		dao.update(old);
	}
	
	private String getDrugCondition(String name){
		String condition="";
		if(StringUtils.isNotBlank(name)){
			condition += " and drugName = '"+name+"'";
		}
		return condition;
	}
	public BasicDao getDao() {
		return dao;
	}

	public void setDao(BasicDao dao) {
		this.dao = dao;
	}
	
	
}
