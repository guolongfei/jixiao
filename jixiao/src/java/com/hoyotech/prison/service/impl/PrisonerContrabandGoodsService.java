package com.hoyotech.prison.service.impl;

import java.util.Date;
import java.util.List;

import com.hoyotech.prison.bean.ContrabandGoods;
import com.hoyotech.prison.bean.PrisonerContrabandGoods;
import com.hoyotech.prison.dao.impl.BasicDao;
import com.hoyotech.prison.util.ObjectUpdateUtil;

public class PrisonerContrabandGoodsService {
	private BasicDao dao;
	
	/**
	 * 添加涉案物品
	 * @param obj
	 * @return
	 */
	public String addContrabandGoods(ContrabandGoods obj){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(obj);
		obj.setAddTime(new Date());
		obj.setUpdateTime(new Date());
		String id = dao.save(obj);
		return id;
	}
	
	/**
	 * 添加
	 * @param obj
	 * @return
	 */
	public String add(PrisonerContrabandGoods obj){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(obj);
		obj.setAddTime(new Date());
		obj.setUpdateTime(new Date());
		String id = dao.save(obj);
		return id;
	}
	
	/**
	 * 添加
	 * @param obj
	 * @return
	 */
	public void update(PrisonerContrabandGoods obj){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(obj);
		obj.setUpdateTime(new Date());
		dao.update(obj);
	}
	
	/**
	 * 查询此物品清单中的详细信息
	 * @param id
	 * @return
	 */
	public PrisonerContrabandGoods detail(String id){
		PrisonerContrabandGoods obj = (PrisonerContrabandGoods) dao.detail(PrisonerContrabandGoods.class, id);
		return obj;
	}

	/**
	 * 查询此物品清单中的详细信息
	 * @param prisonerId
	 * @return
	 */
	public PrisonerContrabandGoods detailByPrisoner(String prisonerId){
		PrisonerContrabandGoods obj = null;
		if(prisonerId != null && !"".equals(prisonerId)){
			List<PrisonerContrabandGoods> list = (List<PrisonerContrabandGoods>) dao.queryByHql("from PrisonerContrabandGoods where prisoner.id=?", new Object[]{prisonerId});
			if(list.size() > 0){
				obj = list.get(0);
				// 查询此物品清单中的物品列表
				List<ContrabandGoods> subList = (List<ContrabandGoods>) dao.queryByHql("from ContrabandGoods where prisoner.id=?", new Object[]{prisonerId});
				for(ContrabandGoods contrabandGoods : subList){
					obj.getContrabandGoods().add(contrabandGoods);
				}
			}
		}
		return obj;
	}
	
	public BasicDao getDao() {
		return dao;
	}
	
	public void setDao(BasicDao dao) {
		this.dao = dao;
	}
}
