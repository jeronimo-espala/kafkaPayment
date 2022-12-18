package com.emailconsumer.service.impl;

import com.emailconsumer.domain.Payment;
import com.emailconsumer.repository.EmailRepository;
import com.emailconsumer.service.EmailService;
import com.emailconsumer.service.dto.PaymentDTO;
import com.emailconsumer.service.mapper.EmailMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailServiceImpl implements EmailService {

    private final EmailRepository emailRepository;
    private final EmailMapper emailMapper;

    public void save(payment.PaymentAvro payload) {
        PaymentDTO paymentDTO = new PaymentDTO(payload.getId().toString(), payload.getName().toString(),
                payload.getValue(), payload.getEmail().toString());
        var payment = emailMapper.toEntity(paymentDTO);
        var retorno = emailRepository.save(payment);
        log.info("Saved on database: " + retorno);
    }
}
