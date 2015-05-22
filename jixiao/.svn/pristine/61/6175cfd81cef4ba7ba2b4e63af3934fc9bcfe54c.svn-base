package com.hoyotech.prison.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hoyotech.prison.bean.PrisonDevice;
import com.hoyotech.prison.dao.impl.BasicDao;
import com.hoyotech.prison.util.ObjectUpdateUtil;

public class PrisonDeviceService {
	private BasicDao dao;
	
	/**
	 * 查询组织信息
	 * 
	 **/
	public List<PrisonDevice> getList(String prisonName, String deviceName, int pageNumber,int pageSize,String prisonCode){
		List<String> param = getParaCondition(prisonName, deviceName);
		String condition = getCondition(prisonName, deviceName);
		String hql = "from PrisonDevice where state=1 and prisonCode="+prisonCode+condition+" order by updateTime desc";
		return (List<PrisonDevice>)dao.queryByHql(hql, param.toArray(), pageNumber, pageSize);
	}
	
	/**
	 * 查询组织总数
	 **/
	public int getCount(String prisonName, String deviceName ,String prisonCode){
		List<String> param = getParaCondition(prisonName, deviceName);
		String condition = getCondition(prisonName, deviceName);
		String hql = "select count(*) from PrisonDevice where state=1 and prisonCode="+prisonCode+condition;
		return dao.getCount(hql, param.toArray());
	}
	
	public String getCondition(String prisonName, String deviceName){
		StringBuilder sb = new StringBuilder();
		if(prisonName != null && prisonName.length() > 0){
			sb.append(" and prisonInfo.prisonName like '%"+prisonName+"%'");
		}
		if(deviceName != null && deviceName.length() > 0){
			sb.append(" and device.deviceName like '%"+deviceName+"%'");
		}
		return sb.toString();
	}
	
	public List<String> getParaCondition(String prisonName, String deviceName){
		List<String> list = new ArrayList<String>();

		return list;
	}
	
	public String add(PrisonDevice info){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(info);
		info.setUpdateTime(new Date());
		info.setAddTime(new Date());
		return dao.save(info);
	}
	
	public void update(PrisonDevice info){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(info);
		info.setUpdateTime(new Date());
		dao.update(info);
	}
	
	public PrisonDevice detail(String id){
		return (PrisonDevice)dao.detail(PrisonDevice.class, id);
	}
	
	public void delete(String id){
		String hql = "update PrisonDevice set state=0 where id=?";
		dao.executeHql(hql, new Object[]{id});
	}
	
	public BasicDao getDao() {
		return dao;
	}
	
	public void setDao(BasicDao dao) {
		this.dao = dao;
	}
}
