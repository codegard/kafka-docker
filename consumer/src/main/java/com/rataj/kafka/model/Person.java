package com.rataj.kafka.model;

import java.util.UUID;

public class Person {

    private final UUID id;
    private final String name;
    private final String surname;
    private final int age;

    public Person(String name, String surname, int age) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
}
