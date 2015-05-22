package com.hoyotech.prison.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hoyotech.prison.bean.Car;
import com.hoyotech.prison.dao.impl.BasicDao;
import com.hoyotech.prison.dao.impl.DictionaryDao;
import com.hoyotech.prison.util.ObjectUpdateUtil;

public class CarService {

	private BasicDao dao;
	DictionaryDao dictionaryDao;
	
	
	/**
	 * 检索车辆管理信息
	 * **/
	public String getCondition(String carnum,String enginenum,String driver,String cartype){
		StringBuilder sb = new StringBuilder();
		if(carnum != null && carnum.length() > 0){
			sb.append(" and carNum like '%"+carnum+"%'");
		}
		if(enginenum != null && enginenum.length() > 0){
			sb.append(" and engineNum like '%"+enginenum+"%'");
		}
		if(driver != null && driver.length() > 0){
			sb.append(" and dirver like '%"+driver+"%'");
		}
		if(cartype != null && cartype.length() > 0){
			sb.append(" and vehicleType=?");
		}
		return sb.toString();
	}
	
	/**
	 * 检索信息所需要的条件
	 * **/
	public List<String> getParaCondition(String  carnum,String enginenum,String driver,String cartype){
		List<String> list = new ArrayList<String>();
//		if(carnum != null && carnum.length() > 0){
//			list.add(carnum);
//		}
//		if(enginenum != null && enginenum.length() > 0){
//			list.add(enginenum);
//		}
//		if(driver != null && driver.length() > 0){
//			list.add(driver);
//		}
		if(cartype != null && cartype.length() > 0){
			list.add(cartype);
		}
		return list;
	}
	
	
	/**
	 * 查询所有车辆管理信息
	 * **/
	public List<Car> allcar(String carnum,String enginenum,String driver,String cartype,int pageNumber,int pageSize,String prisonCode){
		List<String> param = getParaCondition(carnum,enginenum,driver,cartype);
		String condition = getCondition(carnum,enginenum,driver,cartype);
		String hql = "from Car where state=1 and prisonCode="+prisonCode+condition+" order by updateTime desc";
		return (List<Car>)dao.queryByHql(hql, param.toArray(), pageNumber, pageSize);

	}
	
	/**
	 * 查询车辆管理的总数
	 * **/
	public int countCar(String carnum,String enginenum,String driver,String cartype,String prisonCode){
		List<String> param = getParaCondition(carnum,enginenum,driver,cartype);
		String condition = getCondition(carnum,enginenum,driver,cartype);
		String hql = "select count(*) from Car where state=1 and prisonCode="+prisonCode+condition;
		return dao.getCount(hql, param.toArray());
	}
	
	/**
	 * 添加一条车辆管理信息
	 * **/
	public String addCar(Car info){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(info);
		info.setAddTime(new Date());
		info.setUpdateTime(new Date());
		return dao.save(info);
	}
	
	/**
	 * 查询一条车辆管理信息
	 * **/
	public Car carDetail(String id){
		return (Car)dao.detail(Car.class, id);
	}
	
	/**
	 * 删除一条车辆管理信息
	 * **/
	public void carDel(String id){
		String hql = "update Car set state=0 where id=?";
		dao.executeHql(hql, new Object[]{id});
	}
	
	/**
	 * 修改一条车辆管理信息
	 * **/
	public void carUpdate(Car info){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(info);
		info.setUpdateTime(new Date());
		dao.update(info);
	}

	public BasicDao getDao() {
		return dao;
	}

	public void setDao(BasicDao dao) {
		this.dao = dao;
	}

	public DictionaryDao getDictionaryDao() {
		return dictionaryDao;
	}

	public void setDictionaryDao(DictionaryDao dictionaryDao) {
		this.dictionaryDao = dictionaryDao;
	}
	
	
}
