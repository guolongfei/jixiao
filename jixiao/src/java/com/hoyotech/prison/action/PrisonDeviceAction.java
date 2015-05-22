package com.hoyotech.prison.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.Device;
import com.hoyotech.prison.bean.PrisonDevice;
import com.hoyotech.prison.bean.PrisonInfo;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.DictionaryService;
import com.hoyotech.prison.service.impl.PrisonDeviceService;
import com.hoyotech.prison.service.impl.PrisonInfoService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.ObjectUpdateUtil;
import com.hoyotech.prison.util.PrisonUtil;
import com.isa.pims.basic.ServletRequestUtils;

public class PrisonDeviceAction {
	private PrisonDeviceService prisonDeviceService;
	private DictionaryService dictionaryService;
	private PrisonInfoService prisonService;
	
	private List<PrisonDevice> list;
	private PrisonDevice prisonDevice;
	private int pageNum;
	private int limit;
	private int totalPage;
	private int totalNum;
	private String id ;

	private List<PrisonInfo> prisonList;
	private Map<Device, List<Device>> deviceList;
	
	// 检索条件
	private String prisonName;
	private String deviceName;

	private LogFactory log;
	
	public String list() {
		HttpServletRequest request = ServletActionContext.getRequest();
		pageNum = ServletRequestUtils.getInt(request, "page", "1");
		limit = ServletRequestUtils.getInt(request, "limit", "20");
		String prisonCode=PrisonUtil.getPrisonCode(request);
		list = prisonDeviceService.getList(prisonName, deviceName, pageNum, limit,prisonCode);
		totalNum = prisonDeviceService.getCount(prisonName, deviceName,prisonCode);
		totalPage = (totalNum - 1) / limit + 1;
//		for(PrisonDevice pd:list){
//			System.out.println(pd.getId()+" "+pd.getAddTime()+" "+pd.getDevice().getDeviceName());
//		}
		return "list";
	}

	public String addUI() {
		prisonList = prisonService.allPrisonInfo();
		deviceList = dictionaryService.getDeviceList();
		return "addUI";
	}

	public String editUI() {
		prisonList = prisonService.allPrisonInfo();
		deviceList = dictionaryService.getDeviceList();
		prisonDevice = prisonDeviceService.detail(id);
		return "edit";
	}
	
	public String add() {
		HttpServletRequest request = ServletActionContext.getRequest();
		prisonDevice.setPrisonCode(PrisonUtil.getPrisonCode(request));
		id = prisonDeviceService.add(prisonDevice);
		
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(prisonDevice, config.getInsert(), operate, config.getDevice(), config.getSucceed(), request);
		return "Detail";
	}

	public String detail(){
		prisonDevice = prisonDeviceService.detail(id);
		return "detail";
	}
	
	public String update(){
		PrisonDevice obj = prisonDeviceService.detail(prisonDevice.getId());
		PrisonDevice old_obj = prisonDeviceService.detail(prisonDevice.getId());
		ObjectUpdateUtil.compareProperty(prisonDevice, obj);
		
		prisonDeviceService.update(obj);
		id=prisonDevice.getId();
		
		// 添加日志
		
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。";
		log.getModifyLogMessage(obj, old_obj, config.getUpdate(), operate, config.getMedical(), config.getSucceed(), request);
		return "Detail";
	}
	
	public String delete(){
		//prisonDevice.setUpdateTime(new Date());
		prisonDeviceService.delete(id);
		
		// 添加日志
		PrisonDevice object = new PrisonDevice();
		object.setId(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "删除成功。";
		log.getModifyLogMessage(null, object, config.getDelete(), operate, config.getDevice(), config.getSucceed(), request);
		return "select";
	}
	
	public LogFactory getLog() {
		return log;
	}

	public void setLog(LogFactory log) {
		this.log = log;
	}

	public PrisonDeviceService getPrisonDeviceService() {
		return prisonDeviceService;
	}

	public void setPrisonDeviceService(PrisonDeviceService prisonDeviceService) {
		this.prisonDeviceService = prisonDeviceService;
	}

	public PrisonDevice getPrisonDevice() {
		return prisonDevice;
	}

	public void setPrisonDevice(PrisonDevice prisonDevice) {
		this.prisonDevice = prisonDevice;
	}

	public List<PrisonDevice> getList() {
		return list;
	}

	public void setList(List<PrisonDevice> list) {
		this.list = list;
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

	public DictionaryService getDictionaryService() {
		return dictionaryService;
	}

	public void setDictionaryService(DictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}

	public PrisonInfoService getPrisonService() {
		return prisonService;
	}

	public void setPrisonService(PrisonInfoService prisonService) {
		this.prisonService = prisonService;
	}

	public List<PrisonInfo> getPrisonList() {
		return prisonList;
	}

	public void setPrisonList(List<PrisonInfo> prisonList) {
		this.prisonList = prisonList;
	}

	public Map<Device, List<Device>> getDeviceList() {
		return deviceList;
	}

	public void setDeviceList(Map<Device, List<Device>> deviceList) {
		this.deviceList = deviceList;
	}

	public String getPrisonName() {
		return prisonName;
	}

	public void setPrisonName(String prisonName) {
		this.prisonName = prisonName;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
}