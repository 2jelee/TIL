package com.gs52.jwt.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.gs52.jwt.security.services.UserDetailsServiceImpl;

public class AuthTokenFilter extends OncePerRequestFilter {
	@Autowired
	private JwtUtils jwtUtils;

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			String jwt = parseJwt(request);
			if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
				String username = jwtUtils.getUserNameFromJwtToken(jwt);

				UserDetails userDetails = userDetailsService.loadUserByUsername(username);
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		} catch (Exception e) {
			logger.error("Cannot set user authentication: {}", e);
		}

		filterChain.doFilter(request, response);
	}

	private String parseJwt(HttpServletRequest request) {  //로그인 정보에 대한 Token을 “Bearer”라는 접두사를 달았고, 접두사를 제외한 나머지 정보를 가져옴
		String headerAuth = request.getHeader("Authorization");
//		String headerAuth = request.getHeader("ADMIN");
		
		System.out.println("headerAuth : " + headerAuth);
		
		if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
			
//			System.out.println("headerAuth : " + headerAuth);
//			System.out.println("headerAuth.startsWith(Bearer )");
//			System.out.println(headerAuth.startsWith("Bearer "));

//			System.out.println(headerAuth.substring(7, headerAuth.length()));
			
			return headerAuth.substring(7, headerAuth.length());  // 클라이언트로부터 받은 토큰을 파싱하기 전에 먼저 앞 7글자, "Bearer "를 떼어야함- 업계 표준임
		}

		return null;
//		return headerAuth.substring(7, headerAuth.length());
	}
}
