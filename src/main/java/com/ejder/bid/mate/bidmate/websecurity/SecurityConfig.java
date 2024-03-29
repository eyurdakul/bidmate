package com.ejder.bid.mate.bidmate.websecurity;

import com.ejder.bid.mate.bidmate.constants.Matchers;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public SecurityConfig(){super();}

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(Matchers.BASE_MATCHER.matcher)
                .permitAll()
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, Matchers.BASE_API_MATCHER.matcher)
                .permitAll();
    }
}
