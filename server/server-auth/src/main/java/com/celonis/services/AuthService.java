package com.celonis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.celonis.commons.Defines;
import com.celonis.daos.IAuthDAO;
import com.celonis.entities.User;
import com.celonis.models.AuthUser;

@Service
public class AuthService implements IAuthService{
	
	@Autowired
	private IAuthDAO authDAO;

	@Override
	public synchronized boolean authenticateUser(AuthUser user){
                if (!authDAO.authenticateUser(user.getUsername(), user.getPassword())) {
    	            return false;
                } else {
    	            return true;
                }
	}

	@Override
	public User registerUser(User user) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<User> request = new HttpEntity<>(user);
        ResponseEntity<User> response = restTemplate.postForEntity(Defines.SERIVCES_URLS+Defines.USERS_SERVICES_PORT+"/users/",request, User.class);
        HttpStatus status = response.getStatusCode();
        try {
			if (status == HttpStatus.CREATED) {
				return response.getBody();
			} else {
				throw new Exception("Unable to register new user");
			}
		} catch (Exception e) {
			throw e;
		}
	}

}
