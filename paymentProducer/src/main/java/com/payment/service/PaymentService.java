package com.payment.service;

import com.payment.dto.PaymentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private static final String TOPIC = "payment";
    private final KafkaTemplate<String, PaymentDTO> kafkaTemplate;

    public PaymentDTO sendTopic(PaymentDTO paymentDTO) {
        kafkaTemplate.send(TOPIC, paymentDTO);
        return paymentDTO;
    }
}
