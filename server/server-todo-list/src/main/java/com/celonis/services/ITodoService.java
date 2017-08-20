package com.celonis.services;

import java.util.List;

import com.celonis.entities.Todo;

public interface ITodoService {
	List<Todo> getAllTodos();
    Todo getTodoById(int todoId);
    boolean addTodo(Todo todo);
    void updateTodo(Todo todo);
    void deleteTodo(int todoId);

}
