package com.mds.passbook;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mds.passbook.repo.GolfUserRepository;
import com.mds.passbook.repo.dao.GolfUserDao;

@Service
public class SpringAuthProvider implements UserDetailsService{
	
	@Autowired
	GolfUserRepository userRepoService;

	@Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(username);
		GolfUserDao user = userRepoService.findByName(username);
		
		if(user == null){
			return null;
		}
		
		List<GrantedAuthority> authority = new ArrayList<>();
		
		return new User(user.getName(), user.getName(), authority);
	}

}
