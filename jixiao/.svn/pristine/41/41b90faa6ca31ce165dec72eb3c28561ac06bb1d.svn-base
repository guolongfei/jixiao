package com.hoyotech.prison.util;

import java.io.IOException;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HttpSessionCheckFilter implements Filter {
	
	public static String ERROR_URL = "/login.action";
	public void init(FilterConfig arg0) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response,	FilterChain chain) throws IOException, ServletException {
		if(request instanceof HttpServletRequest && response instanceof HttpServletResponse){
			HttpServletRequest httpRequest=(HttpServletRequest)request;
            HttpServletResponse httpResponse=(HttpServletResponse)response;
			HttpSession session = httpRequest.getSession();
			//request.setCharacterEncoding("UTF-8");
			
			if(session != null){
				//省厅角色 不做权限处理
				if(session.getAttribute("st_role")!=null && session.getAttribute("st_role").equals("st")){
					System.out.println("----------省厅权限----------");
					chain.doFilter(request,response);
					return;
				}
				
				
				String userId = (String)session.getAttribute("userId");
				String userName=(String)session.getAttribute("userName");
				Set<String> urlSet = (Set<String>)session.getAttribute("url");
				final String requestUrl = httpRequest.getRequestURI();
				String[] urlstring = {"login_login.action","login.action"};
				boolean flag = false;
				for(String url : urlstring){
					if(requestUrl.indexOf(url) != -1){
						flag = true;
						break;
					}
				}
		        if(userName == null || "".equals(userName)){
		        	if(flag){
		        		chain.doFilter(request,response);
		        	} else{
		        		System.out.println("----------未登录或已超时----------");
			        	String path = httpRequest.getContextPath();
			        	httpResponse.sendRedirect(path + ERROR_URL);
		        	}
		        }else if(urlSet != null){
		        	urlSet.add("main.action");
		        	urlSet.add("main_st.action");
		        	
		        	for(String url : urlSet){
						if(requestUrl.indexOf(url) != -1){
							flag = true;
							if(!flag){
								System.out.println(url);
							}
							break;
						}
					}
		        	if(flag){
		        		chain.doFilter(request,response);
		        	}else{
		        		System.out.println("----------没权限访问----------");
			        	String path = httpRequest.getContextPath();
			        	httpResponse.sendRedirect(path + ERROR_URL);
		        	}
		        }
			}else{
				chain.doFilter(request, response);
			}
		}else{
			chain.doFilter(request, response);
		}
	}	
	
	public void destroy() {

	}

}

