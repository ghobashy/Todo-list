package com.celonis.daos;

import java.util.List;

import com.celonis.entities.Todo;

public interface ITodoDAO {

	List<Todo>getAllTodos();
	Todo getTodoById(int todoId);
	void addTodo(Todo todo);
    void updateTodo(Todo todo);
    void deleteTodo(int todoId);
	boolean todoExists(String name);

}
