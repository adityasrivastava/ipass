package com.mds.passbook;

import java.util.Date;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mds.passbook.repo.GolfCourseRepository;
import com.mds.passbook.repo.GolfHolesRepository;
import com.mds.passbook.repo.GolfPassRepository;
import com.mds.passbook.repo.GolfRepository;
import com.mds.passbook.repo.GolfScoreRepository;
import com.mds.passbook.repo.GolfTeeRepository;
import com.mds.passbook.repo.GolfUserRepository;
import com.mds.passbook.repo.model.Golf;
import com.mds.passbook.repo.model.GolfCourse;
import com.mds.passbook.repo.model.GolfHoles;
import com.mds.passbook.repo.model.GolfPass;
import com.mds.passbook.repo.model.GolfScore;
import com.mds.passbook.repo.model.GolfTee;
import com.mds.passbook.repo.model.GolfUser;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class RepositoryTest {
	
	@Autowired
	GolfRepository golfRepo;
	
	@Autowired
	GolfCourseRepository golfCourseRepo;
	
	@Autowired
	GolfHolesRepository golfHolesRepo;
	
	@Autowired
	GolfPassRepository golfPassRepo;
	
	@Autowired
	GolfUserRepository golfUserRepo;
	
	@Autowired
	GolfScoreRepository golfScoreRepo;
	
	@Autowired
	GolfTeeRepository golfTeeRepo;
	
	
	@org.junit.Test
	public void getAllTest(){
		Iterable<Golf> it = golfRepo.findAll();
		for(Golf g:it){
			System.out.println("Golf "+g.getId()+">>>>>>>>>>>>>>>>>>>>");
			System.out.println(g.toString());
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	
		}
	}
	
	@org.junit.Test
	public void findOneTest(){
		Golf g = golfRepo.findOne(new Integer(1));
		System.out.println("Golf "+g.getId()+">>>>>>>>>>>>>>>>>>>>FIND ONE BY ID>>>>>>>>>>>>>>>>>>>>");
		System.out.println(g.toString());
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	}
	
	@org.junit.Test
	public void insertGolfCourseTest(){
		// Golf Course Added
		GolfCourse gCourse = new GolfCourse();
		gCourse.setCourseName("GolfCourse 1");
		
		golfCourseRepo.save(gCourse);
		
	}
	
	@org.junit.Test
	public void insertGolfHolesTest(){
		// Golf holes Added
		GolfHoles gHoles = new GolfHoles();
		gHoles.setHoles(9);
		golfHolesRepo.save(gHoles);
		
	}
	
	@org.junit.Test
	public void insertGolfPassTest(){
		// Golf Pass Added
		GolfPass gPass = new GolfPass();
		gPass.setPassAdded(true);
		gPass.setToken("XYZ");
		golfPassRepo.save(gPass);

	}
	
	@org.junit.Test
	public void insertGolfUserTest(){
	
		GolfUser gUser = new GolfUser();
		gUser.setAge(1);
		gUser.setGender("MALE");
		gUser.setHandicap(20);
		gUser.setName("Aditya");
		
		golfUserRepo.save(gUser);

	}
	
	@org.junit.Test
	public void insertGolfScoreTest(){
		GolfScore gScore = new GolfScore();
		gScore.setHoleNumber(1);
		gScore.setScore(10);
		
		golfScoreRepo.save(gScore);
	}
	
	@org.junit.Test
	public void insertGolfTeeTest(){
		
		GolfTee gTee = new GolfTee();
		gTee.setColor("Red");
		gTee.setPar(3);
		gTee.setYards(100);
	
		golfTeeRepo.save(gTee);
	}
	
	@org.junit.Test
	public void mainTest(){
		// Create user ....
		
		
		GolfUser gUser = new GolfUser();
		gUser.setAge(1);
		gUser.setGender("MALE");
		gUser.setHandicap(20);
		gUser.setName("Aditya");
		
		GolfPass gPass = new GolfPass();
		gPass.setPassAdded(true);
		gPass.setToken("XYZ");
		
		gUser.setPass(gPass);
		
		golfUserRepo.save(gUser);
		
		
		// Create Game ....golf...lets play golf. :D
		
		GolfCourse gCourse = new GolfCourse();
		gCourse.setCourseName("GolfCourse 1");
		
		golfCourseRepo.save(gCourse);
		
		GolfCourse gCourse1 = new GolfCourse();
		gCourse1.setCourseName("GolfCourse 2");
		
		golfCourseRepo.save(gCourse1);

		
		GolfHoles gHoles = new GolfHoles();
		gHoles.setHoles(9);
		golfHolesRepo.save(gHoles);
		
		GolfHoles gHoles1 = new GolfHoles();
		gHoles1.setHoles(18);
		golfHolesRepo.save(gHoles1);
		
		
		GolfTee gTee = new GolfTee();
		gTee.setColor("Red");
		gTee.setPar(3);
		gTee.setYards(100);
	
		golfTeeRepo.save(gTee);
		
		
		GolfTee gTee1 = new GolfTee();
		gTee1.setColor("Black");
		gTee1.setPar(3);
		gTee1.setYards(100);
	
		golfTeeRepo.save(gTee);
		
		
		GolfScore gScore = new GolfScore();
		gScore.setHoleNumber(1);
		gScore.setScore(10);
		
		golfScoreRepo.save(gScore);
		
		GolfScore gScore1 = new GolfScore();
		gScore1.setHoleNumber(1);
		gScore1.setScore(10);
		
		golfScoreRepo.save(gScore1);
		
		GolfScore gScore2 = new GolfScore();
		gScore2.setHoleNumber(1);
		gScore2.setScore(10);
		
		golfScoreRepo.save(gScore2);
		
		
		Golf golf = new Golf();
		
		golf.setGolfCoursesId(gCourse);
		golf.setHoleTypesId(gHoles);
		golf.setTeeTypesId(gTee);
		golf.setUsersId(gUser);
		golf.getScoresId().add(gScore);
		golf.getScoresId().add(gScore1);
		golf.getScoresId().add(gScore2);
		
		golfRepo.save(golf);
		
		Golf newGolf = new Golf();
		Golf find = golfRepo.findOne(1);
		
		System.out.println(find);
		
		
	}
	
}
