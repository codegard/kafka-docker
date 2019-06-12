package com.rataj.kafka.config;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.TopicPartition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.ContainerAwareErrorHandler;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.kafka.support.serializer.DeserializationException;

import java.util.List;
import java.util.Objects;

final class KafkaErrorHandler implements ContainerAwareErrorHandler {

    private static final Logger LOG = LoggerFactory.getLogger(KafkaErrorHandler.class);
    private static final String KEY_DESERIALIZATION_ERROR_KEY = "springDeserializerExceptionKey";
    private static final String VALUE_DESERIALIZATION_ERROR_KEY = "springDeserializerExceptionValue";

    @Override
    public void handle(Exception thrownException, List<ConsumerRecord<?, ?>> records, Consumer<?, ?> consumer, MessageListenerContainer container) {

        if (thrownException.getClass().equals(DeserializationException.class)) {
            records.stream()
                    .filter(consumerRecord -> !Objects.nonNull(consumerRecord.headers().lastHeader(KEY_DESERIALIZATION_ERROR_KEY))
                            || !Objects.nonNull(consumerRecord.headers().lastHeader(VALUE_DESERIALIZATION_ERROR_KEY)))
                    .forEach(consumerRecord -> {
                        String topic = consumerRecord.topic();
                        long offset = consumerRecord.offset();
                        int partition = consumerRecord.partition();
                        TopicPartition topicPartition = new TopicPartition(topic, partition);
                        consumer.seek(topicPartition, offset + 1L);
                        LOG.info("Skipping message with topic {} and offset {} - cause: {}", topic, offset, thrownException.getMessage());
                    });
        } else {
            LOG.info("Consumer exception - cause: {}", thrownException.getMessage());
        }
    }
}
