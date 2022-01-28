package com.jskno.taskmanagement.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
//                .antMatchers("/login*")
//                    .permitAll()
                .antMatchers("/mvc-projects/delete/**")
                    .hasAuthority("ADMIN")
                .anyRequest()
                    .authenticated()
                .and()
                .formLogin()
                    .loginPage("/login").permitAll()
                    .loginPage("/login").loginProcessingUrl("/doLogin")
                .and()
                .logout().permitAll().logoutRequestMatcher(new AntPathRequestMatcher("/doLogout", "GET"));
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user")
                    .password(encoder().encode("Password"))
                    .authorities("USER")
                .and()
                .withUser("admin")
                    .password(encoder().encode("Password"))
                    .authorities("ADMIN");
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }


}
