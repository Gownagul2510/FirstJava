package com.firstjava.firstjava;

import com.firstjava.firstjava.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServices   {


    @Autowired
    private TodoRepository todoRepository;
    /// Creating Todo
    public Todo createTodo(Todo todo){
        return todoRepository.save(todo);
    }
    // Returning the Todo
    public Todo returnTodo(Long id)
    {
        return todoRepository.findById(id).orElseThrow(()->new RuntimeException("Todo not found"));
    }

    //Get all the todos

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();  // JPA repository method
    }

    //Deleting Specific todo by id
    public void deleteTodoById(Long id) {
        if (!todoRepository.existsById(id)) {
            throw new RuntimeException("Todo with id " + id + " not found");
        }
        todoRepository.deleteById(id);
    }

   //Deleting the all todos
   public void deleteAlltodo()
   {
       todoRepository.deleteAll();
   }

   //Updating the particular todo
   public Todo updatethetodo(Long id,Todo updateTodo)
   {
       Optional<Todo>Optionaltodo=todoRepository.findById(id);
       if(!Optionaltodo.isPresent()){
           Todo existingTodo=Optionaltodo.get();
            existingTodo.setTitle(updateTodo.getTitle());
            existingTodo.setDescription(updateTodo.getDescription());
            existingTodo.setStatus(updateTodo.getStatus());
            return todoRepository.save(existingTodo);
       }
       else{
           throw new RuntimeException("Give todo id"+id+"Not present");
       }
   }
}
