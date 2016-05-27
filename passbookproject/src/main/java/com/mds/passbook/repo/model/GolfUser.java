package com.mds.passbook.repo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name="GOLF_USER")
public class GolfUser extends AbstractDateStampEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID")
	private int userId;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="AGE")
	private int age;
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="HANDICAP")
	private int handicap;
	
	@OneToOne(cascade=CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name="GOLF_PASS")
	private GolfPass pass;
	
	@OneToMany(mappedBy="usersId", cascade=CascadeType.ALL)
	private List<Golf> golf = new ArrayList<Golf>();

	public List<Golf> getGolf() {
		return golf;
	}

	public void setGolf(List<Golf> golf) {
		this.golf = golf;
	}



	public GolfUser(){
		
	}

	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getHandicap() {
		return handicap;
	}
	public void setHandicap(int handicap) {
		this.handicap = handicap;
	}

	public GolfPass getPass() {
		return pass;
	}



	public void setPass(GolfPass pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "GolfUser [userId=" + userId + ", name=" + name + ", age=" + age + ", gender=" + gender + ", handicap="
				+ handicap + ", pass=" + pass + "]";
	}

	
}
