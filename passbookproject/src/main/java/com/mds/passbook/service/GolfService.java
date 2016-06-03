package com.mds.passbook.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mds.passbook.bean.Golf;
import com.mds.passbook.bean.GolfCourse;
import com.mds.passbook.bean.GolfGame;
import com.mds.passbook.bean.GolfHoles;
import com.mds.passbook.bean.GolfPass;
import com.mds.passbook.bean.GolfScore;
import com.mds.passbook.bean.GolfTee;
import com.mds.passbook.bean.GolfUser;
import com.mds.passbook.bean.PassRegistrations;
import com.mds.passbook.repo.dao.GolfDao;
import com.mds.passbook.repo.dao.GolfScoreDao;
import com.mds.passbook.repo.dao.GolfTeeDao;
import com.mds.passbook.repo.dao.PassRegistrationsDao;

@Service
public interface GolfService {
	
	void createGame(GolfUser user, String golfCourseId, String holeTypeId, String teeTypeId);
	
	
	void addGolfScore(GolfScore score);
	void deleteGolfScore(GolfScore score);
	void updateGolfScore(GolfScore score);
	
	List<GolfScoreDao> addGolf(GolfGame golf);
	void deleteGolf(int id);
	void updateGolf(GolfGame golf);
	
	void addGolfPass(GolfPass pass);
	void deleteGolfPass(GolfPass pass);
	void updateGolfPass(GolfPass pass);
	
	void addGolfTee(GolfTee tee);
	void deleteGolfTee(GolfTee tee);
	void updateGolfTee(GolfTee tee);
	
	void addGolfHole(GolfHoles hole);
	void deleteGoldHole(GolfHoles hole);
	void updateGolfHole(GolfHoles hole);
	
	void addGolfCourse(GolfCourse course);
	void deleteGolfCourse(GolfCourse course);
	void updateGolfCourse(GolfCourse course);

	Iterable<GolfUser> getAllUser();
	GolfUser getUserById(int id);
	GolfUser addUser(GolfUser user);
	void deleteUser(GolfUser user);
	void updateUser(GolfUser user);
	
	Iterable<GolfDao> getAllGolf();
	GolfDao getGolfById(int id);
	void addGame(GolfDao golf);
	void deleteGame(GolfDao golf);
	void updateGame(GolfDao golf);
	
	GolfScore updateScore(GolfScore score);
	
	Iterable<GolfTeeDao> getAllTee();
	void addTee(GolfTeeDao tee);
	void deleteTee(GolfTeeDao tee);
	void updateTee(GolfTeeDao tee);
	GolfScoreDao getScoreById(int id);
	
	List<GolfScoreDao> getScoresById(int id);
	
	void deletePassRegistrations(PassRegistrations passRegister);
	
	void updatePassRegistrations(PassRegistrations passRegister);
	
	List<PassRegistrationsDao> findUpdatedPass(String passTypeId, String deviceId);
	
	List<GolfCourse> findAllGolfCourses();
	
	List<GolfHoles> findAllGolfHoles();
	
	List<GolfTee> findAllGolfTee();
	
	List<Golf> findAllGolf();
	
	GolfTeeDao getTeeById(int id);
}
