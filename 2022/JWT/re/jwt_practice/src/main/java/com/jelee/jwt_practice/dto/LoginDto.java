package com.jelee.jwt_practice.dto;

import com.sun.istack.NotNull;
import lombok.*;


//Login 시 사용할 class

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {

    @NotNull
    @Size(min = 3, max = 50)
    private String username;

    @NotNull
    @Size(min = 3, max = 100)
    private String password;
}