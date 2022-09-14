package com.junit_mockito.mockito.services;

import com.junit_mockito.mockito.dao.UserRepository;
import com.junit_mockito.mockito.exception.ResourceNotFoundException;
import com.junit_mockito.mockito.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user){
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @Override
    public User findUserById(Long id){
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
            return userOptional.get();
        }
        else{
            throw new ResourceNotFoundException("Exception", "Id", id);
        }
    }

    @Override
    public User updateUser( User user ,Long id){
        User existingUser = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Exception", "Id", id));

        existingUser.setName(user.getName());
        existingUser.setRole(user.getRole());
        userRepository.save(existingUser);
        return existingUser;
    }

    @Override
    public String deleteUserById( Long id){
        userRepository.deleteById(id);
        return " Deleted Successfully";
    }

}
