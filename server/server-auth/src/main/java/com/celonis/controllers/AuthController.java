package com.celonis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.celonis.models.AuthUser;
import com.celonis.services.IAuthService;

@Controller
@RequestMapping("auth")
public class AuthController {

	@Autowired
	IAuthService authService;
	
	@PostMapping("/")
	public ResponseEntity<Void> authenicateUser(@RequestBody AuthUser user) {		 
		boolean flag = authService.authenticateUser(user);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
