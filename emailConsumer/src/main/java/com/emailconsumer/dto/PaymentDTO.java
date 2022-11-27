package com.emailconsumer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@Document
public class PaymentDTO implements Serializable {

    @Id
    private String id;
    private String name;
    private Double value;
    private String email;
}
