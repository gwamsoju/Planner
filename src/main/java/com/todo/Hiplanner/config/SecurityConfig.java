package com.todo.Hiplanner.config;

import com.todo.Hiplanner.config.auth.PrincipalDetails;
import com.todo.Hiplanner.config.oauth.PrincipalOAuth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PrincipalOAuth2UserService principalOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/members/**","/messages/**","/planners/**").authenticated()
                .anyRequest().permitAll() // 그외는 접근 가능
            .and()
                .formLogin()
                .loginPage("/")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/login/result",true)
            .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logoutProc"))
                .invalidateHttpSession(true)
             .and()
                .oauth2Login()
                .loginPage("/login")
                .defaultSuccessUrl("/login/result",true)
                .userInfoEndpoint()
                .userService(principalOAuth2UserService);
    }
}
