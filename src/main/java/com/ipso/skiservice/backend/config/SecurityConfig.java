package com.ipso.skiservice.backend.config;

import com.ipso.skiservice.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {


    private final UserService appUserService;

    @Bean
    public UserDetailsService userDetailsService() {
        return appUserService;
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(appUserService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity
                                                           httpSecurity) throws Exception {
        return httpSecurity
                .csrf().disable()
                .formLogin(httpForm -> {
                    httpForm.loginPage("/login");
//                    httpForm.loginProcessingUrl("/req/login");
                    httpForm.defaultSuccessUrl("/index", true);
                })

                .authorizeHttpRequests(registry -> {
                    registry.requestMatchers("/req/signup", "/req/login", "/login", "/signup", "/css/**", "/js/**").permitAll();
                    registry.anyRequest().authenticated();
                })
                .build();

    }
}