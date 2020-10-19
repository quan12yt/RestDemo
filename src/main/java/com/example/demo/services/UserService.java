package com.example.demo.services;

import com.example.demo.model.Users;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<Users> getALLUsers();
    void deleteUser(Long userId);
    Users updateUser(Users user, Long userId);
    Optional<Users> findUserById(Long userId);
    Users insertUser(Users users);
}
