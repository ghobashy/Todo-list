package com.celonis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public boolean registerUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
