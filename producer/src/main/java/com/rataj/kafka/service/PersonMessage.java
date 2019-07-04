package com.rataj.kafka.service;

import com.rataj.kafka.model.Person;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

class PersonMessage implements Message<Person> {

    private final MessageHeaders headers;
    private final Person payload;

    private PersonMessage(Builder builder) {
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

    static class Builder {

        private Map<String, Object> headers;
        private Person payload;

        private Builder(Person payload) {
            this.payload = payload;
            this.headers = new HashMap<>();
        }

        static Builder withPayload(Person payload) {
            if (payload == null) {
                throw new IllegalArgumentException();
            }
            return new Builder(payload);
        }

        Builder withTopic(String topic) {
            if (StringUtils.isEmpty(topic)) {
                throw new IllegalArgumentException();
            }
            this.headers.put(KafkaHeaders.TOPIC, topic);
            return this;
        }

        Builder withKey(String key) {
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
