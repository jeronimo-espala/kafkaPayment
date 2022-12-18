package com.emailconsumer.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Payment implements Serializable {

    @Id
    private String id;
    private String name;
    private Double value;
    private String email;
    private String status;
}
