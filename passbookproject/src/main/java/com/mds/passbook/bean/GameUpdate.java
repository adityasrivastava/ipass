package com.mds.passbook.bean;

import java.sql.Timestamp;
import java.util.List;

public class GameUpdate {
	
	private List<String> serialNumbers;
	private String lastUpdated;
	public List<String> getSerialNumbers() {
		return serialNumbers;
	}
	public void setSerialNumbers(List<String> serialNumbers) {
		this.serialNumbers = serialNumbers;
	}
	public String getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	public String currentTimeStamp(){
		return ""+new Timestamp(System.currentTimeMillis() - (1000 * 60 * 60));
	}

}
