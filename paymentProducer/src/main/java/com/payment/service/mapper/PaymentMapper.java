package com.payment.service.mapper;

import com.payment.domain.Payment;
import com.payment.service.dto.PaymentDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    Payment toEntity(PaymentDTO paymentDTO);

    PaymentDTO toDto(Payment payment);
}
