package com.mishobo.test_driven_development.section7.service.implementation;

import com.mishobo.test_driven_development.data.UserRepository;
import com.mishobo.test_driven_development.section7.model.User;
import com.mishobo.test_driven_development.section7.service.abstraction.UserService;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


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

        String id = UUID.randomUUID().toString();
        user.setId(id);

        boolean isUserCreated;

        try {
            isUserCreated = userRepository.save(user);
        } catch (RuntimeException ex) {
            throw new UserServiceException(ex.getMessage());
        }

        if(!isUserCreated) throw new UserServiceException("Could not save user");

        return user;
    }
}
