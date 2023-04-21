package me.ghisiluizgustavo.strproducer.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Log4j2
@RequiredArgsConstructor
@Service
public class StringProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message){
        kafkaTemplate.send("str-topic", message).whenComplete((result, error) -> {
            if (error != null){
                log.error("Error while send message: {} ERROR: {}", message, error.getMessage());
            }
            log.info("Message was sent with success: {} On partition {}", message, result.getRecordMetadata().partition());
        });
    }


}
