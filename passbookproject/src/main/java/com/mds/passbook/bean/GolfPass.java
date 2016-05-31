package com.mds.passbook.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class GolfPass {
	
	private int passId;
	private String token;
	private boolean passAdded;
	
	

	public GolfPass(String token, boolean passAdded) {
		super();
		this.token = token;
		this.passAdded = passAdded;
	}
	public int getId() {
		return passId;
	}
	public void setId(int passId) {
		this.passId = passId;
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
