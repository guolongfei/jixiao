package com.hoyotech.prison.bean;

import java.util.Date;

import com.hoyotech.prison.log.PropertyName;

public class PrisonDevice{

	@PropertyName(name = "ID")
	private String id;
	@PropertyName(name = "装备")
	private Device device;
	@PropertyName(name = "监所")
	private PrisonInfo prisonInfo;
	@PropertyName(name = "数量")
	private Integer number;
	private Date addTime;
	private int state=1;
	private Date updateTime;
	private String prisonCode;
	private int isSync = 0;// 是否同步；0：未同步；1：已同步

	public PrisonDevice() {

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
    public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
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

    public Device getDevice() {
        return this.device;
    }
    
    public void setDevice(Device device) {
        this.device = device;
    }

    public PrisonInfo getPrisonInfo() {
        return this.prisonInfo;
    }
    
    public void setPrisonInfo(PrisonInfo prisonInfo) {
        this.prisonInfo = prisonInfo;
    }

    public Integer getNumber() {
        return this.number;
    }
    
    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getAddTime() {
        return this.addTime;
    }
    
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

	public void setPrisonCode(String prisonCode) {
		this.prisonCode = prisonCode;
	}
}