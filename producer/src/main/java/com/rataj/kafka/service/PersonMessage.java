package com.rataj.kafka.service;

import com.rataj.kafka.model.Person;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class PersonMessage implements Message<Person> {

    private final MessageHeaders headers;
    private final Person payload;

    PersonMessage(PersonMessageBuilder builder) {
        this.headers = new MessageHeaders(builder.headers);
        this.payload = builder.payload;
    }

    @Override
    public Person getPayload() {
        return payload;
    }

    @Override
    public MessageHeaders getHeaders() {
        return headers;
    }

    static class PersonMessageBuilder {

        private Map<String, Object> headers;
        private Person payload;

        PersonMessageBuilder() {
            this.headers = new HashMap<>();
        }

        PersonMessageBuilder withPayload(Person payload) {
            if (payload == null) {
                throw new IllegalArgumentException();
            }
            this.payload = payload;
            return this;
        }

        PersonMessageBuilder withTopic(String topic) {
            if (StringUtils.isEmpty(topic)) {
                throw new IllegalArgumentException();
            }
            this.headers.put(KafkaHeaders.TOPIC, topic);
            return this;
        }

        PersonMessageBuilder withKey(String key) {
            if (StringUtils.isEmpty(key)) {
                throw new IllegalArgumentException();
            }
            this.headers.put(KafkaHeaders.MESSAGE_KEY, key);
            return this;
        }

        Message<Person> build() {
            return new PersonMessage(this);
        }

    }
}
