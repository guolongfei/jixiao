package com.hoyotech.prison.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.hoyotech.prison.log.PropertyName;

public class PrisonerContrabandGoods {

	@PropertyName(name = "ID")
	private String id;
	private String noYear; // 编号.年
	@PropertyName(name = "流水号")
	private String noNumber; // 编号.流水号
	@PropertyName(name = "被拘留人")
	private Prisoner prisoner;// 被拘留人
	@PropertyName(name = "办案民警")
	private Police handlePolice; // 办案民警
	@PropertyName(name = "办案民警签字时间")
	private Date handleDate;// 办案民警签字时间、
	@PropertyName(name = "接收单位经办人")
	private String receivesUnitAgent;// 接收单位经办人
	@PropertyName(name = "接收时间")
	private Date receivesDate;// 接收时间
	@PropertyName(name = "所领导")
	private Police prisonLeader;// 所领导
	@PropertyName(name = "所领导签字时间")
	private Date prisonLeaderDate;// 所领导签字时间
	private Set<ContrabandGoods> contrabandGoods = new HashSet<ContrabandGoods>(0);// 涉案物品集合

	private int state = 1; // 状态
	private Date addTime;
	private Date updateTime;
	private String prisonCode;
	
	private int isSync = 0;// 是否同步；0：未同步；1：已同步

	/** default constructor */
	public PrisonerContrabandGoods() {
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

	public Prisoner getPrisoner() {
		return this.prisoner;
	}

	public void setPrisoner(Prisoner prisoner) {
		this.prisoner = prisoner;
	}

	public String getNoYear() {
		return noYear;
	}

	public void setNoYear(String noYear) {
		this.noYear = noYear;
	}

	public String getNoNumber() {
		return noNumber;
	}

	public void setNoNumber(String noNumber) {
		this.noNumber = noNumber;
	}

	public Set<ContrabandGoods> getContrabandGoods() {
		return contrabandGoods;
	}

	public void setContrabandGoods(Set<ContrabandGoods> contrabandGoods) {
		this.contrabandGoods = contrabandGoods;
	}

	public Police getHandlePolice() {
		return handlePolice;
	}

	public void setHandlePolice(Police handlePolice) {
		this.handlePolice = handlePolice;
	}

	public Date getHandleDate() {
		return handleDate;
	}

	public void setHandleDate(Date handleDate) {
		this.handleDate = handleDate;
	}

	public String getReceivesUnitAgent() {
		return receivesUnitAgent;
	}

	public void setReceivesUnitAgent(String receivesUnitAgent) {
		this.receivesUnitAgent = receivesUnitAgent;
	}

	public Date getReceivesDate() {
		return receivesDate;
	}

	public void setReceivesDate(Date receivesDate) {
		this.receivesDate = receivesDate;
	}

	public Police getPrisonLeader() {
		return prisonLeader;
	}

	public void setPrisonLeader(Police prisonLeader) {
		this.prisonLeader = prisonLeader;
	}

	public Date getPrisonLeaderDate() {
		return prisonLeaderDate;
	}

	public void setPrisonLeaderDate(Date prisonLeaderDate) {
		this.prisonLeaderDate = prisonLeaderDate;
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
}