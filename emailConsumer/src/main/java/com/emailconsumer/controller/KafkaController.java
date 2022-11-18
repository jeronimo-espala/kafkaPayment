package com.emailconsumer.controller;

import com.emailconsumer.dto.PaymentDTO;
import com.emailconsumer.service.EmailSevice;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaController {

    private final EmailSevice emailSevice;

    @KafkaListener(
            topics = "payment",
            containerFactory = "kafkaListenerContainerFactory")
    public void greetingListener(PaymentDTO payload) {
        log.info("Payload received: " + payload);
        emailSevice.save(payload);
    }
}
