package com.mishobo.test_driven_development.user;

import com.mishobo.test_driven_development.data.UserRepository;
import com.mishobo.test_driven_development.section7.model.User;

import com.mishobo.test_driven_development.section7.service.implementation.UserServiceException;
import com.mishobo.test_driven_development.section7.service.implementation.UserServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestUserService {

    @InjectMocks
    UserServiceImpl userService;

    @Mock
    UserRepository usersRepository;

    @DisplayName("user creation method")
    @Test
    void testCreateUser_whenUserDetailsProvided_returnsUserObject() {
        //arrange

        when(usersRepository.save(Mockito.any(User.class))).thenReturn(true);

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
        Mockito.verify(usersRepository, Mockito.times(1)).save(Mockito.any(User.class));
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


    @DisplayName("if save() fails, throw UserServiceException")
    @Test
    void testCreateUser_whenSaveMethodThrowsException_thenThrowsUserServiceException() {
        //arrange
        User createUser  = new User(
                "Hussein",
                "Mishobo",
                "hussein@gmail.com",
                "Mishobo1234",
                "Mishobo1234"
        );
        when(usersRepository.save(any(User.class))).thenThrow(RuntimeException.class);

        // act && assert
        assertThrows(UserServiceException.class, () -> userService.createUser(createUser), "save method should throw UserServiceException");

    }




}
