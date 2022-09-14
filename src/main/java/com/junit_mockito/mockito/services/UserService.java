package com.junit_mockito.mockito.services;

import com.junit_mockito.mockito.model.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    List<User> getAllUsers();
    User findUserById(Long id);
    User updateUser( User user ,Long id);
    String deleteUserById( Long id);
}
