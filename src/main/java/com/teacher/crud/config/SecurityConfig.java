package com.teacher.crud.config;
import com.teacher.crud.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
public class SecurityConfig{


    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JWTEntryPoint  authEntryPoint;


    // REST API AUTHENTICATION USING HTTP BASIC AUTH
     @Bean
     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
     {
         http
             .csrf().disable()
             .exceptionHandling()
             .authenticationEntryPoint(authEntryPoint)
             .and()
             .sessionManagement()
             .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
             .and()
             .authorizeRequests().anyRequest().authenticated()
             .and()
             .httpBasic();

         http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

         return http.build();
     }

     @Bean
     public UserDetailsService users() {
         UserDetails user = User
             .withUsername("user")
             .password(passwordEncoder().encode("password"))
             .roles("USER")
             .build();

         UserDetails admin = User
             .withUsername("admin")
             .password(passwordEncoder().encode("password"))
             .roles("ADMIN")
             .build();
         return new InMemoryUserDetailsManager(user,admin);
     }

     @Bean
     public PasswordEncoder passwordEncoder() {
         return new BCryptPasswordEncoder(8);
     }


     @Bean
     public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
         return authenticationConfiguration.getAuthenticationManager();
     }

     @Bean
    public JWTAuthenticationFilter jwtAuthenticationFilter() throws Exception {
         return new JWTAuthenticationFilter();
     }






    // REST API AUTHENTICATION USING API KEYS
//    @Override
//    protected void configure(HttpSecurity http) throws Exception
//    {
//        http
//         .csrf().disable()
//         .addFilterBefore(new AuthenticationFilter() , UsernamePasswordAuthenticationFilter.class)
//         .authorizeRequests()
//         .antMatchers("/api").authenticated()
//         .anyRequest().permitAll();
//
//    }

    //REST API AUTHENTICATION USING OAUTH
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//       return  http
//            .authorizeRequests(auth-> {
//                auth.antMatchers("/api").permitAll();
//               auth.anyRequest().authenticated();
//           })
//           .oauth2Login(withDefaults())
//           .formLogin(withDefaults())
//           .build();
//
//   }


    //REST API AUTHENTICATION USING JWT TOKEN


}
