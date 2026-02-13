package com.example.jwtTest.security;

import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;


@Component 				 // Bean 생성 
@RequiredArgsConstructor // 필수
public class JwtTokenProvider {
	private String secret_key = "2jelee";
	
	// token 유효 시간 : 30분 (L => Long type)
	private long token_valid_time = 1000L * 60 * 30;
	
	//base 64로 인코딩  
	
	
	@PostConstruct
	protected void init() { // 역할 : 객체 초기화 담당, secret_key를 Base 64로 인코딩
		secret_key = Base64.getEncoder().encodeToString(secret_key.getBytes());
		
	}
	
	// JWT 토큰 생성
	public String create_token(String userPk, List<String> roles) {
		// jjwt(Lib) 추가 
		Claims claims = Jwts.claims().setSubject(userPk); // JWT playload에 저장되는 정보 단위
		claims.put("roles", roles);						  // key, value 쌍으로 저장 
		
		//작성 날짜
		Date now = new Date();
		
		return Jwts.builder().setClaims(claims) // 정보 저장 
							 .setIssuedAt(now)  // 토큰 발행시간 
							 .setExpiration(new Date(now.getTime() + token_valid_time)) //만료시간 설정 
							 .signWith(SignatureAlgorithm.HS256, secret_key) //암호화 알고리즘 사용 + secret_key = Signature
							 .compact(); //compact : ~~ 이렇게 만들어 줘. 
	}
	
	// JWT token에서 인증 정보 조회
	
	// token에서 회원정보 추출
	
	// Request의 Header에서 token값 가져오기
	
	// token 유효성, 만료일자 확인 
}
