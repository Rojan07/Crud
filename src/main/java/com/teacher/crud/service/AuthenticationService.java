package com.teacher.crud.service;

import javax.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;

import com.teacher.crud.entity.ApiKeyAuthentication;

public class AuthenticationService {

    private static final String HEADER = "X-API-KEY";
    private static final String TOKEN = "youcantseeme";


public  static Authentication getAuthentication(HttpServletRequest request){

    String apiKey = request.getHeader(HEADER);
    if(apiKey==null || !apiKey.equals(TOKEN)){
        throw new BadCredentialsException("Invalid Api key");
    }
    return new ApiKeyAuthentication(apiKey,AuthorityUtils.NO_AUTHORITIES);
} 
     

}
