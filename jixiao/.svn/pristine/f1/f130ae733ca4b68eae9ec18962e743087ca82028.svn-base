package com.hoyotech.prison.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.hoyotech.prison.bean.Prisoner;
import com.hoyotech.prison.dao.impl.BasicDao;

public class ProvinceService {

	private BasicDao dao;
	/**
	 * 检索被拘留人信息
	 * **/
	public String getCondition(String priNum,String priName,String roomNum,String level,Date inTime,
			String detainState,String qiman,Date tiqian,String sex,Date chaoqi,Date outTime,String inReason,String waiji,String city_id){
		StringBuilder sb = new StringBuilder();
		if(sex != null && sex.length() > 0){
			sb.append(" and gender.id=?");
		}
		if(chaoqi != null){
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String date2=formatter.format(new Date());
			sb.append(" and dateOutprison < to_date('"+ date2+"','yyyy-MM-dd')");
		}
		if(outTime != null){
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String date2=formatter.format(new Date());
			sb.append(" and dateOutprison= to_date('"+ date2+"','yyyy-MM-dd')");
		}
		if(inReason != null && inReason.length() > 0){
			sb.append(" and imprisonReason.id=?");
		}
		if(waiji != null && waiji.length() > 0){
			sb.append(" and nationality.id>4");
		}
		if(priNum != null && priNum.length() > 0){
			sb.append(" and prisonCode=?");
		}
		if(priName != null && priName.length() > 0){
			sb.append(" and name like '%"+priName+"%'");
		}
		if(roomNum != null && roomNum.length() > 0){
			sb.append(" and detentionInfo.detentionCode=?");
		}
		if(level != null && level.length() > 0){
			sb.append(" and dangerLevel=?");
		}
		if(inTime != null){
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String date1=formatter.format(new Date());
			sb.append(" and dateInprison= to_date('"+ date1+"','yyyy-MM-dd')");
		}
		if(tiqian != null){
			sb.append(" and realityOutTime<dateOutprison");
		}
		if(qiman != null){
			sb.append(" and outprisonReson.id= '"+qiman+"'");
		}
		sb.append(" and state=?");
		if(city_id!=null && city_id.length()>0){
			sb.append("and prison.area.area.id = ?");
		}
		
		return sb.toString();
	}
	/**
	 * 检索信息所需要的条件
	 * **/
	public List<String> getParaCondition(String priNum,String priName,String roomNum,String level,Date inTime,String detainState,String qiman,Date tiqian,String sex,String inReason,String city_id){
		List<String> list = new ArrayList<String>();
		if(sex != null && sex.length() > 0){
			list.add(sex);
		}
		if(inReason != null && inReason.length() > 0){
			list.add(inReason);
		}
		
		if(priNum != null && priNum.length() > 0){
			list.add(priNum);
		}
//		if(priName != null && priName.length() > 0){
//			list.add(priName);
//		}
		if(roomNum != null && roomNum.length() > 0){
			list.add(roomNum);
		}
		if(level != null && level.length() > 0){
			list.add(level);
		}
		
		if(detainState != null && detainState.length() > 0){
			list.add(detainState);
		}else{
			list.add("1");
		}
		if(city_id!=null && city_id.length()>0){
			list.add(city_id);
		}
		
		return list;
	}
	
	/**
	 * 查询被拘留人信息
	 * **/
	public List<Prisoner> allPrisoners(String priNum,String priName,String roomNum,String level,Date inTime,String detainState,String qiman,Date tiqian,int pageNumber,int pageSize){
		List<String> param = getParaCondition(priNum, priName, roomNum, level,inTime,detainState,qiman,tiqian,null,null,null);
		String condition = getCondition(priNum, priName, roomNum, level,inTime,detainState,qiman,tiqian,null,null,null,null,null,null);
		String hql = "from Prisoner where 1=1"+condition+" order by updateTime desc";
		return (List<Prisoner>)dao.queryByHql(hql, param.toArray(), pageNumber, pageSize);
	}
	
	/**
	 * 查询请假回所的被拘留人信息
	 * **/
	public List<Prisoner> qingjiahuisuo(int pageNumber,int pageSize){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String date1=formatter.format(new Date());
		String hql = "from Prisoner where id in(select prisoner.id from OutPrison where endTime= '"+date1+"' ) order by updateTime desc";
		return (List<Prisoner>)dao.queryByHql(hql, new Object[]{}, pageNumber, pageSize);
	}
	
