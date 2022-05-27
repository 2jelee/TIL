package com.jelee.jwt_practice.service;

import com.jelee.jwt_practice.entity.User;
import com.jelee.jwt_practice.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

// Spring security에서 중요한 부분 중 하나인 UserDetailsService를 구현한 CustomerUserDetailsService class.
@Component("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    /*
    UserDetailsService를 implements하고 UserRepository를 주입받는다.
    loadUserByUsername 메소드를 오버라이드 해서 로그인 시에 DB에서 유저정보와 권한정보를 가져오게 된다.
    해당 정보를 기반으로 userdetails.User 객체를 생성해서 리턴한다.
     */

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String username) {
        return userRepository.findOneWithAuthoritiesByUsername(username)
                .map(user -> createUser(username, user))
                .orElseThrow(() -> new UsernameNotFoundException(username + " -> 데이터베이스에서 찾을 수 없습니다."));
    }

    private org.springframework.security.core.userdetails.User createUser(String username, User user) {
        if (!user.isActivated()) {
            throw new RuntimeException(username + " -> 활성화되어 있지 않습니다.");
        }
        List<GrantedAuthority> grantedAuthorities = user.getAuthorities().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getAuthorityName()))
                .collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(),
                grantedAuthorities);
    }
}