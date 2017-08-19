package com.celonis.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.celonis.entities.Todo;

@Transactional
@Repository
public class TodoDAO implements ITodoDAO{

	@PersistenceContext	
	private EntityManager entityManager;
	
	public TodoDAO() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Todo> getAllTodos() {
		String hql = "FROM Todo as todoList ORDER BY todoList.creation_date";
		return (List<Todo>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Todo getTodoById(int todoId) {
		return entityManager.find(Todo.class, todoId);
	}

	@Override
	public void addTodo(Todo todo) {
		entityManager.persist(todo);
		
	}
	@Override
	public void updateTodo(Todo todo) {
		Todo itemToUpdate = getTodoById(todo.getId());
		itemToUpdate.setStatus(todo.getStatus());
		itemToUpdate.setUser_id(todo.getUser_id());
		itemToUpdate.setName(todo.getName());
		itemToUpdate.setCreation_date(todo.getCreation_date());
		entityManager.flush();
	}

	@Override
	public void deleteTodo(int todoId) {
		entityManager.remove(getTodoById(todoId));
		
	}
	
	@Override
	public boolean todoExists(String name) {
		String hql = "FROM todo as todoList WHERE todoList.name = ?";
		int count = entityManager.createQuery(hql).setParameter(1, name)
		              .getResultList().size();
		return count > 0 ? true : false;
	}

}
