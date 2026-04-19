package com.example.lost_found.Service;

import com.example.lost_found.DTO.LoginRequest;
import com.example.lost_found.Entity.User;
import com.example.lost_found.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User Login(LoginRequest request){
        User user = userRepository.findByEmail(request.getEmail());
        if(user == null){
            throw new RuntimeException("Invalid email or password");
        }
        if(!passwordEncoder.matches(request.getPassword(),user.getPassword())){
            throw new RuntimeException("Invalid password");
        }
        return user;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User findByEmail(String email){
        return  userRepository.findByEmail(email);
    }
}
