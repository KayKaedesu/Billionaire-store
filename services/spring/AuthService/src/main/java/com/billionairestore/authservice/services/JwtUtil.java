package com.billionairestore.authservice.services;

import com.billionairestore.authservice.entities.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private String expirationTime;
    private Key key;
    @PostConstruct
    public void init(){
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }
    public Claims getAllClaimsFromToken(String token){
        System.out.println(token);
        return Jwts.parser().setSigningKey(key).build().parseClaimsJws(token).getBody();
    }
    public Date getExpirationDateFromToken(String token){
        return getAllClaimsFromToken(token).getExpiration();
    }
    private Boolean isTokenExpired(String token){
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }
    public String generate(User userVO, String type){
//        System.out.println("generating");
//        System.out.println(userVO);
//        System.out.println(type);
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", userVO.getUserId());
        claims.put("role", userVO.getRole());
        return doGenerateToken(claims, userVO.getUsername(), type);
    }
    private String doGenerateToken(Map<String, Object> claims, String username, String type){
//        System.out.println("DOGEN");
//        System.out.println(claims);
//        System.out.println(username);
//        System.out.println(type);
        long expirationTimeLong;
        if ("ACCESS".equals(type)){
            expirationTimeLong = Long.parseLong(expirationTime) * 1000;
        }else {
            expirationTimeLong = Long.parseLong(expirationTime) * 1000 * 5;
        }
        final Date createdDate = new Date();
        final Date expirationDate = new Date(createdDate.getTime() + expirationTimeLong);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(createdDate)
                .setExpiration(expirationDate)
                .signWith(key)
                .compact();
    }
    public Boolean validateToken(String token){
        return !isTokenExpired(token);
    }
}
