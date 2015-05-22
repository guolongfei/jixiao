package com.hoyotech.prison.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.Role;
import com.hoyotech.prison.bean.User;
import com.hoyotech.prison.bean.Police;
import com.hoyotech.prison.bean.UserRole;
import com.hoyotech.prison.bean.PrisonInfo;
import com.hoyotech.prison.bean.UserPowerZD;
import com.hoyotech.prison.dao.impl.BasicDao;
import com.hoyotech.prison.util.ObjectUpdateUtil;

public class UserService {

private BasicDao dao;
	
	/**
	 * 检索信息
	 * **/
	public String getCondition(String zuzhi,String zhanghao,String name,String useState){
		StringBuilder sb = new StringBuilder();
		if(zuzhi != null && zuzhi.length() > 0){
			sb.append(" and orgid like '%"+zuzhi+"%'");
		}
		if(zhanghao != null && zhanghao.length() > 0){
			sb.append(" and username like '%"+zhanghao+"%'");
		}
		if(name != null && name.length() > 0){
			sb.append(" and name.name like '%"+name+"%'");
		}
		if(useState != null && useState.length() > 0){
			sb.append(" and mark=?");
		}
		return sb.toString();
	}
	
	/**
	 * 检索信息所需要的条件
	 * **/
	public List<String> getParaCondition(String zuzhi,String zhanghao,String name,String useState){
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
	 * 查询所有用户信息
	 * **/
	public List<User> list(String zuzhi,String zhanghao,String name,String useState,int pageNumber,int pageSize,String prisonCode){
		List<String> param = getParaCondition(zuzhi, zhanghao, name,useState);
		String condition = getCondition(zuzhi, zhanghao, name,useState);
		HttpServletRequest request = ServletActionContext.getRequest();
		String type=(String)request.getSession().getAttribute("orgType");
		String hql="";
		if("2".equals(type)){
			 hql= "from User where state=1 and organizeType='2'"+condition+" order by updateTime desc";
		}else{
			 hql = "from User where state=1 and prisonCode="+prisonCode+condition+" order by updateTime desc";
		}
		return (List<User>)dao.queryByHql(hql, param.toArray(), pageNumber, pageSize);

	}
	
	/**
	 * 查询所有支队用户信息
	 * **/
	public List<User> listZD(String zuzhi,String zhanghao,String name,String useState,int pageNumber,int pageSize,String prisonCode){
		List<String> param = getParaCondition(zuzhi, zhanghao, name,useState);
		String condition = getCondition(zuzhi, zhanghao, name,useState);
		HttpServletRequest request = ServletActionContext.getRequest();	
		String hql="";
	    hql= "from User where state=1 and organizeType='3'"+condition+" order by updateTime desc";
		return (List<User>)dao.queryByHql(hql, param.toArray(), pageNumber, pageSize);
	}
	
	/**
	 * 查询用户的总数
	 * **/
	public int count(String prisonerNum,String prisonerName,String operator,String examineState,String prisonCode){
		List<String> param = getParaCondition(prisonerNum,prisonerName,operator,examineState);
		String condition = getCondition(prisonerNum,prisonerName,operator,examineState);
		HttpServletRequest request = ServletActionContext.getRequest();
		String type=(String)request.getSession().getAttribute("orgType");
		String hql="";
		if("2".equals(type)){
			 hql= "select count(*) from User where state=1 and organizeType='2'"+condition;
		}else{
			hql = "select count(*) from User where state=1 and prisonCode="+prisonCode+condition;
		}
		return dao.getCount(hql, param.toArray());
	}
	
	/**
	 * 添加一条用户信息
	 * **/
	public String add(User info){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(info);
//		SysUsers system=new SysUsers();
//		system.setAddress(StringUtils.$C(info.getAddress(),""));
//		system.setAddTime(new Date());
//		system.setDegree(info.getDegree()!=null?info.getDegree().getDescription():"");
//		system.setEmail(StringUtils.$C(info.getEmail(),""));
//		system.setMark("1");
//		system.setMobile1(StringUtils.$C(info.getMobile1(),""));
//		system.setMobile2(StringUtils.$C(info.getMobile2(),""));
//		system.setMsn(StringUtils.$C(info.getMsn(),""));
//		system.setName(StringUtils.$C(info.getName(),""));
//		system.setPassWord(StringUtils.$C(info.getPassword(),""));
//		system.setPhone(StringUtils.$C(info.getPhone(),""));
//		system.setPolity(info.getPolity()!=null?info.getPolity().getDescription():"");
//		system.setPrisonCode(StringUtils.$C(info.getPrisonCode(),""));
//		system.setQq(StringUtils.$C(info.getQq(),""));
//		system.setUpdateTime(new Date());
//		system.setUserBirthday(info.getUserBirthday()!=null?info.getUserBirthday():null);
//		system.setUserName(StringUtils.$C(info.getUsername(),""));
//		system.setUserSex(info.getUsersex()!=null?info.getUsersex().getDescription():"");
//		system.setUserZC(StringUtils.$C(info.getUserZc(),""));
//		system.setUserZW(StringUtils.$C(info.getUserZw(),""));
//		system.setZipCode(StringUtils.$C(info.getZipCode(),""));
//		dao.save(system);
		
		info.setAddTime(new Date());
		info.setMark("1");
		info.setUpdateTime(new Date());
		return dao.save(info);
	}
	
	/*
	 * 添加一条支队的权限存储信息
	 * */
	public void addPowerZD(UserPowerZD upzd){
		dao.save(upzd);
	}
	
	/*
	 * 更新一条支队查阅拘留所权限信息
	 * */
	public void updatePowerZD(UserPowerZD upzd){
		dao.executeHql("update UserPowerZD set powerZD=? where userId=?", new Object[]{upzd.getPowerZD(),upzd.getUserId()});
	}
	
	/*
	 * 为支队账户配置超管role
	 * */
	public void addRolePowerZD(UserRole ur){
		String sd=dao.save(ur);
		dao.executeHql("update UserRole set roleId='7' where id=?", new Object[]{sd});
	}
	
	/**
	 * 查询一条用户信息
	 * **/
	public User detail(String id){
		return (User)dao.detail(User.class, id);
	}
	
	/**
	 * 查询一条警员信息（支队用户名）
	 * **/
	public Police detailZD(String id){
		return (Police)dao.detail(Police.class, id);
	}
	
	/**
	 * 删除一条用户信息
	 * **/
	public void delete(String id){
		String hql = "update User set state=0 where id=?";
		dao.executeHql(hql, new Object[]{id});
	}
	
	/**
	 * 修改一条用户信息
	 * **/
	public void update(User info){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(info);
		info.setUpdateTime(new Date());
		dao.update(info);
	}
	
	/*
	 * 修改一条警员信息（支队名称）
	 * */
	public void updateZD(String strid,String strname,User info1){
		//解决外键为空的异常
		Police info=(Police)dao.detail(Police.class, strid);
		info.setName(strname);
		info.setUpdateTime(new Date());
		dao.update(info);
		ObjectUpdateUtil.checkProperty(info1);
		dao.update(info1);
	}
	
	/*
	 * 查询所有正在使用的拘留所的信息
	 * */
	public List getUsingPrisonInfo(){
		String hql="select id,prisonCode,prisonName from PrisonInfo where STATE='1'";
		return (List)dao.queryByHql(hql, new Object[]{});
	}
	
	/*
	 * 查询一个支队账户的权限
	 * */
	public String getUserPowerStr(String idd){
		return (String)dao.executeHql("select powerZD from UserPowerZD where userId=?", new Object[]{idd});
	}
	
	/*
	 * 保存支队权限能够查阅的拘留所信息
	 * */
	
	/**
	 * 查询所有角色信息
	 * **/
	public List<Role> roleList(String type,String prisonCode){
		HttpServletRequest request = ServletActionContext.getRequest();
		String orgType=(String)request.getSession().getAttribute("orgType");
		String hql="";
		if("2".equals(orgType)){
			 hql= "from Role where state=1 and organizeType='2'";
		}else{
			hql = "from Role where organizeType='1' and prisonCode="+prisonCode;
		}
		return (List<Role>)dao.queryByHql(hql, new Object[]{});
	}
	
	/**     
	 * 修改角色的权限
	 * **/
	public void updateRole(String id,String[] ids){
		String hql = "delete from UserRole where userId=?";
		dao.executeHql(hql, new Object[]{id});
		UserRole userRole=new UserRole();
		if(ids!=null){ 
			for(int i=0;i<ids.length;i++){
				userRole.setUserId(id);
				Role role=new Role();
				role.setId(ids[i]);
				userRole.setRoleId(role);
				dao.save(userRole);
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
