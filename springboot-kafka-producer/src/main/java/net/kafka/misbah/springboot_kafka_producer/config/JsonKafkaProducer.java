package net.kafka.misbah.springboot_kafka_producer.config;

import net.kafka.misbah.springboot_kafka_producer.pojo.User;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {

    private KafkaTemplate<String, User> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User message) {
        System.out.println("Message " + message);
        Message<User> data = MessageBuilder
                .withPayload(message)
                .setHeader(KafkaHeaders.TOPIC, "kafka_json")
                .build();
        kafkaTemplate.send(data);
    }
}
