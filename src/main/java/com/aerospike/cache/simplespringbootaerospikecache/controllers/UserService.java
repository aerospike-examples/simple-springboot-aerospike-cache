package com.aerospike.cache.simplespringbootaerospikecache.controllers;

import com.aerospike.cache.simplespringbootaerospikecache.objects.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    public Optional<User> readUserById(int id) {
        System.out.println("UserService: readUserById execution");
        return Optional.of(new User(3, "cachetest", "cachetest", 67));
    }

    public User addUser(User user) {
        System.out.println("UserService: addUser execution");
        return user;
    }

    public void removeUserById(int id) {
        System.out.println("UserService: removeUserById execution");
    }
}