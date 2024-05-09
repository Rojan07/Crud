package com.teacher.crud.config;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

public class AuthenticationFilter extends BasicAuthenticationFilter {

    public AuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
     
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {

                String apiKey = request.getHeader("x-api-key");

                if (apiKey=="ashdki21388324jsda") 
                chain.doFilter(request, response);
                    else
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                
    }
}
