package com.hoyotech.prison.service.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.Area;
import com.hoyotech.prison.bean.Career;
import com.hoyotech.prison.bean.DetentionInfo;
import com.hoyotech.prison.bean.Device;
import com.hoyotech.prison.bean.Dictionary;
import com.hoyotech.prison.bean.Document;
import com.hoyotech.prison.bean.Medical;
import com.hoyotech.prison.bean.Nationality;
import com.hoyotech.prison.bean.Peoples;
import com.hoyotech.prison.bean.Police;
import com.hoyotech.prison.bean.Prisoner;
import com.hoyotech.prison.bean.WorkUnit;
import com.hoyotech.prison.dao.impl.BasicDao;
import com.hoyotech.prison.dao.impl.DictionaryDao;
import com.hoyotech.prison.util.PrisonUtil;

public class DictionaryService {
	private DictionaryDao dictionaryDao;
	private BasicDao dao;
	
	/**
	 * 查询民警表中的选项
	 * **/
	public List<Police> selectPolice(String prisonCode){
		return dictionaryDao.selectPolice(prisonCode);
	}
	
	/**
	 * 查询民警表中的选项
	 * **/
	public List<Medical> selectMedical(String prisonCode){
		return dictionaryDao.selectMedical(prisonCode);
	}
	
	/**
	 * 查询民族表中的选项
	 * **/
	public List<Peoples> selectPeoples(int type){
		return dictionaryDao.selectPeoples(type);
	}
	/**
	 * 查询职业表中的选项
	 * **/
	public List<Career> selectCareer(int type){
		return dictionaryDao.selectCareer(type);
	}
	/**
	 * 查询证件类型表中的选项
	 * **/
	public List<Document> selectDocument(int type){
		return dictionaryDao.selectDocument(type);
	}
	/**
	 * 查询国籍表中的选项
	 * **/
	public List<Nationality> selectNationality(int type){
		return dictionaryDao.selectNationality(type);
	}
	
	/**
	 * 查询数据字典中下拉列表的选项
	 * **/
	public List<Dictionary> selectDictionary(int type) {
		return dictionaryDao.selectDictionary(type);
	}
	
	/**
	 * 查询工作单位
	 * **/
	public List<WorkUnit> selectWorkUnit(String prisonCode) {
		List<WorkUnit> list= dictionaryDao.selectworkUnit(prisonCode);
		
		for(WorkUnit org : list){
			org.setUnitName(getPath(org.getLevel())+"|-"+org.getUnitName());
		}
		return list;
	}
	
	private String getPath(int level){
		StringBuilder path = new StringBuilder("");
		for(int i=1; i<level; i++){
			path.append("　");
		}
		return path.toString();
	}
	/**
	 * 查询被拘留人姓名下拉列表
	 * **/
	public List<Prisoner> selectPrisoner(String prisonCode) {
		return dictionaryDao.selectPrisoner(prisonCode);
	}
	
	
	/**
	 * 查询所有装备
	 * **/
	public Map<Device, List<Device>> getDeviceList() {
		List<Device> list = (List<Device>)dao.queryByHql("from Device where parent_id is null", null);
		Map<Device, List<Device>> map = new HashMap<Device, List<Device>>();
		for(Device device : list){
			List<Device> subList = (List<Device>)dao.queryByHql("from Device where parent_id=?", new Object[]{device.getId()});
			for(Device subDevice : subList){
				subDevice.setDeviceName(subDevice.getDeviceName()+" ("+subDevice.getDeviceUnit()+")");
			}
			map.put(device, subList);
		}
		return map;
	}

	/**
	 * 行政区划列表
	 * @return
	 */
	public Map<Area, List<Area>> getAllAreaList(){
		List<Area> list = (List<Area>)dao.queryByHql("from Area", null);
		Map<Area, List<Area>> map = new HashMap<Area, List<Area>>();
		int i = 0;
		Area parentArea = null;
		List<Area> tempList = null;
		for(Area area : list){
			if(area.getArea() == null){
				parentArea = list.get(i);
				tempList = new ArrayList<Area>();
				map.put(parentArea, tempList);
				
			}else if(parentArea.getId().equals(area.getArea().getId())){
				tempList.add(area);
			}
			i++;
		}
		return map;
	}
	
	/**
	 * 一级行政区划列表
	 * @return
	 */
	public List<Area> getAreaListLevel1(){
		List<Area> list = (List<Area>)dao.queryByHql("from Area where area.id is null", null);
		return list;
	}
	
	/**
	 * 查询流水号
	 * @return
	 */
	public String getNo(String tablename){
		HttpServletRequest request = ServletActionContext.getRequest();
		String year=String.valueOf(PrisonUtil.getYear());
		String code=PrisonUtil.getPrisonCode(request);
		String hql="select e.noNumber from "+tablename+" e where e.noYear=? and prisonCode=? order by id desc";
		String no=(String)dao.queryByHqlReturnUnique(hql, new Object[]{year,code},1,1);
		int i;
		if(no==null){
			i=1;
		}else{
			i = Integer.parseInt(no);
			i++;
		}
		DecimalFormat df = new DecimalFormat("000000");
		return df.format(i);
		
	}
	
	/**
	 * 查询拘室列表
	 * 
	 **/
	public List<DetentionInfo> getDetentionList(String prisonId){
		String hql = "from DetentionInfo where state=1 and prisonInfo=?";
		return (List<DetentionInfo>)dao.queryByHql(hql, new Object[]{prisonId});
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
