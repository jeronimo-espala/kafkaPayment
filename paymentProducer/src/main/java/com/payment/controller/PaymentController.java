package com.payment.controller;

import com.payment.service.dto.PaymentDTO;
import com.payment.service.impl.PaymentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequiredArgsConstructor
public class PaymentController {

    private static final String API_PAYMENT = "/payment";
    private final PaymentServiceImpl paymentService;

    @PostMapping
    public ResponseEntity<PaymentDTO> payment(@RequestBody PaymentDTO paymentDTO) throws URISyntaxException {
        PaymentDTO payment = paymentService.sendTopic(paymentDTO);
        return ResponseEntity.created(new URI(API_PAYMENT + payment.getName()))
                .body(payment);
    }
}
