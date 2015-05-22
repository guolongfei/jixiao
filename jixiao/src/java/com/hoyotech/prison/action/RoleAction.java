package com.hoyotech.prison.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.Permission;
import com.hoyotech.prison.bean.Role;
import com.hoyotech.prison.bean.RolePermission;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.RoleService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.ObjectUpdateUtil;
import com.hoyotech.prison.util.PrisonUtil;
import com.isa.pims.basic.ServletRequestUtils;
import com.isa.pims.basic.StringUtils;
import com.opensymphony.xwork2.ActionSupport;

public class RoleAction extends ActionSupport {

	RoleService roleService;
	private List<Role> roles;
	private Map<String,List<Permission>> map;
	private List checks;
	private String[] perId;
	private Role role;
	private int pageNum;
	private int limit; 
	private int totalPage;
	private int totalNum;
	private String id;
	private String checkstring;
	
	private String name;
	private String useState;
	private LogFactory log;
	
	/**
	 * 查询所有角色的信息
	 * **/
	public String select() {
		HttpServletRequest request = ServletActionContext.getRequest();
		pageNum = ServletRequestUtils.getInt(request, "page", "1");
		limit = ServletRequestUtils.getInt(request, "limit", "20");
		String prisonCode=PrisonUtil.getPrisonCode(request);
		roles = roleService.list(name,useState,pageNum, limit,prisonCode);
		totalNum = roleService.count(name,useState,prisonCode);
		totalPage = (totalNum - 1) / limit + 1;
		
		String type=(String)request.getSession().getAttribute("orgType");
		if("2".equals(type)){
			return "stList";
		}else{
			return "List";
		}
		
	}

	/**
	 * 添加一条角色的信息
	 * **/
	public String add() {
		HttpServletRequest request = ServletActionContext.getRequest();
		role.setPrisonCode(PrisonUtil.getPrisonCode(request));
		String organize=StringUtils.$C((String)request.getSession().getAttribute("orgType"),"");
		role.setOrganizeType(organize);
		id = roleService.add(role); // 添加数据得到id
		
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(role, config.getInsert(), operate, config.getRole(), config.getSucceed(), request);
		return "detail";
	}

	/**
	 * 查询一条角色的信息
	 * **/
	public String detail() {
		role = roleService.detail(id);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String type=(String)request.getSession().getAttribute("orgType");
		if("2".equals(type)){
			return "stDetail";
		}else{
			return "Detail";
		}
		
	}

	/**
	 * 删除一条角色的信息
	 * **/
	public String delete() {
		roleService.delete(id);
		
		// 添加日志
		Role object = new Role();
		object.setId(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "删除成功。";
		log.getModifyLogMessage(null, object, config.getDelete(), operate, config.getRole(), config.getSucceed(), request);
		
		return "select";
	}

	/**
	 * 修改一条角色的信息
	 * **/
	public String update() {
		Role obj = roleService.detail(role.getId());
		Role old_obj = roleService.detail(role.getId());
		ObjectUpdateUtil.compareProperty(role, obj);
		roleService.update(obj);
		id = role.getId();
		
		// 添加日志
		
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。";
		log.getModifyLogMessage(obj, old_obj, config.getUpdate(), operate, config.getRole(), config.getSucceed(), request);
		return "detail";
	}

	/**
	 * 进入添加页面
	 * **/
	public String interAdd() {
		//role = roleService.detail(id);
		return "Add";
	}

	
	/**
	 * 进入修改页面
	 * **/
	public String interEdit() {
		role = roleService.detail(id);
		return "Edit";
	}
	
	/**
	 * 进入权限修改页面
	 * **/
	public String permissionEdit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String organize=StringUtils.$C((String)request.getSession().getAttribute("orgType"),"");
		role = roleService.detail(id);
		map=roleService.perList(organize);
		checkstring="";
		for(RolePermission i:role.getRolePer()){
			checkstring=checkstring+i.getPerId().getId()+"," ;
		}
		String type=(String)request.getSession().getAttribute("orgType");
		if("2".equals(type)){
			return "stpermission";
		}else{
			return "permission";
		}
		
	}
	
	/**
	 * 修改权限
	 * **/
	public String updatePer() {
		roleService.updatePer(id,perId);
		
		// 添加日志
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。修改了角色id为"+id+"的权限";
		log.getModifyLogMessage(null, null, config.getUpdate(), operate, config.getRole(), config.getSucceed(), request);
		return "detail";
	}
	
	public LogFactory getLog() {
		return log;
	}

	public void setLog(LogFactory log) {
		this.log = log;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Map<String, List<Permission>> getMap() {
		return map;
	}

	public void setMap(Map<String, List<Permission>> map) {
		this.map = map;
	}

	public List getChecks() {
		return checks;
	}

	public void setChecks(List checks) {
		this.checks = checks;
	}

	public String[] getPerId() {
		return perId;
	}

	public void setPerId(String[] perId) {
		this.perId = perId;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCheckstring() {
		return checkstring;
	}

	public void setCheckstring(String checkstring) {
		this.checkstring = checkstring;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUseState() {
		return useState;
	}

	public void setUseState(String useState) {
		this.useState = useState;
	}
	
	
}

