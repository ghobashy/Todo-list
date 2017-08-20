package com.celonis.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.celonis.entities.User;

@Transactional
@Repository
public class UserDAO implements IUserDAO{

	@PersistenceContext	
	private EntityManager entityManager;
	

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		String hql = "FROM User as userList ORDER BY userList.username";
		return (List<User>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public User getUserById(int userId) {
		return entityManager.find(User.class, userId);
	}

	@Override
	public void addUser(User user) {
		entityManager.persist(user);
		
	}
	@Override
	public void updateUser(User user) {
		User itemToUpdate = getUserById(user.getId());
		itemToUpdate.setStatus(user.getStatus());
		itemToUpdate.setFirstName(user.getFirstName());
		itemToUpdate.setLastName(user.getLastName());
		entityManager.flush();
	}

	@Override
	public void deleteUser(int userId) {
		entityManager.remove(getUserById(userId));
		
	}
	
	@Override
	public boolean userExists(String username) {
		String hql = "FROM user as userList WHERE userList.username = ?";
		int count = entityManager.createQuery(hql).setParameter(1, username)
		              .getResultList().size();
		return count > 0 ? true : false;
	}

}
