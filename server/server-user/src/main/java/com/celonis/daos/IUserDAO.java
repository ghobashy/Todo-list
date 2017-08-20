package com.celonis.daos;

import java.util.List;

import com.celonis.entities.User;

public interface IUserDAO {

	List<User>getAllUsers();
	User getUserById(int userId);
	void addUser(User user);
    void updateUser(User user);
    void deleteUser(int userId);
	boolean userExists(String name);

}
