package com.emailconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class EmailConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmailConsumerApplication.class, args);
    }

    @KafkaListener(id = "emailGroup", topics = "payment")
    public void listen(String in) {
        System.out.println(in);
    }

}
