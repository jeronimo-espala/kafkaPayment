package com.emailconsumer.repository;

import com.emailconsumer.domain.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends MongoRepository<Payment, String> {
}
