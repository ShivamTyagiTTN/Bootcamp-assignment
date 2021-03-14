package com.assignment.springdata2.repos.inheritance.mapping;

import com.assignment.springdata2.entities.inhertance.mapping.joined.PaymentJoined;
import org.springframework.data.repository.CrudRepository;

public interface PaymentJoinedRepository extends CrudRepository<PaymentJoined, Integer> {
}
