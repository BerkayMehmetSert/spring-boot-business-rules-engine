package com.bms.businessrulesengine.controller;

import com.bms.businessrulesengine.model.User;
import com.bms.businessrulesengine.request.CreateUserRequest;
import com.bms.businessrulesengine.request.UpdateUserRequest;
import com.bms.businessrulesengine.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void createUser(CreateUserRequest request) {
        userService.createUser(request);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable int id, UpdateUserRequest request) {
        userService.updateUser(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
}
