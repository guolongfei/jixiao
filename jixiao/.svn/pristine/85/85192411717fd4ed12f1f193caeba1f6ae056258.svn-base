package com.hoyotech.prison.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.PrisonInfo;
import com.hoyotech.prison.bean.Prisoner;
import com.hoyotech.prison.dao.impl.BasicDao;

public class AnalysisService {
	private BasicDao dao;

	public String getCondition(String state, String age, String sex,
			String status, String marry, String edu, String crime,
			String startTime, String endTime, String prisonCon,
			String prisonCode) {
		StringBuilder sb = new StringBuilder();
		if (state != null && state.length() > 0) {
			sb.append(" and state=" + state);
		} else {
			sb.append(" and state!=0");
		}

		if (prisonCon != null && prisonCon.length() > 0) {
			sb.append(" and prisonCode=" + prisonCon);
		}

		if (age != null && age.length() > 0) {
			if (age.equals("1810")) {
				sb.append(" and age<18");
			} else if (age.equals("25")) {
				sb.append(" and age>=18 and age<=25");
			} else if (age.equals("351")) {
				sb.append(" and age>=26 and age<=35");
			} else if (age.equals("361")) {
				sb.append(" and age>=36 and age<=60");
			} else if (age.equals("601")) {
				sb.append(" and age>60");
			}
		}

		if (sex != null && sex.length() > 0) {
			sb.append(" and gender.id=" + sex);
		}
		if (crime != null && crime.length() > 0) {
			sb.append(" and crime.id=" + crime);
		}

		if (status != null && status.length() > 0) {
			sb.append(" and status.id=" + status);
		}
		if (marry != null && marry.length() > 0) {
			sb.append(" and marryStatus.id=" + marry);
		}
		if (edu != null && edu.length() > 0) {
			sb.append(" and educationLevel.id=" + edu);
		}

		if (startTime != null && startTime.length() > 0) {
			sb.append(" and dateInprison >=to_date('" + startTime + "','yyyy-MM-dd')");
		}

		if (endTime != null && endTime.length() > 0) {
			sb.append(" and dateInprison <=to_date('" + endTime + "','yyyy-MM-dd')");
		}

		HttpServletRequest request = ServletActionContext.getRequest();
		String type = (String) request.getSession().getAttribute("orgType");
		if ("1".equals(type)) {
			if (prisonCode != null && prisonCode.length() > 0) {
				sb.append(" and prisonCode='" + prisonCode+"'");
			}
		}
		return sb.toString();
	}

	public String getSqlCondition(String state, String age, String sex,
			String status, String marry, String edu, String crime,
			String startTime, String endTime, String prisonCon,
			String prisonCode) {
		StringBuilder sb = new StringBuilder();
		if (state != null && state.length() > 0) {
			sb.append(" and state=" + state);
		} else {
			sb.append(" and state!=0");
		}
		if (prisonCon != null && prisonCon.length() > 0) {
			sb.append(" and prison_code=" + prisonCon);
		}
		if (age != null && age.length() > 0) {
			if (age.equals("1810")) {
				sb.append(" and age<18");
			} else if (age.equals("25")) {
				sb.append(" and age>=18 and age<=25");
			} else if (age.equals("351")) {
				sb.append(" and age>=26 and age<=35");
			} else if (age.equals("361")) {
				sb.append(" and age>=36 and age<=60");
			} else if (age.equals("601")) {
				sb.append(" and age>60");
			}
		}

		if (sex != null && sex.length() > 0) {
			sb.append(" and gender=" + sex);
		}

		if (crime != null && crime.length() > 0) {
			sb.append(" and crime=" + crime);
		}

		if (status != null && status.length() > 0) {
			sb.append(" and status=" + status);
		}
		if (marry != null && marry.length() > 0) {
			sb.append(" and marry_status=" + marry);
		}
		if (edu != null && edu.length() > 0) {
			sb.append(" and education_level=" + edu);
		}

		HttpServletRequest request = ServletActionContext.getRequest();
		String type = (String) request.getSession().getAttribute("orgType");
		if ("1".equals(type)) {
			if (prisonCode != null && prisonCode.length() > 0) {
				sb.append(" and prison_code=" + prisonCode);
			}
		}

		if (startTime != null && startTime.length() > 0) {
			sb.append(" and date_inprison >=to_date('" + startTime + "','yyyy-MM-dd')");
		}

		if (endTime != null && endTime.length() > 0) {
			sb.append(" and date_inprison <=to_date('" + endTime + "','yyyy-MM-dd')");
		}

		return sb.toString();
	}

