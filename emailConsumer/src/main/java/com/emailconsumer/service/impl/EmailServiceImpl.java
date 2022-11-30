package com.emailconsumer.service.impl;

import com.emailconsumer.service.dto.PaymentDTO;
import com.emailconsumer.repository.EmailRepository;
import com.emailconsumer.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailServiceImpl implements EmailService {

    private final EmailRepository emailRepository;

    public void save(payment.PaymentAvro payload) {
        PaymentDTO paymentDTO = new PaymentDTO(payload.getId().toString(), payload.getName().toString(), payload.getValue(), payload.getEmail().toString());
        var retorno = emailRepository.save(paymentDTO);
        log.info("Saved on database: " + retorno);
    }
}
