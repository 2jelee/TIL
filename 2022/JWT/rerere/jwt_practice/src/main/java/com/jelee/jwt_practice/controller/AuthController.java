package com.jelee.jwt_practice.controller;

import com.jelee.jwt_practice.dto.LoginDto;
import com.jelee.jwt_practice.dto.TokenDto;
import com.jelee.jwt_practice.jwt.JwtFilter;
import com.jelee.jwt_practice.jwt.TokenProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

// 로그인 API를 추가하기 위한 클래스

@RestController
@RequestMapping("/api")
public class AuthController {
    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    // TokenProvider, AuthenticationManagerBuilder를 주입받는다.
    public AuthController(TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder) {
        this.tokenProvider = tokenProvider;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<TokenDto> authorize(@Valid @RequestBody LoginDto loginDto) {

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());

        // [CustomUserDetailsService.java] authenticationToken을 이용해서 Authentication 객체를 생성하려고 authenticate()가 실행이 될 때 loadUserByUsername() 가 실행됨.
        // Authentication 객체를 생성하고 이를 SecurityContext에 저장하고 Authentication 객체를 createToken 메소드를 통해서 JWT token을 생성.
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // JWT Token을 Response Header에도 넣어주고 TokenDto를 이용해서 Response Body에도 넣어서 리턴하게 된다.
        String jwt = tokenProvider.createToken(authentication);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);

        return new ResponseEntity<>(new TokenDto(jwt), httpHeaders, HttpStatus.OK);
    }
}