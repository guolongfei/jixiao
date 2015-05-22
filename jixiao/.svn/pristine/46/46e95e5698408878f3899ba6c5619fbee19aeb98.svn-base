package com.hoyotech.prison.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hoyotech.prison.bean.JX_Permission;
import com.hoyotech.prison.bean.JX_Role;
import com.hoyotech.prison.bean.JX_RolePermission;
import com.hoyotech.prison.bean.JX_User;
import com.hoyotech.prison.bean.Permission;
import com.hoyotech.prison.bean.Role;
import com.hoyotech.prison.bean.RolePermission;
import com.hoyotech.prison.dao.impl.BasicDao;

public class JX_RoleService {
	
	private BasicDao dao;	
	public BasicDao getDao() {
		return dao;
	}
	public void setDao(BasicDao dao) {
		this.dao = dao;
	}
	
	/*
	 * 刘泉2015.01.27
	 * 保存人员信息
	 * */
	public String bs_SaveAddRole(JX_Role obj){
		return dao.save(obj);
	}
	
//	/**
//	 * 查询所有权限信息
//	 * **/
//	public Map<String,List<Permission>> perList(String type){
//		String hql = "from Permission where organizeType=? order by moduleId asc";
//	 List<Permission> list=(List<Permission>)dao.queryByHql(hql, new Object[]{type});
//	 Map<String, List<Permission>> map = new HashMap<String, List<Permission>>();
//	 List<Permission> permissionList=null;
//	 for(Permission per:list){
//		 if(!map.containsKey(per.getModuleName())){
//			 permissionList=new ArrayList<Permission>();
//			 map.put(per.getModuleName(), permissionList);
//		 }
//		 permissionList.add(per);
//	 }
//	 return map;
//	}
	
	/*
	 * 刘泉2015.01.28
	 * 查询所有权限信息
	 * */
	public Map<String,List<JX_Permission>> getPerList(){
		String hql = "from JX_Permission where 1=1 order by moduleId asc";
		List<JX_Permission> list=(List<JX_Permission>)dao.queryByHql(hql, new Object[]{});
		Map<String, List<JX_Permission>> map = new HashMap<String, List<JX_Permission>>();
		List<JX_Permission> permissionList=null; 
		for(JX_Permission per:list){
			 if(!map.containsKey(per.getModuleName())){
				 permissionList=new ArrayList<JX_Permission>();
				 map.put(per.getModuleName(), permissionList);
			 }
			 permissionList.add(per);
		 }
		 return map;
	}
	
//	/**
//	 * 修改角色的权限
//	 * **/
//	public void updatePer(String id,String[] pers){
//		String hql = "delete from RolePermission where roleId=?";
//		dao.executeHql(hql, new Object[]{id});
//		RolePermission permission=new RolePermission();
//		if(pers!=null){
//			for(int i=0;i<pers.length;i++){
//				permission.setRoleId(id);
//				Permission per = new Permission();
//				per.setId(Integer.parseInt(pers[i]));
//				permission.setPerId(per);
//				dao.save(permission);
//			}
//		}
//	}
	
	/*
	 * 刘泉2015.01.29
	 * 更新角色权限
	 * */
	public void updatePer(String id,String[] pers){
		String hql = "delete from JX_RolePermission where role_Id=?";
		dao.executeHql(hql, new Object[]{id});
		JX_RolePermission permission=new JX_RolePermission();
		if(pers!=null){
			for(int i=0;i<pers.length;i++){
				permission.setRole_Id(id);
				JX_Permission per = new JX_Permission();
				per.setId(Integer.parseInt(pers[i]));
				permission.setJx_permission(per);
				dao.save(permission);
			}
		}
	}
	
	/*
	 * 刘泉2015.01.29
	 * 获取角色信息
	 * */
	public JX_Role getRoleDetail(String id){
		return (JX_Role)dao.detail(JX_Role.class, id);
	}
	
	/*
	 * 刘泉2015.03.25
	 * 获取角色列表
	 * */
	public List<JX_Role> getJX_RoleList(String dept_id,int pagenum,int limit){
		String hql = "from JX_Role where department_id=?";				
		return (List<JX_Role>)dao.queryByHql(hql, new Object[]{dept_id}, pagenum, limit);		
	}
	
	/*
	 * 刘泉2015.03.26
	 * 获取角色总数
	 * */
	public int getJX_RoleListNum(String dept_id){
		String hql = "select count(*) from JX_Role where department_id=?";
		return dao.getCount(hql, new Object[]{dept_id});
	}
	
	
//	/**
//	 * 修改角色的权限
//	 * **/
//	public void updatePer(String id,String[] pers){
//		String hql = "delete from RolePermission where roleId=?";
//		dao.executeHql(hql, new Object[]{id});
//		RolePermission permission=new RolePermission();
//		if(pers!=null){
//			for(int i=0;i<pers.length;i++){
//				permission.setRoleId(id);
//				Permission per = new Permission();
//				per.setId(Integer.parseInt(pers[i]));
//				permission.setPerId(per);
//				dao.save(permission);
//			}
//		}
//	}
	
}
