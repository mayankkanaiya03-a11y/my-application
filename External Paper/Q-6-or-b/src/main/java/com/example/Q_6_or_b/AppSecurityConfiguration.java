package com.example.Q_6_or_b;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AppSecurityConfiguration {

    @Bean
    public UserDetailsManager  userDetailsManager() {

        UserDetails mayank = User.builder()
                .username("Mayank")
                .password("{noop}123")
                .roles("DEPARTMENT_ADMIN")
                .build();

        UserDetails yaksh = User.builder()
                .username("Yaksh")
                .password("{noop}123")
                .roles("INSTRUCTOR")
                .build();

        UserDetails krish = User.builder()
                .username("Krish")
                .password("{noop}123")
                .roles("STUDENT")
                .build();

        return new InMemoryUserDetailsManager(mayank,yaksh,krish);
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests( configurer ->
                configurer.requestMatchers(HttpMethod.GET,"/course")
                        .hasAnyRole("DEPARTMENT_ADMIN","INSTRUCTOR","STUDENT")
                        .requestMatchers(HttpMethod.GET,"/course/{id}")
                        .hasAnyRole("DEPARTMENT_ADMIN","INSTRUCTOR","STUDENT")
                        .requestMatchers(HttpMethod.POST,"/course")
                        .hasAnyRole("DEPARTMENT_ADMIN","INSTRUCTOR")
                        .requestMatchers(HttpMethod.PUT,"/course/{id}")
                        .hasAnyRole("DEPARTMENT_ADMIN","INSTRUCTOR")
                        .requestMatchers(HttpMethod.DELETE,"/course/{id}")
                        .hasAnyRole("DEPARTMENT_ADMIN")
                );

        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}
