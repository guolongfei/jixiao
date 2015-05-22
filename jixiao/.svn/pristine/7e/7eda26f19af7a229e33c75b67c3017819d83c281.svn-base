package com.hoyotech.prison.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hoyotech.prison.bean.DetentionArea;
import com.hoyotech.prison.bean.DetentionInfo;
import com.hoyotech.prison.bean.UserDetention;
import com.hoyotech.prison.dao.impl.BasicDao;

public class UserDetentionService {
	private BasicDao dao;
	
	/**
	 * 添加
	 * @param obj
	 * @return
	 */
	public String add(UserDetention obj){
		obj.setAddTime(new Date());
		return dao.save(obj);
	}
	
	/**
	 * 获取该用户可监测的拘留室的列表
	 * @param UserId
	 * @return
	 */
	public String getSelectedList(String UserId){
		//return (List<UserDetention>)dao.queryByHql("from UserDetention where user.id=?", new Object[]{UserId});
		List<String> list = (List<String>) dao.queryByHql("select detention.id from UserDetention where user.id=?", new Object[]{UserId});
		String array = "";
		for(String str : list){
			array += str+",";
		}
		return array;
	}
	
	/**
	 * 获取该拘留所所有拘留区域和拘室
	 * @param prisonId
	 * @param prisonCode
	 * @return
	 */
	public List<DetentionArea> getDetentionList(String prisonId){
		String condition = "";
		List<String> paras = new ArrayList<String>();
		if(prisonId !=null && !"".equals(prisonId)){
			condition += " and prisonInfo.id=?";
			paras.add(prisonId);
		}
		String hql = "from DetentionInfo where state=1"+condition+" order by detentionArea.id";
		List<DetentionInfo> list = (List<DetentionInfo>)dao.queryByHql(hql, paras.toArray());
		
		List<DetentionArea> areaList = new ArrayList<DetentionArea>(); 
		int i = 0;
		DetentionArea area = null;
		for(DetentionInfo obj : list){
			if(i == 0){
				area = obj.getDetentionArea();
				area.getDetentionInfoList().add(obj);
				areaList.add(area);
			}else if(area.equals(obj.getDetentionArea())){
				area.getDetentionInfoList().add(obj);
			}else{
				area = obj.getDetentionArea();
				area.getDetentionInfoList().add(obj);
				areaList.add(area);
			}
			i++;
			obj.setDetentionArea(null);
		}
		return areaList;
	}
	
	/**
	 * 删除此用户的所有权限
	 * @param userId
	 */
	public void delete(String userId){
		String hql = "delete from UserDetention where user.id=?";
		dao.executeHql(hql, new Object[]{userId});
	}
	
	/**
	 * 获取该用户可检测的拘室和对应的区域
	 * @param userId
	 * @return
	 */
	public List<DetentionArea> getSelected(String userId){
		String hql = "select detention.id from UserDetention where state=1 and user.id=?";
		List<Object> idList = (List<Object>)dao.queryByHql(hql, new Object[]{userId});
		StringBuilder paras = new StringBuilder();
		for(Object id : idList){
			paras.append("'"+id.toString()+"',");
		}
		List<DetentionArea> areaList = new ArrayList<DetentionArea>();
		if(paras.length()>0){
			paras.deleteCharAt(paras.length()-1);

			hql = "from DetentionInfo where state=1 and id in("+paras+") order by detentionArea.id";
			List<DetentionInfo> list = (List<DetentionInfo>)dao.queryByHql(hql, null);
			
			int i = 0;
			DetentionArea area = null;
			for(DetentionInfo obj : list){
				
				/***********************刘泉****************************/
				hql="select count(*) from Prisoner where detentionInfo.id='"+obj.getId()+"' and prisonCode='"+obj.getPrisonCode()+"' and realityOutTime=null and state=1";
				Integer pNum=dao.getCount(hql, null);
				obj.setInfoPrisonerNum(pNum);
				System.out.println(obj.getId()+"##"+obj.getPrisonCode()+"##"+pNum);
				/***********************2014.07.17****************************/
				
				if(i == 0){
					area = obj.getDetentionArea();
					area.getDetentionInfoList().add(obj);
					areaList.add(area);
				}else if(area.equals(obj.getDetentionArea())){
					area.getDetentionInfoList().add(obj);
				}else{
					area = obj.getDetentionArea();
					area.getDetentionInfoList().add(obj);
					areaList.add(area);
				}
				i++;
				obj.setDetentionArea(null);
				
			}
		}
		
		return areaList;
	}
	
	/**
	 * 检查该用户是否有查看该拘室的权限
	 * @param userId
	 * @param roomId
	 * @return
	 */
	public boolean checkPriv(String userId, String roomId){
		String hql = "select count(*) from UserDetention where state=1 and user.id=? and detention.id=?";
		Long count = (Long) dao.queryByHqlReturnUnique(hql, new Object[]{userId, roomId});
		if(count > 0){
			return true;
		}else{
			return false;
		}
	}
	
	public BasicDao getDao() {
		return dao;
	}
	
	public void setDao(BasicDao dao) {
		this.dao = dao;
	}
	
}
