package com.celonis.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.celonis.daos.ITodoDAO;
import com.celonis.entities.Todo;

@Service
public class TodoService implements ITodoService{

	@Autowired
	private ITodoDAO todoDAO;
	@Override
	public Todo getTodoById(int todoId) {
		Todo obj = todoDAO.getTodoById(todoId);
		return obj;
	}	
	@Override
	public List<Todo> getAllTodos(){
		return todoDAO.getAllTodos();
	}
	@Override
	public synchronized boolean addTodo(Todo todo){
                if (todoDAO.todoExists(todo.getName())) {
    	            return false;
                } else {
    	            todoDAO.addTodo(todo);
    	            return true;
                }
	}
	@Override
	public void updateTodo(Todo todo) {
		todoDAO.updateTodo(todo);
	}
	@Override
	public void deleteTodo(int todoId) {
		todoDAO.deleteTodo(todoId);
	}

}
