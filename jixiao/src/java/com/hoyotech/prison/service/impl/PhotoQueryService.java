package com.hoyotech.prison.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.hoyotech.prison.dao.impl.BasicDao;

public class PhotoQueryService {
	private BasicDao dao;
	
	public BasicDao getDao() {
		return dao;
	}

	public void setDao(BasicDao dao) {
		this.dao = dao;
	}

	public List<String> allPrisonersForPhoto(String documeNum, String name,
			String origionPlaceCode, String birthdayStartTime,
			String birthdayStopTime, String educationLevelId,
			String prison_id, String detentionCode, String inStartTime,
			String inStopTime, String outStartTime, String outStopTime,
			String inprisonReson, String outprisonReson, int pageNumber, int pageSize) {
		String hql = "select id from Prisoner where 1=1 ";
		List param = getParaCondition(documeNum,name,origionPlaceCode,birthdayStartTime,birthdayStopTime,educationLevelId,prison_id,detentionCode,inStartTime,
				inStopTime,outStartTime,outStopTime,inprisonReson,outprisonReson);
		String condition = getCondition(documeNum,name,origionPlaceCode,birthdayStartTime,birthdayStopTime,educationLevelId,prison_id,detentionCode,inStartTime,
				inStopTime,outStartTime,outStopTime,inprisonReson,outprisonReson);
		hql	+=	condition;
		
		//hql="select id from Prisoner where 1=1  and birthday > to_date('1980-05-05','yyyy-MM-dd')";
		//return (List<String>) dao.queryByHql(hql,null,pageNumber, pageSize);
		return (List<String>) dao.queryByHql(hql, param.toArray(), pageNumber, pageSize);
	}

	private String getCondition(String documeNum, String name,
			String origionPlaceCode, String birthdayStartTime,
			String birthdayStopTime, String educationLevelId,
			String prison_id, String detentionCode, String inStartTime,
			String inStopTime, String outStartTime, String outStopTime,
			String inprisonReson, String outprisonReson) {
		StringBuilder sb = new StringBuilder();
		if(documeNum!=null && !documeNum.equals("")){
			sb.append(" and documeNum like '%"+documeNum +"%'");
		}
		if(name!=null && !name.equals("")){
			sb.append(" and name like '%"+name +"%'");
		}
		if(origionPlaceCode!=null && !origionPlaceCode.equals("")){
			System.out.println(origionPlaceCode+"   1");
			sb.append(" and origionPlace.id = ?");
		}
		if(birthdayStartTime!=null && !birthdayStartTime.equals("")){
			sb.append(" and birthday > ?");
		}
		if(birthdayStopTime!=null && !birthdayStopTime.equals("")){
			sb.append(" and birthday < ?");
		}
		if(educationLevelId!=null && !educationLevelId.equals("")){
			System.out.println(educationLevelId+"    2");
			sb.append(" and educationLevel.id = ?");
		}
		if(prison_id!=null && !prison_id.equals("")){
			sb.append(" and prison.id = ?");
		}
		if(detentionCode!=null && !detentionCode.equals("")){
			sb.append(" and detentionInfo.detentionCode like '%"+detentionCode+"%'");
		}
		if(inStartTime!=null && !inStartTime.equals("")){
			sb.append(" and dateInprison >= ?");
		}
		if(inStopTime!=null && !inStopTime.equals("")){
			sb.append(" and dateInprison <= ?");
		}
		if(outStartTime!=null && !outStartTime.equals("")){
			sb.append(" and realityOutTime >= ?");
		}
		if(outStopTime!=null && !outStopTime.equals("")){
			sb.append(" and realityOutTime <= ?");
		}
		if(inprisonReson!=null && !inprisonReson.equals("")){
			sb.append(" and imprisonReason.id = ?");
		}
		if(outprisonReson!=null && !outprisonReson.equals("")){
			sb.append(" and outprisonReson.id = ?");
		}
		return sb.toString();
	}

	private List getParaCondition(String documeNum, String name,
			String origionPlaceCode, String birthdayStartTime,
			String birthdayStopTime, String educationLevelId,
			String prison_id, String detentionCode, String inStartTime,
			String inStopTime, String outStartTime, String outStopTime,
			String inprisonReson, String outprisonReson) {
		List list = new ArrayList();
		if(origionPlaceCode!=null && !origionPlaceCode.equals("")){
			list.add(origionPlaceCode);
		}
		if(birthdayStartTime!=null && !birthdayStartTime.equals("")){
			birthdayStartTime="to_date('"+birthdayStartTime+"','yyyy-MM-dd')";
			list.add(birthdayStartTime);
		}
		if(birthdayStopTime!=null && !birthdayStopTime.equals("")){
			birthdayStopTime="to_date('"+birthdayStopTime+"','yyyy-MM-dd')";
			list.add(birthdayStopTime);
		}
		if(educationLevelId!=null && !educationLevelId.equals("")){
			list.add(educationLevelId);
		}
		if(prison_id!=null && !prison_id.equals("")){
			list.add(prison_id);
		}
		if(inStartTime!=null && !inStartTime.equals("")){
			inStartTime="to_date('"+inStartTime+"','yyyy-MM-dd')";
			list.add(inStartTime);
		}
		if(inStopTime!=null && !inStopTime.equals("")){
			inStopTime="to_date('"+inStopTime+"','yyyy-MM-dd')";
			list.add(inStopTime);
		}
		if(outStartTime!=null && !outStartTime.equals("")){
			outStartTime="to_date('"+outStartTime+"','yyyy-MM-dd')";
			list.add(outStartTime);
		}
		if(outStopTime!=null && !outStopTime.equals("")){
			outStopTime="to_date('"+outStopTime+"','yyyy-MM-dd')";
			list.add(outStopTime);
		}
		if(inprisonReson!=null && !inprisonReson.equals("")){
			list.add(inprisonReson);
		}
		if(outprisonReson!=null && !outprisonReson.equals("")){
			list.add(outprisonReson);
		}
		return list;
	}

	public int allCount(String documeNum, String name, String origionPlaceCode,
			String birthdayStartTime, String birthdayStopTime,
			String educationLevelId, String prisonId, String detentionCode,
			String inStartTime, String inStopTime, String outStartTime,
			String outStopTime, String inprisonReson, String outprisonReson) {
		String hql = "select count(*) from Prisoner where 1=1 " ;
		List param = getParaCondition(documeNum,name,origionPlaceCode,birthdayStartTime,birthdayStopTime,educationLevelId,prisonId,detentionCode,inStartTime,
				inStopTime,outStartTime,outStopTime,inprisonReson,outprisonReson);
		String condition = getCondition(documeNum,name,origionPlaceCode,birthdayStartTime,birthdayStopTime,educationLevelId,prisonId,detentionCode,inStartTime,
				inStopTime,outStartTime,outStopTime,inprisonReson,outprisonReson);
		hql	+=	condition;
//		hql="select count(*) from Prisoner where 1=1  and birthday > to_date('1980-05-05','yyyy-MM-dd')";
//		return  10;
		return  dao.getCount(hql, param.toArray());
	}
}
