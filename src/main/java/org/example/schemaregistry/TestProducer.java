package org.example.schemaregistry;

import com.google.gson.Gson;
import com.schema.avro.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TestProducer {

    private static final String TOPIC = "test_topic_0";

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    @Autowired
    private Gson gson;

    public void produceUser(String name, int age) {
        User user = User.newBuilder()
                .setName(name)
                .setAge(age)
                .build();

        kafkaTemplate.send(TOPIC, name, user);
        System.out.println("Produced user: " + gson.toJson(user));
    }
}
