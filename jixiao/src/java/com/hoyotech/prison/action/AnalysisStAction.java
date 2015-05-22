package com.hoyotech.prison.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.hoyotech.prison.bean.Dictionary;
import com.hoyotech.prison.bean.PrisonInfo;
import com.hoyotech.prison.bean.Prisoner;
import com.hoyotech.prison.model.AnalysisInfo;
import com.hoyotech.prison.service.impl.AnalysisService;
import com.hoyotech.prison.service.impl.DictionaryService;
import com.hoyotech.prison.service.impl.PrisonInfoService;
import com.hoyotech.prison.service.impl.ProvinceService;
import com.hoyotech.prison.util.PrisonUtil;
import com.hoyotech.prison.util.Type;
import com.isa.pims.basic.ServletRequestUtils;

public class AnalysisStAction {
	private AnalysisService analysisService;
	private DictionaryService dictionaryService;
	private List<Dictionary> gender; // 性别
	private List<Dictionary> marryStatus; // 婚姻状况
	private List<Dictionary> eduLevel; // 文化程度
	private List<Dictionary> status; // 身份
	private List<Dictionary> crimes; // 犯罪行为
	private List<PrisonInfo> prisonList; // 拘留所
	private String resultName = "";
	private String resultNum = "";
	private String genderType;
	private String marryType;
	private String endType;
	private String statusType;
	private String ageType;
	private StringBuilder sb;
	private StringBuilder sb2;
	private String ageCon;
	private String sexCon;
	private String statusCon;
	private String marryCon;
	private String stateCon;
	private String eduCon;
	private String crimeCon;
	private String prisonCon;
	private String startTime;
	private String endTime;
	private List<Prisoner> prisonerList;
	private int pageNum;
	private int limit;
	private int totalPage;
	private int totalNum;
	private Integer he = 0;
	private String prisonCode;
	private List<AnalysisInfo> asilist = new ArrayList<AnalysisInfo>();
	private String aflag;// 区别分析收押或出所的字段
	private String city_id;
	private PrisonInfoService prisonService;

	

	public PrisonInfoService getPrisonService() {
		return prisonService;
	}

	public void setPrisonService(PrisonInfoService prisonService) {
		this.prisonService = prisonService;
	}

	public ProvinceService getProvinceService() {
		return provinceService;
	}

	public void setProvinceService(ProvinceService provinceService) {
		this.provinceService = provinceService;
	}

	public String getCity_id() {
		return city_id;
	}

	public void setCity_id(String cityId) {
		city_id = cityId;
	}

	public String getAflag() {
		return aflag;
	}

	public void setAflag(String aflag) {
		this.aflag = aflag;
	}

	public List<AnalysisInfo> getAsilist() {
		return asilist;
	}

	public void setAsilist(List<AnalysisInfo> asilist) {
		this.asilist = asilist;
	}

	public String getPrisonCode() {
		return prisonCode;
	}

	public void setPrisonCode(String prisonCode) {
		this.prisonCode = prisonCode;
	}

	public String select() {
		initDict();
		return "success";
	}

	public String inAnalysis() {
		aflag = "in";
		return "inanalysis";
	}

	public String outAnalysis() {
		aflag = "out";
		return "outanalysis";
	}
	
	public String classifyAnalysis() {
		return "classifyAnalysis";
	}
	
	public String statisticsAnalysis() {
		return "statisticsAnalysis";
	}
	
