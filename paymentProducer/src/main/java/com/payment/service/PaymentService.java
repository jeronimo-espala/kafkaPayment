package com.payment.service;

import com.payment.service.dto.PaymentDTO;

public interface PaymentService {
    PaymentDTO sendTopic(PaymentDTO paymentDTO);
}
