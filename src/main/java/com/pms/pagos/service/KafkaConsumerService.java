package com.pms.pagos.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

    @KafkaListener(topics = "update-state-topic", groupId = "consumer-group-1")
    public void consume(String message) {
        logger.info("Consumed message: {}", message);
    }
}