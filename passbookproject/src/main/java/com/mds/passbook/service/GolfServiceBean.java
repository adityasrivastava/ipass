package com.mds.passbook.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mds.passbook.bean.Golf;
import com.mds.passbook.bean.GolfCourse;
import com.mds.passbook.bean.GolfGame;
import com.mds.passbook.bean.GolfHoles;
import com.mds.passbook.bean.GolfPass;
import com.mds.passbook.bean.GolfScore;
import com.mds.passbook.bean.GolfTee;
import com.mds.passbook.bean.GolfTeeDetails;
import com.mds.passbook.bean.GolfUser;
import com.mds.passbook.bean.PassRegistrations;
import com.mds.passbook.mapper.GolfMapperInterface;
import com.mds.passbook.repo.GolfCourseRepository;
import com.mds.passbook.repo.GolfHolesRepository;
import com.mds.passbook.repo.GolfPassRegistrationsRepository;
import com.mds.passbook.repo.GolfPassRepository;
import com.mds.passbook.repo.GolfRepository;
import com.mds.passbook.repo.GolfScoreRepository;
import com.mds.passbook.repo.GolfTeeDetailsRepository;
import com.mds.passbook.repo.GolfTeeRepository;
import com.mds.passbook.repo.GolfUserRepository;
import com.mds.passbook.repo.dao.GolfCourseDao;
import com.mds.passbook.repo.dao.GolfDao;
import com.mds.passbook.repo.dao.GolfHolesDao;
import com.mds.passbook.repo.dao.GolfPassDao;
import com.mds.passbook.repo.dao.GolfScoreDao;
import com.mds.passbook.repo.dao.GolfTeeDao;
import com.mds.passbook.repo.dao.GolfTeeDetailsDao;
import com.mds.passbook.repo.dao.GolfUserDao;
import com.mds.passbook.repo.dao.PassRegistrationsDao;

@Component
public class GolfServiceBean implements GolfService {

	@Autowired
	GolfRepository golfRepo;

	@Autowired
	GolfCourseRepository golfCourseRepo;

	@Autowired
	GolfHolesRepository golfHolesRepo;

	@Autowired
	GolfPassRepository golfPassRepo;

	@Autowired
	GolfPassRegistrationsRepository golfPassRegisterRepo;

	@Autowired
	GolfUserRepository golfUserRepo;

	@Autowired
	GolfScoreRepository golfScoreRepo;

	@Autowired
	GolfTeeRepository golfTeeRepo;

	@Autowired
	GolfTeeDetailsRepository golfTeeDetailsRepo;

	@Override
	public GolfUser addUser(GolfUser user) {

		GolfUserDao userDao;
		GolfPassDao passDao;

		userDao = new GolfUserDao();

		userDao.setName(user.getName());
		userDao.setAge(user.getAge());
		userDao.setGender(user.getGender());
		userDao.setHandicap(user.getHandicap());

		passDao = new GolfPassDao();
		if (user.getPass() != null) {
			passDao.setPassAdded(user.getPass().isPassAdded());
			userDao.setPass(passDao);
		}

		userDao = golfUserRepo.save(userDao);
		user.setUserId(userDao.getUserId());

		return user;
	}

	@Override
	public void deleteUser(GolfUser user) {
		GolfUserDao userDao = new GolfUserDao();
		golfUserRepo.delete(userDao);
	}

	@Override
	public void updateUser(GolfUser user) {
		GolfUserDao userDao = new GolfUserDao();
		golfUserRepo.save(userDao);
	}

	@Override
	public Iterable<GolfUser> getAllUser() {

		GolfUser user = new GolfUser();

		return null;
	}

	@Override
	public GolfUser getUserById(int id) {
		GolfUserDao userDao = new GolfUserDao();
		return null;
	}

	@Override
	public Iterable<GolfDao> getAllGolf() {
		return golfRepo.findAll();
	}

	@Override
	public GolfDao getGolfById(int id) {
		return golfRepo.findOne(id);
	}

