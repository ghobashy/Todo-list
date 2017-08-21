package com.celonis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.celonis.entities.User;

import com.celonis.security.jwt.TokenAuthenticationService;
import com.celonis.services.IAuthService;

@Controller
@RequestMapping("register")
public class RegistrationContoller {
	
	@Autowired
	IAuthService authService;
	
	@PostMapping("/")
	public ResponseEntity<User> registerUser(@RequestBody User user) {	
		try {
			User newUser = authService.registerUser(user);
			HttpHeaders headers = new HttpHeaders();
			TokenAuthenticationService tokenService = new TokenAuthenticationService();
			tokenService.addHeader(headers, user.getUsername());
			return new ResponseEntity<User>(newUser,headers, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<User>(HttpStatus.CONFLICT);
		}
		
	}

}
