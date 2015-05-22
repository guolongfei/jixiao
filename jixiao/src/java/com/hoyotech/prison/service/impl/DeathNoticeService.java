package com.hoyotech.prison.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.hoyotech.prison.bean.DeathNotice;
import com.hoyotech.prison.dao.impl.BasicDao;

public class DeathNoticeService {

	private BasicDao dao;
	
	public DeathNotice detailByPrisoner(String prisonerId){
		List<DeathNotice> list = (List<DeathNotice>)dao.queryByHql("from DeathNotice where prisoner.id=?", new Object[]{prisonerId});
		return list.size()>0?list.get(0):new DeathNotice();
	}
	
	/**
	 * 添加一条被拘留人死亡通知书信息
	 * **/
	public String add(DeathNotice info){
		info.setAddTime(new Date());
		info.setUpdateTime(new Date());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String time=formatter.format(info.getWriteTime());
		String hql = "update Prisoner set state=4,realityOutTime=? where id=?";
		dao.executeHql(hql, new Object[]{"to_date('"+time+"','yyyy-MM-dd')","'"+info.getPrisoner().getId()+"'"});
		return dao.save(info);
	}
	
	/**
	 * 查询一条被拘留人死亡通知书信息
	 * **/
	public DeathNotice detail(String id){
		return (DeathNotice)dao.detail(DeathNotice.class, id);
	}
	
	/**
	 * 删除一条被拘留人死亡通知书信息
	 * **/
	public void delete(String id){
		String hql = "update DeathNotice set state=0 where id=?";
		dao.executeHql(hql, new Object[]{id});
	}
	
	/**
	 * 修改审批状态
	 * **/
	public void examineChange(String id,String info){
		String hql = "update DeathNotice set examine=? where id=?";
		dao.executeHql(hql, new Object[]{info,id});
	}
	
	/**
	 * 修改一条被拘留人死亡通知书信息
	 * **/
	public void update(DeathNotice info){
		info.setUpdateTime(new Date());
		dao.update(info);
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String time=formatter.format(info.getWriteTime());
		String hql = "update Prisoner set state=4,realityOutTime=? where id=?";
		dao.executeHql(hql, new Object[]{"to_date('"+time+"','yyyy-MM-dd')","'"+info.getPrisoner().getId()+"'"});
	}

	public BasicDao getDao() {
		return dao;
	}

	public void setDao(BasicDao dao) {
		this.dao = dao;
	}
	
}
