package com.tong.Controller;

import com.tong.Entity.User;
import com.tong.Handler.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserHandler userHandler;

    @GetMapping("/hello")
    public String hello(){
        return "hello webflux";
    }

    @GetMapping("")
    public Flux<User> getAllUsers(){
        return userHandler.findALlUser();
    }

    @GetMapping("/{id}")
    public Mono<User> getUser(@PathVariable("id") Long id){
        return userHandler.findUserById(id);
    }
    @GetMapping("/add")
    public Mono<Long> addUser(@RequestBody User user){
        return userHandler.addUser(user);
    }
    @GetMapping("/update")
    public Mono<Long> updateUser(@RequestBody User user){
        return userHandler.updateUser(user);
    }

    @GetMapping("/delete/{id}")
    public Mono<Long> deleteUser(@PathVariable("id") Long id){
        return userHandler.deleteUser(id);
    }
}
