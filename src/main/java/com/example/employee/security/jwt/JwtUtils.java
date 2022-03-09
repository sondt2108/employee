package com.example.employee.security.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.example.employee.security.service.UserDetailsImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.*;

@Component
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
    
    
    @Value("${sondt.app.jwtSecret}")
    private String jwtSecret;


    @Value("${sondt.app.jwtExpirationMs}")
    private int jwtExpirationMs;


    public String generateJwtToken(Authentication authentication) {

        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
    
        return Jwts.builder()
            .setSubject((userPrincipal.getUsername()))
            .setIssuedAt(new Date())
            .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
            .signWith(SignatureAlgorithm.HS512, jwtSecret)
            .compact();
      }
  // Lấy thông tin được lưu trong token
  public Claims getClaimsFromToken(String token) {
      // Kiểm tra token có bắt đầu bằng tiền tố
      if (token == null) return null;

      try {
          return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
      } catch (ExpiredJwtException e) {
          return null;
      }
  }

}
