package com.mds.passbook.repo.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="GOLF_TEE")
public class GolfTeeDao extends AbstractDateStampEntity implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TEE_ID")
	private int teeId;
	
	@Column(name="COLOR")
	private String color;
	
	@OneToMany(mappedBy="golfTee", cascade=CascadeType.ALL)
	private List<GolfTeeDetailsDao> teeDetails = new ArrayList<GolfTeeDetailsDao>();
	
	public GolfTeeDao(){
		
	}

	public GolfTeeDao(int teeId) {
		this.teeId = teeId;
	}

	public List<GolfTeeDetailsDao> getTeeDetails() {
		return teeDetails;
	}

	public void setTeeDetails(List<GolfTeeDetailsDao> teeDetails) {
		this.teeDetails = teeDetails;
	}

	public int getTeeId() {
		return teeId;
	}

	public void setTeeId(int teeId) {
		this.teeId = teeId;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "GolfTee [teeId=" + teeId + ", color=" + color + "]";
	}

}
