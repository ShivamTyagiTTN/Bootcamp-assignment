package com.springbootcamp.springsecurity.dao;

import com.springbootcamp.springsecurity.domain.AppUser;
import com.springbootcamp.springsecurity.domain.GrantAuthorityImpl;
import com.springbootcamp.springsecurity.domain.User;
import com.springbootcamp.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Arrays;

@Repository
public class UserDao {

    @Autowired
    UserRepository userRepository;

    public AppUser loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        System.out.println(user);
        if (username != null) {
            return new AppUser(user.getUsername(), user.getPassword(), Arrays.asList(new GrantAuthorityImpl(user.getRole())));
        } else {
            throw new RuntimeException();
        }

    }
}
