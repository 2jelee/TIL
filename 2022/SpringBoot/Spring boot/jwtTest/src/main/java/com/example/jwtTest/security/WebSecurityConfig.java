package com.example.jwtTest.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {  
	
		http.httpBasic().and()
						.authorizeHttpRequests()
						.antMatchers("/admin/**").hasRole("ADMIN")
						.antMatchers("/user/**").hasRole("USER")
						.antMatchers("/**").permitAll();
	} 
}
