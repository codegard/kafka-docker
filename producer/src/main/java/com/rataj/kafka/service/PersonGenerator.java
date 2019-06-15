package com.rataj.kafka.service;

import com.rataj.kafka.model.Person;
import com.rataj.kafka.model.Profession;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

class PersonGenerator {

    private PersonGenerator() {
        throw new UnsupportedOperationException();
    }

    static Person generate() {
        return new Person(
                randomName(),
                randomSurname(),
                ThreadLocalRandom.current().nextInt(18, 50),
                Profession.values()[ThreadLocalRandom.current().nextInt(0, Profession.values().length)]
        );
    }

    private static String randomName() {
        List<String> names = List.of(
                "Mateusz",
                "Katarzyna",
                "Krzysztof",
                "Adam",
                "Mariusz",
                "Zenon",
                "Filip",
                "Kinsey"
        );
        int rand = ThreadLocalRandom.current().nextInt(names.size());
        return names.get(rand);
    }

    private static String randomSurname() {
        List<String> names = List.of(
                "Kowalski",
                "Małysz",
                "Pudzianowski",
                "Hannawald",
                "Lewangolski",
                "Wolanski",
                "Kuc",
                "Nowak"
        );
        int rand = ThreadLocalRandom.current().nextInt(names.size());
        return names.get(rand);
    }
}
