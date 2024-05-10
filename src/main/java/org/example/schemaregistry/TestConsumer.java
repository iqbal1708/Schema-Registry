package org.example.schemaregistry;

import com.google.gson.Gson;
import com.schema.avro.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TestConsumer {

    @Autowired
    Gson gson;

    @KafkaListener(topics = "test_topic_0", groupId = "my-consumer-group")
    public void consume(User user) {
        System.out.println("Consumed user: " + gson.toJson(user));
    }

}
