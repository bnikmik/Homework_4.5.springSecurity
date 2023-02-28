package org.example.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@EnableWebSecurity
public class SecurityConfigNew extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser(userBuilder.username("Ivan").password("qwerty").roles("Employee"))
                .withUser(userBuilder.username("Petr").password("asdfgh").roles("IT"))
                .withUser(userBuilder.username("Olga").password("zxcvbn").roles("Security"))
                .withUser(userBuilder.username("Ekaterina").password("123456").roles("Director"));
    }
}