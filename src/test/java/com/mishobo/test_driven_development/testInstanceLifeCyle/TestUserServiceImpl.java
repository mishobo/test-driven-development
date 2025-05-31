package com.mishobo.test_driven_development.testInstanceLifeCyle;


import com.mishobo.test_driven_development.io.UsersDatabase;
import com.mishobo.test_driven_development.io.UsersDatabaseMapImpl;
import com.mishobo.test_driven_development.service.UserService;
import com.mishobo.test_driven_development.service.UserServiceImpl;
import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestUserServiceImpl {

    UsersDatabase usersDatabase;
    UserService userService;
    String userId = "";

    @BeforeAll
    void setup() {
        // Create & initialize database
        usersDatabase = new UsersDatabaseMapImpl();
        usersDatabase.init();
        userService = new UserServiceImpl(usersDatabase);
    }

    @AfterAll
    void cleanup() {
        // Close connection
        // Delete database
        usersDatabase.close();
    }

    @Test
    @Order(1)
    @DisplayName("Create User works")
    void testCreateUser_whenProvidedWithValidDetails_returnsUserId() {
        //Arrange - WHEN
        Map <String, String> user = new HashMap<>();
        user.put("firstName", "John");
        user.put("lastName", "Doe");

        //GIVEN
        userId = userService.createUser(user);
        System.out.println(userId);

        //THEN
        Assertions.assertNotNull(userId);
    }


    @Test
    @Order(2)
    @DisplayName("Update user works")
    void testUpdateUser_whenProvidedWithValidDetails_returnsUpdatedUserDetails() {
        //arrange
        Map <String, String> user = new HashMap<>();
        user.put("firstName", "Jane");
        user.put("lastName", "Doe");

        //Act
        Map  updatedUser = userService.updateUser(userId, user);

        //Assert
        assertEquals(user.get("firstName"), updatedUser.get("firstName"), "Returned firstName was not updated");
        assertEquals(user.get("lastName"), updatedUser.get("lastName"), "Returned lastName was not updated");

    }

    @Test
    @Order(3)
    @DisplayName("Find user works")
    void testGetUserDetails_whenProvidedWithValidUserId_returnsUserDetails() {
        //act
        Map userDetails = userService.getUserDetails(userId);

        //Assert
        assertNotNull(userDetails);
        assertEquals(userId, userDetails.get("userId"), "Returned userId not a match");
    }

    @Test
    @Order(4)
    @DisplayName("Delete user works")
    void testDeleteUser_whenProvidedWithValidUserId_returnsUserDetails() {
        //Act
        userService.deleteUser(userId);

        //assert
        Map userDetails = userService.getUserDetails(userId);
        assertNull(userDetails, "Returned user details was not deleted");
    }


}
