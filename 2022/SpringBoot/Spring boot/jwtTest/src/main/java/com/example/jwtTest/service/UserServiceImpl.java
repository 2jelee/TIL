package com.example.jwtTest.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.jwtTest.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService {

	private final UserRepository userRepository; // final -> @RequiredArgsConstructor
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { 
		
		return (UserDetails)userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Username(사용자)를 찾을 수 없습니다."));
		
//		return (UserDetails)userRepository.findById(Long.parseLong(username))
//						  	 .orElseThrow(() -> new UsernameNotFoundException("Username(사용자)를 찾을 수 없습니."));
	}

}
