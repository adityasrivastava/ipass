package com.mds.passbook.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.social.security.SpringSocialConfigurer;

import com.mds.passbook.repo.UserProfileRepository;
import com.mds.passbook.security.service.PassbookSecurityService;
import com.mds.passbook.security.service.PassbookSocialService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserProfileRepository userProfileRepo;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.
			userDetailsService(userDetailsService());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
//		csrf()
//		.disable().
		formLogin()
		.loginPage("/login")
		.and()
		.authorizeRequests()
		.antMatchers("/home")
		.authenticated()
		.and()
         .apply(new SpringSocialConfigurer());
		
		
//		http
//		.authorizeRequests()
//		.anyRequest()
//		.authenticated()
//		.and()
//		.formLogin()
//		.loginPage("/login")
//		.usernameParameter("username")
//		.passwordParameter("password")
//		.permitAll()
////		.and()
////		.apply(new SpringSocialConfigurer())
//		.and().exceptionHandling().accessDeniedPage("/403");
	}
	
	@Bean
	public PassbookSocialService socialService(){
		return new PassbookSocialService(userProfileRepo);
	}
	
	@Bean
	public PassbookSecurityService userDetailsService(){
		return new PassbookSecurityService(userProfileRepo);
	}


}