	/**
	 * 查询所有的拘留所
	 * **/
	public List<PrisonInfo> allPrion() {
		String hql = "from PrisonInfo ";
		return (List<PrisonInfo>) dao.queryByHql(hql, new Object[] {});
	}

	/**
	 * 查询被拘留人列表
	 * **/
	public List<Prisoner> allPrisoner(String state, String age, String sex,
			String status, String marry, String edu, String crime,
			int pageNumber, int pageSize, String startTime, String endTime,
			String prisonCon, String prisonCode) {
		String condition = this.getCondition(state, age, sex, status, marry,
				edu, crime, startTime, endTime, prisonCon, prisonCode);
		String hql = "from Prisoner where 1=1 " + condition;
		return (List<Prisoner>) dao.queryByHql(hql, new Object[] {},
				pageNumber, pageSize);
	}

	/**
	 * 统计总数
	 * **/
	public List<Object> allCount(String state, String age, String sex,
			String status, String marry, String edu, String crime,
			String startTime, String endTime, String prisonCon,
			String prisonCode) {
		String condition = this.getSqlCondition(state, age, sex, status, marry,
				edu, crime, startTime, endTime, prisonCon, prisonCode);
		String hql = "select count(*) as count from prisoner where 1=1 "
				+ condition;
		System.out.println(hql);
		return (List<Object>) dao.queryBySql(hql, new Object[] {});
	}

	/**
	 * 统计犯罪行为人数
	 * @param aflag 
	 * **/
	public List<Object> imprisonReasonNum(String state, String age, String sex,
			String status, String marry, String edu, String crime,
			String startTime, String endTime, String prisonCon,
			String prisonCode, String aflag) {
		String condition = this.getCondition(state, age, sex, status, marry,
				edu, crime, startTime, endTime, prisonCon, prisonCode);
		String reason = "";
		if(aflag.equals("in")){
			reason ="p.imprisonReason.description";
		}else if(aflag.equals("out")){
			reason ="p.outprisonReson.description";
		}
		String hql = "select "+reason+" as a,count(*) as b from Prisoner p where 1=1"
				+ condition + " group by "+reason;
		return (List<Object>) dao.queryByHql(hql, new Object[] {});
	}
	
	
	/**
	 * 统计犯罪行为
	 * **/
	public List crime(String state, String age, String sex, String status,
			String marry, String edu, String crime, String startTime,
			String endTime, String prisonCon, String prisonCode) {
		String condition = this.getCondition(state, age, sex, status, marry,
				edu, crime, startTime, endTime, prisonCon, prisonCode);
		String hql = "select p.crime.description as a,count(*) as b from Prisoner p where 1=1"
				+ condition + " group by p.crime.description";
		return (List) dao.queryByHql(hql, new Object[] {});
	}

	/**
	 * 统计拘留所人数
	 * **/
	public List prison(String state, String age, String sex, String status,
			String marry, String edu, String crime, String startTime,
			String endTime, String prisonCon, String prisonCode) {
		String condition = this.getCondition(state, age, sex, status, marry,
				edu, crime, startTime, endTime, prisonCon, prisonCode);
		String hql = "select p.prison.prisonName as a,count(*) as b from Prisoner p where 1=1"
				+ condition + " group by p.prison.prisonName";
		return (List) dao.queryByHql(hql, new Object[] {});
	}

	/**
	 * 统计性别人数
	 * **/
	public List sex(String state, String age, String sex, String status,
			String marry, String edu, String crime, String startTime,
			String endTime, String prisonCon, String prisonCode) {
		String condition = this.getCondition(state, age, sex, status, marry,
				edu, crime, startTime, endTime, prisonCon, prisonCode);
		String hql = "select p.gender.description as a,count(*) as b from Prisoner p where 1=1"
				+ condition + " group by p.gender.description";
		return (List) dao.queryByHql(hql, new Object[] {});
	}

	/**
	 * 统计婚姻状况人数
	 * **/
	public List marry(String state, String age, String sex, String status,
			String marry, String edu, String crime, String startTime,
			String endTime, String prisonCon, String prisonCode) {
		String condition = this.getCondition(state, age, sex, status, marry,
				edu, crime, startTime, endTime, prisonCon, prisonCode);
		String hql = "select p.marryStatus.description as a,count(*) as b from Prisoner p where 1=1"
				+ condition + " group by p.marryStatus.description";
		return (List) dao.queryByHql(hql, new Object[] {});
	}

