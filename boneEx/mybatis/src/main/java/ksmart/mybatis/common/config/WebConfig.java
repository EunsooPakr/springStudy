package ksmart.mybatis.common.config;

import ksmart.mybatis.common.interceptor.CommonInterceptor;
import ksmart.mybatis.common.interceptor.loginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    private final CommonInterceptor commonInterceptor;
    private final ksmart.mybatis.common.interceptor.loginInterceptor loginInterceptor;

    public WebConfig(CommonInterceptor commonInterceptor, loginInterceptor loginInterceptor) {
        this.commonInterceptor = commonInterceptor;
        this.loginInterceptor = loginInterceptor;
    }
    /* addInterceptors: 사용자정의된 interceptor 적용시키는 메소드 */

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // interceptore 적용시에는 주의할점
        // 주소중 동적인페이지 요청을 제외한 정적리소스는 제외시켜줘야한다.
        registry.addInterceptor(commonInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/css/**")
                .excludePathPatterns("/js/**")
                .excludePathPatterns("/favicon.ico");

        // 로그인 안 해도 되는것들 나열
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/")
                .excludePathPatterns("/css/**")
                .excludePathPatterns("/js/**")
                .excludePathPatterns("/favicon.ico")
                .excludePathPatterns("/member/login")
                .excludePathPatterns("/member/addMember")
                .excludePathPatterns("/member/idCheck");



        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
