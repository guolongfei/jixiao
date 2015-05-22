package com.hoyotech.prison.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.service.impl.JX_RoleService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.bean.JX_Permission;
import com.hoyotech.prison.bean.JX_Role;
import com.hoyotech.prison.bean.JX_RolePermission;
import com.isa.pims.basic.ServletRequestUtils;


public class JX_RoleAction {
	
	HttpServletRequest request=ServletActionContext.getRequest();
	private JX_RoleService jx_RoleService;
	private List<JX_Role> listjr;
	private JX_Role jx_Role;
	private String rolePer_id;
	private List<JX_Role> jx_Roles;	
	private Map<String,List<JX_Permission>> map;
	private String checkstring;
	private String[] perId;
	private int pageNum;
	private int limit; 
	private int totalPage;
	private int totalNum;
	private String roleIdPer;

	public JX_RoleAction(){
		
	}

	
	/*
	 * 刘泉2015.01.26
	 * 进入角色添加页面
	 * */
	public String bs_gotoAddRole(){	
		String dept_id=request.getSession().getAttribute("deptId").toString();		
		return "gotoAddRole";
	}
	
	/*
	 * 刘泉2015.01.27
	 * 添加角色函数
	 * */
	public String bs_SaveAddRole(){
		jx_Role.setAdd_date(new Date());
		String dept_id=request.getSession().getAttribute("deptId").toString();		
		jx_Role.setDepartment_id(dept_id);
		jx_RoleService.bs_SaveAddRole(jx_Role);
		getRoleList();
		return "AddSuccess";
	}
	
//	/**
//	 * 进入权限修改页面
//	 * **/
//	public String permissionEdit() {
//		HttpServletRequest request = ServletActionContext.getRequest();
//		String organize=StringUtils.$C((String)request.getSession().getAttribute("orgType"),"");
//		role = roleService.detail(id);
//		map=roleService.perList(organize);
//		checkstring="";
//		for(RolePermission i:role.getRolePer()){
//			checkstring=checkstring+i.getPerId().getId()+"," ;
//		}
//		String type=(String)request.getSession().getAttribute("orgType");
//		if("2".equals(type)){
//			return "stpermission";
//		}else{
//			return "permission";
//		}
//		
//	}
	
	/*
	 * 刘泉2015.01.28
	 * 进入权限修改界面
	 * */
	public String bs_getPermissionEdit(){
		map=jx_RoleService.getPerList();
		jx_Role=jx_RoleService.getRoleDetail(roleIdPer);
		checkstring="";
		for(JX_RolePermission i:jx_Role.getRolePer()){
			checkstring=checkstring+i.getJx_permission().getId()+"," ;
		}
		return "editPermission";
	}
	
	/*
	 * 刘泉2015.03.25
	 * 进入角色列表
	 * */
	public String bs_getRoleList(){
		getRoleList();
		return "gotoRoleList";
	}
	
	/*
	 * 刘泉2015.03.26
	 * 获取角色列表信息
	 * */
	public void getRoleList(){
		String dept_id=request.getSession().getAttribute("deptId").toString();
		pageNum = ServletRequestUtils.getInt(request, "page", "1");
		limit = ServletRequestUtils.getInt(request, "limit", "5");
		jx_Roles=jx_RoleService.getJX_RoleList(dept_id,pageNum,limit);			
		totalNum=jx_RoleService.getJX_RoleListNum(dept_id);	
		totalPage = (totalNum - 1) / limit + 1;
	}
	
//	/**
//	 * 修改权限
//	 * **/
//	public String updatePer() {
//		roleService.updatePer(id,perId);
//		
//		// 添加日志
//		HttpServletRequest request = ServletActionContext.getRequest();
//		ConfigHelper config = ConfigHelper.getConfig();
//		String operate = "修改成功。修改了角色id为"+id+"的权限";
//		log.getModifyLogMessage(null, null, config.getUpdate(), operate, config.getRole(), config.getSucceed(), request);
//		return "detail";
//	}
	
	/*
	 * 刘泉2015.01.29
	 * 修改权限
	 * */
	public String updatePer(){
		jx_RoleService.updatePer(jx_Role.getId(), perId);
		getRoleList();
		return "editPerAces";
	}
 
	public Map<String, List<JX_Permission>> getMap() {
		return map;
	}


	public void setMap(Map<String, List<JX_Permission>> map) {
		this.map = map;
	}


	public String getCheckstring() {
		return checkstring;
	}


	public void setCheckstring(String checkstring) {
		this.checkstring = checkstring;
	}


	public HttpServletRequest getRequest() {
		return request;
	}


	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}


	public JX_RoleService getJx_RoleService() {
		return jx_RoleService;
	}


	public void setJx_RoleService(JX_RoleService jxRoleService) {
		jx_RoleService = jxRoleService;
	}


	public List<JX_Role> getListjr() {
		return listjr;
	}


	public void setListjr(List<JX_Role> listjr) {
		this.listjr = listjr;
	}


	public JX_Role getJx_Role() {
		return jx_Role;
	}


	public void setJx_Role(JX_Role jxRole) {
		jx_Role = jxRole;
	}
	
	public String[] getPerId() {
		return perId;
	}


	public void setPerId(String[] perId) {
		this.perId = perId;
	}

	public String getRoleIdPer() {
		return roleIdPer;
	}


	public void setRoleIdPer(String roleIdPer) {
		this.roleIdPer = roleIdPer;
	}
	
	public List<JX_Role> getJx_Roles() {
		return jx_Roles;
	}


	public void setJx_Roles(List<JX_Role> jxRoles) {
		jx_Roles = jxRoles;
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
	
	public String getRolePer_id() {
		return rolePer_id;
	}


	public void setRolePer_id(String rolePerId) {
		rolePer_id = rolePerId;
	}
}
