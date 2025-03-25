package com.bootReact.Spring_Boot_and_React_CRUD_Operation.controller;

import com.bootReact.Spring_Boot_and_React_CRUD_Operation.exception.UserNotFoundException;
import com.bootReact.Spring_Boot_and_React_CRUD_Operation.model.User;
import com.bootReact.Spring_Boot_and_React_CRUD_Operation.reposetory.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
@CrossOrigin("http://localhost:3000")
public class UserController {
    @Autowired
    UserRepo userRepo;

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return new ResponseEntity<>( userRepo.save(user), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return new ResponseEntity<>( userRepo.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        return new ResponseEntity<>(userRepo.findById(id).orElseThrow(() -> new UserNotFoundException(id)),HttpStatus.OK);
    }

    /*@PostMapping("{id}")
    public ResponseEntity<User> userUpdate(@RequestBody User newUser, @PathVariable Long id) {
        User updatedUser = userRepo.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    user.setMobileNumber(newUser.getMobileNumber());
                    return userRepo.save(user); // Save the updated user
                })
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        return ResponseEntity.ok(updatedUser);
    }*/

    @PutMapping("{id}")
    public ResponseEntity<User> userUpdate(@RequestBody User newUser, @PathVariable Long id) {
        return userRepo.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    user.setMobileNumber(newUser.getMobileNumber());
                    return ResponseEntity.ok(userRepo.save(user)); // Save and return ResponseEntity
                })
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        User user = userRepo.findById(id).orElseThrow(()->new UserNotFoundException(id));
        String name = user.getName();
        userRepo.deleteById(id);
        return ResponseEntity.ok(name+ " Profile is Deleted");
    }


}






















