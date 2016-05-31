package com.mds.passbook.repo.dao;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name="GOLF_PASS")
public class GolfPassDao extends AbstractDateStampEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PASS_ID")
	private int passId;
	
	@Column(name="TOKEN")
	private String token;
	
	@Column(name="PASS_ADDED")
	private boolean passAdded;
	
	public GolfPassDao(){
		
	}
	

	public GolfPassDao(String token, boolean passAdded) {
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
