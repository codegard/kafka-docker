package com.rataj.kafka.service;

import com.rataj.kafka.model.Person;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

@EnableKafka
@Service
public class KafkaListenerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaListenerService.class);

    @KafkaListener(topics = "${kafka.topics.create}")
    public void personListener(ConsumerRecord<UUID, Person> consumerRecord) {
        LOGGER.info(consumerRecord.toString());
    }
}
