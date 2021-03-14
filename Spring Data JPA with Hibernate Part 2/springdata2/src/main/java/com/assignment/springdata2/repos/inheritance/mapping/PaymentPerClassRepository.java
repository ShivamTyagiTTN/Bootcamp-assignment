package com.assignment.springdata2.repos.inheritance.mapping;

import com.assignment.springdata2.entities.inhertance.mapping.tableperclass.PaymentPerClass;
import org.springframework.data.repository.CrudRepository;

public interface PaymentPerClassRepository extends CrudRepository<PaymentPerClass, Integer> {
}
