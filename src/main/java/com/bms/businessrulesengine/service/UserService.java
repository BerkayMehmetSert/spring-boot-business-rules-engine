package com.bms.businessrulesengine.service;

import com.bms.businessrulesengine.core.utilities.security.PasswordEncoder;
import com.bms.businessrulesengine.core.utilities.services.BusinessRules;
import com.bms.businessrulesengine.model.User;
import com.bms.businessrulesengine.repository.UserRepository;
import com.bms.businessrulesengine.request.CreateUserRequest;
import com.bms.businessrulesengine.request.UpdateUserRequest;
import com.bms.businessrulesengine.service.userRules.UserBusinessRules;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserBusinessRules userBusinessRules;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       UserBusinessRules userBusinessRules) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userBusinessRules = userBusinessRules;
    }

    public void createUser(CreateUserRequest request) {
        BusinessRules.run(() -> {
            userBusinessRules.checkIfUserExistsByUsername(request.getUsername());
            userBusinessRules.checkIfUserExistsByEmail(request.getEmail());
        });

        var user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());

        userRepository.save(user);
    }

    public void updateUser(final int id, UpdateUserRequest request) {
        var user = BusinessRules.run(() -> userBusinessRules.getUser(id));

        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());

        userRepository.save(user);
    }

    public void deleteUser(final int id) {
        var user = BusinessRules.run(() -> userBusinessRules.getUser(id));

        userRepository.delete(user);
    }

    public User getUser(final int id) {
        return BusinessRules.run(() -> userBusinessRules.getUser(id));
    }

    public List<User> getAllUsers() {
        var users = userRepository.findAll();

        BusinessRules.run(() -> userBusinessRules.checkIfUserListIsEmpty(users));
        return users;
    }
}
