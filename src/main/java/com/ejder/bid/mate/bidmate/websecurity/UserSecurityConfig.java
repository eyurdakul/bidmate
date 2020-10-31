package com.ejder.bid.mate.bidmate.websecurity;

import com.ejder.bid.mate.bidmate.constants.Matchers;
import com.ejder.bid.mate.bidmate.constants.Paths;
import com.ejder.bid.mate.bidmate.constants.Roles;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@Order(2)
public class UserSecurityConfig extends WebSecurityConfigurerAdapter {

    public UserSecurityConfig(){
        super();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .requestMatchers()
                .antMatchers(Matchers.USER_MATCHER.matcher)
                .and()
                .authorizeRequests()
                .antMatchers(Matchers.USER_MATCHER.matcher)
                .hasRole(Roles.USER.role)

                .and()
                .formLogin()
                .loginPage(Paths.USER_LOGIN.path)
                .loginProcessingUrl(Paths.USER_PROCESS.path)
                .failureUrl(Paths.USER_LOGIN.path)
                .defaultSuccessUrl(Paths.USER_MY.path)

                .and()
                .logout()
                .logoutUrl(Paths.LOGOUT.path)
                .logoutSuccessUrl(Paths.HOME.path);
    }
}