package com.anish.kafkaproducerpoc.service.impl;

import com.anish.kafkaproducerpoc.config.KafkaProducerProperties;
import com.anish.kafkaproducerpoc.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class MessageServiceImpl implements MessageService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final KafkaProducerProperties kafkaProducerProperties;

    @Override
    public void sendMessage(Object message) {
        try {
            kafkaTemplate.send(kafkaProducerProperties.topics().foods(),
                    String.valueOf(message));
        } catch (Exception e) {
            log.error("Error sending message to Kafka topic");
        }
    }
}
