package com.hoyotech.prison.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.hoyotech.prison.bean.JX_Department;
import com.hoyotech.prison.bean.JX_User;
import com.hoyotech.prison.dao.impl.BasicDao;

public class JX_DepartmentService {

	private JX_Department department;
	private BasicDao dao;
	public BasicDao getDao() {
		return dao;
	}
	public void setDao(BasicDao dao) {
		this.dao = dao;
	}
	
	
	public JX_Department getDepartment() {
		return department;
	}
	public void setDepartment(JX_Department department) {
		this.department = department;
	}
	/*
	 * 刘泉2015.01.20
	 * 保存发布信息
	 * */
	public String bs_SaveAdd(JX_Department obj){
		return dao.save(obj);
	}
	
	/*
	 * 刘泉
	 * 查询部门列表
	 * */
	public List<JX_Department> getDepartmentList(String str,int pagenum,int limit){
		String hql="from JX_Department where id='"+str+"' or pid='"+str+"'";
		return (List<JX_Department>)dao.queryByHql(hql, new Object[]{}, pagenum, limit);
	}
	
	/*
	 * 刘泉
	 * 查询部门总数
	 * */
	public int getDepartmentNum(String str){
		String hql="select count(*) from JX_Department where id='"+str+"' or pid='"+str+"'";
		return dao.getCount(hql, new Object[]{});
	}
	
	/*
	 * 刘泉
	 * 查询部门详细信息
	 * */
	public JX_Department getDepartmentDetail(String id){
		return (JX_Department)dao.detail(JX_Department.class, id);
	}
	
	/*
	 * 删除部门信息
	 * */
	public void deleteDePartment(String dept_id){
		String hql = "delete from JX_Department where id='"+dept_id+"'";
		this.dao.executeHql(hql, new Object[]{});
	}
	/*
	 * 更新部门信息
	 * */
	public void updateDepartement(String dept_id,String name){
		System.out.println(name);
		String hql = "update JX_Department set name='"+name+"' where id='"+dept_id+"'";
		this.dao.executeHql(hql, new Object[]{});
	}
}
