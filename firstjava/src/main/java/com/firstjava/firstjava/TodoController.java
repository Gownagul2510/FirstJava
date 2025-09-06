package com.firstjava.firstjava;

import com.firstjava.firstjava.models.Todo;
import org.antlr.v4.runtime.RuntimeMetaData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.RunnableFuture;

@RestController
@RequestMapping("todo")
public class TodoController {

    @Autowired
    private TodoServices todoService;


    @GetMapping("/{id}")
    ResponseEntity<Todo> gettodobyid(@PathVariable Long id){
        try{
        Todo todo=todoService.returnTodo(id);
        return new ResponseEntity<>(todo,HttpStatus.OK);}
        catch(RuntimeException exception){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);} }


    // Retive all the todo
    @GetMapping("/all")
    ResponseEntity<List<Todo>> getAllTodos() {
        List<Todo> todos = todoService.getAllTodos();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    @PostMapping("/create")
    ResponseEntity<Todo> createUser (@RequestBody  Todo todo){

        Todo createdTodo = todoService.createTodo(todo);
        return new ResponseEntity<>(createdTodo, HttpStatus.CREATED);

    }
    // ✅ DELETE todo by id

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteTodoById(@PathVariable Long id) {
        try {
            todoService.deleteTodoById(id);
            return new ResponseEntity<>("Todo deleted successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Todo not found", HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/clear")
    ResponseEntity<String> deletAll()
     {
        todoService.deleteAlltodo();
        return new ResponseEntity<>("Todo deleted successfully", HttpStatus.OK);
    }
    @PutMapping("/{id}")
    ResponseEntity<?> UpdatingExistingTodo(@PathVariable Long id , @RequestBody Todo updatetodo) {
        try {
            Todo updatedTodo = todoService.updatethetodo( id,  updatetodo);
            return new ResponseEntity<>(updatedTodo, HttpStatus.OK);
        } catch (RuntimeException e){
            return new ResponseEntity<>("Todo Not found",HttpStatus.NOT_FOUND);
        }
    }


}
