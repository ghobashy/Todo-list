package com.celonis.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository
public class LoginDAO implements ILoginDAO{
	
	@PersistenceContext	
	private EntityManager entityManager;


	@Override
	public boolean authenticateUser(String username, String password) {
		String hql = "FROM user as userList WHERE userList.username = ? and password = ?";
		int count = entityManager.createQuery(hql).setParameter(1, username).setParameter(2,password)
		              .getResultList().size();
		return count > 0 ? true : false;
	}

}
