package com.verisk.demo.todo.controller;

import com.verisk.demo.todo.model.Todo;
import com.verisk.demo.todo.repository.TodoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoRepository repo;

    public TodoController(TodoRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Todo> getTodos() {
        return repo.findAll();
    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        return repo.save(todo);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
