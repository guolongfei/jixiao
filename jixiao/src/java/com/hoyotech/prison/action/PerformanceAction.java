package com.hoyotech.prison.action;


import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.hoyotech.prison.bean.Comment;
import com.hoyotech.prison.bean.JX_People;
import com.hoyotech.prison.bean.Performance;
import com.hoyotech.prison.service.impl.PerformanceService;


public class PerformanceAction {
	private PerformanceService performanceService;
	private Performance performance;
	private List<Performance> pfList;//某年某月的日记载列表
	private List<Performance> pfmonthList;//某年某月的月小结
	private List<Performance> pfseasonList;//某年所有季汇总
	private String year;//查询某年的绩效
	private String month;//查询某月的绩效
	private String pageNumber;//分页第几页
	private String now;//当前时间
	private Performance pfOfmonth;//月计划
	private Performance pfOfseason;//季计划
	private Performance summaryOfmonth;//月小结
	private Performance summaryOfseason;//季汇总
	private Integer type;//当前季度
	private Performance purposeOfyear;//年度工作目标
	private Performance summaryOfyear;//年总结
	private String errorMsg;//返回操作的结果
	private JX_People jxPeople; //当前登录的人
	private List<JX_People> jpList;//当前部门所有人员
	private String empId;//当前部门其他人员的ID
	private String empName;//当前部门其他人员的真实姓名
	private String empName1;//当前部门其他人员的真实姓名
	
	private String commentContent; //评论内容
	private List<Comment> cmList;  //获取评论列表
	private List<Comment> fyList;  //分页获取评论列表
	private String name;           //用户真实姓名
	private int commentNum;        //评论数量
	private int pageNum;       //分页当前页
	private int totalPage;     //分页总数
	
