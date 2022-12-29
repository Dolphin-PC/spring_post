package com.dolphin.spring_post.Auth;

import com.dolphin.spring_post.Domain.Member;
import com.dolphin.spring_post.Domain.User;
import com.dolphin.spring_post.Enum.UserRoleType;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class JwtManager {

    private final String securityKey = "bb9daf4d-fa55-4037-ae9b-5ab6bf4db888";
    private final Long expiredTime = 1000 * 60L * 60L * 6L;

    public String generateJwtToken(User user) {
        Date now = new Date();
        return Jwts.builder()
                .setSubject(user.getUserName())
                .setHeader(createHeader())
                .setClaims(createClaims(user))
                .setExpiration(new Date(now.getTime() + expiredTime))
                .signWith(SignatureAlgorithm.HS256, securityKey)
                .compact();
    }

    private Map<String, Object> createClaims(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", user.getUserName());
        claims.put("roles", user.getUserRoleType());
        return claims;
    }

    private Map<String, Object> createHeader() {
        Map<String, Object> header = new HashMap<>();
        header.put("type", "JWT");
        header.put("alg", "HS256");
        header.put("regDate", System.currentTimeMillis());
        return header;
    }

    private Claims getClaims(String token) {
        return Jwts.parser().setSigningKey(securityKey).parseClaimsJws(token).getBody();
    }

    public String getUserNameFromToken(String token) {
        return (String) getClaims(token).get("username");
    }

    public Set<UserRoleType> getUserRoleSetFromToken(String token) {
        return (Set<UserRoleType>) getClaims(token).get("roles");
    }


}
