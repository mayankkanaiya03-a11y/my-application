# **Q-6 or b**









## AppSecurityConfiguration.java











package com.example.Q\_6\_or\_b;



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



&#x20;   @Bean

&#x20;   public UserDetailsManager  userDetailsManager() {



&#x20;       UserDetails mayank = User.builder()

&#x20;               .username("Mayank")

&#x20;               .password("{noop}123")

&#x20;               .roles("DEPARTMENT\_ADMIN")

&#x20;               .build();



&#x20;       UserDetails yaksh = User.builder()

&#x20;               .username("Yaksh")

&#x20;               .password("{noop}123")

&#x20;               .roles("INSTRUCTOR")

&#x20;               .build();



&#x20;       UserDetails krish = User.builder()

&#x20;               .username("Krish")

&#x20;               .password("{noop}123")

&#x20;               .roles("STUDENT")

&#x20;               .build();



&#x20;       return new InMemoryUserDetailsManager(mayank,yaksh,krish);

&#x20;   }





&#x20;   @Bean

&#x20;   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

&#x20;       http.authorizeHttpRequests( configurer ->

&#x20;               configurer.requestMatchers(HttpMethod.GET,"/course")

&#x20;                       .hasAnyRole("DEPARTMENT\_ADMIN","INSTRUCTOR","STUDENT")

&#x20;                       .requestMatchers(HttpMethod.GET,"/course/{id}")

&#x20;                       .hasAnyRole("DEPARTMENT\_ADMIN","INSTRUCTOR","STUDENT")

&#x20;                       .requestMatchers(HttpMethod.POST,"/course")

&#x20;                       .hasAnyRole("DEPARTMENT\_ADMIN","INSTRUCTOR")

&#x20;                       .requestMatchers(HttpMethod.PUT,"/course/{id}")

&#x20;                       .hasAnyRole("DEPARTMENT\_ADMIN","INSTRUCTOR")

&#x20;                       .requestMatchers(HttpMethod.DELETE,"/course/{id}")

&#x20;                       .hasAnyRole("DEPARTMENT\_ADMIN")

&#x20;               );



&#x20;       http.httpBasic(Customizer.withDefaults());

&#x20;       http.csrf(csrf -> csrf.disable());



&#x20;       return http.build();

&#x20;   }

}



