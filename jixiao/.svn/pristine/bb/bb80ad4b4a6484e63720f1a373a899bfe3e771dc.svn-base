package com.hoyotech.prison.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.GradeTable;
import com.hoyotech.prison.bean.GradeTypeTable;
import com.hoyotech.prison.bean.JX_People;
import com.hoyotech.prison.bean.Police;
import com.hoyotech.prison.bean.RecordTable;
import com.hoyotech.prison.service.impl.RecordManageService;

public class RecordAction {
	private RecordManageService recordManageService;
	private String year;
	private String month;
	private String day;
	private RecordTable recordTable;
	private List list;
	private String startTime;
	private String endTime;
	private String recordState;
	private Police policeName;
	private GradeTable grade;
	private GradeTypeTable gradeType;
	private JX_People people;
	private String depId;
	
	private int pageNum;       //分页当前页
	private int totalNum;      //数据总数
	private int totalPage;     //分页总数
	
	private List list2;
	private List list1;
	
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List getList1() {
		return list1;
	}

	public void setList1(List list1) {
		this.list1 = list1;
	}

	public List getList2() {
		return list2;
	}

	public void setList2(List list2) {
		this.list2 = list2;
	}

	public String getDepId() {
		return depId;
	}

	public void setDepId(String depId) {
		this.depId = depId;
	}

	public JX_People getPeople() {
		return people;
	}

	public void setPeople(JX_People people) {
		this.people = people;
	}

	public GradeTable getGrade() {
		return grade;
	}

	public void setGrade(GradeTable grade) {
		this.grade = grade;
	}

	public GradeTypeTable getGradeType() {
		return gradeType;
	}

	public void setGradeType(GradeTypeTable gradeType) {
		this.gradeType = gradeType;
	}

	public Police getPoliceName() {
		return policeName;
	}

	public void setPoliceName(Police policeName) {
		this.policeName = policeName;
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

	public String getRecordState() {
		return recordState;
	}

	public void setRecordState(String recordState) {
		this.recordState = recordState;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public RecordTable getRecordTable() {
		return recordTable;
	}

	public void setRecordTable(RecordTable recordTable) {
		this.recordTable = recordTable;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public RecordManageService getRecordManageService() {
		return recordManageService;
	}

	public void setRecordManageService(RecordManageService recordManageService) {
		this.recordManageService = recordManageService;
	}

	@SuppressWarnings("unchecked")
	public String recordList(){
		Calendar a=Calendar.getInstance();
		year=String.valueOf(a.get(Calendar.YEAR));
		month=String.valueOf(a.get(Calendar.MONTH)+1);
		day=String.valueOf(a.get(Calendar.DATE));
		String sDate=year+"-"+month;
		String date=year+"-"+month+"-"+day;
		list = recordManageService.queryRec(sDate,date);
		return "recordList";
	}
	
	public String recordList2(){
		String date="";
		String lastDay="";
		if(month!=null&&!month.equals("")){
		date=year+"-"+month;
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR,Integer.parseInt(year));
		cal.set(Calendar.MONTH,Integer.parseInt(month));
		cal.add(Calendar.MONTH, -1);
		Date lastDay0 = cal.getTime();
		lastDay = new SimpleDateFormat("yyyy-MM-dd").format(lastDay0);
		}
		list = recordManageService.queryRecord(date,startTime,endTime,recordState,lastDay);
		return "recordList2";
	}
	
	//年考核
	public String gradeList(){
		Calendar a=Calendar.getInstance();
		year=String.valueOf(a.get(Calendar.YEAR));
		list=recordManageService.gradeList(year,recordState);
		return "gradeList";
	}
	
	public String queryDep(){
		if(pageNum==0)
		{
			pageNum=1;
		}
		list=recordManageService.queryDep(pageNum+"");
		list1=recordManageService.queryCheckVote();
		totalNum = recordManageService.getTotalDep2();
		totalPage = (totalNum - 1) / 10 + 1;
		return "queryDep";
	}
	
	public String queryDep2(){
		if(pageNum==0)
		{
			pageNum=1;
		}
		list=recordManageService.queryDep(pageNum+"");
		totalNum = recordManageService.getTotalDep2();
		totalPage = (totalNum - 1) / 10 + 1;
		
//		list2=recordManageService.queryCheckVote2();
		return "queryDep2";
	}
	
	// 内部测评
	public String InternalVote(){
		String[] sp = depId.split(",");
		for (int i = 0; i < sp.length; i++) {
			if(recordManageService.queryCheckVote(sp[i])){
			recordManageService.addInternalVote(sp[i]);
			}
		}
		list=recordManageService.queryVotes();
		return "InternalVote";
	}
	
	// 外部测评
	private String name;
	private String tel;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String OuternalVote(){
		String[] sp = depId.split(",");
		for (int i = 0; i < sp.length; i++) {
//			if(recordManageService.queryCheckVote2(sp[i],name,tel)){
				recordManageService.addOuternalVote(sp[i],name,tel);
//			}
		}
		list=recordManageService.queryVotes2();
		return "OuternalVote";
	}
	
	//测评汇总
	public String voteGather(){
		if(pageNum==0)
		{
			pageNum=1;
		}
		list=recordManageService.voteGather(recordState,pageNum+"");
		list2=recordManageService.queryDep(pageNum+"");
		totalNum = recordManageService.getTotalDep2();
		totalPage = (totalNum - 1) / 10 + 1;
		return "voteGather";
	}
	
	
	
	
}
