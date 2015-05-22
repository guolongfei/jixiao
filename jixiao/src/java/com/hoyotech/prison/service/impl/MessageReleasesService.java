package com.hoyotech.prison.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.hoyotech.prison.bean.Arraign;
import com.hoyotech.prison.bean.AttachedFile;
import com.hoyotech.prison.bean.BasicSetUp;
import com.hoyotech.prison.bean.JX_Appraise;
import com.hoyotech.prison.bean.MessageReleases;
import com.hoyotech.prison.bean.MessageType;
import com.hoyotech.prison.bean.RuleType;
import com.hoyotech.prison.dao.impl.BasicDao;

public class MessageReleasesService {

	private BasicDao dao;
	public BasicDao getDao() {
		return dao;
	}
	public void setDao(BasicDao dao) {
		this.dao = dao;
	}
	@SuppressWarnings("unchecked")
	public List<MessageReleases> getMessageList(String messageType, String pageNum) {
		// TODO Auto-generated method stub
		if(pageNum.equals("")||pageNum==null)
		{
			pageNum=1+"";
		}
		List<String> param=new ArrayList<String>();
		param.add(pageNum);
		List<MessageReleases> list=new ArrayList<MessageReleases>();
		String hql="from MessageReleases where messageType.type_id="+messageType+"order by add_time desc";
        list = (List<MessageReleases>)dao.queryByHql(hql,new Object[] {},Integer.parseInt(pageNum),10);
		//list=(List<MessageReleases>) dao.queryByHql("from MessageReleases", null);
		return list;
	}

	public List<JX_Appraise> getAppraise(String pageNum){
		if(pageNum.equals("")||pageNum==null)
		{
			pageNum=1+"";
		}
		List<String> param=new ArrayList<String>();
		param.add(pageNum);
		List<JX_Appraise> list = new ArrayList<JX_Appraise>();
		String hql = "from JX_Appraise order by appraise_time desc";
		list = (List<JX_Appraise>) dao.queryByHql(hql,new Object[] {},Integer.parseInt(pageNum),10);
		return list;
	}
	//获取实绩评价信息数量
	public int getAppraiseNum(){
		List<JX_Appraise> list = new ArrayList<JX_Appraise>();
		String hql = "from JX_Appraise";
		list= (List<JX_Appraise>) dao.queryByHql(hql, null);
		return list.size();
	}
	public MessageReleases detail(String id) {
		// TODO Auto-generated method stub
//		System.out.println(id);
		return (MessageReleases) dao.detail(MessageReleases.class, id);
//		return (MessageReleases) dao.queryByHqlReturnUnique("from MessageReleases where id=", new Object[]{id});
	}
	//发表评价
	public void addAppraise(Object obj){
		dao.save(obj);
	}
	@SuppressWarnings("unchecked")
	public List<JX_Appraise> appraiseList(String id){
		String hql = "from JX_Appraise where messageReleasesId='"+id+"' order by appraise_time desc";
		return (List<JX_Appraise>) dao.queryByHql(hql, null);
	}
	//
	//获取消息数据数量
	public int getTotalList(String messageType) {
		// TODO Auto-generated method stub
		List<MessageReleases> list=new ArrayList<MessageReleases>();
		String hql="from MessageReleases where messageType.type_id="+messageType;
        list = (List<MessageReleases>)dao.queryByHql(hql,null);
        return list.size();
	}
	public String getTypeName(String messageType) {
		// TODO Auto-generated method stub
		List<MessageType> list=new ArrayList<MessageType>();
		String hql="from MessageType where type_id="+messageType;
        list = (List<MessageType>)dao.queryByHql(hql,null);
        return list.get(0).getType_name();
	}
	
	/*
	 * 刘泉  2015.01.20
	 * 信息发布后台 查询信息列表
	 * */
	public List<Object[]> bs_getMessageList(int pagenum){
		// TODO Auto-generated method stub
		List<Object[]> list=new ArrayList<Object[]>();
		String hql="select m.id,m.title,m.messageType.type_name,m.add_time,ju.jx_people.name,jd.name from MessageReleases m,JX_User ju,JX_Department jd where m.user_id=ju.id and m.add_dept_id=jd.id order by m.add_time desc";
		return (List<Object[]>)dao.queryByHql(hql, new Object[] {}, pagenum, 10);
	}

	
	//根据标题模糊查询政策消息
	public int getTotalZhengceList(String messageType, String title, int ruleType) {
		// TODO Auto-generated method stub
		List<MessageReleases> list=new ArrayList<MessageReleases>();
		String hql;
		if(ruleType==0)
		{
		    hql="from MessageReleases where messageType.type_id="+messageType+"and title like '%"+title+"%'"+"order by add_time desc";
		}
		else
		{
		    hql="from MessageReleases where messageType.type_id="+messageType+"and title like '%"+title+"%'"+" and rule_type="+ruleType+" order by add_time desc";
		}
        list = (List<MessageReleases>)dao.queryByHql(hql,null);
        return list.size();
	}
	
