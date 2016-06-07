package com.mds.passbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
@ComponentScan("com.mds.passbook")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	@Qualifier("springAuthProvider")
	UserDetailsService userDetailService;
	
	@Autowired
	public void configureGlobalAuth(final AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.anyRequest()
		.authenticated()
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.formLogin()
		.loginPage("/login")
		.usernameParameter("username")
		.passwordParameter("password")
		.permitAll()
		.and().exceptionHandling().accessDeniedPage("/403");
	}
	
	
//
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
//	}
}