package com.rataj.kafka;

import com.rataj.kafka.config.KafkaProperties;
import com.rataj.kafka.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.ConsumerFactory;

@EnableConfigurationProperties({KafkaProperties.class})
@SpringBootApplication
public class KafkaConsumerApplication {

    @Autowired
    ConsumerFactory<String, Person> consumerFactory;

    public static void main(String[] args) {
        SpringApplication.run(KafkaConsumerApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return (args) -> consumerFactory.createConsumer();
    }

}