	@Override
	public void addGame(GolfDao golf) {
		golfRepo.save(golf);
	}

	@Override
	public void deleteGame(GolfDao golf) {
		golfRepo.delete(golf);
	}

	@Override
	public void updateGame(GolfDao golf) {
		golfRepo.save(golf);
	}

	@Override
	public GolfScoreDao getScoreById(int id) {
		return golfScoreRepo.findOne(id);
	}

	@Override
	public void updateScore(GolfScore score) {

		GolfScoreDao scoreDao;
		GolfDao golfDao;

		golfDao = golfRepo.findOne(score.getGolf().getId());

		scoreDao = golfScoreRepo.findByGolfAndHoleNumber(golfDao, score.getHoleNumber());

		scoreDao.setScore(score.getScore());

		golfScoreRepo.save(scoreDao);
	}

	@Override
	public Iterable<GolfTeeDao> getAllTee() {
		return golfTeeRepo.findAll();
	}

	@Override
	public GolfTeeDao getTeeById(int id) {
		return golfTeeRepo.findOne(id);
	}

	@Override
	public void addTee(GolfTeeDao tee) {
		golfTeeRepo.save(tee);
	}

	@Override
	public void deleteTee(GolfTeeDao tee) {
		golfTeeRepo.delete(tee);
	}

	@Override
	public void updateTee(GolfTeeDao tee) {
		golfTeeRepo.save(tee);
	}

	@Override
	public void createGame(GolfUser user, String golfCourseId, String holeTypeId, String teeTypeId) {

		GolfPass golfPass;

		GolfDao golfDao;
		GolfUserDao userDao;
		GolfPassDao passDao;

		golfPass = user.getPass();

		passDao = new GolfPassDao(golfPass.getToken(), golfPass.isPassAdded());
		userDao = new GolfUserDao(user.getName(), user.getAge(), user.getGender(), user.getHandicap(), passDao);

		golfDao = new GolfDao(userDao, new GolfCourseDao(Integer.parseInt(golfCourseId)),
				new GolfHolesDao(Integer.parseInt(holeTypeId)), new GolfTeeDao(Integer.parseInt(teeTypeId)));

		golfRepo.save(golfDao);
	}

	@Override
	public void addGolfCourse(GolfCourse course) {
		GolfCourseDao courseDao;

		courseDao = new GolfCourseDao();
		courseDao.setCourseName(course.getCourseName());
		golfCourseRepo.save(courseDao);

	}

	@Override
	public void deleteGolfCourse(GolfCourse course) {
		golfCourseRepo.delete(course.getGolfCourseId());
	}

	@Override
	public void updateGolfCourse(GolfCourse course) {

		GolfCourseDao courseDao;

		courseDao = new GolfCourseDao();
		courseDao.setGolfCourseId(course.getGolfCourseId());
		courseDao.setCourseName(course.getCourseName());

		golfCourseRepo.save(courseDao);
	}

	@Override
	public void addGolfHole(GolfHoles hole) {
		GolfHolesDao holesDao;

		holesDao = new GolfHolesDao();
		holesDao.setHoles(hole.getHoles());
		golfHolesRepo.save(holesDao);
	}

	@Override
	public void deleteGoldHole(GolfHoles hole) {
		golfHolesRepo.delete(hole.getHoleTypeId());
	}

	@Override
	public void updateGolfHole(GolfHoles hole) {
		GolfHolesDao holeDao;

		holeDao = new GolfHolesDao();
		holeDao.setHoleTypeId(hole.getHoleTypeId());
		holeDao.setHoles(hole.getHoles());

		golfHolesRepo.save(holeDao);
	}

