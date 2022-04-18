package com.tong.Dao;

import com.tong.Entity.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserRepository {
    private ConcurrentMap<Long, User> repository = new ConcurrentHashMap<>();
    private static AtomicLong idGenerator = new AtomicLong(0);

    public Long add(User user){
        Long id = idGenerator.incrementAndGet();
        repository.put(id,user);
        return id;
    }

    public User findUserById(Long id){
        return repository.get(id);
    }

    public Collection<User> findAll(){
        return repository.values();
    }

    public Long update(User user){
        repository.put(user.getId(),user);
        return user.getId();
    }

    public Long delete(Long id){
        repository.remove(id);
        return id;
    }
}
