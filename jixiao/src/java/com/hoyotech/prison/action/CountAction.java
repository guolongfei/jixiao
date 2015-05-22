package com.hoyotech.prison.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.Census;
import com.hoyotech.prison.service.impl.CountService;
import com.hoyotech.prison.util.PrisonUtil;

public class CountAction {

	private CountService countService;
	private List<Census> censusList=new ArrayList<Census>();
	private List<String> sqls=new ArrayList<String>();
	private Date time;
	private String datetime;
	
	public String timeChose() throws Exception{
		return "timeChose";
	}
	
	public String select() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode=PrisonUtil.getPrisonCode(request);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		if(datetime!=null){
			datetime=datetime+"-10";
			time=(Date)simpleDateFormat.parseObject(datetime);
		}
		
		if(time==null){
			time=new Date();
		}
		
		Calendar cal=Calendar.getInstance();//当前日期
		cal.setTime(time);
		cal.set(Calendar.DATE,1);//设为当前月的1号
		cal.add(Calendar.DATE,-1);//减一天，变为上月最后一天

		
		String date=simpleDateFormat.format(cal.getTime());//输出2005-04-30
		
		String lastMonth=" and date_inprison <to_date('"+date+" 23:59:59','yyyy-MM-dd hh24:mi:ss') and (reality_outTime > to_date('"+date+" 23:59:59','yyyy-MM-dd hh24:mi:ss') or reality_outTime is NULL) and state!=0 and prison_code="+prisonCode;
		sqls.add(lastMonth);
		String feifa=" and state=10 ";
		sqls.add(feifa);
		
		Calendar cal2=Calendar.getInstance();
		cal2.setTime(time);
		cal2.set(Calendar.DATE, cal2.getActualMaximum(Calendar.DATE));
		String date2=simpleDateFormat.format(cal2.getTime());//本月底
		
		String thisMonthAdd=" and date_inprison > to_date('"+date+" 23:59:59','yyyy-MM-dd hh24:mi:ss') and date_inprison < to_date('"+date2+" 23:59:59','yyyy-MM-dd hh24:mi:ss') and state!=0 and prison_code="+prisonCode;
		sqls.add(thisMonthAdd);
		
		String feifa2=" and state=10";
		sqls.add(feifa2);
		
		String zhianjuliu=" and date_inprison > to_date('"+date+" 23:59:59','yyyy-MM-dd hh24:mi:ss') and date_inprison < to_date('"+date2+" 23:59:59','yyyy-MM-dd hh24:mi:ss') and imprison_reason=20 and state!=0 and prison_code="+prisonCode;
		sqls.add(zhianjuliu);
		
		String sifajuliu=" and date_inprison > to_date('"+date+" 23:59:59','yyyy-MM-dd hh24:mi:ss') and date_inprison < to_date('"+date2+" 23:59:59','yyyy-MM-dd hh24:mi:ss') and imprison_reason=21 and state!=0 and prison_code="+prisonCode;
		sqls.add(sifajuliu);
		
		String qita=" and date_inprison > to_date('"+date+" 23:59:59','yyyy-MM-dd hh24:mi:ss') and date_inprison < to_date('"+date2+" 23:59:59','yyyy-MM-dd hh24:mi:ss') and imprison_reason!=21 and imprison_reason!=20 and state!=0 and prison_code="+prisonCode;
		sqls.add(qita);
		
		String taopaozhuihui=" and state=10";
		sqls.add(taopaozhuihui);
		
		String benyuejianshao=" and reality_outTime > to_date('"+date+" 23:59:59','yyyy-MM-dd hh24:mi:ss') and reality_outTime < to_date('"+date2+" 23:59:59','yyyy-MM-dd hh24:mi:ss') and state!=0 and prison_code="+prisonCode;
		sqls.add(benyuejianshao);
		
		String feifa3=" and state=10";
		sqls.add(feifa3);
		
		String juliuqiman=" and reality_outTime > to_date('"+date+" 23:59:59','yyyy-MM-dd hh24:mi:ss') and reality_outTime < to_date('"+date2+" 23:59:59','yyyy-MM-dd hh24:mi:ss') and outprison_reson=107 and state!=0 and prison_code="+prisonCode;
		sqls.add(juliuqiman);
		
		String qiangzhijiedu=" and reality_outTime > to_date('"+date+" 23:59:59','yyyy-MM-dd hh24:mi:ss') and reality_outTime < to_date('"+date2+" 23:59:59','yyyy-MM-dd hh24:mi:ss') and outprison_reson=112 and state!=0 and prison_code="+prisonCode;
		sqls.add(qiangzhijiedu);
		
