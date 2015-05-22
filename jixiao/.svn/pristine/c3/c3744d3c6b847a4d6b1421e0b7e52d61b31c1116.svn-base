package com.hoyotech.prison.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.hoyotech.prison.bean.Area;
import com.hoyotech.prison.bean.DetentionArea;
import com.hoyotech.prison.bean.Organization;
import com.hoyotech.prison.bean.PrisonInfo;
import com.hoyotech.prison.dao.impl.BasicDao;
import com.hoyotech.prison.dao.impl.DictionaryDao;
import com.hoyotech.prison.util.ObjectUpdateUtil;


public class PrisonInfoService  {

	private BasicDao dao;
	DictionaryDao dictionaryDao;
	private List<PrisonInfo> infoList;
	
	/**
	 * 检索拘留所信息
	 * **/
	public String getCondition(String priNum,String priName,String priLevel,String priSize){
		StringBuilder sb = new StringBuilder();
		if(priNum != null && priNum.length() > 0){
			sb.append(" and prisonCode=?");
		}
		if(priName != null && priName.length() > 0){
			sb.append(" and prisonName like '%"+priName+"%'");
		}
		if(priLevel != null && priLevel.length() > 0){
			sb.append(" and prisonLevel=?");
		}
		if(priSize != null && priSize.length() > 0){
			sb.append(" and prisonSize=?");
		}
		return sb.toString();
	}
	
	/**
	 * 检索信息所需要的条件
	 * **/
	public List<String> getParaCondition(String num,String name,String level,String size){
		List<String> list = new ArrayList<String>();
		if(num != null && num.length() > 0){
			list.add(num);
		}
//		if(name != null && name.length() > 0){
//			list.add(name);
//		}
		if(level != null && level.length() > 0){
			list.add(level);
		}
		if(size != null && size.length() > 0){
			list.add(size);
		}
		return list;
	}
	
	/**
	 * 查询所有拘留所信息
	 * **/
	public List<PrisonInfo> allPrisonInfo(){
		String hql = "from PrisonInfo where state=1 order by updateTime desc";
		return (List<PrisonInfo>)dao.queryByHql(hql, null);

	}
	
	/**
	 * 查询第一条诗句
	 * @return
	 */
	public String getPrisonCode() {
		String hql = "select prisonCode from PrisonInfo where state=1 order by updateTime";
		return (String)dao.queryByHql(hql, null).get(0);
	}
	
	
	/**
	 * 查询区域信息
	 * **/
	public List<DetentionArea> getDetentionArea(String prisonId){
		List<DetentionArea> list = (List<DetentionArea>)dao.queryByHql("from DetentionArea where state=1 and prisonInfo.id=?", new Object[]{prisonId});
		return list;
	}
	
	/**
	 * 查询所有拘留所信息
	 * **/
	public List<PrisonInfo> allPrisonInfo(String num,String name,String level,String size,int pageNumber,int pageSize){
		List<String> param = getParaCondition(num, name, level, size);
		String condition = getCondition(num, name, level, size);
		String hql = " from PrisonInfo where state!=3 "+condition+" order by updateTime desc";
		System.out.println(hql+"---------");
		return (List<PrisonInfo>)dao.queryByHql(hql, param.toArray(), pageNumber, pageSize);

	}
	
	/**
	 * 查询拘留所信息的总数
	 * **/
	public int countPrisonInfo(String num,String name,String level,String size){
		List<String> param = getParaCondition(num, name, level, size);
		String condition = getCondition(num, name, level, size);
		String hql = "select count(*) from PrisonInfo where 1=1"+condition;
		return dao.getCount(hql, param.toArray());
	}
	
	/**
	 * 添加一条拘留所信息
	 * **/
	public String addPrisonInfo(PrisonInfo info){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(info);
		info.setAddTime(new Date());
		info.setUpdateTime(new Date());
		//设置拘留所编码
		String prisonCode = this.createPrisonCode(info.getArea().getId());
		info.setPrisonCode(prisonCode);
		//设置公安机关代码
		Organization org = (Organization)dao.detail(Organization.class, info.getOrg().getId());
		info.setPublicSecurityOrganCode(org.getOrgCode());
		
		return dao.save(info);
	}
	
	/**
	 * 查询一条拘留所信息
	 * **/
	public PrisonInfo prisonInfoDetail(String id){
		return (PrisonInfo)dao.detail(PrisonInfo.class, id);
	}
	
	/**
	 * 废弃一条拘留所信息
	 * **/
	public void prisonInfoDel(String id){
		String hql = "update PrisonInfo set state=0 where id=?";
		dao.executeHql(hql, new Object[]{id});
	}
	
	/**
	 * 启用一条拘留所信息
	 * **/
	public void prisonInfoStart(String id){
		String hql = "update PrisonInfo set state=1 where id=?";
		dao.executeHql(hql, new Object[]{id});
	}
	
	/**
	 * 修改一条拘留所信息
	 * **/
	public void prisonInfoUpdate(PrisonInfo info){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(info);
		info.setUpdateTime(new Date());
		dao.update(info);
	}

	/**
	 * 生成拘留所编码
	 * @param areaId
	 * @return
	 */
	public String createPrisonCode(int areaId){
		Area area = (Area) dao.detail(Area.class, areaId);
		//查询该区域下已有拘留所数量，设置拘留所序号
		int count = dao.getCount("select count(*) from PrisonInfo where area.id=?", new Object[]{areaId});
		count++;
		char ch = 'A';
		String code = count+"";
		if(count >= 10){
			ch += count - 10;
			code = ch+"";
		}
		
		//第1-6位表示拘留所所在行政区划代码；
		//第7位表示归口类别；"1"表示各省、自治区、直辖市、公安厅、局。
		//第8位表示监管单位类型；"2"表示为拘留所。
		//第9为表示拘留所序号，代码自定
		String prionCode = area.getRegionCode()+"1"+"2"+code;
		
		return prionCode;
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


	public List<PrisonInfo> getInfoList() {
		return infoList;
	}

	public void setInfoList(List<PrisonInfo> infoList) {
		this.infoList = infoList;
	}

	//通过城市获取其拘留所信息
	public StringBuilder getPrisonInfoByArea(String cityId) {
		
//		"employees": [
//{ "firstName":"John" , "lastName":"Doe" },
//{ "firstName":"Anna" , "lastName":"Smith" },
//{ "firstName":"Peter" , "lastName":"Jones" }
//]
		String hql ="";
		Object[] obj;
		if(cityId !=null){
			hql="select prisonCode,prisonName from PrisonInfo where area.area.id = ?";
			obj = new Object[]{cityId};
		}else{
			hql="select prisonCode,prisonName from PrisonInfo";
			obj= new Object[]{};
		}
		
		StringBuilder sb = new StringBuilder("[");
		List list = dao.queryByHql(hql, obj);
		for(Iterator<Object[]> it = list.iterator();it.hasNext();){
			Object[] objs = it.next();
			sb.append("{\"id\":\""+objs[0]+"\",\"name\":\""+objs[1]+"\"}");
			if(it.hasNext()){
				sb.append(",");
			}
		}
		sb.append("]");
		return sb;
	}

	//显示拘留所的风貌图片
	public byte[] getImageById(String prisonId) {
		List<PrisonInfo> list = (List<PrisonInfo>) dao.queryByHql(
				"from PrisonInfo where id=? ",
				new Object[] { prisonId });
		return list.size() > 0 ? list.get(0).getPrisonImage() : null;
		
		
	}
}
