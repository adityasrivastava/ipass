package com.mds.passbook.repo;

import org.springframework.data.repository.CrudRepository;

import com.mds.passbook.repo.model.Golf;
import com.mds.passbook.repo.model.GolfCourse;

public interface GolfRepository extends CrudRepository<Golf, Integer>{
	
	public Golf findByGolfCoursesId(GolfCourse golfCourseId);
	
}
