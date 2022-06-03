package com.example.demo.di;

import org.springframework.stereotype.Component;

@Component
public class Hello {

    public String helloWorld(String name){
        return "Hello " + name;
    }

}
