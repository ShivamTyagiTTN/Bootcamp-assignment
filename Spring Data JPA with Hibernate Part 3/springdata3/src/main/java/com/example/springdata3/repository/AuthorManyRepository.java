package com.example.springdata3.repository;

import com.example.springdata3.entity.manytomany.AuthorMany;
import org.springframework.data.repository.CrudRepository;

public interface AuthorManyRepository extends CrudRepository<AuthorMany, Integer> {
}
