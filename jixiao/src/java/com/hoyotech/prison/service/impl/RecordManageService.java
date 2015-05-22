package com.hoyotech.prison.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.GradeTable;
import com.hoyotech.prison.bean.InternalVote;
import com.hoyotech.prison.bean.JX_Department;
import com.hoyotech.prison.bean.JX_People;
import com.hoyotech.prison.bean.JX_User;
import com.hoyotech.prison.bean.Memcon;
import com.hoyotech.prison.bean.MessageReleases;
import com.hoyotech.prison.bean.RecordTable;
import com.hoyotech.prison.dao.impl.BasicDao;


public class RecordManageService {
	private BasicDao dao;
	
	public BasicDao getDao() {
		return dao;
	}

	public void setDao(BasicDao dao) {
		this.dao = dao;
	}

	public List<RecordTable> queryRecord(String date,String startTime,String endTime,String recordState,String lastDay) {
		String hql="from RecordTable where 1=1 ";
		if(date!=null&&date.length()>0){
			hql+=" and recordDate>= to_date('"+date+"-01 00:00:00','yyyy-MM-dd hh24:mi:ss') and recordDate<=to_date('"+lastDay+" 23:59:59','yyyy-MM-dd hh24:mi:ss')";
		}
		if(startTime != null && startTime.length() > 0){
			hql+=" and startTime >=to_date('"+startTime+"','yyyy-MM-dd hh24:mi:ss')";
		}
		if(endTime != null && endTime.length() > 0){
			hql+=" and endTime<= to_date('"+endTime+"','yyyy-MM-dd hh24:mi:ss')";
		}
		if(recordState != null && recordState.length() > 0){
			hql+=" and recordState ='"+recordState+"'";
		}
		
		return (List<RecordTable>)dao.queryByHql(hql, new Object[]{});
	}
	

	public List<RecordTable> queryRecordById(Integer recordId) {
		String hql="from RecordTable where recordId="+recordId;
		return (List)dao.queryByHql(hql, new Object[]{});
	}

	public List queryRec(String date,String lastDay) {
			String hql="from RecordTable where recordDate>= to_date('"+date+"-1 00:00:00','yyyy-MM-dd hh24:mi:ss') and recordDate<=to_date('"+lastDay+" 23:59:59','yyyy-MM-dd hh24:mi:ss')";
			return (List<RecordTable>) dao.queryByHql(hql, new Object[]{});
	}

	public List gradeList(String year, String recordState) {
		String hql="from GradeTable gt where 1=1 ";
		if(year!=null&&year.length()>0){
			hql+=" and gt.gradeDate>= to_date('"+year+"-01-01 00:00:00','yyyy-MM-dd hh24:mi:ss') and gt.gradeDate<=to_date('"+year+"-12-30 23:59:59','yyyy-MM-dd hh24:mi:ss')";
		}
		if(recordState != null && recordState.length() > 0){
			hql+=" and gt.postId ='"+recordState+"'";
		}
		return (List)dao.queryByHql(hql, new Object[]{});
	}

	public List queryDep(String pageNum) {
		if(pageNum.equals("")||pageNum==null)
		{
			pageNum=1+"";
		}
		String hql="from JX_Department";
		return (List)dao.queryByHql(hql, new Object[]{},Integer.parseInt(pageNum),10);
	}

	public JX_User queryPeopleId(){
		String userId=(String) ServletActionContext.getRequest().getSession().getAttribute("userId");
		return (JX_User) dao.detail(JX_User.class, userId);
	}
	
	//新增内部测评数据
	public void addInternalVote(String valueOf) {
		JX_User user=new JX_User();
		JX_People people=new JX_People();
		user=queryPeopleId();
		InternalVote vote=new InternalVote();
		vote.setVoteTime(new Date());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String time=formatter.format(vote.getVoteTime());
		vote.setDepartmentId(valueOf);
		vote.setUserId(user.getId());
		people=user.getJx_people();
		vote.setPeopleId(people.getId());
		vote.setVotesNumber(1);
		vote.setVoteType("1");
		dao.save(vote);
	}

