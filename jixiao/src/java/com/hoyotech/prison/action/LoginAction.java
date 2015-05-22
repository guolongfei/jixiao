package com.hoyotech.prison.action;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.hoyotech.prison.bean.RolePermission;
import com.hoyotech.prison.bean.User;
import com.hoyotech.prison.bean.UserRole;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.LoginService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.bean.PrisonInfo;
import com.hoyotech.prison.bean.UserPowerZD;

public class LoginAction {
	LoginService loginService;
	private String username;
	private String password;
	private LogFactory log;
	private User user;
	private String newPrisoncode;
	private UserPowerZD upzd; 
	
	public UserPowerZD getUpzd() {
		return upzd;
	}

	public void setUpzd(UserPowerZD upzd) {
		this.upzd = upzd;
	}

	private String prisonid;
	private String prisoncode;
	private String prisonname;

	public String getPrisonname() {
		return prisonname;
	}

	public void setPrisonname(String prisonname) {
		this.prisonname = prisonname;
	}

	public String getPrisonid() {
		return prisonid;
	}

	

	public void setPrisonid(String prisonid) {
		this.prisonid = prisonid;
	}

	public String getPrisoncode() {
		return prisoncode;
	}

	public void setPrisoncode(String prisoncode) {
		this.prisoncode = prisoncode;
	}

	public String getNewPrisoncode() {
		return newPrisoncode;
	}

	public void setNewPrisoncode(String newPrisoncode) {
		this.newPrisoncode = newPrisoncode;
	}

