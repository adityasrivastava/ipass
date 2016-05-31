package com.mds.passbook.bean;

import java.io.Serializable;
import java.util.ArrayList;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class GolfTeeDetails {
	
	private int teeTypeId;
	private int holeNumber;
	private int yards;
	private int par;
	private int stroke;
	
	private GolfTee golfTee;

	public int getHoleNumber() {
		return holeNumber;
	}
	public void setHoleNumber(int holeNumber) {
		this.holeNumber = holeNumber;
	}
	public GolfTee getGolfTee() {
		return golfTee;
	}
	public void setGolfTee(GolfTee golfTee) {
		this.golfTee = golfTee;
	}
	public int getStroke() {
		return stroke;
	}
	public void setStroke(int stroke) {
		this.stroke = stroke;
	}
	public int getTeeTypeId() {
		return teeTypeId;
	}
	public void setTeeTypeId(int teeTypeId) {
		this.teeTypeId = teeTypeId;
	}
	public int getYards() {
		return yards;
	}
	public void setYards(int yards) {
		this.yards = yards;
	}
	public int getPar() {
		return par;
	}
	public void setPar(int par) {
		this.par = par;
	}
	@Override
	public String toString() {
		return "GolfTee [teeTypeId=" + teeTypeId + ", yards=" + yards + ", par=" + par + ", holeNumber="+ holeNumber + ", stroke="+ stroke + "]";
	}


}
