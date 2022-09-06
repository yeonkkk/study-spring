package com.cos.photogramstart.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity // 해당 파일로 security를 활성화 시킨다.
@Configuration // IoC
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http); 이 코드가 login 가로채는 것 -> 가존 security 기능 비활성화
        http.authorizeRequests()
                .antMatchers("/", "/user/**", "/image/**", "/subscribe/**", "/comment/**").authenticated() // 인증이 필요한 주소
                .anyRequest().permitAll() // 나머지는 허용
                .and()
                .formLogin()
                .loginPage("/auth/signin") // 인증이 안된 상태에서 위 주소들에 접근할 경우 이동되는 경로
                .defaultSuccessUrl("/"); // 로그인 성공 시 이동하는 경로
    }
}