	//登陆发送ajax请求  
	public void login(){
		HttpServletResponse response=ServletActionContext.getResponse();
		HttpServletRequest request=ServletActionContext.getRequest();
	
		try{
			String callback=request.getParameter("callback");
			PrintWriter out=response.getWriter();
			user = loginService.getUserByName(username);
			upzd = loginService.getPrisonInfoListZD(user.getId());
			//System.out.println("======"+username+"=========="+ loginService.getUserByName(username)+"=====+"+callback+"====================");
			if(user == null){
				if(callback!=null && !callback.equals("")) //返回jsonp格式用于单点登录
				{
					out.println(callback+"([{\"result\":\"0\"}])");
					out.println(callback);
				}
				else
				{
					out.println("{\"result\":\"0\"}"); // 用户名不存在
				}
			}else{
				int state=1;
				if("1".equals(user.getOrganizeType())){
					state=loginService.getPrisonState(user.getPrisonCode());
				}
				if(state==1){
					// 校验密码
					if("0".equals(user.getMark())){
						if(callback!=null && !callback.equals("")) //返回jsonp格式用于单点登录
						{
							out.println(callback+"([{\"result\":\"1\"}])");
							out.println(callback);
						}
						else
						{
							out.println("{\"result\":\"1\"}"); // 用户被禁用
						}
					}else{
						if(password.equals(user.getPassword())){
							String keyName = "";
							Set<String> keyUrl=new HashSet<String>();
							for(UserRole ur : user.getRoles()){
								if(ur.getRoleId().getMark().equals("1")){
									for(RolePermission rp : ur.getRoleId().getRolePer()){
										keyName = keyName + rp.getPerId().getKeyName()+",";
										if(rp.getPerId().getUrl() != null){
											String[] urls = rp.getPerId().getUrl().split(",");
											for(String str : urls){
												if(!"".equals(str)){
													keyUrl.add(str);
												}
											}
										}
									}
								}
							}
							
							//判断是否是省厅    5代表省厅的角色
							//如果是省厅  在session中设置st_role 为st
							 for(UserRole ur : user.getRoles()){
								 if(ur.getRoleId().getId().equals("5")){
									 request.getSession().setAttribute("st_role", "st");
									 break;
								 }
							 }
							
							request.getSession().setAttribute("roles", user.getRoles());
							request.getSession().setAttribute("url", keyUrl);
							request.getSession().setAttribute("key", keyName);
							request.getSession().setAttribute("userZW", user.getUserZw());
							request.getSession().setAttribute("userZC", user.getUserZc());
//							request.getSession().setAttribute("name", user.getName().getName());
							request.getSession().setAttribute("userId", user.getId()+"");
							request.getSession().setAttribute("userName", username);
							request.getSession().setAttribute("name", user.getName()==null?"超级管理员":user.getName().getName());//设置用户姓名
							request.getSession().setAttribute("orgType", user.getOrganizeType());
							request.getSession().setAttribute("realyName", user.getName()==null?"超级管理员":user.getName().getId());
							request.getSession().setAttribute("prisonId", user.getPrison()!=null?user.getPrison().getId()+"":"");
							request.getSession().setAttribute("prisonName", user.getPrison()!=null?user.getPrison().getPrisonName():"");
							request.getSession().setAttribute("prisonCode", user.getPrisonCode()!=null?user.getPrisonCode():null);
							loginService.updateLoginTime(user);
							//String a=user.getName().getId();
							// 添加日志
							ConfigHelper config = ConfigHelper.getConfig();
							String operate = "登录成功。";
							log.getQueryLogMessage(request, config.getLogin(), operate, config.getUser(), config.getSucceed());
							
							
							
							String url="";
							if("2".equals(user.getOrganizeType())){
								url="province_select.action";
							}else if("3".equals(user.getOrganizeType())){
								//request.getSession().removeAttribute("prisonId");
								//request.getSession().removeAttribute("prisonCode");
								if(prisonid==null||prisoncode==null){
									String nb= upzd.getPowerZD().substring(0, upzd.getPowerZD().indexOf("|"));
									request.getSession().setAttribute("prisonId", nb.substring(0, 32));
									request.getSession().setAttribute("prisonCode", nb.substring(33, 42));
									request.getSession().setAttribute("prisonName", nb.substring(43, nb.length()));
								}else{
									request.getSession().setAttribute("prisonId", prisonid);
									request.getSession().setAttribute("prisonCode", prisoncode);
									prisonname=java.net.URLDecoder.decode(prisonname,"UTF-8");
									request.getSession().setAttribute("prisonName", prisonname);
								}
								url="main.action?user.id="+user.getId()+"&username="+username+"&password="+password;
							}else{
								url="main.action";
							}
							
							//===================laizw=======================
							if(callback!=null && !callback.equals("")) //返回jsonp格式
							{
								out.println(callback+"([{\"result\":\""+url+"\"}])");
								out.println(callback);
							}
							else
							{
							//==============================================
								out.println("{\"result\":\""+url+"\"}"); // 登录成功
							}
							
							//==============================================
							
							System.out.println(url);
						}else{
							if(callback!=null && !callback.equals("")) //返回jsonp格式
							{
								out.println(callback+"([{\"result\":\"3\"}])");
								out.println(callback);
							}
							else
							{
								out.println("{\"result\":\"3\"}"); // 密码错误
							}
						}
					}
				}else{
					if(callback!=null && !callback.equals("")) //返回jsonp格式
					{
						out.println(callback+"([{\"result\":\"5\"}])");
						out.println(callback);
					}
					else
					{
						out.println("{\"result\":\"5\"}"); // 账号所属拘留所已经被省厅禁止使用
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void checkUsername(){
		HttpServletResponse response=ServletActionContext.getResponse();
		try{
			PrintWriter out=response.getWriter();
			if(username!=null){
				
				User user = loginService.getUserByName(username);
				if(user!=null){
					out.println("{\"result\":\"1\"}"); // 用户名已存在
				}else{
					out.println("{\"result\":\"0\"}"); // 用户名可使用
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public LogFactory getLog() {
		return log;
	}

	public void setLog(LogFactory log) {
		this.log = log;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LoginService getLoginService() {
		return loginService;
	}
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
