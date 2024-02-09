package com.playground.githubactionsplayground.controller;

import com.playground.githubactionsplayground.dto.MessageDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greetings")
public class GreetingsController {

    @GetMapping("/hello")
    @ResponseStatus(HttpStatus.OK)
    public MessageDto hello() {
        return new MessageDto("Hello World");
    }

    @GetMapping("/goodbye")
    @ResponseStatus(HttpStatus.OK)
    public MessageDto goodbye() {
        return new MessageDto("Goodbye");
    }

}
