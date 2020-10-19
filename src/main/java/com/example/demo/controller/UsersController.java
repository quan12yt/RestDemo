package com.example.demo.controller;

import com.example.demo.model.Users;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.UserNotFoundAdvice;
import com.example.demo.security.UserNotFoundException;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController("/api/users")
public class UsersController {
    private final AtomicLong counter = new AtomicLong();
    private final UserRepository userRepository;

    public UsersController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //return list of users
    @GetMapping("/api/users")
    public List<Users> getAll() {
        return userRepository.findAll();
    }

    //create new user
    @PostMapping("/api/users")
    @ResponseBody
    public Users postUser(@RequestBody Users u) {
        return userRepository.save(u);
    }

    //get an  users by id
    @GetMapping("/api/users/{id}")
    public EntityModel<Users> getOne(@PathVariable int id) {
        Users u= userRepository.findById(id).orElseThrow(() ->
                {
                    return  new UserNotFoundException(id);
                }
                );
        return  EntityModel.of(u,
                linkTo(methodOn(UsersController.class).getOne(id)).withSelfRel(),
                linkTo(methodOn(UsersController.class).getAll()).withRel("users"));
    }

    //delete an user by id
    @PutMapping("api/users/{id}")
    @ResponseBody
    public Users putUser(@RequestBody Users u, @PathVariable int id) {
        return userRepository.findById(id).map(
                users -> {
                    users.setAddress(u.getAddress());
                    users.setBirthday(u.getBirthday());
                    users.setName(u.getName());
                    return userRepository.save(users);
                }
        ).orElseGet(() -> {
            return userRepository.save(u);
        });
    }

    @DeleteMapping("api/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
    }
}



