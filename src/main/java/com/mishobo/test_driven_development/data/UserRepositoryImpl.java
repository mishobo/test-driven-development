package com.mishobo.test_driven_development.data;

import com.mishobo.test_driven_development.section7.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserRepositoryImpl implements UserRepository {

    Map<String, User> users = new HashMap<>();

    @Override
    public boolean save(User user) {
        boolean result = false;

        if(!users.containsKey(user.getId())) {
            users.put(user.getId(), user);
            result = true;
        }

        return result;
    }


}
