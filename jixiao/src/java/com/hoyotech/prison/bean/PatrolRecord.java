package com.hoyotech.prison.bean;

import java.util.Date;

import com.hoyotech.prison.log.PropertyName;

public class PatrolRecord {

	@PropertyName(name = "ID")
	private String id;
	@PropertyName(name = "日期")
	private Date time;
	@PropertyName(name = "值班人")
	private Police watch;
	@PropertyName(name = "带班所领导")
	private Police leader;
	@PropertyName(name = "接班时间")
	private Date startTime;
	@PropertyName(name = "接班时被拘留人总数")
	private int startNum;
	@PropertyName(name = "新收人数")
	private int inNum;
	@PropertyName(name = "出所人数")
	private Date outNum;
	@PropertyName(name = "交班时间")
	private Date endTime;
	@PropertyName(name = "交班时被拘留人总数")
	private int endNum;
	@PropertyName(name = "监控开始时间1")
	private Date startTime1;
	@PropertyName(name = "监控结束时间1")
	private Date endTime1;
	@PropertyName(name = "监控记事1")
	private String situation1;
	@PropertyName(name = "监控开始时间2")
	private Date startTime2;
	@PropertyName(name = "监控结束时间2")
	private Date endTime2;
	@PropertyName(name = "监控记事2")
	private String situation2;
	@PropertyName(name = "监控开始时间3")
	private Date startTime3;
	@PropertyName(name = "监控结束时间3")
	private Date endTime3;
	@PropertyName(name = "监控记事3")
	private String situation3;
	@PropertyName(name = "监控开始时间4")
	private Date startTime4;
	@PropertyName(name = "监控结束时间4")
	private Date endTime4;
	@PropertyName(name = "监控记事4")
	private String situation4;
	@PropertyName(name = "监控开始时间5")
	private Date startTime5;
	@PropertyName(name = "监控结束时间5")
	private Date endTime5;
	@PropertyName(name = "监控记事5")
	private String situation5;
	@PropertyName(name = "监控开始时间6")
	private Date startTime6;
	@PropertyName(name = "监控结束时间6")
	private Date endTime6;
	@PropertyName(name = "监控记事6")
	private String situation6;
	@PropertyName(name = "监控开始时间7")
	private Date startTime7;
	@PropertyName(name = "监控结束时间7")
	private Date endTime7;
	@PropertyName(name = "监控记事7")
	private String situation7;
	@PropertyName(name = "监控开始时间8")
	private Date startTime8;
	@PropertyName(name = "监控结束时间8")
	private Date endTime8;
	@PropertyName(name = "监控记事8")
	private String situation8;
	@PropertyName(name = "监控开始时间9")
	private Date startTime9;
	@PropertyName(name = "监控结束时间9")
	private Date endTime9;
	@PropertyName(name = "监控记事9")
	private String situation9;
	@PropertyName(name = "监控开始时间10")
	private Date startTime10;
	@PropertyName(name = "监控结束时间10")
	private Date endTime10;
	@PropertyName(name = "监控记事10")
	private String situation10;
	@PropertyName(name = "监控开始时间11")
	private Date startTime11;
	@PropertyName(name = "监控结束时间11")
	private Date endTime11;
	@PropertyName(name = "监控记事11")
	private String situation11;
	@PropertyName(name = "监控开始时间12")
	private Date startTime12;
	@PropertyName(name = "监控结束时间12")
	private Date endTime12;
	@PropertyName(name = "监控记事12")
	private String situation12;
	@PropertyName(name = "监控开始时间13")
	private Date startTime13;
	@PropertyName(name = "监控结束时间13")
	private Date endTime13;
	@PropertyName(name = "监控记事13")
	private String situation13;
	private int state = 1;
	private Date addTime;
	private Date updateTime;
	private String prisonCode;
	private int isSync = 0;// 是否同步；0：未同步；1：已同步

	public PatrolRecord() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Police getWatch() {
		return watch;
	}

	public void setWatch(Police watch) {
		this.watch = watch;
	}

	public Police getLeader() {
		return leader;
	}

