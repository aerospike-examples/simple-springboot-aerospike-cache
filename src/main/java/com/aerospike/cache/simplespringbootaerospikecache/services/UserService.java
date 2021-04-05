package com.aerospike.cache.simplespringbootaerospikecache.services;

import com.aerospike.cache.simplespringbootaerospikecache.objects.User;
import com.aerospike.cache.simplespringbootaerospikecache.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    UserRepository userRepository;

    public Optional<User> readUserById(int id) {
        return userRepository.getUserById(id);
    }

    public User addUser(User user) {
        return userRepository.addUser(user);
    }

    public void removeUserById(int id) {
        userRepository.removeUserById(id);
    }
}
