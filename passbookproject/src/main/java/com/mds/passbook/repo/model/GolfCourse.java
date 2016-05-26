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

@Entity(name="GOLF_COURSE")
public class GolfCourse extends AbstractDateStampEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="GOLF_COURSE_ID")
	private int golfCourseId;
	
	@Column(name="COURSE_NAME")
	private String courseName;
	
	@OneToMany(mappedBy="golfCoursesId")
	private List<Golf> golf = new ArrayList<Golf>();
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public List<Golf> getGolf() {
		return golf;
	}
	public void setGolf(List<Golf> golf) {
		this.golf = golf;
	}
	public int getGolfCourseId() {
		return golfCourseId;
	}
	public void setGolfCourseId(int golfCourseId) {
		this.golfCourseId = golfCourseId;
	}
	@Override
	public String toString() {
		return "GolfCourse [golfCourseId=" + golfCourseId + ", courseName=" + courseName + ", golf=" + golf + "]";
	}

}
