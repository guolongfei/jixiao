package com.hoyotech.prison.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.Comment;
import com.hoyotech.prison.bean.JX_People;
import com.hoyotech.prison.bean.Performance;
import com.hoyotech.prison.dao.impl.BasicDao;

public class PerformanceService {
	private BasicDao dao;

	public BasicDao getDao() {
		return dao;
	}

	public void setDao(BasicDao dao) {
		this.dao = dao;
	}
	
	
	//日记载，月小结或月计划提交dao层
	public Performance savePFByday(Performance p){
		dao.save(p);
		return p;
	}
	//日记载，月小结或月计划更新
	public Performance updatePF(Performance performance){
		String hql = "from Performance p where p.performanceId = ?";
		Performance p = (Performance)dao.queryByHql(hql, new Object[]{performance.getPerformanceId()}).get(0);
		p.setPerformance_content(performance.getPerformance_content());
		dao.update(p);
		return p;
	}
   //获取今天的日记载
	public List<Performance> getpfnow(){
		String employeeId = (String)ServletActionContext.getContext().getSession().get("userid");
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		String now = sf.format(new Date());
		String sql = "from Performance p where to_char(p.performance_date,'yyyy-MM-dd') = ? and p.performance_type = 1 and p.employeeId=?";
		List<Performance> list = (List<Performance>)dao.queryByHql(sql, new Object[]{now,employeeId});
		return list;
	}
	//获取某个月每日记载
	public List<Performance> getpfListByMonth(String year,String month,int pageNumber,String employeeId){
		String hql = "from Performance p where to_char(p.performance_date,'yyyy') = ? and to_char(p.performance_date,'MM') = ? and p.performance_type = 1 and p.employeeId=? order by p.performance_date desc";
		List<Performance> list = (List<Performance>)dao.queryByHql(hql, new Object[]{year,month,employeeId}, pageNumber, 40);
		return list;
	}
	//根据ID获取记载
	public Performance getPFById(Performance performance){
		String hql = "from Performance p where p.performanceId = ?";
		Performance p = (Performance)dao.queryByHql(hql, new Object[]{performance.getPerformanceId()}).get(0);
		return p;
	}
	//获取个人月计划
	public Performance getPFBymonth(String year,String month,String employeeId){
		String hql = "from Performance p where to_char(p.performance_date,'yyyy') = ? and to_char(p.performance_date,'MM') = ? and p.performance_type = 2 and p.employeeId=?";
		List<Performance> list = (List<Performance>)dao.queryByHql(hql, new Object[]{year,month,employeeId});
		return list.size()>0?list.get(0):null;
	}
	
	//获取当月小结
	public Performance getPFSubBymonth(String year,String month,String employeeId){
		String hql = "from Performance p where to_char(p.performance_date,'yyyy') = ? and to_char(p.performance_date,'MM') = ? and p.performance_type = 5 and p.employeeId=?";
		List<Performance> list = (List<Performance>)dao.queryByHql(hql, new Object[]{year,month,employeeId});
		return list.size()>0?list.get(0):null;
	}
	
	//获取个人季计划
	public Performance getPFByseason(String year,String month,String employeeId){
		int m = Integer.parseInt(month);
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
		String hql = "from Performance p where to_char(p.performance_date,'yyyy') = ? and p.season_type = ? and p.performance_type = 3 and p.employeeId=?";
		List<Performance> list = (List<Performance>)dao.queryByHql(hql, new Object[]{year,type,employeeId});
		return list.size()>0?list.get(0):null;
	} 
	
	//获取当前季汇总
	public Performance getPFSubByseason(String year,String month,String employeeId){
		int m = Integer.parseInt(month);
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
		String hql = "from Performance p where to_char(p.performance_date,'yyyy') = ? and p.season_type = ? and p.performance_type = 6 and p.employeeId=?";
		List<Performance> list = (List<Performance>)dao.queryByHql(hql, new Object[]{year,type,employeeId});
		return list.size()>0?list.get(0):null;
	} 
	
	//获取当前季度月小结列表
	public List<Performance> getsumOfmonthList(String year,String month){
		String employeeId = (String)ServletActionContext.getContext().getSession().get("userid");
		int m = Integer.parseInt(month);
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
		String hql = "from Performance p where to_char(p.performance_date,'yyyy') = ? and p.season_type = ? and p.performance_type = 5 and p.employeeId=? order by p.performance_date desc";
		List<Performance> list = (List<Performance>)dao.queryByHql(hql, new Object[]{year,type,employeeId});
		return list.size()>0?list:null;
	}
	
	//获取个人年度工作目标
	public Performance getPurpose(String year,String employeeId){
		String hql = "from Performance p where to_char(p.performance_date,'yyyy') = ? and p.performance_type = 4 and p.employeeId=?";
		List<Performance> list = (List<Performance>)dao.queryByHql(hql, new Object[]{year,employeeId});
		return list.size()>0?list.get(0):null;
	}
	
