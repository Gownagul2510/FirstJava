package com.firstjava.firstjava;

import com.firstjava.firstjava.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoServices   {


    @Autowired
    private TodoRepository todoRepository;

    public Todo createTodo(Todo todo){
        return todoRepository.save(todo);
    }
    public Todo returnTodo(Long id)
    {
        return todoRepository.findById(id).orElseThrow(()->new RuntimeException("Todo not found"));
    }
}
