package com.anish.kafkaconsumerpoc.service.impl;

import com.anish.kafkaconsumerpoc.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    @Override
    @KafkaListener(
            topics = "${app.kafka.topics.foods}"
    )
    public void processMessage(Object message) {
        try {
            System.out.println(message);
        } catch (Exception e) {
            log.error("Error processing message: {}", e.getMessage());
        }
    }
}
