package com.rataj.kafka.model;

import java.util.UUID;

public class Person {

    private final UUID id;
    private final String name;
    private final String surname;
    private final int age;
    private final String profession;

    public Person(UUID uuid, String name, String surname, int age, String profession) {
        this.id = uuid;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.profession = profession;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", profession='" + profession + '\'' +
                '}';
    }
}