	public List queryVotes() {
		String hql="select iv.voteTime,jp.name,jd.name,jd.level from InternalVote iv,JX_Department jd,JX_People jp where iv.voteType='1' and iv.departmentId=jd.id and iv.peopleId=jp.id";
		return (List)dao.queryByHql(hql, new Object[]{});
	}

	//新增外部测评数据
	public void addOuternalVote(String string,String name,String tel) {
		JX_User user=new JX_User();
		JX_People people=new JX_People();
		user=queryPeopleId();
		InternalVote vote=new InternalVote();
		vote.setVoteTime(new Date());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String time=formatter.format(vote.getVoteTime());
		vote.setDepartmentId(string);
		vote.setUserId(user.getId());
		people=user.getJx_people();
		vote.setPeopleId(people.getId());
		vote.setVotesNumber(1);
		vote.setVoteType("0");
		vote.setName(name);
		vote.setTel(tel);
		dao.save(vote);
		
	}

	public List queryVotes2() {
		String hql="select iv.voteTime,iv.name,iv.tel,jd.level,jd.id from InternalVote iv,JX_Department jd,JX_People jp where iv.voteType='0' and iv.departmentId=jd.id and iv.peopleId=jp.id";
		return (List)dao.queryByHql(hql, new Object[]{});
	}

	public List checkDep(String string) {
		String userId=(String) ServletActionContext.getRequest().getSession().getAttribute("userId");
		String hql="from InternalVote where userId='"+userId +"' and departmentId='"+string+"'";
		return (List)dao.queryByHql(hql, new Object[]{});
	}

	
	public List queryCheckVote() {
		String userId=(String) ServletActionContext.getRequest().getSession().getAttribute("userId");
		String hql="select departmentId from InternalVote where voteType='1' and userId='"+userId +"'";
		return (List)dao.queryByHql(hql, new Object[]{});
	}
	
	public boolean queryCheckVote(String sp) {
		String userId=(String) ServletActionContext.getRequest().getSession().getAttribute("userId");
		String hql="select departmentId from InternalVote where voteType='1' and userId='"+userId +"' and departmentId = '"+sp+"'";
		List list = (List)dao.queryByHql(hql, new Object[]{});
		return list.size()==0;
	}

	public List queryCheckVote2() {
		String userId=(String) ServletActionContext.getRequest().getSession().getAttribute("userId");
		String hql="select departmentId from InternalVote where voteType='0' and userId='"+userId +"'";
		return (List)dao.queryByHql(hql, new Object[]{});
	}

	public boolean queryCheckVote2(String sp,String name, String tel) {
		String userId=(String) ServletActionContext.getRequest().getSession().getAttribute("userId");
		String hql="select departmentId from InternalVote where voteType='0' and userId='"+userId +"' and departmentId = '"+sp+"' and tel='"+tel+"' and name='"+name+"'" ;
		List list = (List)dao.queryByHql(hql, new Object[]{});
		return list.size()==0;
	}

	public List voteGather(String voteType,String pageNum) {
		if(pageNum.equals("")||pageNum==null)
		{
			pageNum=1+"";
		}
		
		Calendar a=Calendar.getInstance();
		String year=String.valueOf(a.get(Calendar.YEAR));
		String hql="select jd.name,jd.level,count(iv.departmentId) from InternalVote iv,JX_Department jd where iv.departmentId=jd.id ";
		if(voteType!=null&&!voteType.equals("")){
			hql+=" and iv.voteType='"+voteType+"' ";
		}
		hql+="and iv.voteTime>=to_date('"+year+"01-01 00:00:00','yyyy-MM-dd hh24:mi:ss') and iv.voteTime<=to_date('"+year+"12-30 00:00:00','yyyy-MM-dd hh24:mi:ss')  group by jd.name,jd.level order by count(iv.departmentId)";
		return (List)dao.queryByHql(hql, new Object[]{},Integer.parseInt(pageNum),10);
	}

	public int getTotalDep2() {
		return 0;
	}
	

}
