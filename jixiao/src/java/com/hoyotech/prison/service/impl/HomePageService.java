package com.hoyotech.prison.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.hoyotech.prison.bean.JX_Appraise;
import com.hoyotech.prison.bean.JX_Department;
import com.hoyotech.prison.bean.JX_User;
import com.hoyotech.prison.bean.MessageReleases;
import com.hoyotech.prison.bean.MessageType;
import com.hoyotech.prison.dao.impl.BasicDao;


public class HomePageService {
	private BasicDao dao;

	@SuppressWarnings("unchecked")
	public List<MessageType> navTopList(){
		String hql = "from MessageType mt";
		return (List<MessageType>) dao.queryByHql(hql, new Object[]{});
	}
	
	//查询通知公告信息
	@SuppressWarnings("unchecked")
	public List<MessageReleases> getList(){
		String hql = "from MessageReleases where messageType.type_id=1 order by id desc";
		return (List<MessageReleases>) dao.queryByHql(hql, new Object[]{},1,7);		
	}
	//查询图片新闻
	@SuppressWarnings("unchecked")
	public List<MessageReleases> getImagesList(){
		String hql = "from MessageReleases where messageType.type_id=2 order by id desc";
		return (List<MessageReleases>) dao.queryByHql(hql, new Object[]{},1,5);	
	}
	//查询综合动态
	public List<MessageReleases> getSyntheSizeList(){
		String hql = "from MessageReleases where messageType.type_id=12 order by id desc";
		return (List<MessageReleases>) dao.queryByHql(hql, new Object[]{},1,8);
	}
	//查询市直动态
	public List<MessageReleases> getDynamicList(){
		String hql = "from MessageReleases where messageType.type_id=3 order by id desc";
		return (List<MessageReleases>) dao.queryByHql(hql, new Object[]{},1,8);		
	}
	//查询区街动态
	public List<MessageReleases> getBlockList(){
		String hql = "from MessageReleases where messageType.type_id=11 order by id desc";
		return (List<MessageReleases>) dao.queryByHql(hql, new Object[]{},1,8);		
	}
	//查询最新实绩
	public List<MessageReleases> getPolicyList(){
		String hql = "from MessageReleases where messageType.type_id=4 order by id desc";
		return (List<MessageReleases>) dao.queryByHql(hql, new Object[]{},1,8);		
	}
	//查询政策法规
	public List<MessageReleases> getCounterList(){
		String hql = "from MessageReleases where messageType.type_id=5 order by id desc";
		return (List<MessageReleases>) dao.queryByHql(hql, new Object[]{},1,6);		
	}
	//查询表格下载
	public List<MessageReleases> getSpeechList(){
		String hql = "from MessageReleases where messageType.type_id=6 order by id desc";
		return (List<MessageReleases>) dao.queryByHql(hql, new Object[]{},1,6);		
	}
	//查询他山之石
	public List<MessageReleases> getStoryList(){
		String hql = "from MessageReleases where messageType.type_id=7 order by id desc";
		return (List<MessageReleases>) dao.queryByHql(hql, new Object[]{},1,6);		
	}
	//查询领导言论
	public List<MessageReleases> getProbeList(){
		String hql = "from MessageReleases where messageType.type_id=8 order by id desc";
		return (List<MessageReleases>) dao.queryByHql(hql, new Object[]{},1,6);		
	}
	//查询经验交流
	public List<MessageReleases> getInterflowList(){
		String hql = "from MessageReleases where messageType.type_id=9 order by id desc";
		return (List<MessageReleases>) dao.queryByHql(hql, new Object[]{},1,6);		
	}
	//查询理论探索
	public List<MessageReleases> getReportList(){
		String hql = "from MessageReleases where messageType.type_id=10 order by id desc";
		return (List<MessageReleases>) dao.queryByHql(hql, new Object[]{},1,6);		
	}
	//查询部门类别
	public List<JX_Department> getSortList(){
		String hql = "from JX_Department where level=1";
		List<JX_Department> list = (List<JX_Department>) dao.queryByHql(hql, new Object[]{});
		return list;
	}
	//查询部门信息
	@SuppressWarnings("unchecked")
	public List<Object[]> getDepartmentList(){
		String hql = "from JX_Department where level=1";
		List<JX_Department> list = (List<JX_Department>) dao.queryByHql(hql, new Object[]{});
		List<JX_Department> list1 = null;
		List<Object[]> list2 = new ArrayList<Object[]>();	
		for(int i=0;i<list.size();i++){
				String hql1 = "from JX_Department where pid='"+list.get(i).getId()+"'";
				list2.addAll((Collection<? extends Object[]>) dao.queryByHql(hql1, new Object[]{}));			
		}
		return list2;
	}
	//查询实绩通报
	public List<MessageReleases> getTongbaoList(){
		String hql = "from MessageReleases where messageType.type_id=13 order by id desc";
		return (List<MessageReleases>) dao.queryByHql(hql, new Object[]{},1,8);	
	}
	//查询实绩评价
	@SuppressWarnings("unchecked")
	public List<JX_Appraise> getAppraiseList(){
		String hql = "from JX_Appraise order by id desc";
		return (List<JX_Appraise>) dao.queryByHql(hql, new Object[]{},1,5);	
	}
	
	//查询用户输入的账号是否存在
	public JX_User getLogin(String userName){
		String hql = "from JX_User where username='"+userName+"'";
		JX_User user = (JX_User) dao.queryByHqlReturnUnique(hql,new Object[]{});
		return user ;
	}
	//查询密码是否正确
	public JX_User getPassword(String id,String password){
		String hql = "from JX_User where password='"+password+"' and id='"+id+"'";
		JX_User user = (JX_User) dao.queryByHqlReturnUnique(hql,new Object[]{});
		return user;
	}
	//用户登录，修改登录状态
	public void updateState(String id){
		String hql ="update JX_User set online_state=1 where id='"+id+"'";
		dao.executeHql(hql,new Object[]{});
	}
	//查询当前使用实绩考核系统在线人数
	@SuppressWarnings("unchecked")
	public List<JX_User> getUserNumber(){
		String hql = "from JX_User where online_state=1";
		return (List<JX_User>)dao.queryByHql(hql,new Object[]{});
	}
	//用户退出登录
	public void loginOut(String id){
		String hql ="update JX_User set online_state=0 where id='"+id+"'";
		dao.executeHql(hql,new Object[]{});	
	}
	//判断用户输入的密码是否正确
	@SuppressWarnings("unchecked")
	public JX_User getPsd(String id,String password){
		String hql = "from JX_User where password='"+password+"' and id='"+id+"'";
		return (JX_User) dao.queryByHqlReturnUnique(hql,new Object[]{});
	}
	//用户修改密码
	public void updatePad(String id,String password){
		String hql="update JX_User set password='"+password+"' where id='"+id+"'";
		dao.executeHql(hql, new Object[]{});
	}
	//群众发表评价
	public void add_Appraise(Object obj){	
		dao.save(obj);
	}
			
	public void setDao(BasicDao dao) {
		this.dao = dao;
	}

	public BasicDao getDao() {
		return dao;
	}
}
