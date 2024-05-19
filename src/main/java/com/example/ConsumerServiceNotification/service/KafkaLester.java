package com.example.ConsumerServiceNotification.service;


import com.example.ConsumerServiceNotification.entity.NotificationEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;



@Component
public class KafkaLester {
    private static final Logger LOG = LoggerFactory.getLogger(KafkaLester.class);
    private final ObjectMapper jacksonObjectMapper;
    private final NotificationService notificationService;

    @Autowired
    public KafkaLester(ObjectMapper jacksonObjectMapper, NotificationService notificationService ) {
        this.jacksonObjectMapper = jacksonObjectMapper;
        this.notificationService = notificationService;

    }

@KafkaListener(topics = "${application.kafka.topic}", groupId = "demo-producer")

    public void listenerCreate(ConsumerRecord<String, String> consumerRecord) {

      String  jsonString =  consumerRecord.value();


      NotificationEntity notificationEntity = null;
      try {
          notificationEntity = jacksonObjectMapper.readValue(jsonString, NotificationEntity.class);

          notificationService.addNotify(notificationEntity);

          LOG.info("log save :" + jsonString);
      } catch (JsonProcessingException e) {
          LOG.warn( "log :" + e.getMessage());
          throw new RuntimeException(e);
      }

  }


    @KafkaListener(topics = "topicDelete", groupId = "demo-producer")
  public void listenerDelete(ConsumerRecord<String, String> consumerRecord) {


        String  jsonString =  consumerRecord.value();
          NotificationEntity notificationEntity = null;
        try {
            notificationEntity = jacksonObjectMapper.readValue(jsonString, NotificationEntity.class);

           notificationService.deleteNotify(notificationEntity);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    @KafkaListener(topics = "topicUpdate", groupId = "demo-producer")
    public void listenerUpdate(ConsumerRecord<String, String> consumerRecord) {


        String  jsonString =  consumerRecord.value();
        NotificationEntity notificationEntity = null;
        try {
            notificationEntity = jacksonObjectMapper.readValue(jsonString, NotificationEntity.class);

            notificationService.deleteNotify(notificationEntity);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

}

