package com.example.demo.securityconf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers( "/tpps/v1/userwithpass/**" , "/tpps/v1/typeofcredit/**", "/tpps/v1/user/**") // in new version instead of method antMatchers you must use .requestMatchers
                .permitAll()
                .and()
//                .authorizeHttpRequests()
//                .requestMatchers("/tpps/v1/user/**")// in new version instead of method antMatchers you must use .requestMatchers
//                .authenticated()
//                .and().formLogin()
//                .and()
                .build();
    }

    //"/tpps/v1/user/welcome",

    //authentification
    @Bean
    public UserDetailsService userDetailsService(){

        return new UserWithPassUserDetailsService();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

}
