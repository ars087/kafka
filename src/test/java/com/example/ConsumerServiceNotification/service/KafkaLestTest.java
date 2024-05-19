//package com.example.ConsumerServiceNotification.service;
//
//import com.example.ConsumerServiceNotification.dao.impl.NotificationImpl;
//import com.example.ConsumerServiceNotification.dto.NotificationDto;
//
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//@RunWith(MockitoJUnitRunner.class)
//class KafkaLestTest {
//
//    private String topic = "topic-test";
//    private String jsontring =  "{ \"id \" : 1,\" message\":\"Notification\"}";
//
//    @MockBean
//    KafkaLest kafkaLest;
//
//    NotificationDto notificationDto;
//
//    ConsumerRecord<String, String> consumer = new ConsumerRecord<>( topic,0,2,"key",jsontring);
//    @BeforeEach
//    void setUp() {
//       // kafkaLest = new KafkaLest(objectMapper, notification);
//        notificationDto = new NotificationDto();
//        notificationDto.setId(1);
//        notificationDto.setMessage("Notification");
//    }
//    @Test
//    void listener() {
//
//        kafkaLest.listener(consumer);
//
//    }
//
//
//}