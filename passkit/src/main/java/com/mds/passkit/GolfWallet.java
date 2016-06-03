package com.mds.passkit;

import java.util.List;

public class GolfWallet {

	private String serialNumber;
	private String userName;
	private String userAge;
	private String userGender;
	private String golfHoleType;
	private List<GolfScore> golfScore;

	public GolfWallet(String serialNumber, String userName, String userAge, String userGender, String golfHoleType,
			List<GolfScore> golfScore) {
		this.serialNumber = serialNumber;
		this.userName = userName;
		this.userAge = userAge;
		this.userGender = userGender;
		this.golfHoleType = golfHoleType;
		this.golfScore = golfScore;
	}

	public GolfWallet() {

	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAge() {
		return userAge;
	}

	public void setUserAge(String userAge) {
		this.userAge = userAge;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getGolfHoleType() {
		return golfHoleType;
	}

	public void setGolfHoleType(String golfHoleType) {
		this.golfHoleType = golfHoleType;
	}

	public List<GolfScore> getGolfScore() {
		return golfScore;
	}

	public void setGolfScore(List<GolfScore> golfScore) {
		this.golfScore = golfScore;
	}

}