	private int postId;//当前登录人部门职位ID
	
	
	
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public List<Comment> getFyList() {
		return fyList;
	}
	public void setFyList(List<Comment> fyList) {
		this.fyList = fyList;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Comment> getCmList() {
		return cmList;
	}
	public void setCmList(List<Comment> cmList) {
		this.cmList = cmList;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	
	public String getEmpName1() {
		return empName1;
	}
	public void setEmpName1(String empName1) {
		this.empName1 = empName1;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public List<JX_People> getJpList() {
		return jpList;
	}
	public void setJpList(List<JX_People> jpList) {
		this.jpList = jpList;
	}
	public List<Performance> getPfseasonList() {
		return pfseasonList;
	}
	public void setPfseasonList(List<Performance> pfseasonList) {
		this.pfseasonList = pfseasonList;
	}
	public JX_People getJxPeople() {
		return jxPeople;
	}
	public void setJxPeople(JX_People jxPeople) {
		this.jxPeople = jxPeople;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public Performance getSummaryOfyear() {
		return summaryOfyear;
	}
	public void setSummaryOfyear(Performance summaryOfyear) {
		this.summaryOfyear = summaryOfyear;
	}
	public Performance getPurposeOfyear() {
		return purposeOfyear;
	}
	public void setPurposeOfyear(Performance purposeOfyear) {
		this.purposeOfyear = purposeOfyear;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public List<Performance> getPfmonthList() {
		return pfmonthList;
	}
	public void setPfmonthList(List<Performance> pfmonthList) {
		this.pfmonthList = pfmonthList;
	}
	public Performance getSummaryOfseason() {
		return summaryOfseason;
	}
	public void setSummaryOfseason(Performance summaryOfseason) {
		this.summaryOfseason = summaryOfseason;
	}
	public Performance getSummaryOfmonth() {
		return summaryOfmonth;
	}
	public void setSummaryOfmonth(Performance summaryOfmonth) {
		this.summaryOfmonth = summaryOfmonth;
	}
	public Performance getPfOfseason() {
		return pfOfseason;
	}
	public void setPfOfseason(Performance pfOfseason) {
		this.pfOfseason = pfOfseason;
	}
	public Performance getPfOfmonth() {
		return pfOfmonth;
	}
	public void setPfOfmonth(Performance pfOfmonth) {
		this.pfOfmonth = pfOfmonth;
	}
	public String getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(String pageNumber) {
		this.pageNumber = pageNumber;
	}
	public String getNow() {
		return now;
	}
	public void setNow(String now) {
		this.now = now;
	}
	public List<Performance> getPfList() {
		return pfList;
	}
	public void setPfList(List<Performance> pfList) {
		this.pfList = pfList;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	
	public PerformanceService getPerformanceService() {
		return performanceService;
	}
	public void setPerformanceService(PerformanceService performanceService) {
		this.performanceService = performanceService;
	}

	public Performance getPerformance() {
		return performance;
	}
	public void setPerformance(Performance performance) {
		this.performance = performance;
	}
	
	//工作职责提交和更新
	public String saveOfDuty(){
		errorMsg = "";
		String employeeId = (String)ServletActionContext.getContext().getSession().get("userid");
		jxPeople.setId(employeeId);
		jxPeople = performanceService.updateDuty(employeeId, jxPeople);
		errorMsg = "success";
		return getPerformanceList();
	}

    //跳转到日记载页面
	public String toPFEditByday(){
		List<Performance> list = performanceService.getpfnow();
		performance = list.size()>0?list.get(0):null;
		if(performance == null){
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			now = sf.format(new Date());
		}
		return "toPFEditByday";
	}

	//日记载提交
	public String savePFByday(){
		//HttpServletResponse resp = ServletActionContext.getResponse();
		//resp.setContentType("text/html; charset=utf-8");
		String employeeId = (String)ServletActionContext.getContext().getSession().get("userid");
		errorMsg = "";
		if(!"".equals(performance.getPerformanceId())&&performance.getPerformanceId()!=null){
			performance = performanceService.updatePF(performance);	
		}else{
			performance.setEmployeeId(employeeId);
			performance.setPerformance_date(new Date());
			performance.setPerformance_type(1); 
			performance = performanceService.savePFByday(performance);
		}
		errorMsg = "success";
		return "savePFByday";
	}
	
	//我的实绩记载展示
	public String getPerformanceList(){
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		now = sf.format(new Date());
		//获取当前年月
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int y = cal.get(Calendar.YEAR);
		int m = cal.get(Calendar.MONTH)+1;
		if("".equals(year)||year==null){
			year = y+"";
		}
		if("".equals(month)||month==null){
			if((m+"").length()==1){
				month = "0"+m;
			}else{
				month = m+"";
			}
		}
		//获取工作职责
		String employeeId = (String)ServletActionContext.getContext().getSession().get("userid");
		jxPeople = performanceService.getMyDuty(employeeId);
		//获取月计划
		pfOfmonth = performanceService.getPFBymonth(year,month,employeeId);
		//获取季计划
		pfOfseason = performanceService.getPFByseason(year, month,employeeId);
		//获取年度工作目标
		purposeOfyear = performanceService.getPurpose(year,employeeId);
		int pageNumber1 = ("".equals(pageNumber)||pageNumber==null)?1:Integer.parseInt(pageNumber);
		//获取某月每天的日记载
		pfList = performanceService.getpfListByMonth(year, month, pageNumber1,employeeId);
		return "performanceList";
	}
	
	//根据ID查询每日的记载
	public String getPerformanceById(){
		performance = performanceService.getPFById(performance);
		return "myPerformance"; 
	}
	
	//跳转到月绩效管理界面
	public String toPFOfmonth(){
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		now = sf.format(new Date());
		//获取当前年月
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int y = cal.get(Calendar.YEAR);
		int m = cal.get(Calendar.MONTH)+1;
		year = y+"";
    	if((m+"").length()==1){
				month = "0"+m;
			}else{
				month = m+"";
		}
    	if("".equals(year)||year==null){
			year = y+"";
		}
    	String employeeId = (String)ServletActionContext.getContext().getSession().get("userid");
		//获取月计划
		pfOfmonth = performanceService.getPFBymonth(year,month,employeeId);
		int pageNumber1 = ("".equals(pageNumber)||pageNumber==null)?1:Integer.parseInt(pageNumber);
		//获取当前月每天的日记载
		pfList = performanceService.getpfListByMonth(year, month, pageNumber1,employeeId);
		//获取当前月的小结
		summaryOfmonth = performanceService.getPFSubBymonth(year, month,employeeId);
		//获取当前年份所有月小结
		pfmonthList = performanceService.getsumOfmonthList(year);
		return "toPFOfmonth";
	}
	
	//月计划提交
	public String submitPlanOfmonth(){
		errorMsg = "";
		String employeeId = (String)ServletActionContext.getContext().getSession().get("userid");
		if(!"".equals(pfOfmonth.getPerformanceId())&&pfOfmonth.getPerformanceId()!=null){
			pfOfmonth = performanceService.updatePF(pfOfmonth);	
		}else{
			pfOfmonth.setEmployeeId(employeeId);
			pfOfmonth.setPerformance_date(new Date());
			pfOfmonth.setPerformance_type(2); 
			pfOfmonth = performanceService.savePFByday(pfOfmonth);
		}
		errorMsg = "success";
		return toPFOfmonth();
	}
	
	//月小结提交
	public String subSumOfmonth(){
		errorMsg = "";
		String employeeId = (String)ServletActionContext.getContext().getSession().get("userid");
		if(!"".equals(summaryOfmonth.getPerformanceId())&&summaryOfmonth.getPerformanceId()!=null){
			summaryOfmonth = performanceService.updatePF(summaryOfmonth);	
		}else{Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int m = cal.get(Calendar.MONTH)+1;
		int type = 0;
		if(m==1||m==2||m==3){
			type = 1;
		}else if(m==4||m==5||m==6){
			type = 2;
		}else if(m==7||m==8||m==9){
			type = 3;
		}else{
			type = 4;
		}
		summaryOfmonth.setSeason_type(type);
		summaryOfmonth.setEmployeeId(employeeId);
		summaryOfmonth.setPerformance_date(new Date());
		summaryOfmonth.setPerformance_type(5); 
		summaryOfmonth = performanceService.savePFByday(summaryOfmonth);
		}
		errorMsg = "success";
		return toPFOfmonth();
	}
	

	//跳转到季绩效管理界面
	public String toPFOfseason(){
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		now = sf.format(new Date());
		//获取当前年月
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int y = cal.get(Calendar.YEAR);
		int m = cal.get(Calendar.MONTH)+1;
		if(m==1||m==2||m==3){
			type = 1;
		}else if(m==4||m==5||m==6){
			type = 2;
		}else if(m==7||m==8||m==9){
			type = 3;
		}else{
			type = 4;
		}
		year = y+"";
    	if((m+"").length()==1){
				month = "0"+m;
			}else{
				month = m+"";
		}
    	String employeeId = (String)ServletActionContext.getContext().getSession().get("userid");
		//获取季计划
    	pfOfseason = performanceService.getPFByseason(year, month,employeeId);
		int pageNumber1 = ("".equals(pageNumber)||pageNumber==null)?1:Integer.parseInt(pageNumber);
		//获取当前月每天的日记载
		pfList = performanceService.getpfListByMonth(year, month, pageNumber1,employeeId);
		//获取当前季度每月的月小结
		pfmonthList = performanceService.getsumOfmonthList(year, month);
		//获取当前季汇总
		summaryOfseason = performanceService.getPFSubByseason(year, month,employeeId);
		//获取当前年份所有季汇总
		pfseasonList = performanceService.getsumOfseasonList(year);
		return "toPFOfseason";
	}
	
	//季计划提交
	public String submitOfseason(){
		errorMsg = "";
		String employeeId = (String)ServletActionContext.getContext().getSession().get("userid");
		if(!"".equals(pfOfseason.getPerformanceId())&&pfOfseason.getPerformanceId()!=null){
			pfOfseason = performanceService.updatePF(pfOfseason);	
		}else{
			pfOfseason.setEmployeeId(employeeId);
			pfOfseason.setPerformance_date(new Date());
			pfOfseason.setPerformance_type(3);
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			int m = cal.get(Calendar.MONTH)+1;
			int type = 0;
			if(m==1||m==2||m==3){
				type = 1;
			}else if(m==4||m==5||m==6){
				type = 2;
			}else if(m==7||m==8||m==9){
				type = 3;
			}else{
				type = 4;
			}
			pfOfseason.setSeason_type(type);
			pfOfseason = performanceService.savePFByday(pfOfseason);
		}
		errorMsg = "success";
		return toPFOfseason();
	}
	
	//季汇总提交
	public String submitOfseasonSum(){
		errorMsg = "";
		String employeeId = (String)ServletActionContext.getContext().getSession().get("userid");
		if(!"".equals(summaryOfseason.getPerformanceId())&&summaryOfseason.getPerformanceId()!=null){
			summaryOfseason = performanceService.updatePF(summaryOfseason);	
		}else{
			summaryOfseason.setEmployeeId(employeeId);
			summaryOfseason.setPerformance_date(new Date());
			summaryOfseason.setPerformance_type(6);
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			int m = cal.get(Calendar.MONTH)+1;
			int type = 0;
			if(m==1||m==2||m==3){
				type = 1;
			}else if(m==4||m==5||m==6){
				type = 2;
			}else if(m==7||m==8||m==9){
				type = 3;
			}else{
				type = 4;
			}
			summaryOfseason.setSeason_type(type);
			summaryOfseason = performanceService.savePFByday(summaryOfseason);
		}
		errorMsg = "success";
		return toPFOfseason();
	}
	
	//获取某月每日记载JSON
	public void getpfbyday(){
		String errorMsg = "";
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int y = cal.get(Calendar.YEAR);
		int m = cal.get(Calendar.MONTH)+1;
		if("".equals(year)||year==null){
			year = y+"";
		}
		if("".equals(month)||month==null){
			if((m+"").length()==1){
				month = "0"+m;
			}else{
				month = m+"";
			}
		}
		String employeeId = (String)ServletActionContext.getContext().getSession().get("userid");
		if(empId!=null&&!"".equals(empId)){
			employeeId = empId;
		}
		int pageNumber1 = ("".equals(pageNumber)||pageNumber==null)?1:Integer.parseInt(pageNumber);
		pfList = performanceService.getpfListByMonth(year, month, pageNumber1,employeeId);
		//获取月计划
		pfOfmonth = performanceService.getPFBymonth(year,month,employeeId);
		//获取当前月的小结
		summaryOfmonth = performanceService.getPFSubBymonth(year, month,employeeId);
		errorMsg = "success";
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		String time = "";
		if(pfList.size()>0){
			for (int i = 0; i < pfList.size(); i++) {
				JSONObject j = new JSONObject();
				j.put("id", pfList.get(i).getPerformanceId());
				j.put("content", pfList.get(i).getPerformance_content());
				time = sf.format(pfList.get(i).getPerformance_date());
				j.put("time", time);
				array.put(i, j);
			}
		}
		json.put("array", array);
		json.put("summaryOfmonth", summaryOfmonth!=null?summaryOfmonth.getPerformance_content():null);
		json.put("pfOfmonth", pfOfmonth!=null?pfOfmonth.getPerformance_content():null);
		json.put("errorMsg", errorMsg);
		try {
			ServletActionContext.getResponse().setContentType("text/json; charset=UTF-8");
			PrintWriter out = ServletActionContext.getResponse().getWriter();
			out.print(json);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//年度工作目标提交
	public String purposeOfyear(){
		errorMsg = "";
		String employeeId = (String)ServletActionContext.getContext().getSession().get("userid");
		if(!"".equals(purposeOfyear.getPerformanceId())&&purposeOfyear.getPerformanceId()!=null){
			purposeOfyear = performanceService.updatePF(purposeOfyear);
		}else{
			purposeOfyear.setEmployeeId(employeeId);
			purposeOfyear.setPerformance_date(new Date());
			purposeOfyear.setPerformance_type(4);
			purposeOfyear = performanceService.savePFByday(purposeOfyear);
		}
		errorMsg = "success";
		return toPFOfyear();
	}
	
    //跳转到年绩效管理界面
	public String toPFOfyear(){
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		now = sf.format(new Date());
		//获取当前年月
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int y = cal.get(Calendar.YEAR);
		int m = cal.get(Calendar.MONTH)+1;
		year = y+"";
    	if((m+"").length()==1){
				month = "0"+m;
			}else{
				month = m+"";
		}
    	String employeeId = (String)ServletActionContext.getContext().getSession().get("userid");
		//获取年度工作目标
    	purposeOfyear = performanceService.getPurpose(year,employeeId);
		int pageNumber1 = ("".equals(pageNumber)||pageNumber==null)?1:Integer.parseInt(pageNumber);
		//获取当前月每天的日记载
		pfList = performanceService.getpfListByMonth(year, month, pageNumber1,employeeId);
		//获取今年的所有月小结
		pfmonthList = performanceService.getsumOfmonthList(year);
		//获取当前年总结
		summaryOfyear = performanceService.getPFSubByYear(year);
		return "jixiaoOfyear";
	}
	
	//年总结提交
	public String submitSubOfyear(){
		errorMsg = "";
		String employeeId = (String)ServletActionContext.getContext().getSession().get("userid");
		if(!"".equals(summaryOfyear.getPerformanceId())&&summaryOfyear.getPerformanceId()!=null){
			summaryOfyear = performanceService.updatePF(summaryOfyear);
		}else{
			summaryOfyear.setEmployeeId(employeeId);
			summaryOfyear.setPerformance_date(new Date());
			summaryOfyear.setPerformance_type(7);
			summaryOfyear = performanceService.savePFByday(summaryOfyear);
		}
		errorMsg = "success";
		return toPFOfyear();
	}
	
	//获取其它年份的年终总结
   public void getyearsub(){
	   errorMsg = "";
	   JSONObject json  = new JSONObject();
	   summaryOfyear = performanceService.getPFSubByYear(year);
	   errorMsg = "success";
	   json.put("content", summaryOfyear!=null&&!"".equals(summaryOfyear)?summaryOfyear.getPerformance_content():"");
	   json.put("errorMsg", errorMsg);
	   try {
			ServletActionContext.getResponse().setContentType("text/json; charset=UTF-8");
			PrintWriter out = ServletActionContext.getResponse().getWriter();
			out.print(json);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   } 	
	//定时器程序
	public void bookTime1(){
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		Date date = new Date();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, -1);
		date = cal.getTime();
		String time  = sf.format(date);
		performanceService.btPerformance(time);
	}
	
	//获取本部门人员列表人员列表 
	public String getPeopleList(){
		if(pageNum<=0){
			pageNum = 1;
		}else if(pageNum>=totalPage){
			pageNum = totalPage;
		}else{
		}
		if(jpList == null){
			jpList = performanceService.getpeoples();
			if((jpList.size()%10)!=0){
				totalPage = (jpList.size()/10)+1;
			}else{
				totalPage = jpList.size()/10;
			}	
			jpList = performanceService.getpeoples(pageNum);
		}else{
			jpList = null;
			jpList = performanceService.getpeoples(pageNum);
		}
		return "otherjixiao";
	}
	
	//获取部门其他人绩效情况
	public String getOthersPerformance(){
		//String empName = "";
		Integer po = (Integer) ServletActionContext.getContext().getSession().get("peoPost");
		if(po<postId){
			postId = 1;
		}else{
			postId = 0;
		}
		try {
			//empName1 = URLDecoder.decode(empName, "utf-8");
			if(!"1".equals(empName1)){
				empName = URLDecoder.decode(empName, "utf-8");
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		now = sf.format(new Date());
		//获取当前年月
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int y = cal.get(Calendar.YEAR);
		int m = cal.get(Calendar.MONTH)+1;
		if("".equals(year)||year==null){
			year = y+"";
		}
		if("".equals(month)||month==null){
			if((m+"").length()==1){
				month = "0"+m;
			}else{
				month = m+"";
			}
		}
		//获取工作职责
		jxPeople = performanceService.getMyDuty(empId);
		//获取月计划
		pfOfmonth = performanceService.getPFBymonth(year,month,empId);
		//获取季计划
		pfOfseason = performanceService.getPFByseason(year, month,empId);
		//获取年度工作目标
		purposeOfyear = performanceService.getPurpose(year,empId);
		int pageNumber1 = ("".equals(pageNumber)||pageNumber==null)?1:Integer.parseInt(pageNumber);
		//获取某月每天的日记载
		pfList = performanceService.getpfListByMonth(year, month, pageNumber1,empId);
		
		//获取评论列表
		cmList=performanceService.getCommentList(empId);
		name=(String) ServletActionContext.getRequest().getSession().getAttribute("name");
		if(cmList.size()==0)
		{
			commentNum=0;
		}
		else
		{
			commentNum=cmList.size();
		}
		
		//评论分页
		if(pageNum==0)
		{
			pageNum=1;
		}
		fyList=performanceService.getCommentFyList(empId,pageNum);
		totalPage = (commentNum - 1) / 5 + 1;
		return "otherjixiaoDetail";
	}
	
	//获取部门人员列表 季评鉴
	public String getPeopleList1(){
		//if(jpList!=null)
		//jpList = performanceService.getpeoples(pageNum);
		return "evaluationList";
	}
	
	//获取该季度所有实绩
	public String getOthersPerformance1(){
		//String empName1 = "";
		try {
			if(!"1".equals(empName1)){
				//empName = new String(empName.getBytes("ISO-8859-1"),"utf-8");
				empName = URLDecoder.decode(empName, "utf-8");
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		now = sf.format(new Date());
		//获取当前年月
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int y = cal.get(Calendar.YEAR);
		int m = cal.get(Calendar.MONTH)+1;
		if(m==1||m==2||m==3){
			type = 1;
		}else if(m==4||m==5||m==6){
			type = 2;
		}else if(m==7||m==8||m==9){
			type = 3;
		}else{
			type = 4;
		}
		if("".equals(year)||year==null){
			year = y+"";
		}
		if("".equals(month)||month==null){
			if((m+"").length()==1){
				month = "0"+m;
			}else{
				month = m+"";
			}
		}
		//获取工作职责
		jxPeople = performanceService.getMyDuty(empId);
		//获取月计划
		pfOfmonth = performanceService.getPFBymonth(year,month,empId);
		//获取月小结
		summaryOfmonth = performanceService.getPFSubBymonth(year, month,empId);
		//获取季计划
		pfOfseason = performanceService.getPFByseason(year, month,empId);
		//获取季汇总
		summaryOfseason = performanceService.getPFSubByseason(year, month,empId);
		//获取年度工作目标
		purposeOfyear = performanceService.getPurpose(year,empId);
		int pageNumber1 = ("".equals(pageNumber)||pageNumber==null)?1:Integer.parseInt(pageNumber);
		//获取某月每天的日记载
		pfList = performanceService.getpfListByMonth(year, month, pageNumber1,empId);
		name=(String) ServletActionContext.getRequest().getSession().getAttribute("name");
		return "jixiaoOfseasonDetail";
	}
	
	//工作目标的编辑展示
	public String toPurpose(){
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		now = sf.format(new Date());
		//获取当前年月
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int y = cal.get(Calendar.YEAR);
		int m = cal.get(Calendar.MONTH)+1;
		year = y+"";
    	if((m+"").length()==1){
				month = "0"+m;
			}else{
				month = m+"";
		}
    	String employeeId = (String)ServletActionContext.getContext().getSession().get("userid");
		//获取年度工作目标
    	purposeOfyear = performanceService.getPurpose(year,employeeId);
    	//获取季计划
    	pfOfseason = performanceService.getPFByseason(year, month,employeeId);
    	//获取月计划
		pfOfmonth = performanceService.getPFBymonth(year,month,employeeId);
		return "toPurpose";
	}
	//提交工作目标
	public String savePurpose(){
		//提交年度工作目标
		errorMsg = "";
		String employeeId = (String)ServletActionContext.getContext().getSession().get("userid");
		if(!"".equals(purposeOfyear.getPerformanceId())&&purposeOfyear.getPerformanceId()!=null){
			purposeOfyear = performanceService.updatePF(purposeOfyear);
		}else{
			purposeOfyear.setEmployeeId(employeeId);
			purposeOfyear.setPerformance_date(new Date());
			purposeOfyear.setPerformance_type(4);
			purposeOfyear = performanceService.savePFByday(purposeOfyear);
		}
		//提交季度工作目标
		if(!"".equals(pfOfseason.getPerformanceId())&&pfOfseason.getPerformanceId()!=null){
			pfOfseason = performanceService.updatePF(pfOfseason);	
		}else{
			pfOfseason.setEmployeeId(employeeId);
			pfOfseason.setPerformance_date(new Date());
			pfOfseason.setPerformance_type(3);
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			int m = cal.get(Calendar.MONTH)+1;
			int type = 0;
			if(m==1||m==2||m==3){
				type = 1;
			}else if(m==4||m==5||m==6){
				type = 2;
			}else if(m==7||m==8||m==9){
				type = 3;
			}else{
				type = 4;
			}
			pfOfseason.setSeason_type(type);
			pfOfseason = performanceService.savePFByday(pfOfseason);
		}
		//提交当月工作目标
		if(!"".equals(pfOfmonth.getPerformanceId())&&pfOfmonth.getPerformanceId()!=null){
			pfOfmonth = performanceService.updatePF(pfOfmonth);	
		}else{
			pfOfmonth.setEmployeeId(employeeId);
			pfOfmonth.setPerformance_date(new Date());
			pfOfmonth.setPerformance_type(2); 
			pfOfmonth = performanceService.savePFByday(pfOfmonth);
		}
		errorMsg = "success";
		return toPurpose();
	}

	//记录别人对我的绩效的评论
	public String saveComment()
	{
		Comment ct=new Comment();
		String employeeId = (String)ServletActionContext.getContext().getSession().get("userid");
		ct.setComment_userid(employeeId);
		ct.setCommentby_userid(empId);
		ct.setComment_time(new Date());
		ct.setComment_content(commentContent);
		performanceService.saveComment(ct);
		return getOthersPerformance();
		
	}

	//跳转到打印界面
	public String toJPrint(){
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		now = sf.format(new Date());
		//获取当前年月
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int y = cal.get(Calendar.YEAR);
		int m = cal.get(Calendar.MONTH)+1;
		if(m==1||m==2||m==3){
			type = 1;
		}else if(m==4||m==5||m==6){
			type = 2;
		}else if(m==7||m==8||m==9){
			type = 3;
		}else{
			type = 4;
		}
		if("".equals(year)||year==null){
			year = y+"";
		}
		if("".equals(month)||month==null){
			if((m+"").length()==1){
				month = "0"+m;
			}else{
				month = m+"";
			}
		}
		empId = (String)ServletActionContext.getContext().getSession().get("userid");
		//获取月计划
		pfOfmonth = performanceService.getPFBymonth(year,month,empId);
		//获取月小结
		summaryOfmonth = performanceService.getPFSubBymonth(year, month,empId);
		int pageNumber1 = ("".equals(pageNumber)||pageNumber==null)?1:Integer.parseInt(pageNumber);
		//获取某月每天的日记载
		pfList = performanceService.getpfListByMonth(year, month, pageNumber1,empId);
		return "toPrint";
	}

}
