package net.kafka.misbah.springboot_kafka_producer.Controller;

import net.kafka.misbah.springboot_kafka_producer.config.JsonKafkaProducer;
import net.kafka.misbah.springboot_kafka_producer.config.KafkaProducer;
import net.kafka.misbah.springboot_kafka_producer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/kafka")

public class MessageController {

    private KafkaProducer kafkaProducer;
    private JsonKafkaProducer jsonKafkaProducer;

    @Autowired
    public MessageController(KafkaProducer kafkaProducer, JsonKafkaProducer jsonKafkaProducer) {
        this.kafkaProducer = kafkaProducer;
        this.jsonKafkaProducer = jsonKafkaProducer;
    }

    @GetMapping(value = "/publish")
    public ResponseEntity<String> sendMessage(@RequestParam String message) {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message send successfully");
    }

    @PostMapping(value = "/publish")
    public ResponseEntity<?> sendJsonMessage(@RequestBody User user) {
        jsonKafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Json message send successfully");
    }
}
