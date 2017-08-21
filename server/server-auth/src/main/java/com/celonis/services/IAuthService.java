package com.celonis.services;

import com.celonis.entities.User;
import com.celonis.models.AuthUser;

public interface IAuthService {
	
	boolean authenticateUser(AuthUser user);
	boolean registerUser(User user);
	

}