	//政策管理带分页的模糊查询
	public List<MessageReleases> getZhengceList(String messageType,
			String pageNum, String title, int ruleType) {
		if(pageNum.equals("")||pageNum==null)
		{
			pageNum=1+"";
		}
		List<String> param=new ArrayList<String>();
		param.add(title);
		List<MessageReleases> list=new ArrayList<MessageReleases>();
		String hql;
		if(ruleType==0)
		{
		    hql="from MessageReleases where messageType.type_id="+messageType+"and title like '%"+title+"%'"+"order by add_time desc";
		}
		else
		{
		    hql="from MessageReleases where messageType.type_id="+messageType+"and title like '%"+title+"%'"+" and rule_type="+ruleType+" order by add_time desc";
		}
        list = (List<MessageReleases>)dao.queryByHql(hql,new Object[] {},Integer.parseInt(pageNum),10);
		//list=(List<MessageReleases>) dao.queryByHql("from MessageReleases", null);
		return list;
	}

	
	/*
	 * 刘泉2015.01.22
	 * 获取发布文件总数
	 * */
	public int bs_getTotalMessageSize(){
		// TODO Auto-generated method stub
		List<MessageReleases> list=new ArrayList<MessageReleases>();
		String hql="select m.id,m.title,m.messageType.type_name,m.add_time,ju.jx_people.name,jd.name from MessageReleases m,JX_User ju,JX_Department jd where m.user_id=ju.id and m.add_dept_id=jd.id";
        list = (List<MessageReleases>)dao.queryByHql(hql,new Object[] {});
        return list.size();
	}
	
	/*
	 * 刘泉2015.01.20
	 * 信息类型
	 * */
	public List<MessageType> bs_getMessageType(){
		// TODO Auto-generated method stub
		return (List<MessageType>)dao.queryByHql("from MessageType order by type_name", new Object[] {});
	}
	
	/*
	 * 刘泉2015.01.20
	 * 保存发布信息
	 * */
	public String bs_SaveAdd(MessageReleases obj){
		return dao.save(obj);
	}
	
	//查询政策法规下所有分类
	public List<RuleType> getAllRule() {
		// TODO Auto-generated method stub
		List<RuleType> list=new ArrayList<RuleType>();
		String hql="from RuleType";
        list = (List<RuleType>)dao.queryByHql(hql,new Object[] {});
        return list;
	}
	
	//保存附件
	public void saveFile(AttachedFile af) {
		// TODO Auto-generated method stub
		dao.save(af);
	}
	
	//获取基础信息列表
	@SuppressWarnings("unchecked")
	public List<BasicSetUp> getBasicList(){
		String hql = "from BasicSetUp";
		List<BasicSetUp> list = (List<BasicSetUp>)dao.queryByHql(hql, new Object[]{});
		return list;
	}
	
	//基础信息保存
	public void basicSetUp(BasicSetUp bs){
		dao.save(bs);
	}

	public void updateType(String titleName, String messageType) {
		// TODO Auto-generated method stub
		MessageType mp=(MessageType)dao.queryByHql("from MessageType where type_id="+messageType+"", new Object[] {}).get(0);
		mp.setType_name(titleName);
		dao.getHibernateTemplate().update(mp);
	}
	public List<AttachedFile> getTypeById(String id) {
		// TODO Auto-generated method stub
		List<AttachedFile> list=new ArrayList<AttachedFile>();
		list=(List<AttachedFile>)dao.queryByHql("from AttachedFile where file_id='"+id+"'", new Object[] {});		
		return list;
	}
	

	
	//基础信息删除
	public void deleteBasicSetUp(String bsId){
		String hql = "delete from BasicSetUp bs where bs.id = '"+bsId+"'";
		this.dao.executeHql(hql, new Object[]{});	
	}
	
	//删除新闻
	public void deleteMes(String id) {
		// TODO Auto-generated method stub
		String hql = "delete from MessageReleases ms where ms.id = '"+id+"'";
		this.dao.executeHql(hql, new Object[]{});
	}


}
