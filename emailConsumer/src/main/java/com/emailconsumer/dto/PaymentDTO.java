package com.emailconsumer.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentDTO {

    private String name;
    private Double value;
    private Long number;
}
