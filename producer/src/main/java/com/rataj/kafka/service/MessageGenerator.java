package com.rataj.kafka.service;

import com.rataj.kafka.model.Orc;
import com.rataj.kafka.model.Person;
import com.rataj.kafka.model.Profession;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

final class MessageGenerator {

    private MessageGenerator() {
        throw new UnsupportedOperationException();
    }

    static Message<Person> generatePerson() {
        Person payload = new Person(
                randomName(),
                randomSurname(),
                ThreadLocalRandom.current().nextInt(18, 50),
                Profession.values()[ThreadLocalRandom.current().nextInt(0, Profession.values().length)]
        );
        return PersonMessage.Builder
                .withPayload(payload)
                .withKey(payload.profession().name())
                .withTopic("person.create")
                .build();
    }


    static Message<Orc> generateOrc() {
        Orc payload = new Orc(randomName());
        return new GenericMessage<>(payload, Map.of(KafkaHeaders.TOPIC, "person.create"));
    }

    private static String randomName() {
        List<String> names = List.of(
                "Mats",
                "Robert",
                "Chris",
                "Adam",
                "Kate",
                "James",
                "Filip",
                "Kinsey"
        );
        int rand = ThreadLocalRandom.current().nextInt(names.size());
        return names.get(rand);
    }

    private static String randomSurname() {
        List<String> names = List.of(
                "Kowalski",
                "Reeves",
                "Smith",
                "Hannawald",
                "Lewandowski",
                "Wolanski",
                "Kuc",
                "Jones"
        );
        int rand = ThreadLocalRandom.current().nextInt(names.size());
        return names.get(rand);
    }
}
