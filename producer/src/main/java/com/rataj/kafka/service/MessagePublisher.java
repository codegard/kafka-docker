package com.rataj.kafka.service;

import com.rataj.kafka.model.Orc;
import com.rataj.kafka.model.Person;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class MessagePublisher {

    private final KafkaTemplate<String, Message<?>> kafkaTemplate;

    public MessagePublisher(KafkaTemplate<String, Message<?>> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Scheduled(fixedRate = 2000)
    void publishPerson() {
        Message<Person> personMessage = MessageGenerator.generatePerson();
        kafkaTemplate.send(personMessage);
    }

    @Scheduled(fixedRate = 5000)
    void publishOrc() {
        Message<Orc> orcMessage = MessageGenerator.generateOrc();
        kafkaTemplate.send(orcMessage);
    }


}
