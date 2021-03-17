package com.springbootcamp.springsecurity.repository;

import com.springbootcamp.springsecurity.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {

    User findByUsername(String username);
}
