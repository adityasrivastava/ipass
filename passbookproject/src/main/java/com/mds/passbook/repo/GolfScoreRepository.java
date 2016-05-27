package com.mds.passbook.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mds.passbook.repo.model.Golf;
import com.mds.passbook.repo.model.GolfScore;

public interface GolfScoreRepository extends CrudRepository<GolfScore, Integer> {

	public List<GolfScore> findByGolf(Golf golf);
}
