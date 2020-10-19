package com.example.demo.services;

import com.example.demo.repository.*;
import com.example.demo.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public List<Users> getALLUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public Users updateUser(Users user, Long userId) {
        return userRepository.findById(userId).map(users -> {
            users.setAddress(user.getAddress());
            users.setBirthday(user.getBirthday());
            users.setName(user.getName());
            return userRepository.save(users);
        }).orElseGet(() -> {
            return userRepository.save(user);
        });
    }

    @Override
    public Optional<Users> findUserById(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public Users insertUser(Users users) {
        return userRepository.save(users);
    }


}