		String shourongjiaoyu=" and reality_outTime > to_date('"+date+" 23:59:59','yyyy-MM-dd hh24:mi:ss') and reality_outTime < to_date('"+date2+" 23:59:59','yyyy-MM-dd hh24:mi:ss') and outprison_reson=110 and state!=0 and prison_code="+prisonCode;
		sqls.add(shourongjiaoyu);
		
		String laodongjiaoyang=" and reality_outTime > to_date('"+date+" 23:59:59','yyyy-MM-dd hh24:mi:ss') and reality_outTime < to_date('"+date2+" 23:59:59','yyyy-MM-dd hh24:mi:ss') and outprison_reson=109 and state!=0 and prison_code="+prisonCode;
		sqls.add(laodongjiaoyang);
		
		String xingshijuliu=" and reality_outTime > to_date('"+date+" 23:59:59','yyyy-MM-dd hh24:mi:ss') and reality_outTime < to_date('"+date2+" 23:59:59','yyyy-MM-dd hh24:mi:ss') and outprison_reson=113 and state!=0 and prison_code="+prisonCode;
		sqls.add(xingshijuliu);
		
		String daibu=" and reality_outTime > to_date('"+date+" 23:59:59','yyyy-MM-dd hh24:mi:ss') and reality_outTime < to_date('"+date2+" 23:59:59','yyyy-MM-dd hh24:mi:ss') and outprison_reson=114 and state!=0 and prison_code="+prisonCode;
		sqls.add(daibu);
		
		String taopao=" and state=10";
		sqls.add(taopao);
		
		String siwang=" and reality_outTime > to_date('"+date+" 23:59:59','yyyy-MM-dd hh24:mi:ss') and reality_outTime < to_date('"+date2+" 23:59:59','yyyy-MM-dd hh24:mi:ss') and state=4 and state!=0 and prison_code="+prisonCode;
		sqls.add(siwang);
		
		String qita3=" and reality_outTime > to_date('"+date+" 23:59:59','yyyy-MM-dd hh24:mi:ss') and reality_outTime < to_date('"+date2+" 23:59:59','yyyy-MM-dd hh24:mi:ss') and outprison_reson!=107 and outprison_reson!=112 and outprison_reson!=110 and outprison_reson!=109 and outprison_reson!=113 and outprison_reson!=114 and state!=4 and state!=0 and prison_code="+prisonCode;
		sqls.add(qita3);
		
		String benyuemo=" and date_inprison < to_date('"+date2+" 23:59:59','yyyy-MM-dd hh24:mi:ss') and (reality_outTime > to_date('"+date2+" 23:59:59','yyyy-MM-dd hh24:mi:ss') or reality_outTime is NULL) and state!=0 and prison_code="+prisonCode;
		sqls.add(benyuemo);
		
		String feifa4=" and state=10";
		sqls.add(feifa4);
		
		String benyuezhian=" and date_inprison < to_date('"+date2+" 23:59:59','yyyy-MM-dd hh24:mi:ss') and (reality_outTime > to_date('"+date2+" 23:59:59','yyyy-MM-dd hh24:mi:ss') or reality_outTime is NULL) and imprison_reason=20 and state!=0 and prison_code="+prisonCode;
		sqls.add(benyuezhian);
		
		String benyuesifa=" and date_inprison < to_date('"+date2+" 23:59:59','yyyy-MM-dd hh24:mi:ss') and (reality_outTime > to_date('"+date2+" 23:59:59','yyyy-MM-dd hh24:mi:ss') or reality_outTime is NULL) and imprison_reason=21 and state!=0 and prison_code="+prisonCode;
		sqls.add(benyuesifa);
		
		String qita4=" and date_inprison < to_date('"+date2+" 23:59:59','yyyy-MM-dd hh24:mi:ss') and (reality_outTime > to_date('"+date2+" 23:59:59','yyyy-MM-dd hh24:mi:ss') or reality_outTime is NULL) and imprison_reason!=21 and imprison_reason!=20 and state!=0 and prison_code="+prisonCode;
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
		
		return "success";
		
	}
	
	
	


	public String getDatetime() {
		return datetime;
	}





	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}





	public Date getTime() {
		return time;
	}





	public void setTime(Date time) {
		this.time = time;
	}





	public List<String> getSqls() {
		return sqls;
	}


	public void setSqls(List<String> sqls) {
		this.sqls = sqls;
	}


	public List<Census> getCensusList() {
		return censusList;
	}


	public void setCensusList(List<Census> censusList) {
		this.censusList = censusList;
	}


	public CountService getCountService() {
		return countService;
	}

	public void setCountService(CountService countService) {
		this.countService = countService;
	}
	
}