	/**
	 * 查询外出就医的被拘留人信息
	 * **/
	public List<Prisoner> waiyi(int pageNumber,int pageSize){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String date1=formatter.format(new Date());
		String hql = "from Prisoner where id in(select name.id from OutDoctor where outTime<='"+date1+"' and backTime >='"+date1+"') order by updateTime desc";
		return (List<Prisoner>)dao.queryByHql(hql, new Object[]{}, pageNumber, pageSize);
	}
	
	/**
	 * 查询一条被拘留人信息
	 * **/
	public Prisoner detail(String id){
		return (Prisoner)dao.detail(Prisoner.class, id);
	}
	
	/**
	 * 查询省厅今日事务的人数
	 * **/
	public int countPrisoner(String priNum,String priName,String roomNum,String level,Date inTime,String detainState,
			String qiman,Date tiqian,String sex,Date chaoqi,Date outTime,String inReason,String waiji,String city_id){
		List<String> param = getParaCondition(priNum, priName, roomNum, level,inTime,detainState,qiman,tiqian,sex,inReason,city_id);
		String condition = getCondition(priNum, priName, roomNum, level,inTime,detainState,qiman,tiqian,sex,chaoqi,outTime,inReason,waiji,city_id);
		String hql = "select count(*) from Prisoner where 1=1"+condition;
		return dao.getCount(hql, param.toArray());
	}

	/**
	 * 查询请假回所人数
	 * **/
	public int huisuo(String prisonCode){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String date1=formatter.format(new Date());
		String hql = "select count(*) from OutPrison where endTime=to_date('"+ date1+"','yyyy-MM-dd')";
		if(prisonCode!=null){
			hql+=" and prisonCode='"+prisonCode+"'";
		}
		return dao.getCount(hql, new Object[]{});
	}
	
	/**
	 * 查询请假超期未归的人数
	 * **/
	public int leaveLater(String prisonCode){
		String hql = "select count(*) from LeaveExpires where condition='逾期未归'";
		if(prisonCode!=null){
			hql+=" and prisonCode = '"+prisonCode+"'";
		}
		return dao.getCount(hql, new Object[]{});
	}
	
	/**
	 * 查询外出就医人数
	 * **/
	public int outDoctor(String prisonCode){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String date1=formatter.format(new Date());
		String hql = "select count(*) from OutDoctor where outTime<=to_date('"+ date1+"','yyyy-MM-dd') and backTime >=to_date('"+ date1+"','yyyy-MM-dd')";
		if(prisonCode!=null){
			hql+="and prisonCode = '"+prisonCode+"'";
		}
		return dao.getCount(hql, new Object[]{});
	}
	
	/**
	 * 统计性别人数
	 * **/
	public List sex(){
		String hql = "select p.gender.description as a,count(*) as b from Prisoner p where p.state!=0 and (p.gender.id=12 or p.gender.id=13) group by p.gender.description";
		return dao.queryByHql(hql, new Object[]{});
	}
	
	/**
	 * 统计某一天的在拘人数
	 * **/
	public List inOneDay(String date){
		String hql = "select p.gender.id as a,count(*) as b from Prisoner p where p.state!=0 and (p.gender.id=12 or p.gender.id=13) and dateInprison < to_date('"+date+" 23:59:59','yyyy-MM-dd hh24:mi:ss') and (realityOutTime > to_date('"+date+" 23:59:59','yyyy-MM-dd hh24:mi:ss') or realityOutTime is NULL) group by p.gender.id";
		return dao.queryByHql(hql, new Object[]{});
	}
	//select count(*) from Prisoner where dateInprison < '"+date+" 23:59:59' and (realityOutTime > '"+date+" 23:59:59' or realityOutTime is NULL) and state!=0
	public BasicDao getDao() {
		return dao;
	}

	public void setDao(BasicDao dao) {
		this.dao = dao;
	}
	
	//获取曲线图的数据
	public String getQXT(String prisonCode, String qxstat) {
		String hql = "select count(*) from Prisoner where s ";
		if(prisonCode!=null && prisonCode.length()>0){
			
		}
		if(qxstat!=null && qxstat.equals("")){
			hql+= " ";
		}
		List list =dao.queryByHql(hql, new Object[]{});
		
		return null;
	}
}
