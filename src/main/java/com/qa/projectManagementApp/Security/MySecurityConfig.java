package com.qa.projectManagementApp.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
	

	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider
			=new DaoAuthenticationProvider();
		
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		
		return provider;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/createUser","/getUser")
		.permitAll()
		.antMatchers("/","/createLogin","/createActionList","/deleteaction/{actionid}","/updateAction","/getUserActions")
		.hasAuthority("USER")
		.antMatchers("/getAllLogin","/getAllActions","/getAllUsers")
		.hasAuthority("ADMIN")
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic()
		.and().cors().and().csrf().disable();
		
		
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web.ignoring().antMatchers("/createUser");
	}
	
   
}






