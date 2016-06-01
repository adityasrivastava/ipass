package com.mds.passbook.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mds.passbook.repo.dao.GolfDao;
import com.mds.passbook.repo.dao.GolfScoreDao;

public interface GolfScoreRepository extends CrudRepository<GolfScoreDao, Integer> {

	public List<GolfScoreDao> findByGolf(GolfDao golf);
	public GolfScoreDao findByGolfAndHoleNumber(GolfDao golfGameId, int holeNumber);
}
