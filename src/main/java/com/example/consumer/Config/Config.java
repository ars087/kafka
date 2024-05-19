package com.example.consumer.Config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaAdmin;

@EnableKafka
@Configuration
public class Config {





    @Bean
    public NewTopic topicCreate() {
        return new NewTopic("topicCreate", 1, (short) 1);
    }


    @Bean
    public NewTopic topicDelete() {
        return new NewTopic("topicDelete", 1, (short) 1);
    }

    @Bean
    public NewTopic topicUpdate() {
        return new NewTopic("topicUpdate", 1, (short) 1);
    }



}
