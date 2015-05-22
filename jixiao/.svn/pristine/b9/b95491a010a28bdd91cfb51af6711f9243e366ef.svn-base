package com.hoyotech.prison.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSONObject;
import com.hoyotech.prison.bean.SpecialScore;
import com.hoyotech.prison.service.impl.SpecialScoreService;

public class SpecialScoreAction {
	
	private SpecialScoreService specialScoreService;	
	private SpecialScore spec;
	private File file;
	private String fileFileName;	
	private int year;
	private int season;
	private List<SpecialScore> list;
	private int ye;
	private int se;
	
	public int getYe() {
		return ye;
	}

	public void setYe(int ye) {
		this.ye = ye;
	}

	public int getSe() {
		return se;
	}

	public void setSe(int se) {
		this.se = se;
	}

	private int size;
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public List<SpecialScore> getList() {
		return list;
	}

	public void setList(List<SpecialScore> list) {
		this.list = list;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getSeason() {
		return season;
	}

	public void setSeason(int season) {
		this.season = season;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public SpecialScore getSpec() {
		return spec;
	}

	public void setSpec(SpecialScore spec) {
		this.spec = spec;
	}

	public SpecialScoreService getSpecialScoreService() {
		return specialScoreService;
	}

	public void setSpecialScoreService(SpecialScoreService specialScoreService) {
		this.specialScoreService = specialScoreService;
	}
	
	//添加内容
	public String addScore() throws IOException
	{
		String pid=(String) ServletActionContext.getRequest().getSession().getAttribute("deptId");
		if(fileFileName!=null)
		{
			String root = ServletActionContext.getServletContext().getRealPath("/upload");       
	        InputStream is = new FileInputStream(file);
	        OutputStream os = new FileOutputStream(new File(root, fileFileName));       
	        byte[] buffer = new byte[500];
	        int length = 0;
	        
	        while(-1 != (length = is.read(buffer, 0, buffer.length)))
	        {
	            os.write(buffer);
	        }       
	        os.close();
	        is.close();
	        spec.setScore_file(fileFileName);
		}
		spec.setScore_pid(pid);
	    spec.setScore_cmtTime(new Date());	    
	    specialScoreService.save(spec);
	    
		return "addScore";
	}
	
	//验证添加内容是否存在
	public void IsExistScore() throws IOException
	{
		String pid=(String) ServletActionContext.getRequest().getSession().getAttribute("deptId");
		int flag=specialScoreService.IsExistScore(pid,year,season);
		JSONObject json=new JSONObject();
		json.put("flag", flag);
		ServletActionContext.getResponse().setContentType("text/json; charset=UTF-8");
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		out.print(json);
		out.flush();
		out.close();
	}
	
	//评分展示
	public String showScore()
	{
		String pid=(String) ServletActionContext.getRequest().getSession().getAttribute("deptId");
		size=specialScoreService.showScore(pid).size();
		list=new ArrayList<SpecialScore>();
		if(size>0)
		{
			SpecialScore s=specialScoreService.showScore(pid).get(0);
			year=s.getScore_year();
			season=s.getScore_season();
			list.add(s);
		}
		return "show";
		
	}
	
	//查询
	public String selectScore()
	{
		String pid=(String) ServletActionContext.getRequest().getSession().getAttribute("deptId");
		list=specialScoreService.selectScore(pid,spec.getScore_year(),spec.getScore_season());
        size=list.size();
        year=spec.getScore_year();
        season=spec.getScore_season();
		return "show";
	}

}
