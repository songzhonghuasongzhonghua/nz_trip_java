package com.example.nz_trip.config;

import com.example.nz_trip.interceptor.TokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TokenInterceptor())
                .addPathPatterns("/**") // 拦截所有路径
                .excludePathPatterns("/login","/register","/avatar/**","/image/**","/banner/**","/user/article_list","/user/article");  // 排除不需要Token验证的路径
    }
}