	public void setLeader(Police leader) {
		this.leader = leader;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	public int getInNum() {
		return inNum;
	}

	public void setInNum(int inNum) {
		this.inNum = inNum;
	}


	public Date getOutNum() {
		return outNum;
	}

	public void setOutNum(Date outNum) {
		this.outNum = outNum;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public int getEndNum() {
		return endNum;
	}

	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}

	public Date getStartTime1() {
		return startTime1;
	}

	public void setStartTime1(Date startTime1) {
		this.startTime1 = startTime1;
	}

	public Date getEndTime1() {
		return endTime1;
	}

	public void setEndTime1(Date endTime1) {
		this.endTime1 = endTime1;
	}

	public String getSituation1() {
		return situation1;
	}

	public void setSituation1(String situation1) {
		this.situation1 = situation1;
	}

	public Date getStartTime2() {
		return startTime2;
	}

	public void setStartTime2(Date startTime2) {
		this.startTime2 = startTime2;
	}

	public Date getEndTime2() {
		return endTime2;
	}

	public void setEndTime2(Date endTime2) {
		this.endTime2 = endTime2;
	}

	public String getSituation2() {
		return situation2;
	}

	public void setSituation2(String situation2) {
		this.situation2 = situation2;
	}

	public Date getStartTime3() {
		return startTime3;
	}

	public void setStartTime3(Date startTime3) {
		this.startTime3 = startTime3;
	}

	public Date getEndTime3() {
		return endTime3;
	}

	public void setEndTime3(Date endTime3) {
		this.endTime3 = endTime3;
	}

	public String getSituation3() {
		return situation3;
	}

	public void setSituation3(String situation3) {
		this.situation3 = situation3;
	}

	public Date getStartTime4() {
		return startTime4;
	}

	public void setStartTime4(Date startTime4) {
		this.startTime4 = startTime4;
	}

	public Date getEndTime4() {
		return endTime4;
	}

	public void setEndTime4(Date endTime4) {
		this.endTime4 = endTime4;
	}

	public String getSituation4() {
		return situation4;
	}

	public void setSituation4(String situation4) {
		this.situation4 = situation4;
	}

	public Date getStartTime5() {
		return startTime5;
	}

	public void setStartTime5(Date startTime5) {
		this.startTime5 = startTime5;
	}

	public Date getEndTime5() {
		return endTime5;
	}

	public void setEndTime5(Date endTime5) {
		this.endTime5 = endTime5;
	}

	public String getSituation5() {
		return situation5;
	}

	public void setSituation5(String situation5) {
		this.situation5 = situation5;
	}

	public Date getStartTime6() {
		return startTime6;
	}

	public void setStartTime6(Date startTime6) {
		this.startTime6 = startTime6;
	}

	public Date getEndTime6() {
		return endTime6;
	}

	public void setEndTime6(Date endTime6) {
		this.endTime6 = endTime6;
	}

	public String getSituation6() {
		return situation6;
	}

	public void setSituation6(String situation6) {
		this.situation6 = situation6;
	}

	public Date getStartTime7() {
		return startTime7;
	}

	public void setStartTime7(Date startTime7) {
		this.startTime7 = startTime7;
	}

	public Date getEndTime7() {
		return endTime7;
	}

	public void setEndTime7(Date endTime7) {
		this.endTime7 = endTime7;
	}

	public String getSituation7() {
		return situation7;
	}

	public void setSituation7(String situation7) {
		this.situation7 = situation7;
	}

	public Date getStartTime8() {
		return startTime8;
	}

	public void setStartTime8(Date startTime8) {
		this.startTime8 = startTime8;
	}

	public Date getEndTime8() {
		return endTime8;
	}

	public void setEndTime8(Date endTime8) {
		this.endTime8 = endTime8;
	}

	public String getSituation8() {
		return situation8;
	}

	public void setSituation8(String situation8) {
		this.situation8 = situation8;
	}

	public Date getStartTime9() {
		return startTime9;
	}

	public void setStartTime9(Date startTime9) {
		this.startTime9 = startTime9;
	}

	public Date getEndTime9() {
		return endTime9;
	}

	public void setEndTime9(Date endTime9) {
		this.endTime9 = endTime9;
	}

	public String getSituation9() {
		return situation9;
	}

	public void setSituation9(String situation9) {
		this.situation9 = situation9;
	}

	public Date getStartTime10() {
		return startTime10;
	}

	public void setStartTime10(Date startTime10) {
		this.startTime10 = startTime10;
	}

	public Date getEndTime10() {
		return endTime10;
	}

	public void setEndTime10(Date endTime10) {
		this.endTime10 = endTime10;
	}

	public String getSituation10() {
		return situation10;
	}

	public void setSituation10(String situation10) {
		this.situation10 = situation10;
	}

	public Date getStartTime11() {
		return startTime11;
	}

	public void setStartTime11(Date startTime11) {
		this.startTime11 = startTime11;
	}

	public Date getEndTime11() {
		return endTime11;
	}

	public void setEndTime11(Date endTime11) {
		this.endTime11 = endTime11;
	}

	public String getSituation11() {
		return situation11;
	}

	public void setSituation11(String situation11) {
		this.situation11 = situation11;
	}

	public Date getStartTime12() {
		return startTime12;
	}

	public void setStartTime12(Date startTime12) {
		this.startTime12 = startTime12;
	}

	public Date getEndTime12() {
		return endTime12;
	}

	public void setEndTime12(Date endTime12) {
		this.endTime12 = endTime12;
	}

	public String getSituation12() {
		return situation12;
	}

	public void setSituation12(String situation12) {
		this.situation12 = situation12;
	}

	public Date getStartTime13() {
		return startTime13;
	}

	public void setStartTime13(Date startTime13) {
		this.startTime13 = startTime13;
	}

	public Date getEndTime13() {
		return endTime13;
	}

	public void setEndTime13(Date endTime13) {
		this.endTime13 = endTime13;
	}

	public String getSituation13() {
		return situation13;
	}

	public void setSituation13(String situation13) {
		this.situation13 = situation13;
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

	public String getPrisonCode() {
		return prisonCode;
	}

	public void setPrisonCode(String prisonCode) {
		this.prisonCode = prisonCode;
	}

	public int getIsSync() {
		return isSync;
	}

	public void setIsSync(int isSync) {
		this.isSync = isSync;
	}

	
	
}
