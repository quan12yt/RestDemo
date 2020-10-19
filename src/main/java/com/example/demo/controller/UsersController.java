package com.example.demo.controller;

import com.example.demo.model.Users;
import com.example.demo.services.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;


@RestController()
@RequestMapping("/api/users")
public class UsersController implements Serializable {
    @Autowired
    private final UserServiceImp userServiceImp;

    public UsersController(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }
    //return list of users
    @GetMapping("")
    public List<Users> getAll() {
//        return userRepository.findByIdAndAddress((long) 2,"Ho Chi Minh");
        return userServiceImp.getALLUsers();
    }
    //create new user
    @PostMapping("")
    public Users postUser(@RequestBody Users u) {
        return userServiceImp.insertUser(u);
    }
    //get an  users by id
    @GetMapping("/{id}")
    public Optional<Users> getOne(@PathVariable Long id) {
        return userServiceImp.findUserById(id);
    }
    //update an existed users or create new user
    @PutMapping("/{id}")
    public Users putUser(@RequestBody Users u, @PathVariable Long id) {
        return userServiceImp.updateUser(u,id);
    }
    //delete an user
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userServiceImp.deleteUser(id);
    }
}



