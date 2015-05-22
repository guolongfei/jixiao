package com.hoyotech.prison.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.JX_Details;
import com.hoyotech.prison.service.impl.EmployeeService;

public class EmployeeAction {
	private EmployeeService empService;
	private JX_Details detailsList;
	private String content;
	private String departmentId;
	
	//添加部门考核细则
	public String getAddRule(){
		detailsList = empService.queryDetails(departmentId);
		if(detailsList!=null){
			empService.updateEmployee(content, departmentId);
		}
		else{
			empService.addEmployee(content, departmentId);
		}
		return "addRule";
	}
	//显示考核细则详情
	public String getEmpRule(){
		HttpServletRequest request=ServletActionContext.getRequest();
		departmentId = (String) request.getSession().getAttribute("deptId");
		detailsList = empService.queryDetails(departmentId);
		if(detailsList!=null){
			content = detailsList.getContent();
		}
		else{
			content="";
		}
		return "showList";
	}
	
	public EmployeeService getEmpService() {
		return empService;
	}
	public void setEmpService(EmployeeService empService) {
		this.empService = empService;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public JX_Details getDetailsList() {
		return detailsList;
	}

	public void setDetailsList(JX_Details detailsList) {
		this.detailsList = detailsList;
	}

}
