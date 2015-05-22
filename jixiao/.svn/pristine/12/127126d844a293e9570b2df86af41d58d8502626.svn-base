package com.hoyotech.prison.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.Car;
import com.hoyotech.prison.bean.Dictionary;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.CarService;
import com.hoyotech.prison.service.impl.DictionaryService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.ObjectUpdateUtil;
import com.hoyotech.prison.util.PrisonUtil;
import com.hoyotech.prison.util.Type;
import com.isa.pims.basic.ServletRequestUtils;
import com.opensymphony.xwork2.ActionSupport;

public class CarAction extends ActionSupport {
	
	CarService carService;
	DictionaryService dictionaryService;
	private List<Car> carlist;
	private Car car;
	private int pageNum;
	private int limit; 
	private int totalPage;
	private int totalNum;
	private String id;
	private String carnum; //检索用的车牌号
	private String enginenum; //检索用的发动机号
	private String driver; //检索用的驾驶员姓名
	private String cartype; //检索用的车用类型
	
	private List<Dictionary> carTypes;
	
	private LogFactory log;
	/**
	 * 查询所有车辆管理的信息
	 * **/
	public String select() {
		carTypes=dictionaryService.selectDictionary(Type.CARTYPE);
		HttpServletRequest request=ServletActionContext.getRequest();
		String prisonCode=PrisonUtil.getPrisonCode(request);
		pageNum = ServletRequestUtils.getInt(request, "page","1");
		limit = ServletRequestUtils.getInt(request, "limit","20");
		carlist = carService.allcar(carnum, enginenum, driver, cartype, pageNum, limit,prisonCode);
		totalNum=carService.countCar(carnum, enginenum, driver, cartype,prisonCode);
		totalPage=(totalNum-1)/limit+1;
		return "List";
	}
	
	/**
	 * 添加一条车辆管理的信息
	 * **/
	public String add() {
		HttpServletRequest request = ServletActionContext.getRequest();
		car.setPrisonCode(PrisonUtil.getPrisonCode(request));
		id = carService.addCar(car); //添加数据得到id
		
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(car, config.getInsert(), operate, config.getCar(), config.getSucceed(), request);
		return "detail";
	}

	/**
	 * 查询一条车辆管理的信息,返回到详细页面
	 * **/
	public String detailCar() {
		car=carService.carDetail(id);
		return "Detail";
	}
	
	/**
	 * 删除一条车辆管理的信息
	 * **/
	public String delete() {
		carService.carDel(id);
		
		// 添加日志
		Car object = new Car();
		object.setId(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "删除成功。";
		log.getModifyLogMessage(null, object, config.getDelete(), operate, config.getCar(), config.getSucceed(), request);
		return "select";
	}
	
	/**
	 * 修改一条车辆的信息
	 * **/
	public String update() {
		Car obj = carService.carDetail(car.getId());
		Car old_obj = carService.carDetail(car.getId());
		ObjectUpdateUtil.compareProperty(car, obj);
		
		carService.carUpdate(obj) ;
		id=car.getId();
		
		// 添加日志
		
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。";
		log.getModifyLogMessage(obj, old_obj, config.getUpdate(), operate, config.getCar(), config.getSucceed(), request);
		return "detail";
	}
	
	/**
	 * 进入添加页面
	 * **/
	public String interCarAdd() {
		carTypes=dictionaryService.selectDictionary(Type.CARTYPE);
		return "Add";
	}
	
	/**
	 * 进入修改页面
	 * **/
	public String interCarEdit() {
		carTypes=dictionaryService.selectDictionary(Type.CARTYPE);
		car=carService.carDetail(id);
		return "Edit";
	}
	
	public LogFactory getLog() {
		return log;
	}

	public void setLog(LogFactory log) {
		this.log = log;
	}

	public DictionaryService getDictionaryService() {
		return dictionaryService;
	}

	public void setDictionaryService(DictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}

	public CarService getCarService() {
		return carService;
	}

	public void setCarService(CarService carService) {
		this.carService = carService;
	}

	public List<Car> getCarlist() {
		return carlist;
	}

	public void setCarlist(List<Car> carlist) {
		this.carlist = carlist;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCarnum() {
		return carnum;
	}

	public void setCarnum(String carnum) {
		this.carnum = carnum;
	}

	public String getEnginenum() {
		return enginenum;
	}

	public void setEnginenum(String enginenum) {
		this.enginenum = enginenum;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getCartype() {
		return cartype;
	}

	public void setCartype(String cartype) {
		this.cartype = cartype;
	}

	public List<Dictionary> getCarTypes() {
		return carTypes;
	}

	public void setCarTypes(List<Dictionary> carTypes) {
		this.carTypes = carTypes;
	}
	
	

}
