package com.hoyotech.prison.model;

public class AnalysisInfo {
	private String imprisonReason;//入所原因
	private String outprisonReson;//出所原因
	public String getOutprisonReson() {
		return outprisonReson;
	}
	public void setOutprisonReson(String outprisonReson) {
		this.outprisonReson = outprisonReson;
	}
	private int count;//人数
	private int allCount;//总人数
	private String percent;//百分比
	public String getImprisonReason() {
		return imprisonReason;
	}
	public void setImprisonReason(String imprisonReason) {
		this.imprisonReason = imprisonReason;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getAllCount() {
		return allCount;
	}
	public void setAllCount(int allCount) {
		this.allCount = allCount;
	}
	public String getPercent() {
		return percent;
	}
	public void setPercent(String percent) {
		this.percent = percent;
	}
	
	
}
