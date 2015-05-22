package com.hoyotech.prison.service.impl;

import java.util.Date;
import java.util.List;

import com.hoyotech.prison.bean.Arraign;
import com.hoyotech.prison.dao.impl.BasicDao;

public class ArraignService {

private BasicDao dao;
	
	/**
	 * 查询所有未审批的提解被拘留人登记信息
	 * **/
	public List<Arraign> select(String prisonCode){
		String hql = "from Arraign where examine=0 and state=1 and prisonCode="+prisonCode+" order by updateTime desc";
		return (List<Arraign>)dao.queryByHql(hql, new Object[]{});
	
	}

	/**
	 * 查询所有提解被拘留人登记信息
	 * **/
	public List<Arraign> list(String prisonerId, String prisonCode){
		String hql = "from Arraign where state=1 and prisoner.id=? and prisonCode="+prisonCode+" order by updateTime desc";
		return (List<Arraign>)dao.queryByHql(hql, new Object[]{prisonerId});

	}
	
	/**
	 * 查询提解被拘留人登记的总数
	 * **/
	public int count(String prisonerId, String prisonCode){
		String hql = "select count(*) from Arraign where state=1 and prisoner.id=? and prisonCode="+prisonCode;
		return dao.getCount(hql, new Object[]{prisonerId});
	}
	
	/**
	 * 添加一条提解被拘留人登记信息
	 * **/
	public String add(Arraign info){
		info.setAddTime(new Date());
		info.setUpdateTime(new Date());
		return dao.save(info);
	}
	
	/**
	 * 查询一条提解被拘留人登记信息
	 * **/
	public Arraign detail(String id){
		return (Arraign)dao.detail(Arraign.class, id);
	}
	
	public Arraign detailByPrisoner(String prisonerId){
		List<Arraign> list = (List<Arraign>)dao.queryByHql("from Arraign where prisoner.id=?", new Object[]{prisonerId});
		return list.size()>0?list.get(0):new Arraign();
	}
	
	/**
	 * 删除一条提解被拘留人登记信息
	 * **/
	public void delete(String id){
		String hql = "update Arraign set state=0 where id=?";
		dao.executeHql(hql, new Object[]{id});
	}
	
	/**
	 * 修改审批状态
	 * **/
	public void examineChange(String id,String info){
		String hql = "update Arraign set examine=? where id=?";
		dao.executeHql(hql, new Object[]{info,id});
	}
	
	/**
	 * 修改一条提解被拘留人登记信息
	 * **/
	public void update(Arraign info){
		info.setUpdateTime(new Date());
		dao.update(info);
	}

	public BasicDao getDao() {
		return dao;
	}

	public void setDao(BasicDao dao) {
		this.dao = dao;
	}

	
	
	
}
