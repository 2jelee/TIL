package com.jelee.jwtpractice.service;

import java.util.Collections;
import java.util.Optional;

import com.jelee.jwtpractice.dto.UserDto;
import com.jelee.jwtpractice.entity.Authority;
import com.jelee.jwtpractice.entity.User;
import com.jelee.jwtpractice.repository.UserRepository;
import com.jelee.jwtpractice.util.SecurityUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// UserService는 UserRepository, PasswordEncoder를 주입받는다.
/*
signup() : 회원가입 로직을 수행하는 메소드
=> parameter로 받은 UserDto 안에 getUsername을 기준으로 하여 DB에 이 username의 정보가 있는지 찾아보고
    없으면 권한정보를 생성 및 저장
*/


@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public User signup(UserDto userDto) {
        if (userRepository.findOneWithAuthoritiesByUsername(userDto.getUsername()).orElse(null) != null) {
            throw new RuntimeException("이미 가입되어 있는 유저입니다.");
        }

        // 없으면 권한 정보 생성
        Authority authority = Authority.builder()
                .authorityName("ROLE_USER")
                .build();
        /*
        [중요 포인트]
        signup() 를 통해 가입한 회원은 USER ROLE을 가지고 있고 data.sql에서 자동 생성되는 admin 계정은 User, Admin, Role을 가지고 있다.
        이 차이를 통해 권한 검증 부분을 TEST 한다.
         */

        User user = User.builder()
                .username(userDto.getUsername())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .nickname(userDto.getNickname())
                .authorities(Collections.singleton(authority))
                .activated(true)
                .build();

//        return UserDto.from(userRepository.save(user));
        return userRepository.save(user);
    }

    /*
    [유저, 권한 정보를 가져오는 메소드]
    getuserWithAuthorities username을 기준으로 정보를 가져오고,
    getMyUserWithAuthorities는 SecurityContext에 저장된 username의 정보만 가져옴.

    => 이 2가지 메소드의 허용 권한을 다르게 하여 권한 검증에 대한 부분을 테스트한다.
     */

    @Transactional(readOnly = true)
    public Optional<User> getUserWithAuthorities(String username) {
        return userRepository.findOneWithAuthoritiesByUsername(username);
    }

    @Transactional(readOnly = true)
    public Optional<User> getMyUserWithAuthorities() {
        return SecurityUtil.getCurrentUsername().flatMap(userRepository::findOneWithAuthoritiesByUsername);
    }
}