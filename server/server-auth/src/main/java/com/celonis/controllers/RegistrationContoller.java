package com.celonis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.celonis.entities.User;
import com.celonis.models.AuthUser;
import com.celonis.services.IAuthService;

@Controller
@RequestMapping("register")
public class RegistrationContoller {
	
	@Autowired
	IAuthService authService;
	
	@PostMapping("/")
	public ResponseEntity<Void> authenicateUser(@RequestBody User user) {		 
		
	}

}
