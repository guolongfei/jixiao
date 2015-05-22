package com.hoyotech.prison.service.impl;

import java.util.List;

import com.hoyotech.prison.bean.JX_Department;
import com.hoyotech.prison.bean.JX_People;
import com.hoyotech.prison.bean.JX_Role;
import com.hoyotech.prison.bean.JX_User;
import com.hoyotech.prison.bean.JX_UserRole;
import com.hoyotech.prison.bean.PostTable;
import com.hoyotech.prison.dao.impl.BasicDao;

public class JX_UserService {
	
	private BasicDao dao;	
	public BasicDao getDao() {
		return dao;
	}
	public void setDao(BasicDao dao) {
		this.dao = dao;
	}
	
	
	/*
	 * 刘泉2015.01.27
	 * 查询本部门和下级部门
	 * */
	public List<JX_Department> getDepts(String dept_id){
		String hql="from JX_Department where id='"+dept_id+"' or pid='"+dept_id+"'";
		return (List<JX_Department>)dao.queryByHql(hql, new Object[]{});
	}
	
	/*
	 * 刘泉2015.01.27
	 * 查询所有职务
	 * */
	public List<PostTable> getPosts(){		
		return (List<PostTable>)dao.queryByHql("from PostTable", new Object[]{});
	}
	
	/*
	 * 刘泉2015.01.27
	 * 保存人员信息
	 * */
	public String bs_SaveAddPeo(JX_People obj){
		return dao.save(obj);
	}
	
	/*
	 * 判断用户名是否存在
	 */
	public JX_User queryUser(String userName){
		String hql = "from JX_User where username='"+userName+"'";
		JX_User user = (JX_User) dao.queryByHqlReturnUnique(hql,new Object[]{});
		return user ;
	}
	
	/*
	 * 刘泉2015.01.20
	 * 保存用户信息
	 * */
	public String bs_SaveAdd(JX_User obj){
		return dao.save(obj);
	}
	
	/*
	 * 刘泉2015.03.24
	 * 保存修改用户信息
	 * */
	public String  bs_SaveUpdate(JX_User ouser,JX_People opeople){
		JX_User nuser = new JX_User();
		JX_People npeople = new JX_People();			
		nuser=(JX_User)dao.detail(JX_User.class, ouser.getId());
		nuser.setState(ouser.getState());
		dao.update(nuser);
		npeople=(JX_People)dao.detail(JX_People.class, nuser.getJx_people().getId());
		npeople.setName(opeople.getName());
		//npeople.getJx_department().setId(opeople.getJx_department().getId());
		npeople.getPosttable().setPostId(opeople.getPosttable().getPostId());
		dao.update(npeople);
		return 	"1"; 	
	}
	
	/**
	 * 查询一条用户信息
	 * **/
	public JX_User detail(String id){
		return (JX_User)dao.detail(JX_User.class, id);
	}
	
	public JX_People peodetail(String id){
		return (JX_People) dao.detail(JX_People.class, id);
	}
	
	/**
	 * 查询所有角色信息
	 * **/
	public List<JX_Role> jx_roleList(String deptId){			
		String hql = "from JX_Role where department_id=?";				
		return (List<JX_Role>)dao.queryByHql(hql, new Object[]{deptId});
	}
	
	/**     
	 * 修改角色的权限
	 * **/
	public void updateRole(String id,String[] ids){
		String hql = "delete from JX_UserRole where user_Id=?";
		dao.executeHql(hql, new Object[]{id});
		JX_UserRole userRole=new JX_UserRole();
		if(ids!=null){ 
			for(int i=0;i<ids.length;i++){
				userRole.setUser_Id(id);
				JX_Role role=new JX_Role();
				role.setId(ids[i]);
				userRole.setJx_role(role);
				dao.save(userRole);
			}
		}
	}
	
	/*
	 * 查询用户列表
	 * */
	public List<JX_User> getJX_UserList(String dept_id,int pagenum,int limit){		
		return (List<JX_User>)dao.queryByHql("from JX_User where jx_people.jx_department=?", new Object[]{dept_id}, pagenum, limit);
	}
	
	/*
	 * 查询用户列表总数
	 * */
	public int getJX_UserListNum(String dept_id){		
		return dao.getCount("select count(*) from JX_User where jx_people.jx_department=?", new Object[]{dept_id});
	}
	
	/*
	 * 查询下级部门
	 * */
	public List<JX_Department> getXJdept(String dept_id){
		return (List<JX_Department>)dao.queryByHql("from JX_Department where pid=?", new Object[]{dept_id});
	}
	
	/*
	 * 刘泉
	 * 删除用户信息
	 * */
	public void bs_deleteUser(String userId,String peopleId){		
		String hql1="delete from JX_User where id=?";
		dao.executeHql(hql1, new Object[]{userId});
		String hql="delete from JX_People where id=?";
		dao.executeHql(hql, new Object[]{peopleId});
	}

}
