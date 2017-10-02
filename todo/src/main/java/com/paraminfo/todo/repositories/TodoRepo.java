package com.paraminfo.todo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.paraminfo.todo.models.Todo;

public interface TodoRepo extends MongoRepository<Todo, String> {

}
