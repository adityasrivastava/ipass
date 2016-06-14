package com.mds.passbook.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mds.passbook.repo.dao.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long>{
	
	UserProfile findByEmail(String email);

}
