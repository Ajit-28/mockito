package com.junit_mockito.mockito;

import com.junit_mockito.mockito.dao.UserRepository;
import com.junit_mockito.mockito.model.User;
import com.junit_mockito.mockito.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MockitoApplicationTests {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void getUserTest(){
        when(userRepository.findAll()).thenReturn(Stream.of(new User(101,"ajit","User")).collect(Collectors.toList()));
        assertEquals(1, userService.getAllUsers().size());
    }

    @Test
    public void adduserTest(){
        User user = new User(201,"Mohan","manager");
        when(userRepository.save(user)).thenReturn(user);
        assertEquals(user, userService.addUser(user));
    }

    @Test
    public void getUserByIdTest(){
        List<User> userList  = new ArrayList<>();
        User user = new User(101,"Priti","Manager");
        userList.add(user);
        when(userRepository.findById(101L)).thenReturn(Optional.of(user));
        assertEquals(user,userService.findUserById(101L));
    }
}
