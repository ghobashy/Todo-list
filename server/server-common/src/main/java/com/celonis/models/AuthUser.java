package com.celonis.models;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class AuthUser implements Authentication {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4378242564962181955L;
	private String username;
	private String password;
	private boolean authenticated = true;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object getCredentials() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object getDetails() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object getPrincipal() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
    public boolean isAuthenticated() {
        return this.authenticated;
    }

    @Override
    public void setAuthenticated(boolean b) throws IllegalArgumentException {
        this.authenticated = b;
    }

}
