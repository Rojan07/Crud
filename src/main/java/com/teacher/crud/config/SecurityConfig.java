package com.teacher.crud.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    // REST API AUTHENTICATION USING HTTP BASIC AUTH
    // @Override
    // protected void configure(HttpSecurity http) throws Exception
    // {
    //     http
    //         .csrf().disable()
    //         .authorizeRequests().anyRequest().authenticated()
    //         .and()
    //         .httpBasic();
    // }

    // @Bean
    // public InMemoryUserDetailsManager userDetailsService() {
    //     UserDetails user = User
    //         .withUsername("user")
    //         .password(passwordEncoder().encode("user"))
    //         .roles("USER_ROLE")
    //         .build();
    //     return new InMemoryUserDetailsManager(user);
    // }

    // @Bean
    // public PasswordEncoder passwordEncoder() {
    //     return new BCryptPasswordEncoder(8);
    // }


    // REST API AUTHENTICATION USING API KEYS


    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http
         .csrf().disable()
         .addFilterBefore(new AuthenticationFilter() , UsernamePasswordAuthenticationFilter.class)
         .authorizeRequests()
         .antMatchers("/api").authenticated()
         .anyRequest().permitAll();
          
    }

}
