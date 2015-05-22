package com.hoyotech.prison.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.hoyotech.prison.bean.GoodItem;
import com.hoyotech.prison.bean.GoodSell;
import com.hoyotech.prison.bean.Prisoner;
import com.hoyotech.prison.bean.SthIn;
import com.hoyotech.prison.dao.impl.BasicDao;
import com.hoyotech.prison.util.ObjectUpdateUtil;
public class GoodItemService {
	private BasicDao dao;
	
	/**
	 * 添加商品
	 * @param item
	 * @return 商品ID
	 * @createDate 2014年12月18日
	 * @author mw
	 */
	public String addGoodItem(GoodItem item){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(item);
		item.setAddTime(new Date());
		item.setUpdateTime(new Date());
		return dao.save(item);
	}
	/**
	 * 商品列表查询
	 * @param name商品名称
	 * @param pageNumber
	 * @param pageSize
	 * @param prisonCode
	 * @return
	 * @createDate 2014年12月18日
	 * @author mw
	 */
	public List<GoodItem> queryGoodList(String name,int pageNumber,int pageSize,String prisonCode){
		String condition = getCondition(name);
		return (List<GoodItem>) dao.queryByHql("from GoodItem where prisonCode=? "+condition+" order by updateTime desc", new Object[]{prisonCode}, pageNumber, pageSize);
	}
	
	public int getCount(String name,String prisonCode){
		String condition = getCondition(name);
		return dao.getCount("select count(*) from GoodItem where prisonCode=? "+condition, new Object[]{prisonCode});
	}
	
	private String getCondition(String name){
		String condition = "";
		if(StringUtils.isNotBlank(name)){
			condition = " and itemName='"+name+"' ";
		}
		return condition;
		
	}
	
	public GoodItem get(String id){
		return (GoodItem) dao.detail(GoodItem.class, id);
	}
	
	public void modify(GoodItem item){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(item);
		item.setUpdateTime(new Date());
		dao.update(item);
	}
	/**
	 * 查询在拘人员信息
	 * @param prisonId
	 * @return
	 * @createDate 2014年12月19日
	 * @author mw
	 */
	public List<Prisoner> queryPrsionerList(String prisonId){
		return (List<Prisoner>) dao.queryByHql("from Prisoner where state=1 and prison.id=?", new Object[]{prisonId});
	}
	/**
	 * 查询商品列表
	 * @param prisonCode
	 * @return
	 * @createDate 2014年12月19日
	 * @author mw
	 */
	public List<GoodItem> queryGoodItemList(String prisonCode){
		return (List<GoodItem>) dao.queryByHql("from GoodItem where prisonCode=?", new Object[]{prisonCode});
	}
	/**
	 * 查询消费记录
	 * @param prisonerId
	 * @return
	 * @createDate 2014年12月19日
	 * @author mw
	 */
	public List<GoodSell> queryGoodSellList(String prisonerId){
		return (List<GoodSell>) dao.queryByHql("from GoodSell where prisoner.id=? order by addTime desc", new Object[]{prisonerId});
	}
	/**
	 * 查询可用金额
	 * @param prisonerId
	 * @return
	 * @createDate 2014年12月19日
	 * @author mw
	 */
	public BigDecimal queryCanUseMoney(String prisonerId){
		return new BigDecimal(dao.queryBySql("SELECT SUM(a.MONEY)-SUM(b.BUY_NUM*b.BUY_PRICE) from STHIN a "
				+ "left join GOODSELL b on a.PRISONER_ID=b.PRISONER_ID "
				+ "where a.PRISONER_ID=?", new Object[]{prisonerId}).get(0).toString());
	}
	
	public void insertSellList(GoodSell sell){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(sell);
		sell.setAddTime(new Date());
		sell.setUpdateTime(new Date());
		dao.save(sell);
	}
	
	public List<SthIn> querySthIn(String prisonerId){
		return (List<SthIn>) dao.queryByHql("from SthIn where prisoner.id = ? order by addTime desc", new Object[]{prisonerId});
	}
	
	public void addSthIn(SthIn sthin){
		ObjectUpdateUtil.checkProperty(sthin);
		sthin.setAddTime(new Date());
		sthin.setUpdateTime(new Date());
		dao.save(sthin);
	}
	
	public BasicDao getDao() {
		return dao;
	}
	public void setDao(BasicDao dao) {
		this.dao = dao;
	}
}
