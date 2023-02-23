package com.bms.businessrulesengine.service.userRules;

import com.bms.businessrulesengine.core.exceptions.BusinessException;
import com.bms.businessrulesengine.core.exceptions.NotFoundException;
import com.bms.businessrulesengine.model.User;
import com.bms.businessrulesengine.repository.UserRepository;
import com.bms.businessrulesengine.service.constants.UserMessages;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserBusinessRules {
    private final UserRepository userRepository;

    public UserBusinessRules(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void checkIfUserExistsByUsername(String username) {
        var user = userRepository.findByUsername(username);
        if (user != null) {
            throw new BusinessException(UserMessages.USER_ALREADY_EXISTS_BY_USERNAME);
        }
    }

    public void checkIfUserExistsByEmail(String email) {
        var user = userRepository.findByEmail(email);
        if (user != null) {
            throw new BusinessException(UserMessages.USER_ALREADY_EXISTS_BY_EMAIL);
        }
    }

    public User getUser(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(UserMessages.USER_NOT_FOUND_BY_ID));
    }

    public void checkIfUserListIsEmpty(List<User> users) {
        if (users.isEmpty()) {
            throw new NotFoundException(UserMessages.USER_LIST_IS_EMPTY);
        }
    }
}
