package com.hoyotech.prison.test;

import com.opensymphony.xwork2.ActionSupport;
  
public class Login extends ActionSupport {  
    private static final long serialVersionUID = 6627313805146336838L;  
    private String name;  
    private String password;  
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
    public String getPassword() {  
        return password;  
    }  
    public void setPassword(String password) {  
        this.password = password;  
    }  
    @Override
	public String execute() throws Exception {  
    	if(!("Kevin".equals(this.name)&&"111111".equals(this.password))){  
            this.addActionError("Wrong!");  
            addFieldError("name", getText("user"));  
            addFieldError("password", getText("password错误"));  
        }  
        return INPUT;  
    }
    
}  
