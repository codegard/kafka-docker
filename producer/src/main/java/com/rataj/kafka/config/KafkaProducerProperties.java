package com.rataj.kafka.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "kafka")
public class KafkaProducerProperties {

    private String bootstrapServers;
    private Topics topics;

    public void setBootstrapServers(String bootstrapServers) {
        this.bootstrapServers = bootstrapServers;
    }

    public String getBootstrapServers() {
        return bootstrapServers;
    }

    public Topics getTopics() {
        return topics;
    }

    public void setTopics(Topics topics) {
        this.topics = topics;
    }

    public static class Topics {

        private String create;

        public String getCreate() {
            return create;
        }

        public void setCreate(String create) {
            this.create = create;
        }
    }
}
