package com.example.controller;

import com.example.jwt.JwtTokenProvider;
import com.example.dto.LoginDto;
import com.example.dto.TokenDto;
import com.example.entity.Role;
import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.service.JwtService;
import com.example.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private final JwtService jwtService;

    // 회원 가입 (테스트용)
    @PostMapping("/join")
    public String join(@RequestBody Map<String, String> user) {
        User newUser = userRepository.save(User.builder()
                        .userId(user.get("user_id"))
                        .password(passwordEncoder.encode(user.get("password")))
                        .name(user.get("name"))
                        .role(Role.valueOf(user.get("role")))
                        .build());

        return newUser.toString();
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto, HttpServletResponse response) throws JsonProcessingException {
        User user = userRepository.findByUserId(loginDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사번 입니다."));
        if (!passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        TokenDto tokenDto = jwtTokenProvider.createAccessToken(user.getUsername(), user.getRole());
        jwtService.login(tokenDto);

        Cookie cookie = new Cookie("refresh_token", tokenDto.getRefreshToken());
        //아마 프론트단의 주소겠지..?
//        cookie.setDomain("localhost:3000");
        cookie.setPath("/login");
        cookie.setSecure(true);
        cookie.setHttpOnly(true);

        response.addCookie(cookie);

        return new ResponseEntity<>(tokenDto.getAccessToken(), HttpStatus.OK);
    }

    // front와 연동 테스트
    @GetMapping("/tttt")
    public String test(){
        return "BE test OK";
    }

    //Token test
    @RestController
    public class TestController {

        @PostMapping("/test")
        public HttpStatus test(){
            return HttpStatus.OK;
        }
    }
}