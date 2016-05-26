package com.mds.passbook.repo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="GOLF_TEE")
public class GolfTee extends AbstractDateStampEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TEE_TYPE_ID")
	private int teeTypeId;
	
	@Column(name="COLOR")
	private String color;
	
	@Column(name="YARDS")
	private int yards;
	
	@Column(name="PAR")
	private int par;
	
	@OneToMany(mappedBy="teeTypesId")
	private List<Golf> golf = new ArrayList<Golf>();

	public List<Golf> getGolf() {
		return golf;
	}
	public void setGolf(List<Golf> golf) {
		this.golf = golf;
	}
	public int getTeeTypeId() {
		return teeTypeId;
	}
	public void setTeeTypeId(int teeTypeId) {
		this.teeTypeId = teeTypeId;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
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
		return "GolfTee [teeTypeId=" + teeTypeId + ", color=" + color + ", yards=" + yards + ", par=" + par + ", golf="
				+ golf + "]";
	}


}
