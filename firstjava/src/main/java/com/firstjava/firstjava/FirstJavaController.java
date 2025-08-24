package com.firstjava.firstjava;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstJavaController {
    @GetMapping("/Hello")
    public String Hello()
    {
        return "Hello Gowtham";
    }

}
