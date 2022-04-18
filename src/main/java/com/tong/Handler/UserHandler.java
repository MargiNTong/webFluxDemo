package com.tong.Handler;

import com.tong.Dao.UserRepository;
import com.tong.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.MonoSink;

@Component
public class UserHandler {

    private UserRepository repository;

    @Autowired
    public UserHandler(UserRepository userRepository){
        this.repository = userRepository;
    }
    public Mono<Long> addUser(User user){
        return Mono.create(userMonoSink->userMonoSink.success(repository.add(user)));
    }
    public Mono<User> findUserById(Long id){
        return Mono.justOrEmpty(repository.findUserById(id));
    }
    public Flux<User> findALlUser(){
        return Flux.fromIterable(repository.findAll());
    }
    public Mono<Long> updateUser(User user){
        return Mono.create(userMonoSink->userMonoSink.success(repository.update(user)));
    }
    public Mono<Long> deleteUser(Long id){
        return Mono.create(userMonoSink->userMonoSink.success(repository.delete(id)));
    }
}