	@Override
	public void addGolfTee(GolfTee tee) {
		GolfTeeDao teeDao;

		List<GolfTeeDetailsDao> detailsDaoList;

		detailsDaoList = new ArrayList<GolfTeeDetailsDao>();
		teeDao = new GolfTeeDao();

		for (GolfTeeDetails teeDetails : tee.getTeeDetails()) {
			GolfTeeDetailsDao detailsDao = new GolfTeeDetailsDao();
			detailsDao.setGolfTee(teeDao);
			detailsDao.setHoleNumber(teeDetails.getHoleNumber());
			detailsDao.setPar(teeDetails.getPar());
			detailsDao.setStroke(teeDetails.getStroke());
			detailsDao.setYards(teeDetails.getYards());
			detailsDaoList.add(detailsDao);
		}

		teeDao.setTeeDetails(detailsDaoList);
		teeDao.setColor(tee.getColor());

		golfTeeRepo.save(teeDao);

	}

	@Override
	public void deleteGolfTee(GolfTee tee) {
		golfTeeRepo.delete(tee.getTeeId());
	}

	@Override
	public void updateGolfTee(GolfTee tee) {
		GolfTeeDao teeDao;

		List<GolfTeeDetailsDao> detailsDaoList;

		detailsDaoList = new ArrayList<GolfTeeDetailsDao>();
		teeDao = new GolfTeeDao();

		for (GolfTeeDetails teeDetails : tee.getTeeDetails()) {
			GolfTeeDetailsDao detailsDao = new GolfTeeDetailsDao();
			detailsDao.setTeeTypeId(teeDetails.getTeeTypeId());

			detailsDao.setHoleNumber(teeDetails.getHoleNumber());
			detailsDao.setPar(teeDetails.getPar());
			detailsDao.setStroke(teeDetails.getStroke());
			detailsDao.setYards(teeDetails.getYards());
			detailsDaoList.add(detailsDao);
		}

		// teeDao.setTeeDetails(detailsDaoList);
		teeDao.setColor(tee.getColor());

		golfTeeRepo.save(teeDao);

	}

	@Override
	public void addGolfPass(GolfPass pass) {
		GolfPassDao passDao;

		passDao = new GolfPassDao();

		passDao.setPassAdded(pass.isPassAdded());
		passDao.setToken(pass.getToken());

		golfPassRepo.save(passDao);
	}

	@Override
	public void deleteGolfPass(GolfPass pass) {
		golfPassRepo.delete(pass.getPassId());
	}

	@Override
	public void updateGolfPass(GolfPass pass) {
		GolfPassDao passDao;

		passDao = new GolfPassDao();

		passDao.setPassId(pass.getPassId());
		passDao.setPassAdded(pass.isPassAdded());
		passDao.setToken(pass.getToken());
		passDao.setDeviceId(pass.getDeviceId());

		golfPassRepo.save(passDao);
	}

	@Override
	public List<GolfScoreDao> addGolf(GolfGame golf) {

		GolfDao golfDao;
		GolfUserDao userDao;
		GolfTeeDao teeDao;
		GolfTeeDetailsDao teeDetailsDao;
		GolfCourseDao courseDao;
		GolfHolesDao holesDao;
		GolfPassDao passDao;
		List<GolfScoreDao> scoreDaoList;

		scoreDaoList = new ArrayList<GolfScoreDao>();
		courseDao = golfCourseRepo.findOne(golf.getCourseId());
		userDao = golfUserRepo.findOne(golf.getUserId());
		teeDao = golfTeeRepo.findOne(golf.getTeeTypeId());
		holesDao = golfHolesRepo.findOne(golf.getHoleTypeId());

		golfDao = new GolfDao();
		golfDao.setGolfCoursesId(courseDao);
		golfDao.setHoleTypesId(holesDao);
		golfDao.setTeeTypesId(teeDao);
		golfDao.setUsersId(userDao);

		GolfDao resultDao = golfRepo.save(golfDao);

		// Mapping Tee Details with score
		for (int holeNumber = 1; holeNumber <= holesDao.getHoles(); holeNumber++) {
			teeDetailsDao = golfTeeDetailsRepo.findByGolfTeeAndHoleNumber(teeDao, holeNumber);
			scoreDaoList.add(new GolfScoreDao(0, holeNumber, resultDao, teeDetailsDao));
		}

		PassRegistrationsDao passRegisterDao = new PassRegistrationsDao();
		passRegisterDao.setPass(userDao.getPass());
		passRegisterDao.setPassTypeId(golf.getPassTypeId());

		passRegisterDao.setSerialNumber("" + golfDao.getId());
		golfPassRegisterRepo.save(passRegisterDao);

		golfScoreRepo.save(scoreDaoList);

		List<GolfScoreDao> scoreDao = golfScoreRepo.findByGolf(resultDao);

		System.out.println("SCORE DAO ___" + scoreDao);
		return scoreDao;

	}

