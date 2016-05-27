package com.mds.passbook.repo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotNull;

@Entity(name="GOLF")
public class Golf extends AbstractDateStampEntity implements Serializable{
	
	@Id
	@GeneratedValue
	@Column(name="GOLF_ID")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="GOLF_USER",
				foreignKey=@ForeignKey(name="GOLF_USER_FK"))
//	@JoinTable(
//				name="GOLF_USERS",
//				joinColumns=@JoinColumn(name="GOLF_ID"), 
//				inverseJoinColumns=@JoinColumn(name="USER_ID")
//				)
	private GolfUser usersId;
	
	@ManyToOne
	@JoinColumn(name="GOLF_COURSE",
				foreignKey=@ForeignKey(name="GOLF_COURSE_FK"))
//	@JoinTable(
//				name="GOLF_COURSES",
//				joinColumns=@JoinColumn(name="GOLF_ID"), 
//				inverseJoinColumns=@JoinColumn(name="COURSE_ID")
//				)
	private GolfCourse golfCoursesId;
	
	@ManyToOne
	@JoinColumn(name="GOLF_HOLE",
				foreignKey=@ForeignKey(name="GOLF_HOLE_FK"))
//	@JoinTable(
//				name="GOLF_HOLE_TYPES",
//				joinColumns=@JoinColumn(name="GOLF_ID"), 
//				inverseJoinColumns=@JoinColumn(name="HOLE_TYPE_ID")
//				)
	private GolfHoles holeTypesId;
	
	@OneToOne
	@JoinColumn(name="GOLF_TEE")
	private GolfTee teeTypesId;
	
	
	@OneToMany(mappedBy="golf", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<GolfScore> scoresId = new ArrayList<GolfScore>();

	public Golf(){
		
	}

	public List<GolfScore> getScoresId() {
		return scoresId;
	}

	public void setScoresId(List<GolfScore> scoresId) {
		this.scoresId = scoresId;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public GolfUser getUsersId() {
		return usersId;
	}
	public void setUsersId(GolfUser usersId) {
		this.usersId = usersId;
	}
	public GolfCourse getGolfCoursesId() {
		return golfCoursesId;
	}
	public void setGolfCoursesId(GolfCourse golfCoursesId) {
		this.golfCoursesId = golfCoursesId;
	}
	public GolfHoles getHoleTypesId() {
		return holeTypesId;
	}
	public void setHoleTypesId(GolfHoles holeTypesId) {
		this.holeTypesId = holeTypesId;
	}
	public GolfTee getTeeTypesId() {
		return teeTypesId;
	}
	public void setTeeTypesId(GolfTee teeTypesId) {
		this.teeTypesId = teeTypesId;
	}


	@Override
	public String toString() {
		return "Golf [id=" + id + ", usersId=" + usersId + ", golfCoursesId=" + golfCoursesId + ", holeTypesId="
				+ holeTypesId + ", teeTypesId=" + teeTypesId + "]";
	}
	
	

}
