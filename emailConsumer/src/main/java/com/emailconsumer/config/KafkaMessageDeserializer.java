package com.emailconsumer.config;

import com.emailconsumer.dto.PaymentDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import java.nio.charset.StandardCharsets;
import java.util.Map;

public class KafkaMessageDeserializer implements Deserializer<PaymentDTO> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {}

    @Override
    public PaymentDTO deserialize(String s, byte[] data) {

        if (data == null) {
            System.out.println("Null received at deserializing");
            return null;
        }
        try {
            return objectMapper.readValue(new String(data, StandardCharsets.UTF_8), PaymentDTO.class);
        } catch (Exception e) {
            throw new SerializationException("Error when deserializing byte[] to paymentDTO");
        }
    }

    @Override
    public void close() {}
}
