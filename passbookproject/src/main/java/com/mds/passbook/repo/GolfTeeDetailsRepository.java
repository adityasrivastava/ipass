package com.mds.passbook.repo;

import org.springframework.data.repository.CrudRepository;
import com.mds.passbook.repo.dao.GolfTeeDao;
import com.mds.passbook.repo.dao.GolfTeeDetailsDao;

public interface GolfTeeDetailsRepository extends CrudRepository<GolfTeeDetailsDao, Integer> {

	GolfTeeDetailsDao findByGolfTeeAndHoleNumber(GolfTeeDao teeId, int holeNumber); 
}
