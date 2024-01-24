package com.pee.dockerized.postgresql.controller;

import com.pee.dockerized.postgresql.entity.User;
import com.pee.dockerized.postgresql.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User Enpoint", description = "Easy Endpoint for docker project")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    @Operation(method = "GET", summary = "Get endpoint for get all users")
    @ApiResponse(responseCode = "200", description = "List all users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    @Operation(method = "GET", summary = "Get endpoint for get an id users")
    @ApiResponse(responseCode = "200", description = "Get a user")
    @GetMapping(path = "/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        Optional<User> userRec = userRepository.findById(id);
        if (userRec.isPresent()){
            return new ResponseEntity<>(userRec.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @Operation(method = "POST", summary = "Post endpoint for create a user")
    @ApiResponse(responseCode = "201", description = "Add a user")
    @PostMapping
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }
}
