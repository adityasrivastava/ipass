package com.mds.passbook.bean;

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

import org.hibernate.annotations.GeneratorType;

public class GolfTee {

	private int teeId;
	private String color;
	private List<GolfTeeDetails> teeDetails = new ArrayList<GolfTeeDetails>();

	public List<GolfTeeDetails> getTeeDetails() {
		return teeDetails;
	}

	public void setTeeDetails(List<GolfTeeDetails> teeDetails) {
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
		return "GolfTee [teeId=" + teeId + ", color=" + color + ", teeDetails="+ teeDetails + "]";
	}

}
