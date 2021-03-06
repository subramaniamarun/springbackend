package com.paraminfo.todo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paraminfo.todo.models.Todo;
import com.paraminfo.todo.repositories.TodoRepo;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class TodoController {

	@Autowired
	TodoRepo todoRepo;
	
	public List<Todo> getAllTodos(){
		Sort sortByCreatedAtDesc = new Sort(Sort.Direction.DESC, "createdAt");
		return todoRepo.findAll(sortByCreatedAtDesc);
		
	}
	
	@PostMapping("/todos")
	public Todo createTodo(@Valid @RequestBody Todo todo) {
		todo.setCompleted(false);
		return todoRepo.save(todo);
		
	}
	
	 @GetMapping(value="/todos/{id}")
	    public ResponseEntity<Todo> getTodoById(@PathVariable("id") String id) {
	        Todo todo = todoRepo.findOne(id);
	        if(todo == null) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        } else {
	            return new ResponseEntity<>(todo, HttpStatus.OK);
	        }
	    }
	 
	 @PutMapping(value="/todos/{id}")
	    public ResponseEntity<Todo> updateTodo(@PathVariable("id") String id,
	                                           @Valid @RequestBody Todo todo) {
	        Todo todoData = todoRepo.findOne(id);
	        if(todoData == null) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        todoData.setTitle(todo.getTitle());
	        todoData.setCompleted(todo.isCompleted());
	        Todo updatedTodo = todoRepo.save(todoData);
	        return new ResponseEntity<>(updatedTodo, HttpStatus.OK);
	    }
	 
	 @DeleteMapping(value="/todos/{id}")
	    public void deleteTodo(@PathVariable("id") String id) {
	        todoRepo.delete(id);
	    }
}
