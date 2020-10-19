package com.example.demo.controller;

import com.example.demo.model.Users;
import com.example.demo.repository.UserRepository;
import com.example.demo.exception.UserNotFoundException;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController("/api/users")
public class UsersController implements Serializable {
    private final AtomicLong counter = new AtomicLong();
    private final UserRepository userRepository;

    public UsersController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //return list of users
    @GetMapping("/api/users")
    public List<Users> getAll() {
//        return userRepository.findByIdAndAddress((long) 2,"Ho Chi Minh");
        return userRepository.findAll();
    }


    //create new user
    @PostMapping("/api/users")
    public Users postUser(@RequestBody Users u) {
        return userRepository.save(u);
    }

    //get an  users by id
    @GetMapping("/api/users/{id}")
    public EntityModel<Users> getOne(@PathVariable Long id) {
        Users u= userRepository.findById(id).orElseThrow(() ->
                {
                    return  new UserNotFoundException(id);
                }
                );
        return  EntityModel.of(u,
                linkTo(methodOn(UsersController.class).getOne(id)).withSelfRel(),
                linkTo(methodOn(UsersController.class).getAll()).withRel("users"));
    }

    //update an existed users or create new user
    @PutMapping("api/users/{id}")
    public Users putUser(@RequestBody Users u, @PathVariable Long id) {
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

    //delete an user
    @DeleteMapping("api/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}



