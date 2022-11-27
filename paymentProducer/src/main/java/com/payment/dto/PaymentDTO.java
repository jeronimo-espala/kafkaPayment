package com.payment.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class PaymentDTO {

    @Id
    private String id;
    private String name;
    private Double value;
    private String email;
}
