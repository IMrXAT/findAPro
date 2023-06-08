package com.example.findapro.app;

import com.example.findapro.core.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class SecurityConfiguration{

    private final UserService userService;

    @Bean
    SecurityFilterChain configureSecurity(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests()
                .requestMatchers("/login", "/registration", "/new-user", "/", "/tasks","/tasks/**", "/search").permitAll()
                .requestMatchers("/adding_task", "/roles").hasAuthority("customer")
                .requestMatchers("/new-task").authenticated()
                .anyRequest().denyAll()
                .and()
                .formLogin()
                .and()
                .httpBasic();
        http.csrf().disable();
        return http.build();
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

}
