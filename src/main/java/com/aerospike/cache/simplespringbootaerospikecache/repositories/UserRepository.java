package com.aerospike.cache.simplespringbootaerospikecache.repositories;

import com.aerospike.cache.simplespringbootaerospikecache.objects.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository {

    @Cacheable(value = "test", key = "#id")
    public Optional<User> getUserById(int id) {
        System.out.println("Simulating a read from the main data store (cache miss).");
        return Optional.of(new User(id, "jimmy page", "jimmy@gmail.com", 77));
    }

    @CachePut(value = "test", key = "#user.id")
    public User addUser(User user) {
        System.out.println("Simulating addition of " + user + " to the main data store.");
        return user;
    }

    @CacheEvict(value = "test", key = "#id")
    public void removeUserById(int id) {
        System.out.println("Simulating removal of " + id + " from the main data store.");
    }
}
