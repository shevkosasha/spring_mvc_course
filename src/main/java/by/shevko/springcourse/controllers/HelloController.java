package by.shevko.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/hw")
    public String hello(){
        System.out.println("hw request");
        return "hello";
    }
}
