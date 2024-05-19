package com.example.consumer;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {


    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String topic;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate, @Value("${application.kafka.topic}") String topic) {

        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }


    public void sendEvent(String event) {

        kafkaTemplate.send(topic, event);
        //kafkaTemplate.setTransactionIdPrefix("slow");

    }


    public void deleteEvent(String event) {

        kafkaTemplate.send("topicDelete", event);


    }

    public void updateEvent(String event) {

        kafkaTemplate.send("topicUpdate", event);

    }


}
