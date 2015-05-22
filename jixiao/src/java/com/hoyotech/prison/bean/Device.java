package com.hoyotech.prison.bean;

import com.hoyotech.prison.log.PropertyName;

/**
 * 数据字典，设备
 * @author Hzibo
 *
 */
public class Device {

	@PropertyName(name = "ID")
	private Integer id;
	private Device device;
	private String deviceName;
	private String deviceUnit;

    public Device() {
    }

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Device getDevice() {
        return this.device;
    }
    
    public void setDevice(Device device) {
        this.device = device;
    }

    public String getDeviceName() {
        return this.deviceName;
    }
    
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceUnit() {
        return this.deviceUnit;
    }
    
    public void setDeviceUnit(String deviceUnit) {
        this.deviceUnit = deviceUnit;
    }
}