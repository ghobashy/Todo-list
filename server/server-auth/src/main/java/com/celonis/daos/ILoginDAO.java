package com.celonis.daos;

public interface ILoginDAO {
	boolean authenticateUser(String username, String password);
}
