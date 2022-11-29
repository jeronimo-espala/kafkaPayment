package com.payment.service.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
public class PaymentDTO {

    private String id;
    private String name;
    private Double value;
    private String email;
}
