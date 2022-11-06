package com.emailconsumer.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Getter
@Setter
@RedisHash("Payment")
public class PaymentDTO implements Serializable {
    private String id;
    private String name;
    private Double value;
    private Long number;
    private String email;

    @Override
    public String toString() {
        return "PaymentDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", number=" + number +
                ", email='" + email + '\'' +
                '}';
    }
}
