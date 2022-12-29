package com.dolphin.spring_post.Auth;

import com.dolphin.spring_post.Domain.User;
import com.dolphin.spring_post.Enum.UserRoleType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Jwtmanager Test")
class JwtManagerTest {


    private JwtManager jwtManager;

    @BeforeEach
    void setUp() {
        jwtManager = new JwtManager();
    }

    @Test
    @DisplayName("토큰 생성 및 복호화 테스트")
    void tokenTest() {
        // given
        LocalDateTime now = LocalDateTime.now();

//        User user = User.builder()
//                .userName("pcy")
//                .password("1234")
//                .userRoleType(UserRoleType.USER)
//                .build();
//
//        // when
//        // 1) 토큰 생성
//        final String token = jwtManager.generateJwtToken(user);
//        // 2) 토큰으로부터 username 가져오기
//        String usernameFromToken = jwtManager.getUserNameFromToken(token);
//
//        // then
//        assertEquals("pcy", usernameFromToken);
    }
}