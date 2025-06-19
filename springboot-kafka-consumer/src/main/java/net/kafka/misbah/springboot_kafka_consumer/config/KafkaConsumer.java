package net.kafka.misbah.springboot_kafka_consumer.config;

import net.kafka.misbah.springboot_kafka_consumer.pojo.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "misbah",groupId = "myGroup")
    public void consume(String message){
        System.out.println("Recieved message ->"+message);
    }


    @KafkaListener(topics = "kafka_json",groupId = "myGroup")
    public void consume_json_message(User user){
        System.out.println("Recieved message ->"+user);
    }
}
