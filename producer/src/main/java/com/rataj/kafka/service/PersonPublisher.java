package com.rataj.kafka.service;

import com.rataj.kafka.model.Person;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class PersonPublisher {

    private final KafkaTemplate<String, Person> kafkaTemplate;

    public PersonPublisher(KafkaTemplate<String, Person> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Scheduled(fixedRate = 10)
    void publish() {
        Person person = PersonGenerator.generate();
        kafkaTemplate.send(topic, person.profession().name(), person);
    }


}
