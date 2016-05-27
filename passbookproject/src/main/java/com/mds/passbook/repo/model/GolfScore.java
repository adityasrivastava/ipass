package com.mds.passbook.repo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name="GOLF_SCORE")
public class GolfScore extends AbstractDateStampEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SCORE_ID")
	private int scoreId;
	
	@Column(name="SCORE")
	private int score;

	@OneToOne
	private GolfTeeDetails golfTeeDetailsId;
	
	@ManyToOne
	@JoinColumn(name="GOLF_ID",
				foreignKey=@ForeignKey(name="GOLF_ID_FK"))
//	@JoinTable(
//				name="GOLF_SCORES",
//				joinColumns=@JoinColumn(name="SCORE_ID"),
//				inverseJoinColumns=@JoinColumn(name="GOLF_ID"))
	private Golf golf;
	
	
	
	public int getScoreId() {
		return scoreId;
	}
	public void setScoreId(int scoreId) {
		this.scoreId = scoreId;
	}
	public GolfTeeDetails getGolfTeeDetailsId() {
		return golfTeeDetailsId;
	}
	public void setGolfTeeDetailsId(GolfTeeDetails golfTeeDetailsId) {
		this.golfTeeDetailsId = golfTeeDetailsId;
	}
	public Golf getGolf() {
		return golf;
	}
	public void setGolf(Golf golf) {
		this.golf = golf;
	}
	public int getId() {
		return scoreId;
	}
	public void setId(int scoreId) {
		this.scoreId = scoreId;
	}

	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "GolfScore [scoreId=" + scoreId + ", score=" + score + ", golf=" + golf
				+ "]";
	}

}