	/**
	 * 统计文化程度人数
	 * **/
	public List education(String state, String age, String sex, String status,
			String marry, String edu, String crime, String startTime,
			String endTime, String prisonCon, String prisonCode) {
		String condition = this.getCondition(state, age, sex, status, marry,
				edu, crime, startTime, endTime, prisonCon, prisonCode);
		String hql = "select p.educationLevel.description as a,count(*) as b from Prisoner p where 1=1"
				+ condition + " group by p.educationLevel.description";
		return (List) dao.queryByHql(hql, new Object[] {});
	}

	/**
	 * 统计身份人数
	 * **/
	public List<Object> shenfen(String state, String age, String sex,
			String status, String marry, String edu, String crime,
			String startTime, String endTime, String prisonCon,
			String prisonCode) {
		String condition = this.getCondition(state, age, sex, status, marry,
				edu, crime, startTime, endTime, prisonCon, prisonCode);
		String hql = "select p.status.description as a,count(*) as b from Prisoner p where 1=1"
				+ condition + " group by p.status.description";
		return (List<Object>) dao.queryByHql(hql, new Object[] {});
	}

	/**
	 * 统计年龄段人数
	 * **/
	public List<Object> age(String state, String age, String sex,
			String status, String marry, String edu, String crime,
			String startTime, String endTime, String prisonCon,
			String prisonCode) {
		String condition = this.getSqlCondition(state, age, sex, status, marry,
				edu, crime, startTime, endTime, prisonCon, prisonCode);
		String hql = "select nnd as d,count(*) as b from (select case when age<18 then '18以下' when age>=18 and age<=25 then '18-25'"
				+ "when age>=26 and age<=35 then '26-35'"
				+ "when age>=36 and age<=60 then '36-60'"
				+ "when age>60 then '60以上'"
				+ "when age is NULL then '其他'"
				+ "end as nnd from prisoner where 1=1"
				+ condition
				+ ") a group by nnd";
		return (List<Object>) dao.queryBySql(hql, new Object[] {});
	}

	// 此处以上的数据图的查询，下面是人数的查询

	/**
	 * 统计状态人数
	 * **/
	public List<Object> stateNum(String state, String age, String sex,
			String status, String marry, String edu, String crime,
			String startTime, String endTime, String prisonCon,
			String prisonCode) {
		String condition = this.getCondition(state, age, sex, status, marry,
				edu, crime, startTime, endTime, prisonCon, prisonCode);
		String hql = "select p.state as a,count(*) as b from Prisoner p where 1=1"
				+ condition + " group by p.state";
		return (List<Object>) dao.queryByHql(hql, new Object[] {});
	}

	/**
	 * 统计性别人数
	 * **/
	public List sexNum(String state, String age, String sex, String status,
			String marry, String edu, String crime, String startTime,
			String endTime, String prisonCon, String prisonCode) {
		String condition = this.getCondition(state, age, sex, status, marry,
				edu, crime, startTime, endTime, prisonCon, prisonCode);
		String hql = "select p.gender.id as a,count(*) as b from Prisoner p where 1=1"
				+ condition + " group by p.gender.id";
		return (List) dao.queryByHql(hql, new Object[] {});
	}

	/**
	 * 统计拘留所人数
	 * **/
	public List prisonNum(String state, String age, String sex, String status,
			String marry, String edu, String crime, String startTime,
			String endTime, String prisonCon, String prisonCode) {
		String condition = this.getCondition(state, age, sex, status, marry,
				edu, crime, startTime, endTime, prisonCon, prisonCode);
		String hql = "select p.prisonCode as a,count(*) as b from Prisoner p where 1=1"
				+ condition + " group by p.prisonCode";
		return (List) dao.queryByHql(hql, new Object[] {});
	}

	/**
	 * 统计犯罪行为人数
	 * **/
	public List<Object> crimeNum(String state, String age, String sex,
			String status, String marry, String edu, String crime,
			String startTime, String endTime, String prisonCon,
			String prisonCode) {
		String condition = this.getCondition(state, age, sex, status, marry,
				edu, crime, startTime, endTime, prisonCon, prisonCode);
		String hql = "select p.crime.id as a,count(*) as b from Prisoner p where 1=1"
				+ condition + " group by p.crime.id";
		return (List<Object>) dao.queryByHql(hql, new Object[] {});
	}



