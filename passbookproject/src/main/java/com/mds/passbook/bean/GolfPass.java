package com.mds.passbook.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

public class GolfPass {

	private int passId;
	private String token;
	private int deviceId;
	private boolean passAdded;
	private List<PassRegistrations> registeredPass;

	public GolfPass() {

	}

	public GolfPass(String token, boolean passAdded) {
		this.token = token;
		this.passAdded = passAdded;
	}

	public int getPassId() {
		return passId;
	}

	public void setPassId(int passId) {
		this.passId = passId;
	}

	public int getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}

	public List<PassRegistrations> getRegisteredPass() {
		return registeredPass;
	}

	public void setRegisteredPass(List<PassRegistrations> registeredPass) {
		this.registeredPass = registeredPass;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public boolean isPassAdded() {
		return passAdded;
	}

	public void setPassAdded(boolean passAdded) {
		this.passAdded = passAdded;
	}

	@Override
	public String toString() {
		return "GolfPass [passId=" + passId + ", token=" + token + ", passAdded=" + passAdded + "]";
	}

}
