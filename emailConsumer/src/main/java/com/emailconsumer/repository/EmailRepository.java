package com.emailconsumer.repository;

import com.emailconsumer.dto.PaymentDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<PaymentDTO, String> {
}
