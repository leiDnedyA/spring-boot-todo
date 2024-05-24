package dev.aydendiel.springtest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TodoItemController {

    private List<TodoItem> db = List.of(new TodoItem("1", "first item"), new TodoItem("2", "second item"));

    @GetMapping("/")
    public String hello() {
        return "Hello world";
    }

    @GetMapping("/todo-items")
    public List<TodoItem> get() {
        return db;
    }

    @GetMapping("/todo-items/{id}")
    public List<TodoItem> get(@PathVariable String id) {
    return db.stream().filter(item -> item.getId().equals(id)).collect(Collectors.toList());
    }
}
