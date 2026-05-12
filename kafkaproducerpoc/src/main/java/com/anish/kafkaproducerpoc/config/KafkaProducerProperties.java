package com.anish.kafkaproducerpoc.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.kafka")
public record KafkaProducerProperties(
        Topics topics
) {
    public record Topics(
            String foods
    ) { }
}
