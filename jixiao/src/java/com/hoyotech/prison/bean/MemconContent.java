package com.hoyotech.prison.bean;

import java.util.Date;

import com.hoyotech.prison.log.PropertyName;

public class MemconContent {

	@PropertyName(name = "ID")
	private String id;
	@PropertyName(name = "问")
	private String question;// 问
	@PropertyName(name = "答")
	private String answer; // 答
	@PropertyName(name = "谈话记录")
	private Memcon memcon; // 谈话记录
	private int state = 1; // 状态
	private Date addTime; // 添加时间
	private Date updateTime; // 修改时间
	private int isSync = 0;// 是否同步；0：未同步；1：已同步

	public MemconContent() {
		super();
	}

	public MemconContent(String question, String answer, Memcon memcon) {
		super();
		this.question = question;
		this.answer = answer;
		this.memcon = memcon;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getIsSync() {
		return isSync;
	}

	public void setIsSync(int isSync) {
		this.isSync = isSync;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Memcon getMemcon() {
		return memcon;
	}

	public void setMemcon(Memcon memcon) {
		this.memcon = memcon;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
