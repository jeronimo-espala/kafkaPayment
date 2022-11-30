package com.payment.service.impl;

import com.payment.domain.Payment;
import com.payment.service.dto.PaymentDTO;
import com.payment.repository.PaymentRepository;
import com.payment.service.PaymentService;
import com.payment.service.mapper.PaymentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    private static final String TOPIC = "payment";
    private final KafkaTemplate<String, payment.PaymentAvro> kafkaTemplate;
    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;

    public PaymentDTO sendTopic(PaymentDTO paymentDTO) {
        var paymentCore = paymentMapper.toEntity(paymentDTO);
        Payment pay = paymentRepository.insert(paymentCore);
        log.info("Saved on database: " + pay);
        payment.PaymentAvro paymentAvro = payment.PaymentAvro.newBuilder().setName(paymentCore.getName()).setEmail(paymentCore.getEmail())
                .setId(paymentCore.getId()).setValue(paymentCore.getValue()).build();
        kafkaTemplate.send(TOPIC, paymentAvro);
        return paymentDTO;
    }
}
