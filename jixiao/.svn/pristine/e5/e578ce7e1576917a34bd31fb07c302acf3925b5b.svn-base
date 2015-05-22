package com.hoyotech.prison.action;

import java.util.HashMap;  
import java.util.Map;  
  
import javax.servlet.ServletContext;  
import javax.servlet.http.HttpSession;  
import javax.servlet.http.HttpSessionBindingEvent;  
import javax.servlet.http.HttpSessionBindingListener; 

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.hoyotech.prison.dao.impl.BasicDao;
import com.hoyotech.prison.service.impl.HomePageService;

public class OnlineUserBindingListener implements HttpSessionBindingListener{
	
	private String userId;
	private String userName;
	
	
	public OnlineUserBindingListener(String userId,String userName){  
        this.setUserId(userId); 
        this.setUserName(userName);
    }  
	@SuppressWarnings("unchecked")
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		 HttpSession session = event.getSession();  
	       ServletContext application = session.getServletContext();  
	  
	        // 把用户放入在线列表  
	        Map onlineUserList = (Map) application.getAttribute("onlineUserList");  
	        // 第一次使用前，需要初始化  
	        if (onlineUserList == null) {  
	            onlineUserList = new HashMap();  
	            application.setAttribute("onlineUserList", onlineUserList);  
	        }  
	        onlineUserList.put(this.userId,this.userName); 
	        System.out.println(this.userId);
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		 HttpSession session = event.getSession();  
	     ServletContext application = session.getServletContext();  
	  
	        // 从在线列表中删除用户  
	        Map onlineUserList = (Map) application.getAttribute("onlineUserList"); 
	        //System.out.println(this.userId);  
	        ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(application);
			BasicDao sd =(BasicDao)ctx.getBean("dao");
			String hql ="update JX_User set online_state=0 where id='"+userId+"'";
			sd.executeHql(hql,new Object[]{});
	        onlineUserList.remove(this.userId);  
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserName() {
		return userName;
	}
	
}
