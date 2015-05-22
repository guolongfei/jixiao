package com.hoyotech.prison.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.Permission;
import com.hoyotech.prison.bean.Role;
import com.hoyotech.prison.bean.RolePermission;
import com.hoyotech.prison.dao.impl.BasicDao;
import com.hoyotech.prison.util.ObjectUpdateUtil;

public class RoleService {

private BasicDao dao;
	
	/**
	 * 检索信息
	 * **/
	public String getCondition(String name,String useState){
		StringBuilder sb = new StringBuilder();
		if(name != null && name.length() > 0){
			sb.append(" and role like '%"+name+"%'");
		}
		if(useState != null && useState.length() > 0){
			sb.append(" and mark=?");
		}
		return sb.toString();
	}
	
	/**
	 * 检索信息所需要的条件
	 * **/
	public List<String> getParaCondition(String name,String useState){
		List<String> list = new ArrayList<String>();
//		if(prisonerNum != null && prisonerNum.length() > 0){
//			list.add(prisonerNum);
//		}
//		if(prisonerName != null && prisonerName.length() > 0){
//			list.add(prisonerName);
//		}
//		if(operator != null && operator.length() > 0){
//			list.add(operator);
//		}
		if(useState != null && useState.length() > 0){
			list.add(useState);
		}
		return list;
	}
	
	
	/**
	 * 查询所有角色信息
	 * **/
	public List<Role> list(String name,String useState,int pageNumber,int pageSize,String prisonCode){
		List<String> param = getParaCondition( name,useState);
		String condition = getCondition(name,useState);
		HttpServletRequest request = ServletActionContext.getRequest();
		String type=(String)request.getSession().getAttribute("orgType");
		String hql="";
		if("2".equals(type)){
			 hql= "from Role where state=1 and organizeType='2'"+condition+" order by updateTime desc";
		}else{
			 hql = "from Role where state=1 and prisonCode="+prisonCode+condition+" order by updateTime desc";
		}
		//String hql = "from Role where state=1 and prisonCode="+prisonCode+condition;
		return (List<Role>)dao.queryByHql(hql, param.toArray(), pageNumber, pageSize);

	}
	
	/**
	 * 查询角色的总数
	 * **/
	public int count(String operator,String examineState,String prisonCode){
		List<String> param = getParaCondition(operator,examineState);
		String condition = getCondition(operator,examineState);
		HttpServletRequest request = ServletActionContext.getRequest();
		String type=(String)request.getSession().getAttribute("orgType");
		String hql="";
		if("2".equals(type)){
			 hql= "select count(*) from Role where state=1 and organizeType='2'"+condition;
		}else{
			hql = "select count(*) from Role where state=1 and prisonCode="+prisonCode+condition;
		}
		//String hql = "select count(*) from Role where state=1 and prisonCode="+prisonCode+condition;
		return dao.getCount(hql, param.toArray());
	}
	
	/**
	 * 添加一条角色信息
	 * **/
	public String add(Role info){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(info);
		info.setAddTime(new Date());
		info.setMark("1");
		info.setUpdateTime(new Date());
		return dao.save(info);
	}
	
	/**
	 * 查询一条角色信息
	 * **/
	public Role detail(String id){
		return (Role)dao.detail(Role.class, id);
	}
	
	/**
	 * 删除一条角色信息
	 * **/
	public void delete(String id){
		String hql = "update Role set state=0 where id=?";
		dao.executeHql(hql, new Object[]{id});
	}
	
	/**
	 * 修改一条角色信息
	 * **/
	public void update(Role info){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(info);
		info.setUpdateTime(new Date());
		dao.update(info);
	}
	
	/**
	 * 查询所有权限信息
	 * **/
	public Map<String,List<Permission>> perList(String type){
		String hql = "from Permission where organizeType=? order by moduleId asc";
	 List<Permission> list=(List<Permission>)dao.queryByHql(hql, new Object[]{type});
	 Map<String, List<Permission>> map = new HashMap<String, List<Permission>>();
	 List<Permission> permissionList=null;
	 for(Permission per:list){
		 if(!map.containsKey(per.getModuleName())){
			 permissionList=new ArrayList<Permission>();
			 map.put(per.getModuleName(), permissionList);
		 }
		 permissionList.add(per);
	 }
	 return map;
	}
	
	/**
	 * 修改角色的权限
	 * **/
	public void updatePer(String id,String[] pers){
		String hql = "delete from RolePermission where roleId=?";
		dao.executeHql(hql, new Object[]{id});
		RolePermission permission=new RolePermission();
		if(pers!=null){
			for(int i=0;i<pers.length;i++){
				permission.setRoleId(id);
				Permission per = new Permission();
				per.setId(Integer.parseInt(pers[i]));
				permission.setPerId(per);
				dao.save(permission);
			}
		}
	}
	
	public BasicDao getDao() {
		return dao;
	}

	public void setDao(BasicDao dao) {
		this.dao = dao;
	}
	
}
