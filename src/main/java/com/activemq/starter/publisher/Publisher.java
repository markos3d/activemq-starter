package com.activemq.starter.publisher;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.activemq.starter.domain.StarterMessage;

@RestController
public class Publisher {

    private final JmsTemplate jmsTemplate;

    public Publisher(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publishMessage(@RequestBody StarterMessage starterMessage) {
        try {
            jmsTemplate.convertAndSend("activemq-starter-queue", starterMessage);

            return new ResponseEntity<>("Message Sent.", HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
