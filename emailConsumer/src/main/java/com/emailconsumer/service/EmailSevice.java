package com.emailconsumer.service;

import com.emailconsumer.dto.PaymentDTO;
import com.emailconsumer.repository.EmailRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailSevice {

    private final EmailRepository emailRepository;

    public void save(PaymentDTO paymentDTO) {
        var retorno = emailRepository.save(paymentDTO);
        log.info("Saved on database: " + retorno);
    }
}
