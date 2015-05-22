package com.hoyotech.prison.service.impl;

import java.util.Date;
import java.util.List;

import com.hoyotech.prison.bean.Goods;
import com.hoyotech.prison.bean.PrisonerGoods;
import com.hoyotech.prison.dao.impl.BasicDao;
import com.hoyotech.prison.dao.impl.DictionaryDao;
import com.hoyotech.prison.util.ObjectUpdateUtil;

public class PrisonerGoodsService {

	private BasicDao dao;
	private DictionaryDao dictionaryDao;
	
	/**
	 * 添加物品
	 * @param obj
	 * @return
	 */
	public String addGoods(Goods obj){
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
	public String add(PrisonerGoods obj){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(obj);
		obj.setAddTime(new Date());
		obj.setUpdateTime(new Date());

		String id = dao.save(obj);
		return id;
	}
	
	public void update(PrisonerGoods obj){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(obj);
		obj.setUpdateTime(new Date());

		dao.update(obj);
	}
	
	public void updateGoods(Goods obj){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(obj);
		obj.setUpdateTime(new Date());

		dao.update(obj);
	}
	
	/**
	 * 查询此物品清单中的详细信息
	 * @param prisonerId
	 * @return
	 */
	public PrisonerGoods detailByPrisoner(String prisonerId){
		PrisonerGoods obj = null;
		if(prisonerId != null && !"".equals(prisonerId)){
			List<PrisonerGoods> list = (List<PrisonerGoods>) dao.queryByHql("from PrisonerGoods where prisoner.id=?", new Object[]{prisonerId});
			if(list.size() > 0){
				obj = list.get(0);
				// 查询此物品清单中的物品列表
				List<Goods> subList = (List<Goods>) dao.queryByHql("from Goods where prisoner.id=?", new Object[]{prisonerId});
				for(Goods goods : subList){
					obj.getGoods().add(goods);
				}
			}
		}
		return obj;
	}
	
	/**
	 * 查询此物品清单中的详细信息
	 * @param prisonerId
	 * @return
	 */
	public PrisonerGoods detail(String id){
		PrisonerGoods obj = (PrisonerGoods) dao.detail(PrisonerGoods.class, id);
		return obj;
	}
	
	/**
	 * 查询此物品清单中的详细信息
	 * @param prisonerId
	 * @return
	 */
	public Goods detailGoods(String id){
		Goods obj = (Goods) dao.detail(Goods.class, id);
		return obj;
	}
	
	public DictionaryDao getDictionaryDao() {
		return dictionaryDao;
	}
	
	public void setDictionaryDao(DictionaryDao dictionaryDao) {
		this.dictionaryDao = dictionaryDao;
	}

	public BasicDao getDao() {
		return dao;
	}

	public void setDao(BasicDao dao) {
		this.dao = dao;
	}
}
