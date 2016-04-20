package com.mds.passbook.model;

public class PassBook {

	private int id;
	private String deviceLibraryId;
	private String passTypeId;
	private String serialNumber;
	private String authToken;
	private int passType;
	private int passDataId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDeviceId() {
		return deviceLibraryId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceLibraryId = deviceId;
	}
	public String getPassTypeId() {
		return passTypeId;
	}
	public void setPassTypeId(String passTypeId) {
		this.passTypeId = passTypeId;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	
	
	
}
