package com.example.springdata3.repository;

import com.example.springdata3.entity.onetoone.BookOne;
import org.springframework.data.repository.CrudRepository;

public interface BookOneRepository extends CrudRepository<BookOne, Integer> {
}
