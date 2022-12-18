package com.emailconsumer.service.mapper;

import com.emailconsumer.domain.Payment;
import com.emailconsumer.service.dto.PaymentDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmailMapper {

    Payment toEntity(PaymentDTO paymentDTO);

    PaymentDTO toDto(Payment payment);
}
