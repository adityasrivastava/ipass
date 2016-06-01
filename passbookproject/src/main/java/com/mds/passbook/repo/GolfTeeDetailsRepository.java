package com.mds.passbook.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mds.passbook.repo.dao.GolfTeeDao;
import com.mds.passbook.repo.dao.GolfTeeDetailsDao;

public interface GolfTeeDetailsRepository extends CrudRepository<GolfTeeDetailsDao, Integer> {

	GolfTeeDetailsDao findByGolfTeeAndHoleNumber(GolfTeeDao teeId, int holeNumber); 
}
