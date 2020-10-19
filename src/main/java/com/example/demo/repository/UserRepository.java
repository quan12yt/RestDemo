package com.example.demo.repository;

import com.example.demo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<Users,Long> {
    @Query(value = "select * from Users where user_id=?1 and address=?2",  nativeQuery = true)
    public List<Users> findByIdAndAddress(Long id, String address);
}
