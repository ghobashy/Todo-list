package com.celonis.services;

import java.util.List;

import com.celonis.entities.User;

public interface IUserService {
	List<User> getAllUsers();
    User getUserById(int userId);
    boolean addUser(User user);
    void updateUser(User user);
    void deleteUser(int userId);
}
