package com.jan.controller;

import com.jan.model.user.User;
import com.jan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Cacheable("users")
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @Cacheable("userId")
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Integer id) {
        return userRepository.findById(id);
    }

    @Cacheable("search")
    @GetMapping("/search")
    public List<User> getUsersByRole(@RequestParam String role) {
        return userRepository.findByRole(role);
    }
}
