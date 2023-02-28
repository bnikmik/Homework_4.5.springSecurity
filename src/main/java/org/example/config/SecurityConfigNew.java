package org.example.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfigNew extends WebSecurityConfigurerAdapter {

    private DataSource dataSource;

    public SecurityConfigNew(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/request_access").hasAnyRole("Employee", "IT", "Security", "Director")
                .antMatchers("/employee_request").hasAnyRole("Employee", "IT", "Security", "Director")
                .antMatchers("/it_request").hasAnyRole("IT", "Security", "Director")
                .antMatchers("/security_request").hasAnyRole("Security", "Director")
                .antMatchers("/director_request").hasAnyRole("Director")
                .and().formLogin().permitAll();
    }
}