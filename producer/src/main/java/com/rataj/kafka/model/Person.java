package com.rataj.kafka.model;

import java.util.UUID;

public final class Person {

    private final UUID id;
    private final String name;
    private final String surname;
    private final int age;
    private final Profession profession;

    public Person(String name, String surname, int age, Profession profession) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.profession = profession;
    }

    public UUID id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String surname() {
        return surname;
    }

    public int age() {
        return age;
    }

    public Profession profession() {
        return profession;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", profession=" + profession +
                '}';
    }
}
