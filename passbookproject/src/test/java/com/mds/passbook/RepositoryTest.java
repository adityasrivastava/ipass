package com.mds.passbook;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import com.mds.passbook.repo.model.GolfTeeDetails;
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
		
		GolfTeeDetails teeDetails = new GolfTeeDetails();
		teeDetails.setPar(1);
		teeDetails.setStroke(1);
		teeDetails.setYards(1);
		teeDetails.setGolfTee(gTee);
		
		GolfTeeDetails teeDetails2 = new GolfTeeDetails();
		teeDetails2.setPar(1);
		teeDetails2.setStroke(1);
		teeDetails2.setYards(1);
		teeDetails2.setGolfTee(gTee);
		
		gTee.getTeeDetails().add(teeDetails);
		gTee.getTeeDetails().add(teeDetails2);
	
		golfTeeRepo.save(gTee);
	}
	
	@org.junit.Test
	public void mainTest(){
		// Create Golf Course
		GolfCourse gCourse = new GolfCourse();
		gCourse.setCourseName("GolfCourse 1");
		golfCourseRepo.save(gCourse);
		
		GolfCourse gCourse1 = new GolfCourse();
		gCourse1.setCourseName("GolfCourse 2");
		golfCourseRepo.save(gCourse1);
		
		
		// Create golf holes
		
		GolfHoles gHoles = new GolfHoles();
		gHoles.setHoles(9);
		
		GolfHoles gHoles1 = new GolfHoles();
		gHoles1.setHoles(18);
		
		golfHolesRepo.save(gHoles);
		golfHolesRepo.save(gHoles1);
		
		// Create pass 
		
		GolfPass pass = new GolfPass();
		pass.setPassAdded(true);
		pass.setToken("ABC=XYZ");
		
		GolfPass pass2 = new GolfPass();
		pass2.setPassAdded(true);
		pass2.setToken("ABC=XYZ1");
	
		// Create golf User
		GolfUser gUser = new GolfUser();
		gUser.setAge(1);
		gUser.setGender("MALE");
		gUser.setHandicap(20);
		gUser.setName("Aditya");
		gUser.setPass(pass);
		
		GolfUser gUser1 = new GolfUser();
		gUser1.setAge(1);
		gUser1.setGender("MALE");
		gUser1.setHandicap(10);
		gUser1.setName("Aditya2");
		gUser1.setPass(pass2);
		
		golfUserRepo.save(gUser1);
		golfUserRepo.save(gUser);
		
		// Create golf tee
		
		GolfTee gTee = new GolfTee();
		gTee.setColor("Red");
		
		GolfTeeDetails teeDetails = new GolfTeeDetails();
		teeDetails.setPar(1);
		teeDetails.setStroke(1);
		teeDetails.setYards(1);
		teeDetails.setGolfTee(gTee);
		
		GolfTeeDetails teeDetails2 = new GolfTeeDetails();
		teeDetails2.setPar(1);
		teeDetails2.setStroke(1);
		teeDetails2.setYards(1);
		teeDetails2.setGolfTee(gTee);
		
		gTee.getTeeDetails().add(teeDetails);
		gTee.getTeeDetails().add(teeDetails2);
	
		golfTeeRepo.save(gTee);
	

		
		// Default Score
		Golf addGolf = new Golf();
		
		List<GolfScore> score = new ArrayList<>();
		GolfScore gScore = new GolfScore();
		gScore.setHoleNumber(1);
		gScore.setScore(10);
		gScore.setGolf(addGolf);
		
		GolfScore gScore1 = new GolfScore();
		gScore1.setHoleNumber(2);
		gScore1.setScore(10);
		gScore1.setGolf(addGolf);
		
		GolfScore gScore2 = new GolfScore();
		gScore2.setHoleNumber(3);
		gScore2.setScore(10);
		gScore2.setGolf(addGolf);
		
		score.add(gScore);
		score.add(gScore1);
		score.add(gScore2);
		
		// Save golf

		addGolf.setHoleTypesId(gHoles);
		addGolf.setGolfCoursesId(gCourse1);
		addGolf.setUsersId(gUser);
		addGolf.setTeeTypesId(gTee);
		addGolf.setScoresId(score);
		golfRepo.save(addGolf);
		
		// Read Golf
		Golf newGolf = new Golf();
		GolfCourse g = new GolfCourse();
		g.setGolfCourseId(2);
		Golf find = golfRepo.findByGolfCoursesId(g);
		
		
		// Read Golf score 
		Golf gc = new Golf();
		gc.setId(1);
		List<GolfScore> readScore = golfScoreRepo.findByGolf(gc);
		
		for(GolfScore gm: readScore){
			System.out.println("SCore: "+gm);
		}
	
		
		System.out.println(find.getId()+" - "+find);
//		
//		Golf golf1 = new Golf();
//		golf1.setId(1);
//		golfRepo.delete(1);
	}
	
}
