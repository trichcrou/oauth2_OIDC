package com.trichcrou.oauthtwooidc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Oauth2OidcKafkaProducer {

    private static final Logger log = LoggerFactory.getLogger(Oauth2OidcKafkaProducer.class);
    private static final String TOPIC = "topic_oauth2oidc";

    private KafkaTemplate<String, String> kafkaTemplate;

    public Oauth2OidcKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        log.info("Producing message to {} : {}", TOPIC, message);
        this.kafkaTemplate.send(TOPIC, message);
    }
}
