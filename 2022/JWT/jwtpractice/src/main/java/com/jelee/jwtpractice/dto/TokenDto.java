package com.jelee.jwtpractice.dto;

import lombok.*;

// Token 정보를 Response할 때 사용할 TokenDto
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TokenDto {
    private String token;
}