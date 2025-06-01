package com.mishobo.test_driven_development.section7.service.implementation;

import com.mishobo.test_driven_development.section7.model.User;
import com.mishobo.test_driven_development.section7.service.abstraction.UserService;

import java.util.UUID;

public class UserServiceImpl implements UserService {


    @Override
    public User createUser(User user) {
        if (user.getFirstName() == null || user.getFirstName().trim().isEmpty()) {
            throw new IllegalArgumentException("firstName should not be empty");
        }

        if(user.getLastName() == null || user.getLastName().trim().isEmpty()) {
            throw new IllegalArgumentException("lastName should not be empty");
        }

        if(user.getEmail() == null || user.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("email should not be empty");
        }

        if(user.getPassword() == null || user.getPassword().trim().isEmpty()) {
            throw new IllegalArgumentException("password should not be empty");
        }

        if (!user.getPassword().equals(user.getPasswordConfirm())) {
            throw new IllegalArgumentException("passwords do not match");
        }

        String generatedId = UUID.randomUUID().toString();
        user.setId(generatedId);
        return user;
    }
}
