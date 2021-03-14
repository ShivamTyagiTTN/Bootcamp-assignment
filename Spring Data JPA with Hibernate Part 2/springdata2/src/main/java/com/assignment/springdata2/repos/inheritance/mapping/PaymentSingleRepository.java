package com.assignment.springdata2.repos.inheritance.mapping;

import com.assignment.springdata2.entities.inhertance.mapping.singletable.PaymentSingle;
import org.springframework.data.repository.CrudRepository;

public interface PaymentSingleRepository extends CrudRepository<PaymentSingle, Integer> {
}
