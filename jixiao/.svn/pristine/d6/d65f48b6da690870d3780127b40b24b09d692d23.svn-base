package com.hoyotech.prison.service.impl;

import java.util.Date;
import java.util.List;

import com.hoyotech.prison.bean.RiskAssess;
import com.hoyotech.prison.dao.impl.BasicDao;
import com.hoyotech.prison.util.ObjectUpdateUtil;

public class RiskAssessService {

private BasicDao dao;
	
	/**
	 * 查询所有风险评估信息
	 * **/
	public List<RiskAssess> list(String prisonerId, String prisonCode){
		String hql = "from RiskAssess where state=1 and prisoner.id=? and prisonCode="+prisonCode+" order by updateTime desc";
		return (List<RiskAssess>)dao.queryByHql(hql, new Object[]{prisonerId});

	}
	
	/**
	 * 查询风险评估的总数
	 * **/
	public int count(String prisonerId, String prisonCode){
		String hql = "select count(*) from RiskAssess where state=1 and prisoner.id=? and prisonCode="+prisonCode;
		return dao.getCount(hql, new Object[]{prisonerId});
	}
	
	/**
	 * 添加一条风险评估信息
	 * **/
	public String add(RiskAssess info){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(info);
		info.setAddTime(new Date());
		info.setUpdateTime(new Date());
		return dao.save(info);
	}
	
	/**
	 * 查询一条风险评估信息
	 * **/
	public RiskAssess detail(String id){
		return (RiskAssess)dao.detail(RiskAssess.class, id);
	}
	/**
	 * 根据被拘留人id查询一条风险评估信息
	 * **/
	public RiskAssess ByPrisonerId(String prisonerId){
		List<RiskAssess> list = (List<RiskAssess>)dao.queryByHql("from RiskAssess where prisoner.id=?", new Object[]{prisonerId});
		return list.size()>0?list.get(0):new RiskAssess();
	}
	
	public RiskAssess detailByPrisoner(String prisonerId){
		List<RiskAssess> list = (List<RiskAssess>)dao.queryByHql("from RiskAssess where prisoner.id=? order by updateTime desc", new Object[]{prisonerId});
		return list.size()>0?list.get(0):new RiskAssess();
	}
	
	/**
	 * 删除一条风险评估信息
	 * **/
	public void delete(String id){
		String hql = "update RiskAssess set state=0 where id=?";
		dao.executeHql(hql, new Object[]{id});
	}
	
	/**
	 * 修改一条风险评估信息
	 * **/
	public void update(RiskAssess info){
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
