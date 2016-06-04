package com.mds.passbook.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mds.passbook.repo.dao.PassRegistrationsDao;

public interface GolfPassRegistrationsRepository extends CrudRepository<PassRegistrationsDao, Integer>{
		List<PassRegistrationsDao> findByPassTypeId(String passTypeId);
		PassRegistrationsDao findBySerialNumberAndPassTypeId(String serialNumber, String passTypeId);
}
