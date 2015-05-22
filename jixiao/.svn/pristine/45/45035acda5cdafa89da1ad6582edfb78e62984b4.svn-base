package com.hoyotech.prison.action;

import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.hoyotech.prison.bean.Census;
import com.hoyotech.prison.bean.Dictionary;
import com.hoyotech.prison.bean.Prisoner;
import com.hoyotech.prison.service.impl.CountService;
import com.hoyotech.prison.service.impl.DictionaryService;
import com.hoyotech.prison.service.impl.PrisonInfoService;
import com.hoyotech.prison.service.impl.ProvinceService;
import com.hoyotech.prison.util.Type;
import com.isa.pims.basic.ServletRequestUtils;

public class ProvinceAction {

	private ProvinceService provinceService;
	private DictionaryService dictionaryService;
	
	private int rusuo; //入所
	private int qingjiahuisuo; //请假回所
	private int qiman; //期满解除
	private int tiqian; //提前出所
	private int qingjia; //请假出所
	private int waiyi; //外出就医
	private int siwang;//死亡
	
	
	private int zaiju; //在拘
	private int manNum; //在拘男
	private int womanNum; //在拘女
	private int chaoqi; //超期未出的
	private int todayOut; //今日出所的
	private int xingzheng; //行政拘留
	private int sifa; //司法拘留
	private int waiji; //外籍人员
	private int backLater; //超期未归
	private int shencha; //拘留审查
	private int qita; //其他
	private int tousong; //投送未收
	
	private StringBuilder sb;
	private StringBuilder sb2;
	private String resultName="";
	private String resultNum="";
	private Prisoner prisoner;
	private String id;
	
	private String bussiness;
	private String bussiness2;
	private int pageNum;
	private int limit;
	private int totalPage;
	private int totalNum;
	private List<Prisoner> lists;
	private List<Dictionary> dangerLev;
	
	private Date inTime;
	private String detainState;
	private String qimanjiechu;
	private Date tiqianjiechu;
	
	//检索
	private String prisonerNum;
	private String prisonerName;
	private String roomNum;
	private String dangerlevel;
	
	public String timeChose(){
		return "timeChose";
	}
	
	private CountService countService;
	private List<Census> censusList=new ArrayList<Census>();
	private List<String> sqls=new ArrayList<String>();
	private Date time;
	private String datetime;
	private String prisonCode;
	private PrisonInfoService prisonService;
	
	public CountService getCountService() {
		return countService;
	}

	public void setCountService(CountService countService) {
		this.countService = countService;
	}

	public List<Census> getCensusList() {
		return censusList;
	}

	public void setCensusList(List<Census> censusList) {
		this.censusList = censusList;
	}

	public List<String> getSqls() {
		return sqls;
	}

