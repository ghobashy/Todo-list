package com.celonis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.celonis.daos.ILoginDAO;
import com.celonis.models.AuthUser;

@Service
public class LoginService implements ILoginService{
	
	@Autowired
	private ILoginDAO loginDAO;

	@Override
	public synchronized boolean authenticateUser(AuthUser user){
                if (loginDAO.authenticateUser(user.getUsername(), user.getPassword())) {
    	            return false;
                } else {
    	            return true;
                }
	}

}
