package com.aerospike.cache.simplespringbootaerospikecache.controllers;

import com.aerospike.cache.simplespringbootaerospikecache.objects.User;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
public class UserController {

    com.aerospike.cache.simplespringbootaerospikecache.controllers.UserService userService;

    @GetMapping("/users/{id}")
    @Cacheable(value = "test", key = "#id")
    public Optional<User> readUserById(@PathVariable("id") Integer id) {
        System.out.println("UserController: getUserById execution before service");
        return userService.readUserById(id);
    }

    @PostMapping("/users")
    @CachePut(value = "test", key = "#user.id")
    public User addUser(@RequestBody User user) {
        System.out.println("UserController: addUser execution before service");
        System.out.println(user);
        return userService.addUser(user);
    }

    @DeleteMapping("/users/{id}")
    @CacheEvict(value = "test", key = "#id")
    public void deleteUserById(@PathVariable("id") Integer id) {
        System.out.println("UserController: removeUserById execution before service");
        userService.removeUserById(id);
        System.out.println("UserController: removeUserById execution after service");

    }
}
