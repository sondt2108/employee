package com.example.employee.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.employee.security.service.UserDetailServiceImlp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

import io.jsonwebtoken.Claims;




public class AuthTokenFilter extends OncePerRequestFilter {
    
    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserDetailsService userDetailsService;
    private static String HEADER = "Authorization";

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        System.out.println(httpServletRequest.getRequestURI());
        // Lấy token từ cookie
        String token;
        Cookie cookie = WebUtils.getCookie(httpServletRequest, "JWT_TOKEN");
        if (cookie != null) {
            token = cookie.getValue();
        } else {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }

        // Parse thông tin từ token
        Claims claims = jwtUtils.getClaimsFromToken(token);
        if (claims == null) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }

        // Tạo object Authentication
        UsernamePasswordAuthenticationToken authenticationObject = getAuthentication(claims);
        if (authenticationObject == null) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }

        // Xác thực thành công, lưu object Authentication vào SecurityContextHolder
        SecurityContextHolder.getContext().setAuthentication(authenticationObject);
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(Claims claims) {
        String username = claims.getSubject();

        if (username != null) {
            UserDetails user = userDetailsService.loadUserByUsername(username);
            return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        }
        return null;
    }
}

