package com.hoyotech.prison.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.hoyotech.prison.service.impl.JX_DepartmentService;
import com.hoyotech.prison.bean.JX_Department;
import com.isa.pims.basic.ServletRequestUtils;

public class JX_DepartmentAction {
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	HttpServletRequest request=ServletActionContext.getRequest();
	private JX_DepartmentService jx_DepartmentService;
	List<JX_Department> dept_list;
	private JX_Department jx_department;
	private String dept_id;
	private String name;

	private int pageNum;
	private int limit;
	private int totalPage;
	private int totalNum;
	
	


	public JX_DepartmentAction(){}
	
	
	
	/*
	 * 刘泉2015.01.26
	 * 进入部门列表
	 * */
	public String bs_gotoDepartmentList(){
		getdepts();
		return "gotoDepartmentList";
	}
	
	public void getdepts(){
		pageNum = ServletRequestUtils.getInt(request, "page", "1");
		limit = ServletRequestUtils.getInt(request, "limit", "5");
		dept_list=jx_DepartmentService.getDepartmentList(request.getSession().getAttribute("deptId").toString(),pageNum,limit);
		totalNum=jx_DepartmentService.getDepartmentNum(request.getSession().getAttribute("deptId").toString());
		totalPage = (totalNum - 1) / limit + 1;
	}
	
	/* 
	 * 刘泉2015.01.26
	 * 进入部门添加页面
	 * */
	public String bs_gotoAddDepartment(){
		return "gotoAddDepartment";
	}
	
	/*
	 * 刘泉
	 * 进入部门详情界面
	 * */
	public String bs_gotoDepartmentDetail(){
		jx_department=jx_DepartmentService.getDepartmentDetail(dept_id);
		return "gotoDepartmentDetail";
	}
	
	/*
	 * 刘泉2015.01.26
	 * 添加部门函数
	 * */
	public String bs_addDepartment(){
		jx_department.setPid(request.getSession().getAttribute("deptPid").toString());
		jx_department.setLevel(Integer.parseInt(request.getSession().getAttribute("deptLevel").toString())+1);
		jx_department.setAdd_date(new Date());
		System.out.println(jx_department.getAdd_date());
		jx_DepartmentService.bs_SaveAdd(jx_department);
		getdepts();
		return "AddSuccess";
	}
	//删除部门信息
	public String bs_deleteDepartment(){
		jx_DepartmentService.deleteDePartment(dept_id);
		getdepts();
		return "gotoDepartmentList";		
	}
	public String bs_updateDepartment(){
		jx_DepartmentService.updateDepartement(dept_id, name);
		getdepts();
		return "gotoDepartmentList";
	}

	public SimpleDateFormat getDf() {
		return df;
	}

	public void setDf(SimpleDateFormat df) {
		this.df = df;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public JX_DepartmentService getJx_DepartmentService() {
		return jx_DepartmentService;
	}

	public void setJx_DepartmentService(JX_DepartmentService jxDepartmentService) {
		jx_DepartmentService = jxDepartmentService;
	}

	public JX_Department getJx_department() {
		return jx_department;
	}

	public void setJx_department(JX_Department jxDepartment) {
		jx_department = jxDepartment;
	}

	public List<JX_Department> getDept_list() {
		return dept_list;
	}

	public void setDept_list(List<JX_Department> deptList) {
		dept_list = deptList;
	
	}
	
	public String getDept_id() {
		return dept_id;
	}

	public void setDept_id(String deptId) {
		dept_id = deptId;
	}

	public int getPageNum() {
		return pageNum;
	}



	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}



	public int getLimit() {
		return limit;
	}



	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getTotalPage() {
		return totalPage;
	}



	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}



	public int getTotalNum() {
		return totalNum;
	}



	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}

	
	
	

}
