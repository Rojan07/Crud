package com.teacher.crud.config;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;
import com.teacher.crud.service.AuthenticationService;


public class AuthenticationFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
                try{
                    Authentication authentication = AuthenticationService.getAuthentication((HttpServletRequest)request);
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }catch (Exception e){
                   HttpServletResponse httpServletResponse = (HttpServletResponse) response;
                   httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                }
                chain.doFilter(request, response);
    }
}
