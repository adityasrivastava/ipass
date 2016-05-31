package com.mds.passbook.repo;

import org.springframework.data.repository.CrudRepository;

import com.mds.passbook.repo.dao.GolfUserDao;

public interface GolfUserRepository extends CrudRepository<GolfUserDao, Integer>{

}
