package com.celonis.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.celonis.entities.Todo;
import com.celonis.services.ITodoService;

@Controller
@RequestMapping("todos")
public class TodoController {

	@Autowired
	private ITodoService todoService;

	@GetMapping("/")
	public ResponseEntity<List<Todo>> getAllTodos() {
		List<Todo> list = todoService.getAllTodos();
		return new ResponseEntity<List<Todo>>(list, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Todo> getTodoById(@PathVariable("id") Integer id) {
		Todo todo = todoService.getTodoById(id);
		return new ResponseEntity<Todo>(todo, HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<Void> addTodo(@RequestBody Todo todo) {
		boolean flag = todoService.addTodo(todo);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PatchMapping("/")
	public ResponseEntity<Todo> updateTodo(@RequestBody Todo todo) {
		todoService.updateTodo(todo);
		return new ResponseEntity<Todo>(todo, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable("id") Integer id) {
		todoService.deleteTodo(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
