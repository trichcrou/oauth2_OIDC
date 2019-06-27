package com.trichcrou.oauthtwooidc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Oauth2OidcKafkaConsumer {

    private final Logger log = LoggerFactory.getLogger(Oauth2OidcKafkaConsumer.class);
    private static final String TOPIC = "topic_oauth2oidc";

    @KafkaListener(topics = "topic_oauth2oidc", groupId = "group_id")
    public void consume(String message) throws IOException {
        log.info("Consumed message in {} : {}", TOPIC, message);
    }
}
