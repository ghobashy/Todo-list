package com.celonis.services;

import com.celonis.models.AuthUser;

public interface ILoginService {
	
	boolean authenticateUser(AuthUser user);

}
