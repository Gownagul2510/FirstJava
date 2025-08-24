package com.firstjava.firstjava;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("todo")
public class TodoController {
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
    String toWitId(@PathVariable long id)
    {
        return "To with Id:"+ id;
    }
    @GetMapping
    String getName(@RequestParam(name="n") String name)
    {

        String x="How are you";
        return x + name ;

    }

}
