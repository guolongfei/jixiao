package com.hoyotech.prison.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.Memcon;
import com.hoyotech.prison.bean.MemconContent;
import com.hoyotech.prison.bean.Police;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.DictionaryService;
import com.hoyotech.prison.service.impl.MemconService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.PrisonUtil;

public class MemconAction {
	private MemconService memconService;
	private DictionaryService dictionaryService;
	private List<Memcon> memconList;
	private List<MemconContent> contentList;
	private Memcon memcon;
	private MemconContent memconContent;
	private String id;
	private String questions;
	private String answers;
	private LogFactory log;
	
	private int talkTimes; //谈话记录的次数
	private List<Police> policelist;
	
	public void selectPolice(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode=PrisonUtil.getPrisonCode(request);
		policelist=dictionaryService.selectPolice(prisonCode);
	}
	/**
	 * 谈话记录列表
	 * @return
	 */
	public String memconList(){
		memconList = memconService.getMemconList(id);
		return "list";
	}
	
	/**
	 * 谈话详情列表
	 * @return
	 */
	public String detail(){
		memcon = memconService.detail(id);
		talkTimes = memconService.getMemconCount(memcon.getPrisoner().getId());
		contentList = memconService.getContentList(id);
		return "detail";
	}
	
	/**
	 * 添加谈话记录
	 * @return
	 */
	public String addMemcon(){
		HttpServletRequest request = ServletActionContext.getRequest();
		memcon.setPrisonCode(PrisonUtil.getPrisonCode(request));
		id = memconService.addMemcon(memcon);
		
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(memcon, config.getInsert(), operate, config.getMemcon(), config.getSucceed(), request);
		return "Detail";
	}
	
		/**
	 * 添加谈话详情
	 * @return
	 */
	public String addContent(){
		memconService.addContent(memconContent);
		id = memconContent.getMemcon().getId();
		
		// 添加日志
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(memconContent, config.getInsert(), operate, config.getMemconContent(), config.getSucceed(), request);
		return "Detail";
	}
	
	/**
	 * 添加谈话详情
	 * @return
	 */
	public String addContentList(){
		HttpServletResponse response = null;
		PrintWriter out = null;
		try {
			response = ServletActionContext.getResponse();
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String[] questionList = questions.split("\\[,\\]", -2);
		String[] answerList = answers.split("\\[,\\]", -2);
		if(questionList.length != answerList.length){
			
			System.out.println(questionList.length+"\t"+answerList.length);
			out.write("-1");
			return null;
		}
		// 添加日志
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		
		for(int i=0; i<questionList.length; i++){
			MemconContent temp = new MemconContent(questionList[i],answerList[i],new Memcon(id));
			memconService.addContent(temp);
			log.getInsertLogMessage(temp, config.getInsert(), operate, config.getMemconContent(), config.getSucceed(), request);
		}
		out.write("1");
		return null;
	}
	
	public DictionaryService getDictionaryService() {
		return dictionaryService;
	}
	public void setDictionaryService(DictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}
	public List<Police> getPolicelist() {
		return policelist;
	}
	public void setPolicelist(List<Police> policelist) {
		this.policelist = policelist;
	}
	public String addUI(){
		selectPolice();
		return "addUI";
	}
	
	public String editUI(){

		return "edit";
	}
	
	public LogFactory getLog() {
		return log;
	}

	public void setLog(LogFactory log) {
		this.log = log;
	}

	public MemconService getMemconService() {
		return memconService;
	}

	public void setMemconService(MemconService memconService) {
		this.memconService = memconService;
	}

	public List<Memcon> getMemconList() {
		return memconList;
	}

	public void setMemconList(List<Memcon> memconList) {
		this.memconList = memconList;
	}

	public List<MemconContent> getContentList() {
		return contentList;
	}

	public void setContentList(List<MemconContent> contentList) {
		this.contentList = contentList;
	}

	public Memcon getMemcon() {
		return memcon;
	}

	public void setMemcon(Memcon memcon) {
		this.memcon = memcon;
	}

	public MemconContent getMemconContent() {
		return memconContent;
	}

	public void setMemconContent(MemconContent memconContent) {
		this.memconContent = memconContent;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQuestions() {
		return questions;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}

	public String getAnswers() {
		return answers;
	}

	public void setAnswers(String answers) {
		this.answers = answers;
	}

	public int getTalkTimes() {
		return talkTimes;
	}

	public void setTalkTimes(int talkTimes) {
		this.talkTimes = talkTimes;
	}

}