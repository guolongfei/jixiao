package com.hoyotech.prison.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class TimeHelper {
	
	private static SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	private static SimpleDateFormat MINUTE_FORMATTER = new SimpleDateFormat(
	"yyyy-MM-dd HH:mm");
	private static SimpleDateFormat HOUR_FORMATTER = new SimpleDateFormat(
			"yyyy-MM-dd HH");
	
	private static SimpleDateFormat DAY_FORMATTER = new SimpleDateFormat(
		"yyyy-MM-dd");
	private static SimpleDateFormat FORMATTER = new SimpleDateFormat(
	"yyyy年MM月dd");
	
	private static final String ERROEDATE = "时间格式错误";
	private static final String MINAGO="分钟以前";
	private static final String HOURAGO="小时以前";
	private static final String DAYAGO="天以前";
	private static final String WEEKAGO="周以前";
	private static final String MONTHAGO="个月以前";
	private static final String YEARAGO="一年前";
	
	public TimeHelper() {

	}

	/**
	 * 
	 * 
	 * <br>
	 * 入口參數：
	 * 
	 * @return <br>
	 *         出口參數： <br>
	 *         功能介紹：
	 * @return
	 */
	public static String getDateTime() {
		return DATE_FORMATTER.format(Calendar.getInstance(Locale.CHINA).getTime());
	}

	public static String getDayTime() {
		return DAY_FORMATTER.format(Calendar.getInstance(Locale.CHINA).getTime());
	}
	public static String getHourTime() {
		return HOUR_FORMATTER.format(Calendar.getInstance(Locale.CHINA).getTime());
	}
	public static String getStringDateTime(Date date) {
		return DATE_FORMATTER.format(date);
	}
	public static String getStringMinuteTime(Date date) {
		return MINUTE_FORMATTER.format(date);
	}
	
	public static String getStringDayTime(Date day) {
		return DAY_FORMATTER.format(day);
	}

	public static String getSmallDateTime(Date date) {
		return DATE_FORMATTER.format(date);
	}

	public static Date convertToDate(String sdate) {
		Date date = null;
		try {
			date = DATE_FORMATTER.parse(sdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	
	/**
	 * 计算输入日期 N天前 的日期
	 */
	public static String beforeDate(int num) {
		return computeDate(new Date(), 0 - num);
	}

	public static String beforeShortDate(int num){
		return computeShortDate(new Date(), 0 - num);
	}
	
	
	/**
	 * 计算输入日期 N天前 的日期
	 */
	public static String beforeDate(String input, int num) {
		return computeDate(input, 0 - num);
	}

	/**
	 * 计算输入日期 N天后 的日期
	 */
	public static String afterDate(int num) {
		return computeDate(new Date(), num);
	}
	
	/**
	 * 计算输入日期 N天后 的日期
	 */
	public static String afterDate(String input,int num) {
		return computeDate(input, num);
	}

	private static String computeDate(String input, int num) {
		Date date = null;
		try {
			date = DATE_FORMATTER.parse(input);
		} catch (ParseException e) {
			date = new Date();
		}
		return computeDate(date,num);
	}
	
	private static String computeDate(Date inputDate, int num) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(inputDate);
		cal.add(Calendar.DAY_OF_YEAR,num);  
		return DATE_FORMATTER.format(cal.getTime());
	}

	public static String beforeShortDate(String input,int num) {
		return computeShortDate(input, -1*num);
	}
	
	/**
	 * 计算输入日期 N天后 的日期
	 */
	public static String afterShortDate(String input,int num) {
		return computeShortDate(input, num);
	}
	
	public static String afterHour(String input,int num) {
		Date date = null;
		try {
			date = HOUR_FORMATTER.parse(input);
		} catch (ParseException e) {
			e.printStackTrace();
			date = new Date();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.HOUR_OF_DAY, num);
		return HOUR_FORMATTER.format(cal.getTime());
	}
	private static String computeShortDate(String input, int num) {
		Date date = null;
		try {
			date = DAY_FORMATTER.parse(input);
		} catch (ParseException e) {
			date = new Date();
		}
		return computeShortDate(date,num);
	}
	
	private static String computeShortDate(Date inputDate, int num) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(inputDate);
		cal.add(Calendar.DAY_OF_YEAR,num);  
		return DAY_FORMATTER.format(cal.getTime());
	}
	
	/**
	 * 计算开始日期 与 结束日期 之间的天数差
	 */
	public static String distance(String strStart, String strEnd) {
		String distance = null;
		try {
			long timeStart = DATE_FORMATTER.parse(strStart).getTime();
			long timeEnd = DATE_FORMATTER.parse(strEnd).getTime();
			long tin = 0;
			tin = (timeStart > timeEnd) ? (timeStart - timeEnd)
					: (timeEnd - timeStart);
			tin /= (86400 * 1000);
			distance = tin + "";
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return distance;
	}
	
	/**
	 * 计算开始日期 与 结束日期 之间的天数差
	 */
	public static String distanceShort(String strStart, String strEnd) {
		String distance = null;
		try {
			long timeStart = DAY_FORMATTER.parse(strStart).getTime();
			long timeEnd = DAY_FORMATTER.parse(strEnd).getTime();
			long tin = 0;
			tin = (timeStart > timeEnd) ? (timeStart - timeEnd)
					: (timeEnd - timeStart);
			tin /= (86400 * 1000);
			distance = tin + "";
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return distance;
	}
	
	public static String distanceHours(String strStart, String strEnd) {
		String distance = null;
		try{
			long timeStart = HOUR_FORMATTER.parse(strStart).getTime();
			long timeEnd = HOUR_FORMATTER.parse(strEnd).getTime();
			long tin = 0;
			tin = (timeStart > timeEnd) ? (timeStart - timeEnd):(timeEnd - timeStart);
			tin /=(1000*60*60);
			distance = tin + "";
		}catch(ParseException e) {
			e.printStackTrace();
		}
		return distance;
	}
	/**
	 * 计算多久以前，如4小时以前，2天以前，3周以前，4个月以前
	 * @param input
	 * @return
	 */
	public static String beforeHowMany(String input) {
		try {
			if (input == null) {
				return TimeHelper.ERROEDATE;
			} else {
				int diff=TimeHelper.distanceDay(input);
				if(-1==diff){
					return TimeHelper.ERROEDATE;
				}else if(diff==0){
					long mins=TimeHelper.distanceMinute(input);
					if(mins<60){
						return mins+TimeHelper.MINAGO;
					}else{
						return TimeHelper.beforeTime(input)+TimeHelper.HOURAGO;
					}
				}else if(0<diff && diff<=7){
					return diff+TimeHelper.DAYAGO;
				}else if(7<diff && diff<=30){
					return diff/7+TimeHelper.WEEKAGO;
				}else if(30<diff && diff<365){
					return diff/30+TimeHelper.MONTHAGO;
				}else 
					return TimeHelper.YEARAGO;
			}
		} catch (RuntimeException e) {
			return TimeHelper.ERROEDATE;
		}
	}
	private static String beforeTime(String input){		
		return String.valueOf(TimeHelper.distanceMinute(input)/60);
	}
	private static int distanceDay(String input){
		String currentdatetime=TimeHelper.getDateTime();
		String diff=TimeHelper.distance(input, currentdatetime);
		return diff==null?-1:Integer.parseInt(diff);
	}
	
	private static Long distanceMinute(String input){
		long tin = 0;
		try {
			long timeStart = Calendar.getInstance(Locale.CHINA).getTime().getTime();
			long timeEnd = DATE_FORMATTER.parse(input).getTime();
			
			tin = (timeStart > timeEnd) ? (timeStart - timeEnd)
					: (timeEnd - timeStart);
			tin /= (60 * 1000);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return tin;
	}
	/**
	 * 获得昨天对应的固定时间
	 * @param time
	 * @return
	 */
	public static String getYesterdayFixtime(String time){
		Calendar cal = Calendar.getInstance(Locale.CHINA);
		cal.add(Calendar.DAY_OF_YEAR,-1); 
		return DAY_FORMATTER.format(cal.getTime())+" "+time+":00:00";
	}
	
	/**
	 * 获得n个月前的时间点
	 * added by haha
	 * @return
	 */
	public static String getTimeMonthsAgo(int n) {
		Calendar calendar = Calendar.getInstance(Locale.CHINA);   
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - n); 
		return DAY_FORMATTER.format(calendar.getTime());
	}
	
	/**
	 * 获得n个星期前的时间点
	 * @param n
	 * @return
	 */
	public static String getTimeWeeksAgo(int n) {
		Calendar calendar = Calendar.getInstance(Locale.CHINA);  
		calendar.set(Calendar.WEEK_OF_MONTH, calendar.get(Calendar.WEEK_OF_MONTH) - n); 
		return DATE_FORMATTER.format(calendar.getTime());
	}
	
	/**
	 * 获得n个小时前的时间点
	 * @param n
	 * @return
	 */
	public static String getTimeHoursAgo(int n) {
		Calendar calendar = Calendar.getInstance(Locale.CHINA);  
		calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - n); 
		return DATE_FORMATTER.format(calendar.getTime());
	}
	
	/**
	 * 获得n天前的时间点
	 * @param n
	 * @return
	 */
	public static String getTimeDaysAgo(int n) {
		Calendar calendar = Calendar.getInstance(Locale.CHINA);  
		calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - n); 
		return DATE_FORMATTER.format(calendar.getTime());
	}
	/**
	 * 获得n天前的时间点
	 * @param n
	 * @return
	 */
	public static String getDaysAgo(int n) {
		Calendar calendar = Calendar.getInstance(Locale.CHINA);  
		calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - n); 
		return DAY_FORMATTER.format(calendar.getTime());
	}
	
	public static String getDateDaysAgo(int n) {
		Calendar calendar = Calendar.getInstance(Locale.CHINA);  
		calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - n); 
		return FORMATTER.format(calendar.getTime());
	}
	
	
	/**
	 * 获得本周的第一天
	 * @param 
	 */
	public String getFirstDayByWeek(){
		Calendar cal = Calendar.getInstance();
		 int day_of_week = cal.get(Calendar.DAY_OF_WEEK) - 2;
		 cal.add(Calendar.DATE, -day_of_week);
		 return DATE_FORMATTER.format(cal.getTime());
	}
	
	public String getFirstDateByWeek(){
		Calendar cal = Calendar.getInstance();
		int day_of_week = cal.get(Calendar.DAY_OF_WEEK) - 2;
		cal.add(Calendar.DATE, -day_of_week);
		return FORMATTER.format(cal.getTime());
	}
	
	/**
	 * 获得本月的第一天
	 * @param args
	 * @throws ParseException
	 */
	public String getFirstDayBymonth(){
		Calendar cal = Calendar.getInstance();
	    Calendar f = (Calendar)cal.clone();
	    f.clear();
		f.set(Calendar.YEAR,cal.get(Calendar.YEAR));
		f.set(Calendar.MONTH,cal.get(Calendar.MONTH));
		return DAY_FORMATTER.format(f.getTime());
	}
	public String getFirstDateBymonth(){
		Calendar cal = Calendar.getInstance();
		Calendar f = (Calendar)cal.clone();
		f.clear();
		f.set(Calendar.YEAR,cal.get(Calendar.YEAR));
		f.set(Calendar.MONTH,cal.get(Calendar.MONTH));
		return FORMATTER.format(f.getTime());
	}
	
	 //获得上个月第一天的日期        
    public String getLastMonthFirst(){        
        String str = "";        
       Calendar lastDate = Calendar.getInstance();        
      lastDate.add(Calendar.MONTH,-1);//减一个月        
      lastDate.set(Calendar.DATE, 1);//把日期设置为当月第一天         
       str=DAY_FORMATTER.format(lastDate.getTime());        
       return str;          
    }  
	
	 //获得上月最后一天的日期        
    public String getPreviousMonthEnd(){        
        String str = "";        
       Calendar lastDate = Calendar.getInstance();        
      lastDate.add(Calendar.MONTH,-1);//减一个月        
      lastDate.set(Calendar.DATE, 1);//把日期设置为当月第一天         
      lastDate.roll(Calendar.DATE, -1);//日期回滚一天，也就是本月最后一天         
       str=DAY_FORMATTER.format(lastDate.getTime());        
       return str;          
    }  
    int weeks = 0;
 // 获得上周星期一的日期        
    public String getPreviousWeekday() {        
        weeks--;        
        int mondayPlus = this.getMonthPlus();        
        GregorianCalendar currentDate = new GregorianCalendar();        
        currentDate.add(Calendar.DATE, mondayPlus + 7 * weeks);        
        Date monday = currentDate.getTime();        
        DateFormat df = DateFormat.getDateInstance();        
        String preMonday = DATE_FORMATTER.format(monday);        
        return preMonday;        
    } 
    //获得上周日的日期
    public String getPreviousSunday(){
		  Calendar cal=Calendar.getInstance();
		  cal.set(Calendar.DAY_OF_WEEK, 1);
		  return DATE_FORMATTER.format(cal.getTime());
    }
    
    private int getMonthPlus(){        
        Calendar cd = Calendar.getInstance();        
        int monthOfNumber = cd.get(Calendar.DAY_OF_MONTH);        
        cd.set(Calendar.DATE, 1);//把日期设置为当月第一天         
        cd.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天         
        int MaxDate = cd.get(Calendar.DATE);         
        if(monthOfNumber == 1){        
            return -MaxDate;        
        }else{        
            return 1-monthOfNumber;        
        }        
    } 
    //获得当前时间
    public String getCurrentTime(){
    	return DATE_FORMATTER.format(new Date());
    }
    public String getCurrentDate(){
    	return FORMATTER.format(new Date());
    }
    
    public static Date convertToServerDateTime(String sdate) {
		Date date = null;
		try {
			date = DATE_FORMATTER.parse(sdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
    
    public String getCurrentDate(String millis){
    	millis = millis+"000";
    	String date = "";
		Date datexx = new Date(Long.parseLong(millis));
		date = DAY_FORMATTER.format(datexx);
		return date;
    }
    
	public static void main(String[] args) throws ParseException {
		TimeHelper t = new TimeHelper();
//		SimpleDateFormat sfdis = new SimpleDateFormat("yyyy");
//		System.out.println(t.beforeDate(7));
//		String date = t.getCurrentDate();
//		System.out.println(date);
		System.out.println(TimeHelper.getDaysAgo(0));
//		System.out.println(t.getTimeMonthsAgo(2));
//		System.out.println(t.getLastMonthFirst());
//		System.out.println(t.getFirstDayBymonth());
//		System.out.println(t.getLastMonthFirst());
//		SimpleDateFormat HOUR_FORMATTER = new SimpleDateFormat("yyyy年MM月");
//		System.out.println(HOUR_FORMATTER.format(new Date()));
//		String date = "2011-06-04";
//		int index = date.lastIndexOf("-");
//		System.out.println(date.substring(0,index).replaceAll("-","年")+"月");
//		System.out.println(t.getTimeWeeksAgo(1));
	}
}
