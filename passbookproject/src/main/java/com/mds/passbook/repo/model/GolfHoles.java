package com.mds.passbook.repo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="GOLF_HOLES")
public class GolfHoles extends AbstractDateStampEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="HOLDE_TYPE_ID")
	private int holeTypeId;
	
	@Column(name="HOLES")
	private int holes;
	
	@OneToMany(mappedBy="holeTypesId", cascade=CascadeType.ALL)
	private List<Golf> golf = new ArrayList<Golf>();

	public List<Golf> getGolf() {
		return golf;
	}
	public void setGolf(List<Golf> golf) {
		this.golf = golf;
	}
	public int getHoleTypeId() {
		return holeTypeId;
	}
	public void setHoleTypeId(int holeTypeId) {
		this.holeTypeId = holeTypeId;
	}
	
	public int getHoles() {
		return holes;
	}
	public void setHoles(int holes) {
		this.holes = holes;
	}
	@Override
	public String toString() {
		return "GolfHoles [holeTypeId=" + holeTypeId + ", holes=" + holes + "]";
	}

	
}
