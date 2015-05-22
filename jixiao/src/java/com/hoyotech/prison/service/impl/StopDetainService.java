package com.hoyotech.prison.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hoyotech.prison.bean.StopDetain;
import com.hoyotech.prison.dao.impl.BasicDao;
import com.hoyotech.prison.util.ObjectUpdateUtil;


public class StopDetainService {
	
	private BasicDao dao;
	
	/**
	 * 检索信息
	 * **/
	public String getCondition(String prisonerNum,String prisonerName,String operator,String examineState){
		StringBuilder sb = new StringBuilder();
		if(prisonerNum != null && prisonerNum.length() > 0){
			sb.append(" and prisoner.prisonerCode like '%"+prisonerNum+"%'");
		}
		if(prisonerName != null && prisonerName.length() > 0){
			sb.append(" and prisoner.name like '%"+prisonerName+"%'");
		}
		if(operator != null && operator.length() > 0){
			sb.append(" and operator like '%"+operator+"%'");
		}
		if(examineState != null && examineState.length() > 0){
			sb.append(" and examine=?");
		}
		return sb.toString();
	}
	
	/**
	 * 检索信息所需要的条件
	 * **/
	public List<String> getParaCondition(String prisonerNum,String prisonerName,String operator,String examineState){
		List<String> list = new ArrayList<String>();
//		if(prisonerNum != null && prisonerNum.length() > 0){
//			list.add(prisonerNum);
//		}
//		if(prisonerName != null && prisonerName.length() > 0){
//			list.add(prisonerName);
//		}
//		if(operator != null && operator.length() > 0){
//			list.add(operator);
//		}
		if(examineState != null && examineState.length() > 0){
			list.add(examineState);
		}
		return list;
	}
	
	
	/**
	 * 查询所有停止执行拘留信息
	 * **/
	public List<StopDetain> list(String prisonerNum,String prisonerName,String operator,String examineState,int pageNumber,int pageSize,String prisonCode){
		List<String> param = getParaCondition(prisonerNum,prisonerName,operator,examineState);
		String condition = getCondition(prisonerNum,prisonerName,operator,examineState);
		String hql = "from StopDetain where state=1 and prisonCode="+prisonCode+condition+" order by updateTime desc";
		return (List<StopDetain>)dao.queryByHql(hql, param.toArray(), pageNumber, pageSize);

	}
	
	/**
	 * 查询停止执行拘留的总数
	 * **/
	public int count(String prisonerNum,String prisonerName,String operator,String examineState,String prisonCode){
		List<String> param = getParaCondition(prisonerNum,prisonerName,operator,examineState);
		String condition = getCondition(prisonerNum,prisonerName,operator,examineState);
		String hql = "select count(*) from StopDetain where state=1 and prisonCode="+prisonCode+condition;
		return dao.getCount(hql, param.toArray());
	}
	
	/**
	 * 添加一条停止执行拘留信息
	 * **/
	public String add(StopDetain info){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(info);
		info.setAddTime(new Date());
		info.setUpdateTime(new Date());
		return dao.save(info);
	}
	
	/**
	 * 查询一条停止执行拘留信息
	 * **/
	public StopDetain detail(String id){
		return (StopDetain)dao.detail(StopDetain.class, id);
	}
	
	/**
	 * 根据被拘留人查详细信息
	 * @param prisonerId
	 * @return
	 */
	public StopDetain detailByPrisoner(String prisonerId){
		List<StopDetain> list = (List<StopDetain>)dao.queryByHql("from StopDetain where prisoner.id=?", new Object[]{prisonerId});
		return list.size()>0?list.get(0):new StopDetain();
	}
	
	/**
	 * 删除一条停止执行拘留信息
	 * **/
	public void delete(String id){
		String hql = "update StopDetain set state=0 where id=?";
		dao.executeHql(hql, new Object[]{id});
	}
	
	/**
	 * 修改审批状态
	 * **/
	public void examineChange(String id,String info){
		String hql = "update StopDetain set examine=? where id=?";
		dao.executeHql(hql, new Object[]{info,id});
	}
	
	/**
	 * 修改一条停止执行拘留信息
	 * **/
	public void update(StopDetain info){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(info);
		info.setUpdateTime(new Date());
		info.setExamine("0");
		dao.update(info);
	}

	public BasicDao getDao() {
		return dao;
	}

	public void setDao(BasicDao dao) {
		this.dao = dao;
	}

	
	
	
}
