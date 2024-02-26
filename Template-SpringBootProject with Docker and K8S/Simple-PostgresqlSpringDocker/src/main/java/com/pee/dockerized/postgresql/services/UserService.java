package com.pee.dockerized.postgresql.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pee.dockerized.postgresql.entity.User;
import com.pee.dockerized.postgresql.repository.UserRepository;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        Optional<User> getUser = userRepository.findById(id);
        if (getUser.isPresent()) {
            return getUser.get();
        }
        return null;
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }
}
