package com.mishobo.test_driven_development.data;

import com.mishobo.test_driven_development.section7.model.User;

public interface UserRepository {

    boolean save(User user);

}
