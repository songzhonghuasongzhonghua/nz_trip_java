package com.example.nz_trip.interceptor;

import com.example.nz_trip.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

//        if("OPTIONS".equals(request.getMethod())){
//            return true;
//        }
//
//        String token = request.getHeader("Authorization");
//        Claims claims = JwtUtil.parseToken(token);
//        if(claims == null){
//            response.setStatus(401);
//            return false;
//        }
        return true;
    }
}
