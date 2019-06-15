package com.rataj.kafka.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfiguration {

    @Bean
    KafkaTemplate<String, ?> kafkaTemplate() {
        return new KafkaTemplate<>(kafkaProducerConfiguration());
    }

    ProducerFactory<String, ?> kafkaProducerConfiguration() {
        Map<String, Object> properties = new HashMap<>();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "");
        return new DefaultKafkaProducerFactory<>(properties, new StringSerializer(), new JsonSerializer<>());
    }

}
