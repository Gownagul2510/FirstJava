package com.firstjava.firstjava;

import com.firstjava.firstjava.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("todo")
public class TodoController {

    @Autowired
    private TodoServices todoService;




    @GetMapping("/")
    public String todo()
    {
        return "Todo What do you want(normal)";
    }


    @GetMapping("/play")
    String todoWhatdoyouWant()
    {
        return "To do what do you want(pLaying)";
    }

    @GetMapping("/{id}")
    ResponseEntity<Todo> gettodobyid(@PathVariable Long id){
        try{
        Todo todo=todoService.returnTodo(id);
        return new ResponseEntity<>(todo,HttpStatus.OK);}
        catch(RuntimeException exception){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);} }
   

    @GetMapping
    String getName(@RequestParam(name="n") String name)
    {

        String x="How are you";
        return x + name ;
    }

    @PostMapping("/create")
    ResponseEntity<Todo> createUser (@RequestBody  Todo todo){

        Todo createdTodo = todoService.createTodo(todo);
        return new ResponseEntity<>(createdTodo, HttpStatus.CREATED);

    }


}
