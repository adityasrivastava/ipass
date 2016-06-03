package com.mds.passbook.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mds.passbook.bean.GolfGame;
import com.mds.passbook.bean.GolfUser;
import com.mds.passbook.repo.dao.GolfDao;
import com.mds.passbook.repo.dao.GolfScoreDao;
import com.mds.passkit.GeneratePass;
import com.mds.passkit.GolfWallet;

@Component
public class PassbookServiceBean implements PassbookService{
	
	@Autowired
	GolfService golfService;
	
	File newPass;
	InputStream fileInputStream = null;

	@Override
	public InputStream createPassbook(String name, String age, String gender, String golf_course, String hole_type, String tee_type, String handicap){

		GolfUser user;
		GolfGame golf;
		List<GolfScoreDao>  dao = null;
		GolfWallet wallet;
		GolfDao golfDao;
		InputStream passInputStream = null;

		List<com.mds.passkit.GolfScore> scores;
		
		wallet = new GolfWallet();
		user = new GolfUser();
		golf = new GolfGame();
		
		scores = new ArrayList<com.mds.passkit.GolfScore>();
		
		
		user.setAge(Integer.parseInt(age));
		user.setGender(gender);
		user.setHandicap(Integer.parseInt(handicap));
		user.setName(name);

		user = golfService.addUser(user);

		golf.setCourseId(Integer.parseInt(golf_course));
		golf.setHoleTypeId(Integer.parseInt(hole_type));
		golf.setTeeTypeId(Integer.parseInt(tee_type));
		golf.setUserId(user.getUserId());
		golf.setPassTypeId("pass.com.mds.passbookapp");

		dao = golfService.addGolf(golf);
		
		golfDao = dao.get(0).getGolf();

		wallet.setSerialNumber(""+golfDao.getId());
		wallet.setUserName(golfDao.getUsersId().getName());
		wallet.setUserGender(golfDao.getUsersId().getGender());
		wallet.setUserAge(""+golfDao.getUsersId().getAge());
		wallet.setGolfHoleType(""+golfDao.getHoleTypesId().getHoles());

		
		for(GolfScoreDao scoreDao: dao){
			scores.add(new com.mds.passkit.GolfScore(scoreDao.getScore(), 
					scoreDao.getHoleNumber(), 
					scoreDao.getGolfTeeDetailsId().getPar(), 
					scoreDao.getGolfTeeDetailsId().getStroke(), 
					scoreDao.getGolfTeeDetailsId().getGolfTee().getColor(), 
					scoreDao.getGolfTeeDetailsId().getYards() , 
					wallet)
					);
		}
		
		// Create Pass
		generatePass("passes/file3.pkpass", scores);
		
		passInputStream = readPassFile("passes/file3.pkpass");
		
		return passInputStream;
	}

	@Override
	public long getFileSize() {
		if(newPass != null){
			return newPass.length();
		}
		
		return 0L;
	}

	@Override
	public void generatePass(String absolutePath, List<com.mds.passkit.GolfScore> scores) {
		
		GeneratePass generatePass;
		generatePass = new GeneratePass();
		
		try {
			generatePass.createGenericPass(absolutePath, scores);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public InputStream readPassFile(String relativePath) {
		newPass = new File(relativePath);
		
		try {
			fileInputStream = new FileInputStream(newPass);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return fileInputStream;
	}
	
	

}
