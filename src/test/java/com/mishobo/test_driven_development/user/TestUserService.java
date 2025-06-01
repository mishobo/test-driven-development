package com.mishobo.test_driven_development.user;

import com.mishobo.test_driven_development.section7.model.User;
import com.mishobo.test_driven_development.section7.service.abstraction.UserService;
import com.mishobo.test_driven_development.section7.service.implementation.UserServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestUserService {

    UserService userService = new UserServiceImpl();


    @DisplayName("user creation method")
    @Test
    void testCreateUser_whenUserDetailsProvided_returnsUserObject() {
        //arrange
        User createUser  = new User(
                "Hussein",
                "Mishobo",
                "hussein@gmail.com",
                "Mishobo1234",
                "Mishobo1234"
        );


        //act
       User createdUser  = userService.createUser(createUser);
       System.out.println(createdUser);
        //assert
        assertNotNull(createdUser, "created user should not be null");
        assertNotNull(createdUser.getId(), "created user id should not be null");
        assertEquals(createUser.getFirstName(), createdUser.getFirstName(), "first name is incorrect");
        assertEquals(createUser.getLastName(), createdUser.getLastName(), "last name is incorrect");
        assertEquals(createUser.getEmail(), createdUser.getEmail(), "email is incorrect");
        assertEquals(createUser.getPassword(), createdUser.getPassword(), "password is incorrect");
    }


    @DisplayName("When certain attributes are not provides")
    @Test
    void testCreateUser_whenFieldsAreEmpty_throwIllegalArgumentException() {
        //arrange
        User createUser  = new User(
                "",
                "Mishobo",
                null,
                "Mishobo1234",
                "Mishobo1234"
        );
        String expectedExceptionMessage = "firstName should not be empty";

        //act & assert
        IllegalArgumentException message = assertThrows(IllegalArgumentException.class, () -> userService.createUser(createUser), "first should not be empty");
        assertEquals(expectedExceptionMessage, message.getMessage(), "Error message is incorrect");
    }





}
