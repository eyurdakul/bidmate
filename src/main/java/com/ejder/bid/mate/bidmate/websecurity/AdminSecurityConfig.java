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
@Order(1)
public class AdminSecurityConfig extends WebSecurityConfigurerAdapter {

    public AdminSecurityConfig(){
        super();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .requestMatchers()
                .antMatchers(Matchers.ADMIN_MATCHER.matcher)
                .and()
                .authorizeRequests()
                .antMatchers(Matchers.ADMIN_MATCHER.matcher)
                .hasRole(Roles.ADMIN.role)

                .and()
                .formLogin()
                .loginPage(Paths.ADMIN_LOGIN.path)
                .loginProcessingUrl(Paths.ADMIN_PROCESS.path)
                .failureUrl(Paths.ADMIN_LOGIN.path)
                .defaultSuccessUrl(Paths.ADMIN_DASHBOARD.path)

                .and()
                .logout()
                .logoutUrl(Paths.LOGOUT.path)
                .logoutSuccessUrl(Paths.HOME.path);
    }
}
