package com.example.demo.securityconf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

//    @Bean
//    public UserDetailsService userDetailsService(PasswordEncoder encoder){
////        UserDetails admin = User.withUsername("abbc")
////                .password(encoder.encode("psdw"))
////                .roles("ADMIN")
////                .build();
////        UserDetails user = User.withUsername("abc")
////                .password(encoder.encode("psdw"))
////                .roles("USER")
////                .build();
////
////        return new InMemoryUserDetailsManager(admin, user);
//
//        return new UserUserDetailsService(); //TODO Add new java User with user password fields for this video with security
//
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/tpps/v1/user/welcome") // in new version instead of method antMatchers you must use .requestMatchers
                .permitAll()
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/tpps/v1/user/users") // in new version instead of method antMatchers you must use .requestMatchers
                .authenticated()
                .and().formLogin()
                .and()
                .build();

    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
