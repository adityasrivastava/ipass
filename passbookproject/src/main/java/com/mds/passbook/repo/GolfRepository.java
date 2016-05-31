package com.mds.passbook.repo;

import org.springframework.data.repository.CrudRepository;

import com.mds.passbook.repo.dao.GolfDao;
import com.mds.passbook.repo.dao.GolfCourseDao;

public interface GolfRepository extends CrudRepository<GolfDao, Integer>{
	
	public GolfDao findByGolfCoursesId(GolfCourseDao golfCourseId);
	
}
