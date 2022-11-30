package com.emailconsumer.controller;

import com.emailconsumer.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class EmailController {

    private final EmailService emailSevice;

    @KafkaListener(
            topics = "payment",
            containerFactory = "kafkaListenerContainerFactory")
    public void emailListener(ConsumerRecord<String, payment.PaymentAvro> record) {
        log.info("Payload received: " + record.value());
        var paymentAvro = record.value();
        emailSevice.save(paymentAvro);
    }
}
