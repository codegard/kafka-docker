package com.rataj.kafka.service;

import com.rataj.kafka.model.Person;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class PersonPublisher {

    private final KafkaTemplate<String, Message<?>> kafkaTemplate;

    public PersonPublisher(KafkaTemplate<String, Message<?>> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Scheduled(fixedRate = 500)
    void publish() {
        Message<Person> personMessage = PersonMessageGenerator.generate();
        kafkaTemplate.send(personMessage);
    }


}
