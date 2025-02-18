package com.pms.pagos.test;

import static org.mockito.Mockito.*;

import com.pms.pagos.service.KafkaProducerService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.kafka.core.KafkaTemplate;

class KafkaIntegrationTest {

    @Mock
    private KafkaTemplate<String, String> kafkaTemplate;

    @InjectMocks
    private KafkaProducerService kafkaProducerService;

    public KafkaIntegrationTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSendMessage() {
        String message = "Test Message";
        kafkaProducerService.sendMessage(message);
        verify(kafkaTemplate, times(1)).send("update-state-topic", message);
    }
}
