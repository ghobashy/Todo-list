package com.celonis.daos;

public interface IAuthDAO {
	boolean authenticateUser(String username, String password);
}
