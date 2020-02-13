package com.bishe.cloud.configuration;

import com.bishe.cloud.interceptor.LoginRequiredInterceptor;
import com.bishe.cloud.interceptor.PassportInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.annotation.Resource;

@Component
public class CloudWebConfiguration extends WebMvcConfigurationSupport {
    //将拦截器注册进来
    @Resource
    PassportInterceptor passportInterceptor;
    @Resource
    LoginRequiredInterceptor loginRequiredInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(passportInterceptor);
        registry.addInterceptor(loginRequiredInterceptor).addPathPatterns("/setting");
        super.addInterceptors(registry);
    }
}