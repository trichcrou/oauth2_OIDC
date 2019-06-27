package com.trichcrou.oauthtwooidc.web.rest;

import com.trichcrou.oauthtwooidc.service.Oauth2OidcKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/oauth-2-oidc-kafka")
public class Oauth2OidcKafkaResource {

    private final Logger log = LoggerFactory.getLogger(Oauth2OidcKafkaResource.class);

    private Oauth2OidcKafkaProducer kafkaProducer;

    public Oauth2OidcKafkaResource(Oauth2OidcKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.sendMessage(message);
    }
}
