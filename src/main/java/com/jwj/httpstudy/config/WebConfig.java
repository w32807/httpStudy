package com.jwj.httpstudy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        CacheControl cacheControl = CacheControl.maxAge(5, TimeUnit.MINUTES);
        // 이렇게 스프링 설정파일에서 캐시 정책 및 적용 경로를 지정할 수 있다.
        // application.yml에서도 가능!
        registry.addResourceHandler("**/*.*")
                .addResourceLocations("classpath:/static/")
                .setCacheControl(cacheControl);


    }
}
