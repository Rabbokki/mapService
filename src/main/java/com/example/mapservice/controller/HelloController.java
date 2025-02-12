package com.example.mapservice.controller;

import com.example.mapservice.dto.Hello;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        String hello = "Welcome SpringBoot";
        model.addAttribute("data",hello);
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String hello2(Model model,
                         @RequestParam(value = "name", required = false,
                         defaultValue = "수지")String name,
                         @RequestParam(name = "age",required = false)Integer age){
        model.addAttribute("name",name);
        model.addAttribute("age",age);
        return "hello-template";
    }

    @GetMapping("/api-string")
    @ResponseBody
    public String apiString(@RequestParam("name")String name){

        return "hello"+name;
    }

    @GetMapping("api-object")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
}
