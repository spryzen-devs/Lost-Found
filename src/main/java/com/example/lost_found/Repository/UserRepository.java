package com.example.lost_found.Repository;

import com.example.lost_found.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
