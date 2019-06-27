package com.trichcrou.oauthtwooidc.web.rest;

import com.trichcrou.oauthtwooidc.Oauth2OidcApp;
import com.trichcrou.oauthtwooidc.service.Oauth2OidcKafkaProducer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@EmbeddedKafka
@SpringBootTest(classes = Oauth2OidcApp.class)
public class Oauth2OidcKafkaResourceIT {

    @Autowired
    private Oauth2OidcKafkaProducer kafkaProducer;

    private MockMvc restMockMvc;

    @BeforeEach
    public void setup() {
        Oauth2OidcKafkaResource kafkaResource = new Oauth2OidcKafkaResource(kafkaProducer);

        this.restMockMvc = MockMvcBuilders.standaloneSetup(kafkaResource)
            .build();
    }

    @Test
    public void sendMessageToKafkaTopic() throws Exception {
        restMockMvc.perform(post("/api/oauth-2-oidc-kafka/publish?message=yolo"))
            .andExpect(status().isOk());
    }
}
