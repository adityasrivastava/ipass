package com.mds.passbook.repo;

import org.springframework.data.repository.CrudRepository;

import com.mds.passbook.repo.dao.GolfPassDao;

public interface GolfPassRepository extends CrudRepository<GolfPassDao, Integer>{
		GolfPassDao findByDeviceId(String deviceId);
}
