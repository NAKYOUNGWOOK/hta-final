package com.groupware.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.groupware.interceptor.LoginInValidatInterceptor;

@Configuration
//@EnableWebSecurity
public class WebMvcConfig implements WebMvcConfigurer {

	@Autowired
	private LoginInValidatInterceptor si;
	
	
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	System.out.println("server 시작시 자동 실행되는 : WebMvcConfig - addInterceptors() ");
    	
        registry.addInterceptor(si).addPathPatterns("/loginSuccessSecret.html");
        
    }
    
}