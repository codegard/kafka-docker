package com.rataj.kafka.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.UUID;

@JsonDeserialize(builder = Person.Builder.class)
public final class Person {

    private final UUID id;
    private final String name;
    private final String surname;
    private final Integer age;
    private final String profession;

    private Person(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.surname = builder.surname;
        this.age = builder.age;
        this.profession = builder.profession;
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

    @JsonPOJOBuilder
    static class Builder {

        private UUID id;
        private String name;
        private String surname;
        private Integer age;
        private String profession;

        Builder withId(UUID id) {
            this.id = id;
            return this;
        }

        Builder withName(String name) {
            this.name = name;
            return this;
        }

        Builder withSurname(String surname) {
            this.surname = surname;
            return this;
        }

        Builder withAge(Integer age) {
            this.age = age;
            return this;
        }

        Builder withProffesion(String proffesion) {
            this.profession = proffesion;
            return this;
        }

        Person build() {
            return new Person(this);
        }
    }
}
