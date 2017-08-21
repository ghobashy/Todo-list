package com.celonis.security.jwt;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.celonis.commons.Defines;
import com.celonis.models.AuthUser;

@Component
public class CustomAuthProvider
  implements AuthenticationProvider {
	
 
    @Override
    public Authentication authenticate(Authentication authentication) 
      throws AuthenticationException {
  
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        AuthUser user = new AuthUser();
        user.setUsername(name);
        user.setPassword(password);
        HttpEntity<AuthUser> request = new HttpEntity<>(user);
        RestTemplate restTemplate = new RestTemplate();
        
        ResponseEntity<AuthUser> response = restTemplate.postForEntity(Defines.SERIVCES_URLS+Defines.AUTH_SERVICES_PORT+"/auth/",request, AuthUser.class);
        HttpStatus status = response.getStatusCode();
        if (status == HttpStatus.OK) {
//        	authentication.setAuthenticated(true);
//        	return authentication;
  
            // use the credentials
            // and authenticate against the third-party system
            return new UsernamePasswordAuthenticationToken(
              name, password);
        } else {
        	throw new BadCredentialsException("Unable to authenticate");
        }
    }
 
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(
          UsernamePasswordAuthenticationToken.class);
    }
}