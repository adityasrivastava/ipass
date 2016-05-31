package com.mds.passbook.repo;

import org.springframework.data.repository.CrudRepository;

import com.mds.passbook.repo.dao.GolfCourseDao;

public interface GolfCourseRepository extends CrudRepository<GolfCourseDao, Integer> {

}
