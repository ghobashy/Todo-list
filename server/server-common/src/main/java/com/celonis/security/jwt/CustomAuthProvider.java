package com.celonis.security.jwt;

import org.springframework.http.HttpEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.celonis.models.AuthUser;

@Component
public class CustomAuthProvider
  implements AuthenticationProvider {
	
 
    @Override
    public Authentication authenticate(Authentication authentication) 
      throws AuthenticationException {
  
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        HttpEntity<AuthUser> request = new HttpEntity<>(new AuthUser(name, password));
        RestTemplate restTemplate = new RestTemplate();
        boolean auth =  restTemplate.postForObject("localhost:8080/auth",request, Boolean.class);
        if (auth) {
  
            // use the credentials
            // and authenticate against the third-party system
            return new UsernamePasswordAuthenticationToken(
              name, password);
        } else {
            return null;
        }
    }
 
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(
          UsernamePasswordAuthenticationToken.class);
    }
}