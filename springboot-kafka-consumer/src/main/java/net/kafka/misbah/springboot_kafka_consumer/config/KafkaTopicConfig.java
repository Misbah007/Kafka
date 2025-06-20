package net.kafka.misbah.springboot_kafka_consumer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic topic1() {
        return TopicBuilder
                .name("misbah")
                .build();
    }

    @Bean
    public NewTopic topic2() {
        return TopicBuilder
                .name("kafka_json")
                .build();
    }
}