	//获取今年所有月小结列表
	public List<Performance> getsumOfmonthList(String year){
		String employeeId = (String)ServletActionContext.getContext().getSession().get("userid");
		String hql = "from Performance p where to_char(p.performance_date,'yyyy') = ? and p.performance_type = 5 and p.employeeId=? order by p.performance_date desc";
		List<Performance> list = (List<Performance>)dao.queryByHql(hql, new Object[]{year,employeeId});
		return list.size()>0?list:null;
	}
	
	//获取当前年总结
	public Performance getPFSubByYear(String year){
		String employeeId = (String)ServletActionContext.getContext().getSession().get("userid");
		String hql = "from Performance p where to_char(p.performance_date,'yyyy') = ? and p.performance_type = 7 and p.employeeId=?";
		List<Performance> list = (List<Performance>)dao.queryByHql(hql, new Object[]{year,employeeId});
		return list.size()>0?list.get(0):null;
	} 
	
	//工作职责的更新
	public JX_People updateDuty(String employeeId,JX_People jxPeople){
		String hql = "from JX_People jp where jp.id = ?";
		JX_People jp = (JX_People)dao.queryByHql(hql, new Object[]{employeeId}).get(0);
		jp.setDuty(jxPeople.getDuty());
		dao.update(jp);
		return jp;
	}
	
	//获取工作职责
	public JX_People getMyDuty(String employeeId){
		String hql = "from JX_People jp where jp.id = ?";
		JX_People jp = (JX_People)dao.queryByHql(hql, new Object[]{employeeId}).get(0);
		return jp;
	}
	
	//获取某年所有季汇总列表
	public List<Performance> getsumOfseasonList(String year){
		String employeeId = (String)ServletActionContext.getContext().getSession().get("userid");
		String hql = "from Performance p where to_char(p.performance_date,'yyyy') = ? and p.performance_type = 6 and p.employeeId=? order by p.performance_date desc";
		List<Performance> list = (List<Performance>)dao.queryByHql(hql, new Object[]{year,employeeId});
		return list.size()>0?list:null;
	}
	
	//定时程序
	public void btPerformance(String time){
		String hql1 = "select jp.id from JX_People jp";
		List<String> peopleList = (List<String>)dao.queryByHql(hql1, new Object[]{});
		String hql2 = "from Performance p where p.employeeId=? and p.performance_type=1 and to_char(p.performance_date,'yyyy-MM-dd') = ?";
		if(peopleList.size()>0){
			for (int i = 0; i < peopleList.size(); i++) {
				List<Performance> list = (List<Performance>)dao.queryByHql(hql2, new Object[]{peopleList.get(i),time});
				if(list.size()==0){
					Performance p = new Performance();
					p.setPerformance_date(new Date());
					p.setPerformance_type(1);
					p.setEmployeeId(peopleList.get(i));
				    dao.save(p);
				}
			}
		}
		
	}
	
	//获取本部门人员分页信息
	public List<JX_People> getpeoples(int pageNum){
		String depId = (String)ServletActionContext.getContext().getSession().get("deptId");
		Integer postId = (Integer) ServletActionContext.getContext().getSession().get("peoPost");
		String hql = "from JX_People jp where jp.jx_department.id = ? ";
		List<JX_People> list = (List<JX_People>)dao.queryByHql(hql, new Object[]{depId},pageNum,10);
		return list;
	}
	//获取本部门人员信息
	public List<JX_People> getpeoples(){
		String depId = (String)ServletActionContext.getContext().getSession().get("deptId");
		String hql = "from JX_People jp where jp.jx_department.id = ? ";
		List<JX_People> list = (List<JX_People>)dao.queryByHql(hql, new Object[]{depId});
		return list;
	}

	//保存评论内容
	public void saveComment(Comment ct) {
		// TODO Auto-generated method stub
		dao.save(ct);
	}

	//获取评论列表
	public List<Comment> getCommentList(String empId) {
		// TODO Auto-generated method stub
		List<Comment> list=new ArrayList<Comment>();
		String hql = "from Comment cm where cm.commentby_userid= ?";
		list=(List<Comment>) dao.queryByHql(hql, new Object[]{empId});
		return list;
	}

	//分页获取评论列表
	public List<Comment> getCommentFyList(String empId, int pageNum) {
		// TODO Auto-generated method stub
		List<Comment> list=new ArrayList<Comment>();
		String hql = "from Comment cm where cm.commentby_userid='"+empId+"' order by cm.comment_time desc";
		list=(List<Comment>) dao.queryByHql(hql,new Object[] {},pageNum,5);
		return list;
		
	}
}
