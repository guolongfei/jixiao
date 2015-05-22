package com.hoyotech.prison.action;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.service.impl.MapService;

public class MapAction {
	
	private MapService mapService;
	
	private String sexName="";
	private String sexNum="";
	
	private String id;
	StringBuilder sb=new StringBuilder();
	StringBuilder sb2=new StringBuilder();
	
	/**
	 * 统计年龄段比例
	 * **/
	public void age() throws Exception {
		List num=mapService.age();
		
		Integer he=0;
		for(int i=0;i<num.size();i++)
		{	
			Object[] obj= (Object[])num.get(i);
				 he+=(Integer)obj[1];
		}
		for(int i=0;i<num.size();i++)
		{
			Object[] obj= (Object[])num.get(i);
			sb.append(obj[0].toString()+",");
			float f = Float.valueOf((Integer)obj[1])*100/Float.valueOf(he) ;  
			BigDecimal b = new BigDecimal(f);   
			float f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();   
			sb2.append(f1+",");
		}
		sb.deleteCharAt(sb.length()-1);
		sb2.deleteCharAt(sb2.length()-1);
		sexName=sb.toString();
		sexNum=sb2.toString();
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		try{
			PrintWriter out=response.getWriter();
			out.println("{\"name\":\""+sexName+"\",\"num\":\""+sexNum+"\"}"); 
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据不同城市统计年龄段比例
	 * **/
	public void cityAge(){
		List num2=mapService.countAge(id);
		Integer he=0;
		for(int i=0;i<num2.size();i++)
		{	
			Object[] obj= (Object[])num2.get(i);
				 he+=(Integer)obj[1];
		}
		if(num2.size()!=0){
			for(int i=0;i<num2.size();i++)
			{
				Object[] obj= (Object[])num2.get(i);
				sb.append(obj[0].toString()+",");
				float f = Float.valueOf((Integer)obj[1])*100/Float.valueOf(he) ;  
				BigDecimal b = new BigDecimal(f);   
				float f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();   
				sb2.append(f1+",");
			}
			
			sb.deleteCharAt(sb.length()-1);
			sb2.deleteCharAt(sb2.length()-1);
			sexName=sb.toString();
			sexNum=sb2.toString();
		}else{
			sexName="18以下,19-30,31-40,40以上";
			sexNum="0.00,0.00,0.00,0.00";
		}
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		try{
			PrintWriter out=response.getWriter();
			out.println("{\"name\":\""+sexName+"\",\"num\":\""+sexNum+"\"}"); 
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 统计身份比例
	 * **/
	public void shenfen() throws Exception {
		List num=mapService.shenfen();
		float he=0l;
		for(int i=0;i<num.size();i++)
		{
			Object[] obj= (Object[])num.get(i);
			 he+=(Long)obj[1];
		}
		
		for(int i=0;i<num.size();i++)
		{
			Object[] obj= (Object[])num.get(i);
			sb.append(obj[0].toString()+",");
			float f = (Long)obj[1]*100/he;  
			BigDecimal b = new BigDecimal(f);   
			float f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();   
			sb2.append(f1+",");
		}
		sb.deleteCharAt(sb.length()-1);
		sb2.deleteCharAt(sb2.length()-1);
		sexName=sb.toString();
		sexNum=sb2.toString();
		
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		try{
			PrintWriter out=response.getWriter();
			out.println("{\"name\":\""+sexName+"\",\"num\":\""+sexNum+"\"}"); 
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据不同城市统计身份比例
	 * **/
	public void cityShenfen(){
		
		List num2=mapService.countShenfen(id);
		
		float he=0l;
		for(int i=0;i<num2.size();i++)
		{
			Object[] obj= (Object[])num2.get(i);
			 he+=(Long)obj[1];
		}
		
		if(num2.size()!=0){
			for(int i=0;i<num2.size();i++)
			{
				Object[] obj= (Object[])num2.get(i);
				sb.append(obj[0].toString()+",");
				//四舍五入取两位小数
				float f = (Long)obj[1]*100/he;  
				BigDecimal b = new BigDecimal(f);   
				float f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();   
				sb2.append(f1+",");
			}
			sb.deleteCharAt(sb.length()-1);
			sb2.deleteCharAt(sb2.length()-1);
			sexName=sb.toString();
			sexNum=sb2.toString();
		}else{
			sexName="男,女";
			sexNum="0.00,0.00";
		}
		
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		try{
			PrintWriter out=response.getWriter();
			out.println("{\"name\":\""+sexName+"\",\"num\":\""+sexNum+"\"}"); 
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 统计性别比例
	 * **/
	public String select() throws Exception {
		List num=mapService.sex();
		float he=0l;
		for(int i=0;i<num.size();i++)
		{
			Object[] obj= (Object[])num.get(i);
			 he+=(Long)obj[1];
		}
		
		for(int i=0;i<num.size();i++)
		{
			Object[] obj= (Object[])num.get(i);
			sb.append(obj[0].toString()+",");
			float f = (Long)obj[1]*100/he;  
			BigDecimal b = new BigDecimal(f);   
			float f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();   
			sb2.append(f1+",");
		}
		sb.deleteCharAt(sb.length()-1);
		sb2.deleteCharAt(sb2.length()-1);
		sexName=sb.toString();
		sexNum=sb2.toString();
		return "success";
	}
	
	/**
	 * 统计性别比例
	 * **/
	public void sex() throws Exception {
		List num=mapService.sex();
		float he=0l;
		for(int i=0;i<num.size();i++)
		{
			Object[] obj= (Object[])num.get(i);
			 he+=(Long)obj[1];
		}
		
		for(int i=0;i<num.size();i++)
		{
			Object[] obj= (Object[])num.get(i);
			sb.append(obj[0].toString()+",");
			float f = (Long)obj[1]*100/he;  
			BigDecimal b = new BigDecimal(f);   
			float f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();   
			sb2.append(f1+",");
		}
		sb.deleteCharAt(sb.length()-1);
		sb2.deleteCharAt(sb2.length()-1);
		sexName=sb.toString();
		sexNum=sb2.toString();
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		try{
			PrintWriter out=response.getWriter();
			out.println("{\"name\":\""+sexName+"\",\"num\":\""+sexNum+"\"}"); 
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据不同城市统计性别人数
	 * **/
	public void citySex(){
		
		List num2=mapService.countCity(id);
		
		float he=0l;
		for(int i=0;i<num2.size();i++)
		{
			Object[] obj= (Object[])num2.get(i);
			 he+=(Long)obj[1];
		}
		
		if(num2.size()!=0){
			for(int i=0;i<num2.size();i++)
			{
				Object[] obj= (Object[])num2.get(i);
				sb.append(obj[0].toString()+",");
				//四舍五入取两位小数
				float f = (Long)obj[1]*100/he;  
				BigDecimal b = new BigDecimal(f);   
				float f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();   
				sb2.append(f1+",");
			}
			sb.deleteCharAt(sb.length()-1);
			sb2.deleteCharAt(sb2.length()-1);
			sexName=sb.toString();
			sexNum=sb2.toString();
		}else{
			sexName="男,女";
			sexNum="0.00,0.00";
		}
		
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		try{
			PrintWriter out=response.getWriter();
			out.println("{\"name\":\""+sexName+"\",\"num\":\""+sexNum+"\"}"); 
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public MapService getMapService() {
		return mapService;
	}

	public void setMapService(MapService mapService) {
		this.mapService = mapService;
	}

	public String getSexName() {
		return sexName;
	}

	public void setSexName(String sexName) {
		this.sexName = sexName;
	}

	public String getSexNum() {
		return sexNum;
	}

	public void setSexNum(String sexNum) {
		this.sexNum = sexNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public StringBuilder getSb() {
		return sb;
	}

	public void setSb(StringBuilder sb) {
		this.sb = sb;
	}

	public StringBuilder getSb2() {
		return sb2;
	}

	public void setSb2(StringBuilder sb2) {
		this.sb2 = sb2;
	}
	
	
	
	
}
