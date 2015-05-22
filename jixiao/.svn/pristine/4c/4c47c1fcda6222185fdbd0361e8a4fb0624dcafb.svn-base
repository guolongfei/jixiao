package com.hoyotech.prison.service.impl;

import java.util.List;

import com.hoyotech.prison.bean.JX_Details;
import com.hoyotech.prison.dao.impl.BasicDao;

public class EmployeeService {
	private BasicDao dao;
	
	
	//查询部门考核细则
	public JX_Details queryDetails(String departmentId){
		String hql = "from JX_Details where departmentId='"+departmentId+"'";
		return (JX_Details) dao.queryByHqlReturnUnique(hql,new Object[]{});
	}
	//添加考核细则
	public void addEmployee(String content,String departmentId){		
			JX_Details details = new JX_Details();
			details.setContent(content);
			details.setDepartmentId(departmentId);
			dao.save(details);	
	}
	//更新部门考核细则
	public void updateEmployee(String content,String departmentId){
		String hql = "update JX_Details set content='"+content+"' where departmentId='"+departmentId+"'";
		dao.executeHql(hql, new Object[]{});
	}

	public void setDao(BasicDao dao) {
		this.dao = dao;
	}

	public BasicDao getDao() {
		return dao;
	}
}