	/**
	 * 统计婚姻状况人数
	 * **/
	public List marryNum(String state, String age, String sex, String status,
			String marry, String edu, String crime, String startTime,
			String endTime, String prisonCon, String prisonCode) {
		String condition = this.getCondition(state, age, sex, status, marry,
				edu, crime, startTime, endTime, prisonCon, prisonCode);
		String hql = "select p.marryStatus.id as a,count(*) as b from Prisoner p where 1=1"
				+ condition + " group by p.marryStatus.id";
		return (List) dao.queryByHql(hql, new Object[] {});
	}

	/**
	 * 统计文化程度人数
	 * **/
	public List educationNum(String state, String age, String sex,
			String status, String marry, String edu, String crime,
			String startTime, String endTime, String prisonCon,
			String prisonCode) {
		String condition = this.getCondition(state, age, sex, status, marry,
				edu, crime, startTime, endTime, prisonCon, prisonCode);
		String hql = "select p.educationLevel.id as a,count(*) as b from Prisoner p where 1=1"
				+ condition + " group by p.educationLevel.id";
		return (List) dao.queryByHql(hql, new Object[] {});
	}

	/**
	 * 统计身份人数
	 * **/
	public List<Object> statusNum(String state, String age, String sex,
			String status, String marry, String edu, String crime,
			String startTime, String endTime, String prisonCon,
			String prisonCode) {
		String condition = this.getCondition(state, age, sex, status, marry,
				edu, crime, startTime, endTime, prisonCon, prisonCode);
		String hql = "select p.status.id as a,count(*) as b from Prisoner p where 1=1"
				+ condition + " group by p.status.id";
		return (List<Object>) dao.queryByHql(hql, new Object[] {});
	}

	/**
	 * 统计年龄段人数
	 * **/
	public List<Object> ageNum(String state, String age, String sex,
			String status, String marry, String edu, String crime,
			String startTime, String endTime, String prisonCon,
			String prisonCode) {
		String condition = this.getSqlCondition(state, age, sex, status, marry,
				edu, crime, startTime, endTime, prisonCon, prisonCode);
		String hql = "select nnd as d,count(*) as b from (select case when age<18 then '1810' when age>=18 and age<=25 then '25'"
				+ "when age>=26 and age<=35 then '351'"
				+ "when age>=36 and age<=60 then '361'"
				+ "when age>60 then '601'"
				+ "end as nnd from prisoner where 1=1"
				+ condition
				+ ") a group by nnd";
		return (List<Object>) dao.queryBySql(hql, new Object[] {});
	}

	public BasicDao getDao() {
		return dao;
	}

	public void setDao(BasicDao dao) {
		this.dao = dao;
	}

	public StringBuilder getWarningInfoList(String cityId, String prisonId) {
		StringBuilder sb = new StringBuilder("{");
		StringBuilder hql = new StringBuilder("select count(*) from Prisoner where state = 1 ");
		StringBuilder hql2 = new StringBuilder("select sum(designCapacity) from PrisonInfo where 1=1 ");
		List list = new ArrayList();
		if(cityId!= null &&!cityId.equals("")){
			hql.append("and prison.area.area.id = ? ");
			hql2.append(" and area.area.id = ?");
			list.add(cityId);
		}
		if(prisonId!=null && !prisonId.equals("")){
		//	hql2 += " and area.area.id = ?";
		//	hql += "and prison.area.area.id = ? ";
			hql.append(" and prison.prisonCode = ? ");
			hql2.append(" and prisonCode = ?");
			list.add(prisonId);
		}
		
		int b =dao.getCount(hql2.toString(), list.toArray());
		if(b==0){
			sb.append("\"error\":\"0\"");
			sb.append("}");
			return sb;
		}
		// 0为未开发 1:正常 2:预警 3:报警
		// 总体预警
		sb.append("\"ztyj\":\"0\"");
		// 押量预警
		int a =dao.getCount(hql.toString(), list.toArray());
		float f = 0;
			f= (float)a/b;
			if (f >= 0 && f <= 0.5) {
				sb.append(",\"ylyj\":\"1\""); 
			} else if (f > 0.5 && f <= 0.8) {
				sb.append(",\"ylyj\":\"2\""); 
			} else if(f > 0.8 && f<=1){
				sb.append(",\"ylyj\":\"3\""); 	
			}
		// 队伍建设
		sb.append(",\"dwjs\":\"0\"");
		// 危险人物
		sb.append(",\"wxry\":\"0\"");
		// 制度落实
		sb.append(",\"zdls\":\"0\"");
		// 安全设施
		sb.append(",\"aqss\":\"0\"");
		// 设备预警
		sb.append(",\"sbyj\":\"0\"");
		
		sb.append("}");
		return sb;
	}

 
}
