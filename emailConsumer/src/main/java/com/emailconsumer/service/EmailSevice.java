package com.emailconsumer.service;

import com.emailconsumer.dto.PaymentDTO;
import com.emailconsumer.repository.EmailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmailSevice {

    private final EmailRepository emailRepository;

    @KafkaListener(
            topics = "payment",
            containerFactory = "kafkaListenerContainerFactory")
    public void greetingListener(PaymentDTO paymentDTO) {
        save(paymentDTO);
    }

    public void save(PaymentDTO paymentDTO) {
        emailRepository.save(paymentDTO);
    }
}