	public void setSqls(List<String> sqls) {
		this.sqls = sqls;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getPrisonCode() {
		return prisonCode;
	}

	public void setPrisonCode(String prisonCode) {
		this.prisonCode = prisonCode;
	}

	public PrisonInfoService getPrisonService() {
		return prisonService;
	}

	public void setPrisonService(PrisonInfoService prisonService) {
		this.prisonService = prisonService;
	}

	public String photoQuery(){
		
		return "photoQuery";
	}
	
	public String getReportForm(){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String pcode = "";
		if(prisonCode != null && prisonCode.equals("")){
			pcode = "and prison_code="+prisonCode;
		}
		if(datetime!=null){
			datetime=datetime+"-10";
			try {
				time=(Date)simpleDateFormat.parseObject(datetime);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if(time==null){
			time=new Date();
		}
		Calendar cal=Calendar.getInstance();//当前日期
		cal.setTime(time);
		cal.set(Calendar.DATE,1);//设为当前月的1号
		cal.add(Calendar.DATE,-1);//减一天，变为上月最后一天
		String date=simpleDateFormat.format(cal.getTime());//输出2005-04-30
		String lastMonth=" and date_inprison < to_date('"+date+" 23:59:59','yyyy-MM-dd hh24:mi.ss') and (reality_outTime > to_date('"+date+" 23:59:59','yyyy-MM-dd hh24:mi.ss') or reality_outTime is NULL) and state!=0 "+pcode;
		sqls.add(lastMonth);
		String feifa=" and state=10 ";
		sqls.add(feifa);
		Calendar cal2=Calendar.getInstance();
		cal2.setTime(time);
		cal2.set(Calendar.DATE, cal2.getActualMaximum(Calendar.DATE));
		String date2=simpleDateFormat.format(cal2.getTime());//本月底
		String thisMonthAdd=" and date_inprison > to_date('"+date+" 23:59:59','yyyy-MM-dd hh24:mi.ss') and date_inprison < to_date('"+date2+" 23:59:59','yyyy-MM-dd hh24:mi.ss') and state!=0 "+pcode;
		sqls.add(thisMonthAdd);
		String feifa2=" and state=10";
		sqls.add(feifa2);
		
		String zhianjuliu=" and date_inprison > to_date('"+date+" 23:59:59','yyyy-MM-dd hh24:mi.ss') and date_inprison < to_date('"+date2+" 23:59:59','yyyy-MM-dd hh24:mi.ss') and imprison_reason=20 and state!=0 "+pcode;
		sqls.add(zhianjuliu);
		
		String sifajuliu=" and date_inprison > to_date('"+date+" 23:59:59','yyyy-MM-dd hh24:mi.ss') and date_inprison < to_date('"+date2+" 23:59:59','yyyy-MM-dd hh24:mi.ss') and imprison_reason=21 and state!=0 "+pcode;
		sqls.add(sifajuliu);
		
		String qita=" and date_inprison > to_date('"+date+" 23:59:59','yyyy-MM-dd hh24:mi.ss') and date_inprison < to_date('"+date2+" 23:59:59','yyyy-MM-dd hh24:mi.ss') and imprison_reason!=21 and imprison_reason!=20 and state!=0 "+pcode;
		sqls.add(qita);
		
		String taopaozhuihui=" and state=10";
		sqls.add(taopaozhuihui);
		
		String benyuejianshao=" and reality_outTime > to_date('"+date+" 23:59:59','yyyy-MM-dd hh24:mi.ss') and reality_outTime < to_date('"+date2+" 23:59:59','yyyy-MM-dd hh24:mi.ss') and state!=0 "+pcode;
		sqls.add(benyuejianshao);
		
		String feifa3=" and state=10";
		sqls.add(feifa3);
		
		String juliuqiman=" and reality_outTime > to_date('"+date+" 23:59:59','yyyy-MM-dd hh24:mi.ss') and reality_outTime < to_date('"+date2+" 23:59:59','yyyy-MM-dd hh24:mi.ss') and outprison_reson=107 and state!=0 "+pcode;
		sqls.add(juliuqiman);
		
		String qiangzhijiedu=" and reality_outTime > to_date('"+date+" 23:59:59','yyyy-MM-dd hh24:mi.ss') and reality_outTime < to_date('"+date2+" 23:59:59','yyyy-MM-dd hh24:mi.ss') and outprison_reson=112 and state!=0 "+pcode;
		sqls.add(qiangzhijiedu);
		
		String shourongjiaoyu=" and reality_outTime > to_date('"+date+" 23:59:59','yyyy-MM-dd hh24:mi.ss') and reality_outTime < to_date('"+date2+" 23:59:59','yyyy-MM-dd hh24:mi.ss') and outprison_reson=110 and state!=0 "+pcode;
		sqls.add(shourongjiaoyu);
		
		String laodongjiaoyang=" and reality_outTime > to_date('"+date+" 23:59:59','yyyy-MM-dd hh24:mi.ss') and reality_outTime < to_date('"+date2+" 23:59:59','yyyy-MM-dd hh24:mi.ss') and outprison_reson=109 and state!=0 "+pcode;
		sqls.add(laodongjiaoyang);
		
		String xingshijuliu=" and reality_outTime > to_date('"+date+" 23:59:59','yyyy-MM-dd hh24:mi.ss') and reality_outTime < to_date('"+date2+" 23:59:59','yyyy-MM-dd hh24:mi.ss') and outprison_reson=113 and state!=0 "+pcode;
		sqls.add(xingshijuliu);
		
		String daibu=" and reality_outTime > to_date('"+date+" 23:59:59','yyyy-MM-dd hh24:mi.ss') and reality_outTime < to_date('"+date2+" 23:59:59','yyyy-MM-dd hh24:mi.ss') and outprison_reson=114 and state!=0  "+pcode;
		sqls.add(daibu);
		
		String taopao=" and state=10";
		sqls.add(taopao);
		
		String siwang=" and reality_outTime > to_date('"+date+" 23:59:59','yyyy-MM-dd hh24:mi.ss') and reality_outTime < to_date('"+date2+" 23:59:59','yyyy-MM-dd hh24:mi.ss') and state=4 and state!=0 "+pcode;
		sqls.add(siwang);
		
		String qita3=" and reality_outTime > to_date('"+date+" 23:59:59','yyyy-MM-dd hh24:mi.ss') and reality_outTime < to_date('"+date2+" 23:59:59','yyyy-MM-dd hh24:mi.ss') and outprison_reson!=107 and outprison_reson!=112 and outprison_reson!=110 and outprison_reson!=109 and outprison_reson!=113 and outprison_reson!=114 and state!=4 and state!=0  "+pcode;
		sqls.add(qita3);
		
		String benyuemo=" and date_inprison < to_date('"+date2+" 23:59:59','yyyy-MM-dd hh24:mi.ss') and (reality_outTime > to_date('"+date2+" 23:59:59','yyyy-MM-dd hh24:mi.ss') or reality_outTime is NULL) and state!=0 "+pcode;
		sqls.add(benyuemo);
		
		String feifa4=" and state=10";
		sqls.add(feifa4);
		
		String benyuezhian=" and date_inprison < to_date('"+date2+" 23:59:59','yyyy-MM-dd hh24:mi.ss') and (reality_outTime > to_date('"+date2+" 23:59:59','yyyy-MM-dd hh24:mi.ss') or reality_outTime is NULL) and imprison_reason=20 and state!=0 "+pcode;
		sqls.add(benyuezhian);
		
		String benyuesifa=" and date_inprison < to_date('"+date2+" 23:59:59','yyyy-MM-dd hh24:mi.ss') and (reality_outTime > to_date('"+date2+" 23:59:59','yyyy-MM-dd hh24:mi.ss') or reality_outTime is NULL) and imprison_reason=21 and state!=0 "+pcode;
		sqls.add(benyuesifa);
		
		String qita4=" and date_inprison < to_date('"+date2+" 23:59:59','yyyy-MM-dd hh24:mi.ss') and (reality_outTime > to_date('"+date2+" 23:59:59','yyyy-MM-dd hh24:mi.ss') or reality_outTime is NULL) and imprison_reason!=21 and imprison_reason!=20 and state!=0 "+pcode;
		sqls.add(qita4);
		
		for(String con:sqls){
			Census cen=new Census();
			List count=countService.allCount(con);
			if(count.size()>0){
				if(!"0".equals(String.valueOf(count.get(0)))){
					cen.setHeji(String.valueOf(count.get(0)));
				}
				
			}
			List woman=countService.woman(con);
			if(woman.size()>0){
				if(!"0".equals(String.valueOf(woman.get(0)))){
					cen.setSex(String.valueOf(woman.get(0)));
				}
				
			}
			List marry=countService.marry(con);
			if(marry.size()>0){
				for(int i=0;i<marry.size();i++)
				{	
					Object[] obj= (Object[])marry.get(i);
						 if("未婚".equals(obj[0])){
							 cen.setWeihun(String.valueOf(obj[1]));
						 }else if("已婚".equals(obj[0])){
							 cen.setYihun(String.valueOf(obj[1]));
						 }else if("离婚".equals(obj[0])){
							 cen.setLihun(String.valueOf(obj[1]));
						 }else if("其他".equals(obj[0])){
							 cen.setMarryQita(String.valueOf(obj[1]));
						 }else if("丧偶".equals(obj[0])){
							 cen.setSangou(String.valueOf(obj[1]));
						 }
				}
			}
			List age=countService.age(con);
			if(age.size()>0){
				for(int i=0;i<age.size();i++)
				{	
					Object[] obj= (Object[])age.get(i);
						 if("18".equals(obj[0])){
							 cen.setQujian1(String.valueOf(obj[1]));
						 }else if("18-25".equals(obj[0])){
							 cen.setQujian2(String.valueOf(obj[1]));
						 }else if("26-35".equals(obj[0])){
							 cen.setQujian3(String.valueOf(obj[1]));
						 }else if("36-60".equals(obj[0])){
							 cen.setQujian4(String.valueOf(obj[1]));
						 }else if("60以上".equals(obj[0])){
							 cen.setQujian5(String.valueOf(obj[1]));
						 }else if("其他".equals(obj[0])){
							 cen.setQujian6(String.valueOf(obj[1]));
						 }
				}
			}
			List education=countService.education(con);
			if(education.size()>0){
				for(int i=0;i<education.size();i++)
				{	
					Object[] obj= (Object[])education.get(i);
						 if("文盲".equals(obj[0])){
							 cen.setWenmang(String.valueOf(obj[1]));
						 }else if("小学".equals(obj[0])){
							 cen.setXiaoxue(String.valueOf(obj[1]));
						 }else if("中学".equals(obj[0])){
							 cen.setZhongxue(String.valueOf(obj[1]));
						 }else if("大专以上".equals(obj[0])){
							 cen.setDazhuan(String.valueOf(obj[1]));
						 }else if("其他".equals(obj[0])){
							 cen.setEducationQita(String.valueOf(obj[1]));
						 }
				}
			}
			List status=countService.status(con);
			if(status.size()>0){
				for(int i=0;i<status.size();i++)
				{	
					Object[] obj= (Object[])status.get(i);
						 if("国家公务员".equals(obj[0])){
							 cen.setGongwuyuan(String.valueOf(obj[1]));
						 }else if("企事业管理人员".equals(obj[0])){
							 cen.setGuanli(String.valueOf(obj[1]));
						 }else if("工人".equals(obj[0])){
							 cen.setGongren(String.valueOf(obj[1]));
						 }else if("农民".equals(obj[0])){
							 cen.setNongmingQita(String.valueOf(obj[1]));
						 }else if("在校学生".equals(obj[0])){
							 cen.setXuesheng(String.valueOf(obj[1]));
						 }else if("个体工商业者".equals(obj[0])){
							 cen.setGeti(String.valueOf(obj[1]));
						 }else if("离退休人员".equals(obj[0])){
							 cen.setLitui(String.valueOf(obj[1]));
						 }else if("无业人员".equals(obj[0])){
							 cen.setWuye(String.valueOf(obj[1]));
						 }else if("其他".equals(obj[0])){
							 cen.setShenfenQita(String.valueOf(obj[1]));
						 }
				}
			}
			List nationality=countService.nationality(con);
			if(nationality.size()>0){
				for(int i=0;i<nationality.size();i++)
				{	
					Object[] obj= (Object[])nationality.get(i);
						 if("外籍人员".equals(obj[0])){
							 cen.setWaiji(String.valueOf(obj[1]));
						 }else if("港澳人员".equals(obj[0])){
							 cen.setGangao(String.valueOf(obj[1]));
						 }
				}
			}
			List jiguan=countService.jiguan(con);
			if(jiguan.size()>0){
				for(int i=0;i<jiguan.size();i++)
				{	
					Object[] obj= (Object[])jiguan.get(i);
						 if("外省人员".equals(obj[0])){
							 cen.setWaishen(String.valueOf(obj[1]));
						 }
				}
			}
			censusList.add(cen);
		}
		
		return "reportForm";
	}
	
	
	
	public String selectPrisoner(){
		dangerLev = dictionaryService.selectDictionary(Type.DANGERTYPE);
		HttpServletRequest request = ServletActionContext.getRequest();
		pageNum = ServletRequestUtils.getInt(request, "page", "1");
		limit = ServletRequestUtils.getInt(request, "limit", "20");
		if(bussiness!=null){
			if(bussiness.equals("in")){
				inTime=new Date();
			}else if(bussiness.equals("qiman")){
				detainState="3";
				qimanjiechu="107";
			}else if(bussiness.equals("tiqian")){
				detainState="3";
				tiqianjiechu=new Date();
			}else if(bussiness.equals("qingjia")){
				detainState="2";
			}else if(bussiness.equals("siwang")){
				detainState="4";
			}
			lists = provinceService.allPrisoners(prisonerNum, prisonerName, roomNum, dangerlevel,inTime,detainState,qimanjiechu,tiqianjiechu, pageNum, limit);
			totalNum = provinceService.countPrisoner(prisonerNum, prisonerName, roomNum, dangerlevel,inTime,detainState,qimanjiechu,tiqianjiechu,null,null,null,null,null,null);
		}else if(bussiness2!=null){
			if(bussiness2.equals("qingjiahuisuo")){
				lists = provinceService.qingjiahuisuo(pageNum, limit);
				totalNum = provinceService.huisuo(null);
			}else if(bussiness2.equals("waiyi")){
				lists = provinceService.waiyi(pageNum, limit);
				totalNum = provinceService.outDoctor(null);
			}
		}
		
		totalPage = (totalNum - 1) / limit + 1;
		
		return "List";
	}
	
	/**
	 * 查询一条被拘留人的信息
	 * **/
	public String detail() {
		prisoner = provinceService.detail(id);
		return "Detail";
	}
	
	public void initselect(){
		rusuo=provinceService.countPrisoner(null,null,null,null,new Date(), null,null,null,null,null,null,null,null,null);
		qingjiahuisuo=provinceService.huisuo(null);
		waiyi=provinceService.outDoctor(null);
		qiman=provinceService.countPrisoner(null,null,null,null,null, "3","107",null,null,null,null,null,null,null);
		tiqian=provinceService.countPrisoner(null,null,null,null,null, "3",null,new Date(),null,null,null,null,null,null);
		qingjia=provinceService.countPrisoner(null,null,null,null,null, "2",null,null,null,null,null,null,null,null);
		siwang=provinceService.countPrisoner(null,null,null,null,null, "4",null,null,null,null,null,null,null,null);
		zaiju=provinceService.countPrisoner(null,null,null,null,null, "1",null,null,null,null,null,null,null,null);
		manNum=provinceService.countPrisoner(null,null,null,null,null, "1",null,null,"13",null,null,null,null,null);
		womanNum=provinceService.countPrisoner(null,null,null,null,null, "1",null,null,"12",null,null,null,null,null);
		chaoqi=provinceService.countPrisoner(null,null,null,null,null, "1",null,null,null,new Date(),null,null,null,null);
		todayOut=provinceService.countPrisoner(null,null,null,null,null, "1",null,null,null,null,new Date(),null,null,null);
		xingzheng=provinceService.countPrisoner(null,null,null,null,null, "1",null,null,null,null,null,"20",null,null);
		sifa=provinceService.countPrisoner(null,null,null,null,null, "1",null,null,null,null,null,"21",null,null);
		waiji=provinceService.countPrisoner(null,null,null,null,null, "1",null,null,null,null,null,null,"21",null);
		backLater=provinceService.leaveLater(null);
		shencha=provinceService.countPrisoner(null,null,null,null,null, "1",null,null,null,null,null,"22",null,null);
	}
	
	public String select(){
		initselect();
		return "success";
	}

	public String selectAll(){
		initselect();
		return "selectall";
	}
	
	
	
	
	//综合查询
	public String integratedQuery(){
		dangerLev = dictionaryService.selectDictionary(Type.DANGERTYPE);
		HttpServletRequest request = ServletActionContext.getRequest();
		pageNum = ServletRequestUtils.getInt(request, "page", "1");
		limit = ServletRequestUtils.getInt(request, "limit", "20");
		if(bussiness!=null){
			if(bussiness.equals("in")){
				inTime=new Date();
			}else if(bussiness.equals("qiman")){
				detainState="3";
				qimanjiechu="107";
			}else if(bussiness.equals("tiqian")){
				detainState="3";
				tiqianjiechu=new Date();
			}else if(bussiness.equals("qingjia")){
				detainState="2";
			}else if(bussiness.equals("siwang")){
				detainState="4";
			}
			lists = provinceService.allPrisoners(prisonerNum, prisonerName, roomNum, dangerlevel,inTime,detainState,qimanjiechu,tiqianjiechu, pageNum, limit);
			totalNum = provinceService.countPrisoner(prisonerNum, prisonerName, roomNum, dangerlevel,inTime,detainState,qimanjiechu,tiqianjiechu,null,null,null,null,null,null);
		}else if(bussiness2!=null){
			if(bussiness2.equals("qingjiahuisuo")){
				lists = provinceService.qingjiahuisuo(pageNum, limit);
				totalNum = provinceService.huisuo(null);
			}else if(bussiness2.equals("waiyi")){
				lists = provinceService.waiyi(pageNum, limit);
				totalNum = provinceService.outDoctor(null);
			}
		}
		
		totalPage = (totalNum - 1) / limit + 1;
		return "integratedQuery";
	}
	
	public void sexAjax() throws Exception{
		//统计性别
		sb=new StringBuilder();
		sb2=new StringBuilder();
		List sexNum=provinceService.sex();
		for(int i=0;i<sexNum.size();i++)
		{
			
			Object[] obj1= (Object[])sexNum.get(i);
			sb.append(obj1[0].toString()+",");
			sb2.append(obj1[1].toString()+",");
		}
		sb.deleteCharAt(sb.length()-1);
		sb2.deleteCharAt(sb2.length()-1);
		resultName=sb.toString();
		resultNum=sb2.toString();
		
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		try{
			PrintWriter out=response.getWriter();
			out.println("{\"resultName\":\""+resultName+"\",\"resultNum\":\""+resultNum+"\"}"); 
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void sevenDays(){
		sb=new StringBuilder();
		sb2=new StringBuilder();
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat result = new SimpleDateFormat("MM-dd");
		Calendar cal=Calendar.getInstance();//当前日期
		
		cal.add(Calendar.DATE,-6);//7天前
		String date=simpleDateFormat.format(cal.getTime());
		String result1=result.format(cal.getTime());
		List k1=provinceService.inOneDay(date);
		for(int i=0;i<k1.size();i++)
		{
			
			Object[] obj1= (Object[])k1.get(i);
			if(i==0){
				sb2.append(obj1[1].toString()+",");
			}else{
				sb.append(obj1[1].toString()+",");
			}
			
		}
		
		cal.add(Calendar.DATE,1);//6天前
		String date2=simpleDateFormat.format(cal.getTime());
		String result2=result.format(cal.getTime());
		List k2=provinceService.inOneDay(date2);
		for(int i=0;i<k2.size();i++)
		{
			
			Object[] obj1= (Object[])k2.get(i);
			if(i==0){
				sb2.append(obj1[1].toString()+",");
			}else{
				sb.append(obj1[1].toString()+",");
			}
			
		}
		
		
		cal.add(Calendar.DATE,1);//5天前
		String date3=simpleDateFormat.format(cal.getTime());
		String result3=result.format(cal.getTime());
		List k3=provinceService.inOneDay(date3);
		for(int i=0;i<k3.size();i++)
		{
			
			Object[] obj1= (Object[])k3.get(i);
			if(i==0){
				sb2.append(obj1[1].toString()+",");
			}else{
				sb.append(obj1[1].toString()+",");
			}
			
		}
		
		
		cal.add(Calendar.DATE,1);//4天前
		String date4=simpleDateFormat.format(cal.getTime());
		String result4=result.format(cal.getTime());
		List k4=provinceService.inOneDay(date4);
		for(int i=0;i<k4.size();i++)
		{
			
			Object[] obj1= (Object[])k4.get(i);
			if(i==0){
				sb2.append(obj1[1].toString()+",");
			}else{
				sb.append(obj1[1].toString()+",");
			}
			
		}
		
		
		cal.add(Calendar.DATE,1);//3天前
		String date5=simpleDateFormat.format(cal.getTime());
		String result5=result.format(cal.getTime());
		List k5=provinceService.inOneDay(date5);
		for(int i=0;i<k5.size();i++)
		{
			
			Object[] obj1= (Object[])k5.get(i);
			if(i==0){
				sb2.append(obj1[1].toString()+",");
			}else{
				sb.append(obj1[1].toString()+",");
			}
			
		}
		
		cal.add(Calendar.DATE,1);//2天前
		String date6=simpleDateFormat.format(cal.getTime());
		String result6=result.format(cal.getTime());
		List k6=provinceService.inOneDay(date6);
		for(int i=0;i<k6.size();i++)
		{
			
			Object[] obj1= (Object[])k6.get(i);
			if(i==0){
				sb2.append(obj1[1].toString()+",");
			}else{
				sb.append(obj1[1].toString()+",");
			}
			
		}
		
		cal.add(Calendar.DATE,1);//1天前
		String date7=simpleDateFormat.format(cal.getTime());
		String result7=result.format(cal.getTime());
		List k7=provinceService.inOneDay(date7);
		for(int i=0;i<k7.size();i++)
		{
			
			Object[] obj1= (Object[])k7.get(i);
			if(i==0){
				sb2.append(obj1[1].toString()+",");
			}else{
				sb.append(obj1[1].toString()+",");
			}
			
		}
		sb.deleteCharAt(sb.length()-1);
		sb2.deleteCharAt(sb2.length()-1);
		
		String resultName=result1+","+result2+","+result3+","+result4+","+result5+","+result6+","+result7;
//		System.out.println(resultName);
//		System.out.println(sb.toString());
//		System.out.println(sb2.toString());
		
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		try{
			PrintWriter out=response.getWriter();
			out.println("{\"resultName\":\""+resultName+"\",\"woman\":\""+sb2.toString()+"\",\"man\":\""+sb.toString()+"\"}"); 
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	public int getZaiju() {
		return zaiju;
	}

	public void setZaiju(int zaiju) {
		this.zaiju = zaiju;
	}

	public int getManNum() {
		return manNum;
	}

	public void setManNum(int manNum) {
		this.manNum = manNum;
	}

	public int getWomanNum() {
		return womanNum;
	}

	public void setWomanNum(int womanNum) {
		this.womanNum = womanNum;
	}

	public int getChaoqi() {
		return chaoqi;
	}

	public void setChaoqi(int chaoqi) {
		this.chaoqi = chaoqi;
	}

	public int getTodayOut() {
		return todayOut;
	}

	public void setTodayOut(int todayOut) {
		this.todayOut = todayOut;
	}

	public int getXingzheng() {
		return xingzheng;
	}

	public void setXingzheng(int xingzheng) {
		this.xingzheng = xingzheng;
	}

	public int getSifa() {
		return sifa;
	}

	public void setSifa(int sifa) {
		this.sifa = sifa;
	}

	public int getWaiji() {
		return waiji;
	}

	public void setWaiji(int waiji) {
		this.waiji = waiji;
	}

	public int getBackLater() {
		return backLater;
	}

	public void setBackLater(int backLater) {
		this.backLater = backLater;
	}

	public int getShencha() {
		return shencha;
	}

	public void setShencha(int shencha) {
		this.shencha = shencha;
	}

	public int getQita() {
		return qita;
	}

	public void setQita(int qita) {
		this.qita = qita;
	}

	public int getTousong() {
		return tousong;
	}

	public void setTousong(int tousong) {
		this.tousong = tousong;
	}

	public String getPrisonerNum() {
		return prisonerNum;
	}

	public void setPrisonerNum(String prisonerNum) {
		this.prisonerNum = prisonerNum;
	}

	public String getPrisonerName() {
		return prisonerName;
	}

	public void setPrisonerName(String prisonerName) {
		this.prisonerName = prisonerName;
	}

	public String getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}

	public String getDangerlevel() {
		return dangerlevel;
	}

	public void setDangerlevel(String dangerlevel) {
		this.dangerlevel = dangerlevel;
	}

	public DictionaryService getDictionaryService() {
		return dictionaryService;
	}

	public void setDictionaryService(DictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}

	public List<Dictionary> getDangerLev() {
		return dangerLev;
	}

	public void setDangerLev(List<Dictionary> dangerLev) {
		this.dangerLev = dangerLev;
	}

	public String getBussiness2() {
		return bussiness2;
	}

	public void setBussiness2(String bussiness2) {
		this.bussiness2 = bussiness2;
	}

	public Prisoner getPrisoner() {
		return prisoner;
	}

	public void setPrisoner(Prisoner prisoner) {
		this.prisoner = prisoner;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBussiness() {
		return bussiness;
	}


	public void setBussiness(String bussiness) {
		this.bussiness = bussiness;
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


	public List<Prisoner> getLists() {
		return lists;
	}


	public void setLists(List<Prisoner> lists) {
		this.lists = lists;
	}


	public Date getInTime() {
		return inTime;
	}


	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}


	public String getDetainState() {
		return detainState;
	}


	public void setDetainState(String detainState) {
		this.detainState = detainState;
	}


	public String getQimanjiechu() {
		return qimanjiechu;
	}


	public void setQimanjiechu(String qimanjiechu) {
		this.qimanjiechu = qimanjiechu;
	}
	
	public Date getTiqianjiechu() {
		return tiqianjiechu;
	}

	public void setTiqianjiechu(Date tiqianjiechu) {
		this.tiqianjiechu = tiqianjiechu;
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

	public ProvinceService getProvinceService() {
		return provinceService;
	}


	public void setProvinceService(ProvinceService provinceService) {
		this.provinceService = provinceService;
	}


	public int getRusuo() {
		return rusuo;
	}


	public void setRusuo(int rusuo) {
		this.rusuo = rusuo;
	}

	public int getQingjiahuisuo() {
		return qingjiahuisuo;
	}


	public void setQingjiahuisuo(int qingjiahuisuo) {
		this.qingjiahuisuo = qingjiahuisuo;
	}


	public int getQiman() {
		return qiman;
	}


	public void setQiman(int qiman) {
		this.qiman = qiman;
	}


	public int getTiqian() {
		return tiqian;
	}


	public void setTiqian(int tiqian) {
		this.tiqian = tiqian;
	}


	public int getQingjia() {
		return qingjia;
	}


	public void setQingjia(int qingjia) {
		this.qingjia = qingjia;
	}


	public int getWaiyi() {
		return waiyi;
	}


	public void setWaiyi(int waiyi) {
		this.waiyi = waiyi;
	}


	public int getSiwang() {
		return siwang;
	}


	public void setSiwang(int siwang) {
		this.siwang = siwang;
	}
	
	
	
}
