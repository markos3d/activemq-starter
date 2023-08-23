package com.activemq.starter.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.activemq.starter.domain.StarterMessage;

@Component
public class Consumer {
    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @JmsListener(destination = "activemq-starter-queue")
    public void messageListener(StarterMessage starterMessage) {
        logger.info("Message received! {}", starterMessage);
    }
}