	@Override
	public void deleteGolf(int id) {
		golfRepo.delete(id);
	}

	@Override
	public void updateGolf(GolfGame golf) {

	}

	@Override
	public void addGolfScore(GolfScore score) {

		GolfScoreDao scoreDao;

		scoreDao = new GolfScoreDao();

		scoreDao.setGolf(new GolfDao(score.getId()));

		golfScoreRepo.save(scoreDao);
	}

	@Override
	public void deleteGolfScore(GolfScore score) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateGolfScore(GolfScore score) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<GolfScoreDao> getScoresById(int id) {
		GolfScoreDao scoreDao;
		GolfDao golfDao;

		golfDao = golfRepo.findOne(id);

		return golfScoreRepo.findByGolf(golfDao);
	}

	@Override
	public void updatePassRegistrations(PassRegistrations passRegister) {

	}

	@Override
	public void deletePassRegistrations(PassRegistrations passRegister) {
		PassRegistrationsDao registrationsDao;

		registrationsDao = new PassRegistrationsDao();
		registrationsDao.setPassTypeId(passRegister.getPassTypeId());
		registrationsDao.setSerialNumber(passRegister.getSerialNumber());

		golfPassRegisterRepo.delete(registrationsDao);
	}

	@Override
	public List<PassRegistrationsDao> findUpdatedPass(String passTypeId, String deviceId) {

		GolfPassDao passDao;
		List<PassRegistrationsDao> registrationsDao;

		passDao = golfPassRepo.findByDeviceId(deviceId);
		registrationsDao = golfPassRegisterRepo.findByPassTypeId(passTypeId);

		return registrationsDao;

	}

	@Override
	public List<GolfCourse> findAllGolfCourses() {

		Iterable<GolfCourseDao> courseDaoList = golfCourseRepo.findAll();

		List<GolfCourse> courseList = new ArrayList<GolfCourse>();

		for (GolfCourseDao course : courseDaoList) {
			GolfCourse mappedCourse = GolfMapperInterface.INSTANCE.daoToDto(course);
			courseList.add(mappedCourse);
		}

		return courseList;
	}

	@Override
	public List<GolfHoles> findAllGolfHoles() {
		Iterable<GolfHolesDao> holesDaoList = golfHolesRepo.findAll();

		List<GolfHoles> holesList = new ArrayList<GolfHoles>();

		for (GolfHolesDao hole : holesDaoList) {
			GolfHoles holeMapper = GolfMapperInterface.INSTANCE.daoToDto(hole);
			holesList.add(holeMapper);
		}

		return holesList;
	}

	@Override
	public List<GolfTee> findAllGolfTee() {
		Iterable<GolfTeeDao> teeDaoList = golfTeeRepo.findAll();
		
		List<GolfTee> teeList = new ArrayList<GolfTee>();
		
		for (GolfTeeDao tee : teeDaoList) {
			GolfTee teeMapper = GolfMapperInterface.INSTANCE.daoToDto(tee);
			System.out.println(tee);
			teeList.add(teeMapper);
		}

		return teeList;
	}

	@Override
	public List<Golf> findAllGolf() {
		Iterable<GolfDao> golfDaoList = golfRepo.findAll();

		List<Golf> golfList = new ArrayList<Golf>();

		for (GolfDao golf : golfDaoList) {
			Golf golfMapper =  GolfMapperInterface.INSTANCE.daoToDto(golf);
			golfList.add(new Golf());
		}

		return golfList;
	}

}
