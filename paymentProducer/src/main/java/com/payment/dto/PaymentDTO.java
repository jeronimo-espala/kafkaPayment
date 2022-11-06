package com.payment.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentDTO {

    private String id;
    private String name;
    private Double value;
    private Long number;
    private String email;
}
