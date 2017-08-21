package com.celonis.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.celonis.daos.IUserDAO;
import com.celonis.entities.User;

@Service
public class UserService implements IUserService{

	@Autowired
	private IUserDAO userDAO;
	@Override
	public User getUserById(int userId) {
		User obj = userDAO.getUserById(userId);
		return obj;
	}	
	@Override
	public List<User> getAllUsers(){
		return userDAO.getAllUsers();
	}
	@Override
	public synchronized User addUser(User user){
                if (userDAO.userExists(user.getUsername())) {
    	            return null;
                } else {
                	user.setStatus("active");
    	            return userDAO.addUser(user);
                }
	}
	@Override
	public void updateUser(User user) {
		userDAO.updateUser(user);
	}
	@Override
	public void deleteUser(int userId) {
		userDAO.deleteUser(userId);
	}

}
