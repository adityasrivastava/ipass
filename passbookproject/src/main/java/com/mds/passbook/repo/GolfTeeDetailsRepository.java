package com.mds.passbook.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mds.passbook.repo.dao.GolfTeeDetailsDao;

public interface GolfTeeDetailsRepository extends CrudRepository<GolfTeeDetailsDao, Integer> {

	@Query("select td from GolfTeeDetailsDao td where td.teeTypeId = :teeId and td.holeNumber = :holeNumber")
	GolfTeeDetailsDao findByTeeTypeIdAndHoleNumber(@Param("teeId") int teeId, @Param("holeNumber") int holeNumber);
}
