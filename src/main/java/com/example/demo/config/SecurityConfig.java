// package com.example.demo.config;

// import com.example.demo.security.JwtAuthenticationFilter;
// import com.example.demo.security.JwtUtil;
// import org.springframework.context.annotation.*;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
public class SecurityConfig {

    // private final JwtUtil jwtUtil;

    // public SecurityConfig(JwtUtil jwtUtil) {
    //     this.jwtUtil = jwtUtil;
    // }

    // @Bean
    // public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    //     http
    //         .csrf().disable()
    //         .authorizeRequests()
    //         .antMatchers("/auth/**").permitAll()
    //         .anyRequest().authenticated()
    //         .and()
    //         .addFilterBefore(new JwtAuthenticationFilter(jwtUtil),
    //                 org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter.class);

    //     return http.build();
    // }
}
