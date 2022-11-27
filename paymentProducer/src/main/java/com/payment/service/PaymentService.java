package com.payment.service;

import com.payment.dto.PaymentDTO;
import com.payment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private static final String TOPIC = "payment";
    private final KafkaTemplate<String, payment.PaymentAvro> kafkaTemplate;
    private final PaymentRepository paymentRepository;

    public PaymentDTO sendTopic(PaymentDTO paymentDTO) {
        paymentRepository.save(paymentDTO);
        payment.PaymentAvro paymentAvro = payment.PaymentAvro.newBuilder().setName(paymentDTO.getName()).setEmail(paymentDTO.getEmail())
                .setId(paymentDTO.getId()).setValue(paymentDTO.getValue()).build();
        kafkaTemplate.send(TOPIC, paymentAvro);
        return paymentDTO;
    }
}
