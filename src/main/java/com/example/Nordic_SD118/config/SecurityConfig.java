//package com.example.Nordic_SD118.config;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//
//@Configuration
//@EnableWebSecurity
//public class  SecurityConfig  {
//
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new CustomUserDetailsService();
//    }
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public DaoAuthenticationProvider daoAuthenticationProvider() {
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setUserDetailsService(userDetailsService());
//        provider.setPasswordEncoder(passwordEncoder());
//        return provider;
//    }
//
////    @Bean
////    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
////        http.authorizeRequests().antMatchers("/login").permitAll()
////                .antMatchers("/users/**", "/settings/**").hasAuthority("Admin")
////                .hasAnyAuthority("Admin", "Editor", "Salesperson")
////                .hasAnyAuthority("Admin", "Editor", "Salesperson", "Shipper")
////                .anyRequest().authenticated()
////                .and().formLogin()
////                .loginPage("/login")
////                .usernameParameter("email")
////                .permitAll()
////                .and()
////                .rememberMe().key("AbcdEfghIjklmNopQrsTuvXyz_0123456789")
////                .and()
////                .logout().permitAll();
////
////        http.headers().frameOptions().sameOrigin();
////
////        return http.build();
////    }
//}