	private ProvinceService provinceService;
	
	
	// 预警分析
	public void warning() {
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("UTF-8");
			StringBuilder sb = analysisService.getWarningInfoList(city_id,prisonCode);
 			PrintWriter out = response.getWriter();
			out.println(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 获取收押分析数据的列表
	public String getAnalysisList() {
			HttpServletRequest request = ServletActionContext.getRequest();
			pageNum = ServletRequestUtils.getInt(request, "pageNum", "1");
			limit = ServletRequestUtils.getInt(request, "limit", "20");
			// 收押分析
			if(aflag.equals("in")){
				stateCon = "1";
			}else if(aflag.equals("out")){
				stateCon = "3";
			}
			List count = analysisService.allCount(stateCon, ageCon, sexCon,
					statusCon, marryCon, eduCon, crimeCon, startTime, endTime,
					prisonCon, prisonCode);
			List al = analysisService.imprisonReasonNum(stateCon, ageCon,
					sexCon, statusCon, marryCon, eduCon, crimeCon, startTime,
					endTime, prisonCon, prisonCode,aflag);
			totalNum = al.size();
			// for(Iterator<Dictionary> item = list.iterator();item.hasNext();){
			// Dictionary d =item.next();
			for (Iterator<Object> it = al.iterator(); it.hasNext();) {
				AnalysisInfo aif = new AnalysisInfo();
				// 第一个是Dictionary类型 第二个是犯罪类型的总数
				Object[] obj = (Object[]) it.next();
				aif.setImprisonReason(obj[0].toString());
				aif.setCount(Integer.parseInt(obj[1].toString()));
				aif.setAllCount(Integer.valueOf(count.get(0).toString()));
				//aif.setAllCount((Integer) count.get(0));
				double ac = (double) aif.getCount() * 100 / aif.getAllCount();
				DecimalFormat df = new DecimalFormat("##.##");
				String st = df.format(ac);
				aif.setPercent(st + "%");
				asilist.add(aif);
			}
			// }
			totalPage = (totalNum - 1) / limit + 1;
		return "st_analysis_list";
	}

	// public void allCount() throws Exception{
	// HttpServletRequest request = ServletActionContext.getRequest();
	// String prisonCode=PrisonUtil.getPrisonCode(request);
	// //统计总数
	// List
	// count=analysisService.allCount(stateCon,ageCon,sexCon,statusCon,marryCon,eduCon,prisonCode);
	// if(count.size()>0){
	// if(!String.valueOf(count.get(0)).equals("0")){
	// he=(Integer)count.get(0);
	// }
	// }
	// }

	public void crimeAjax() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode = PrisonUtil.getPrisonCode(request);
		// 统计犯罪行为
		sb = new StringBuilder();
		sb2 = new StringBuilder();
		List sexNum = analysisService.crime(stateCon, ageCon, sexCon,
				statusCon, marryCon, eduCon, crimeCon, startTime, endTime,
				prisonCon, prisonCode);
		for (int i = 0; i < sexNum.size(); i++) {
			Object[] obj1 = (Object[]) sexNum.get(i);
			sb.append(obj1[0].toString() + ",");
			sb2.append(obj1[1].toString() + ",");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb2.deleteCharAt(sb2.length() - 1);
		resultName = sb.toString();
		resultNum = sb2.toString();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		try {
			PrintWriter out = response.getWriter();
			out.println("{\"resultName\":\"" + resultName
					+ "\",\"resultNum\":\"" + resultNum + "\"}");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getInfoByPrison(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		try {
			PrintWriter out = response.getWriter();
 			String infojson = "{"+getCountStr(null)+"}";
 			out.println(infojson);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//获取拘留所的人员数
	private String getCountStr(String city_id){
			int rusuo=provinceService.countPrisoner(prisonCode,null,null,null,new Date(), null,null,null,null,null,null,null,null,city_id);
		// 请假回所
//			int qingjiahuisuo=provinceService.huisuo(prisonCode);
//			int waiyi=provinceService.outDoctor(prisonCode);
//			int qiman=provinceService.countPrisoner(prisonCode,null,null,null,null, "3","107",null,null,null,null,null,null);
//			int tiqian=provinceService.countPrisoner(prisonCode,null,null,null,null, "3",null,new Date(),null,null,null,null,null);
			int qingjia=provinceService.countPrisoner(prisonCode,null,null,null,null, "2",null,null,null,null,null,null,null,city_id);
//			int siwang=provinceService.countPrisoner(prisonCode,null,null,null,null, "4",null,null,null,null,null,null,null);
			int zaiju=provinceService.countPrisoner(prisonCode,null,null,null,null, "1",null,null,null,null,null,null,null,city_id);
			int manNum=provinceService.countPrisoner(prisonCode,null,null,null,null, "1",null,null,"13",null,null,null,null,city_id);
			int womanNum=provinceService.countPrisoner(prisonCode,null,null,null,null, "1",null,null,"12",null,null,null,null,city_id);
			int chaoqi=provinceService.countPrisoner(prisonCode,null,null,null,null, "1",null,null,null,new Date(),null,null,null,city_id);
			int todayOut=provinceService.countPrisoner(prisonCode,null,null,null,null, "1",null,null,null,null,new Date(),null,null,city_id);
			int xingzheng=provinceService.countPrisoner(prisonCode,null,null,null,null, "1",null,null,null,null,null,"20",null,city_id);
			int sifa=provinceService.countPrisoner(prisonCode,null,null,null,null, "1",null,null,null,null,null,"21",null,city_id);
			int waiji=provinceService.countPrisoner(prisonCode,null,null,null,null, "1",null,null,null,null,null,null,"21",city_id);
			int backLater=provinceService.leaveLater(prisonCode);
			int shencha=provinceService.countPrisoner(prisonCode,null,null,null,null, "1",null,null,null,null,null,"22",null,city_id);
			return "\"zaiju\":\""+zaiju+"\",\"manNum\":\""+manNum+"\", \"womanNum\":\""+womanNum+"\",\"chaoqi\":\""+chaoqi+"\",\"rusuo\":\""+rusuo+"\",\"todayOut\":\""+todayOut+"\",\"xingzheng\":\""+xingzheng+"\",\"sifa\":\""+sifa+"\",\"waiji\":\""+waiji+"\",\"backLater\":\""+backLater+"\",\"shencha\":\""+shencha+"\",\"qingjia\":\""+qingjia+"\"";
	}

	private String qxstat;
	
	//最近一周的押量分析  //最近一月的押量分析
	public void getQXT(){
		String str =provinceService.getQXT(prisonCode,qxstat);
		
		
	}
	
	//获取城市下的拘留所信息
	public void getPrisonInfoList(){
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("UTF-8");
			StringBuilder sb = new StringBuilder("{\"pridata\":");
			sb.append(prisonService.getPrisonInfoByArea(city_id));
			sb.append(","+getCountStr(city_id)+"}");
			PrintWriter out = response.getWriter();
			out.println(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

	public void prisonAjax() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode = PrisonUtil.getPrisonCode(request);
		// 统计拘留所人数
		sb = new StringBuilder();
		sb2 = new StringBuilder();
		List sexNum = analysisService.prison(stateCon, ageCon, sexCon,
				statusCon, marryCon, eduCon, crimeCon, startTime, endTime,
				prisonCon, prisonCode);
		for (int i = 0; i < sexNum.size(); i++) {
			Object[] obj1 = (Object[]) sexNum.get(i);
			sb.append(obj1[0].toString() + ",");
			sb2.append(obj1[1].toString() + ",");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb2.deleteCharAt(sb2.length() - 1);
		resultName = sb.toString();
		resultNum = sb2.toString();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		try {
			PrintWriter out = response.getWriter();
			out.println("{\"resultName\":\"" + resultName
					+ "\",\"resultNum\":\"" + resultNum + "\"}");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sexAjax() throws Exception {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode = PrisonUtil.getPrisonCode(request);
		// 统计性别
		sb = new StringBuilder();
		sb2 = new StringBuilder();
		List sexNum = analysisService.sex(stateCon, ageCon, sexCon, statusCon,
				marryCon, eduCon, crimeCon, startTime, endTime, prisonCon,
				prisonCode);
		for (int i = 0; i < sexNum.size(); i++) {
			Object[] obj1 = (Object[]) sexNum.get(i);
			sb.append(obj1[0].toString() + ",");
			sb2.append(obj1[1].toString() + ",");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb2.deleteCharAt(sb2.length() - 1);
		resultName = sb.toString();
		resultNum = sb2.toString();

		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		try {
			PrintWriter out = response.getWriter();
			out.println("{\"resultName\":\"" + resultName
					+ "\",\"resultNum\":\"" + resultNum + "\"}");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void marryAjax() throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode = PrisonUtil.getPrisonCode(request);
		// 统计婚姻状况
		sb = new StringBuilder();
		sb2 = new StringBuilder();
		List marry = analysisService.marry(stateCon, ageCon, sexCon, statusCon,
				marryCon, eduCon, crimeCon, startTime, endTime, prisonCon,
				prisonCode);
		for (int i = 0; i < marry.size(); i++) {
			Object[] obj2 = (Object[]) marry.get(i);
			sb.append(obj2[0].toString() + ",");
			sb2.append(obj2[1].toString() + ",");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb2.deleteCharAt(sb2.length() - 1);
		resultName = sb.toString();
		resultNum = sb2.toString();

		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		try {
			PrintWriter out = response.getWriter();
			out.println("{\"resultName\":\"" + resultName
					+ "\",\"resultNum\":\"" + resultNum + "\"}");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void eduAjax() throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode = PrisonUtil.getPrisonCode(request);
		// 统计文化程度
		sb = new StringBuilder();
		sb2 = new StringBuilder();
		List education = analysisService.education(stateCon, ageCon, sexCon,
				statusCon, marryCon, eduCon, crimeCon, startTime, endTime,
				prisonCon, prisonCode);
		for (int i = 0; i < education.size(); i++) {
			Object[] obj3 = (Object[]) education.get(i);
			sb.append(obj3[0].toString() + ",");
			sb2.append(obj3[1].toString() + ",");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb2.deleteCharAt(sb2.length() - 1);
		resultName = sb.toString();
		resultNum = sb2.toString();

		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		try {
			PrintWriter out = response.getWriter();
			out.println("{\"resultName\":\"" + resultName
					+ "\",\"resultNum\":\"" + resultNum + "\"}");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void statusAjax() throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode = PrisonUtil.getPrisonCode(request);
		// 统计身份
		sb = new StringBuilder();
		sb2 = new StringBuilder();
		List status = analysisService.shenfen(stateCon, ageCon, sexCon,
				statusCon, marryCon, eduCon, crimeCon, startTime, endTime,
				prisonCon, prisonCode);
		for (int i = 0; i < status.size(); i++) {
			Object[] obj4 = (Object[]) status.get(i);
			sb.append(obj4[0].toString() + ",");
			sb2.append(obj4[1].toString() + ",");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb2.deleteCharAt(sb2.length() - 1);
		resultName = sb.toString();
		resultNum = sb2.toString();

		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		try {
			PrintWriter out = response.getWriter();
			out.println("{\"resultName\":\"" + resultName
					+ "\",\"resultNum\":\"" + resultNum + "\"}");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ageAjax() throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode = PrisonUtil.getPrisonCode(request);

		// 统计年龄
		sb = new StringBuilder();
		sb2 = new StringBuilder();
		List age = analysisService.age(stateCon, ageCon, sexCon, statusCon,
				marryCon, eduCon, crimeCon, startTime, endTime, prisonCon,
				prisonCode);
		for (int i = 0; i < age.size(); i++) {
			Object[] obj5 = (Object[]) age.get(i);
			sb.append(obj5[0].toString() + ",");
			sb2.append(obj5[1].toString() + ",");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb2.deleteCharAt(sb2.length() - 1);
		resultName = sb.toString();
		resultNum = sb2.toString();

		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		try {
			PrintWriter out = response.getWriter();
			out.println("{\"resultName\":\"" + resultName
					+ "\",\"resultNum\":\"" + resultNum + "\"}");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 查询被拘留人详细信息
	public String getList() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode = PrisonUtil.getPrisonCode(request);
		pageNum = ServletRequestUtils.getInt(request, "pageNum", "1");
		limit = ServletRequestUtils.getInt(request, "limit", "20");
		prisonerList = analysisService.allPrisoner(stateCon, ageCon, sexCon,
				statusCon, marryCon, eduCon, crimeCon, pageNum, limit,
				startTime, endTime, prisonCon, prisonCode);
		List count = analysisService.allCount(stateCon, ageCon, sexCon,
				statusCon, marryCon, eduCon, crimeCon, startTime, endTime,
				prisonCon, prisonCode);
		totalNum = (Integer) count.get(0);
		totalPage = (totalNum - 1) / limit + 1;
		return "stList";
	}

	public void initDict() {
		gender = dictionaryService.selectDictionary(Type.GENDERTYPE);
		marryStatus = dictionaryService.selectDictionary(Type.MARRYTYPE);
		eduLevel = dictionaryService.selectDictionary(Type.EDUCATIONTYPE);
		status = dictionaryService.selectDictionary(Type.STATUSTYPE);
		crimes = dictionaryService.selectDictionary(Type.CRIMETYPE);
		prisonList = analysisService.allPrion();
	}

	public void countNum() {
		StringBuilder sb = new StringBuilder();
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode = PrisonUtil.getPrisonCode(request);
		List state = analysisService.stateNum(stateCon, ageCon, sexCon,
				statusCon, marryCon, eduCon, crimeCon, startTime, endTime,
				prisonCon, prisonCode);
		if (state.size() > 0) {
			for (int i = 0; i < state.size(); i++) {
				Object[] obj = (Object[]) state.get(i);
				sb.append(obj[0].toString() + "=" + obj[1].toString() + ",");
			}
		} else {
			sb.append("123123");
		}
		List sex = analysisService.sexNum(stateCon, ageCon, sexCon, statusCon,
				marryCon, eduCon, crimeCon, startTime, endTime, prisonCon,
				prisonCode);
		for (int i = 0; i < sex.size(); i++) {
			Object[] obj = (Object[]) sex.get(i);
			if (obj[0] == null) {
				obj[0] = "";
			}
			sb.append(obj[0].toString() + "=" + obj[1].toString() + ",");
		}

		List prisonNum = analysisService.prisonNum(stateCon, ageCon, sexCon,
				statusCon, marryCon, eduCon, crimeCon, startTime, endTime,
				prisonCon, prisonCode);
		for (int i = 0; i < prisonNum.size(); i++) {
			Object[] obj = (Object[]) prisonNum.get(i);
			if (obj[0] == null) {
				obj[0] = "";
			}
			sb.append(obj[0].toString() + "=" + obj[1].toString() + ",");
		}

		List crime = analysisService.crimeNum(stateCon, ageCon, sexCon,
				statusCon, marryCon, eduCon, crimeCon, startTime, endTime,
				prisonCon, prisonCode);
		for (int i = 0; i < crime.size(); i++) {
			Object[] obj = (Object[]) crime.get(i);
			if (obj[0] == null) {
				obj[0] = "";
			}
			sb.append(obj[0].toString() + "=" + obj[1].toString() + ",");
		}

		List age = analysisService.ageNum(stateCon, ageCon, sexCon, statusCon,
				marryCon, eduCon, crimeCon, startTime, endTime, prisonCon,
				prisonCode);
		for (int i = 0; i < age.size(); i++) {
			Object[] obj = (Object[]) age.get(i);
			if (obj[0] == null) {
				obj[0] = "";
			}
			sb.append(obj[0].toString() + "=" + obj[1].toString() + ",");
		}

		List marry = analysisService.marryNum(stateCon, ageCon, sexCon,
				statusCon, marryCon, eduCon, crimeCon, startTime, endTime,
				prisonCon, prisonCode);
		for (int i = 0; i < marry.size(); i++) {
			Object[] obj = (Object[]) marry.get(i);
			if (obj[0] == null) {
				obj[0] = "";
			}
			sb.append(obj[0].toString() + "=" + obj[1].toString() + ",");
		}

		List edu = analysisService.educationNum(stateCon, ageCon, sexCon,
				statusCon, marryCon, eduCon, crimeCon, startTime, endTime,
				prisonCon, prisonCode);
		for (int i = 0; i < edu.size(); i++) {
			Object[] obj = (Object[]) edu.get(i);
			if (obj[0] == null) {
				obj[0] = "";
			}
			sb.append(obj[0].toString() + "=" + obj[1].toString() + ",");
		}

		List status = analysisService.statusNum(stateCon, ageCon, sexCon,
				statusCon, marryCon, eduCon, crimeCon, startTime, endTime,
				prisonCon, prisonCode);
		for (int i = 0; i < status.size(); i++) {
			Object[] obj = (Object[]) status.get(i);
			if (obj[0] == null) {
				obj[0] = "";
			}
			sb.append(obj[0].toString() + "=" + obj[1].toString() + ",");
		}

		sb.deleteCharAt(sb.length() - 1);

		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		try {
			PrintWriter out = response.getWriter();
			out.println("{\"stateNum\":\"" + sb.toString() + "\"}");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getPrisonCon() {
		return prisonCon;
	}

	public void setPrisonCon(String prisonCon) {
		this.prisonCon = prisonCon;
	}

	public List<PrisonInfo> getPrisonList() {
		return prisonList;
	}

	public void setPrisonList(List<PrisonInfo> prisonList) {
		this.prisonList = prisonList;
	}

	public List<Dictionary> getCrimes() {
		return crimes;
	}

	public void setCrimes(List<Dictionary> crimes) {
		this.crimes = crimes;
	}

	public String getCrimeCon() {
		return crimeCon;
	}

	public void setCrimeCon(String crimeCon) {
		this.crimeCon = crimeCon;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
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

	public String getResultName() {
		return resultName;
	}

	public void setResultName(String resultName) {
		this.resultName = resultName;
	}

	public String getResultNum() {
		return resultNum;
	}

	public void setResultNum(String resultNum) {
		this.resultNum = resultNum;
	}

	public List<Prisoner> getPrisonerList() {
		return prisonerList;
	}

	public void setPrisonerList(List<Prisoner> prisonerList) {
		this.prisonerList = prisonerList;
	}

	public Integer getHe() {
		return he;
	}

	public void setHe(Integer he) {
		this.he = he;
	}

	public String getAgeCon() {
		return ageCon;
	}

	public void setAgeCon(String ageCon) {
		this.ageCon = ageCon;
	}

	public String getSexCon() {
		return sexCon;
	}

	public void setSexCon(String sexCon) {
		this.sexCon = sexCon;
	}

	public String getStatusCon() {
		return statusCon;
	}

	public void setStatusCon(String statusCon) {
		this.statusCon = statusCon;
	}

	public String getMarryCon() {
		return marryCon;
	}

	public void setMarryCon(String marryCon) {
		this.marryCon = marryCon;
	}

	public String getStateCon() {
		return stateCon;
	}

	public void setStateCon(String stateCon) {
		this.stateCon = stateCon;
	}

	public String getEduCon() {
		return eduCon;
	}

	public void setEduCon(String eduCon) {
		this.eduCon = eduCon;
	}

	public StringBuilder getSb() {
		return sb;
	}

	public void setSb(StringBuilder sb) {
		this.sb = sb;
	}

	public StringBuilder getSb2() {
		return sb2;
	}

	public void setSb2(StringBuilder sb2) {
		this.sb2 = sb2;
	}

	public String getGenderType() {
		return genderType;
	}

	public void setGenderType(String genderType) {
		this.genderType = genderType;
	}

	public String getMarryType() {
		return marryType;
	}

	public void setMarryType(String marryType) {
		this.marryType = marryType;
	}

	public String getEndType() {
		return endType;
	}

	public void setEndType(String endType) {
		this.endType = endType;
	}

	public String getStatusType() {
		return statusType;
	}

	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}

	public String getAgeType() {
		return ageType;
	}

	public void setAgeType(String ageType) {
		this.ageType = ageType;
	}

	public DictionaryService getDictionaryService() {
		return dictionaryService;
	}

	public void setDictionaryService(DictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}

	public List<Dictionary> getGender() {
		return gender;
	}

	public void setGender(List<Dictionary> gender) {
		this.gender = gender;
	}

	public List<Dictionary> getMarryStatus() {
		return marryStatus;
	}

	public void setMarryStatus(List<Dictionary> marryStatus) {
		this.marryStatus = marryStatus;
	}

	public List<Dictionary> getEduLevel() {
		return eduLevel;
	}

	public void setEduLevel(List<Dictionary> eduLevel) {
		this.eduLevel = eduLevel;
	}

	public List<Dictionary> getStatus() {
		return status;
	}

	public void setStatus(List<Dictionary> status) {
		this.status = status;
	}

	public AnalysisService getAnalysisService() {
		return analysisService;
	}

	public void setAnalysisService(AnalysisService analysisService) {
		this.analysisService = analysisService;
	}
}
