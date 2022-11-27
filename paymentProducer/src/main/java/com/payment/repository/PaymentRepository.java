package com.payment.repository;

import com.payment.dto.PaymentDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<PaymentDTO, String> {
}
