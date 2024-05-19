package com.example.consumer.controller;


import com.example.consumer.KafkaProducer;
import com.example.consumer.dto.NotificationDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/")
@RestController
public class ControllerNe {

    private Logger logger = LoggerFactory.getLogger(ControllerNe.class);

    private final KafkaProducer kafkaProducer;
    private final ObjectMapper objectMapper;

    @Autowired
    public ControllerNe(KafkaProducer kafkaProducer, ObjectMapper objectMapper) {
        this.kafkaProducer = kafkaProducer;
        this.objectMapper = objectMapper;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addNotify(@RequestBody NotificationDto notificationDto) {

    try {
        if (  notificationDto.getId() < 0) {
            logger.info("log add: The data is not complete " + notificationDto.getId());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        String jsonNotification =  objectMapper.writeValueAsString(notificationDto);
        kafkaProducer.sendEvent(jsonNotification);
        logger.info("log add: received message " + notificationDto);


        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping(value = "/del/{id}")
    public ResponseEntity<String> deleteNotify(@PathVariable("id") int id) {

        NotificationDto notificationDto = new  NotificationDto(id,"test");

        try {
            String jsonNotification =  objectMapper.writeValueAsString(notificationDto);

            kafkaProducer.deleteEvent( jsonNotification);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return new ResponseEntity<>(HttpStatus.OK);



    }

    @PostMapping(value = "/update")
    public ResponseEntity<String> updateNotify(@RequestBody NotificationDto notificationDto) {

        try {
            String jsonNotification =  objectMapper.writeValueAsString(notificationDto);

            kafkaProducer.updateEvent( jsonNotification);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return new ResponseEntity<>(HttpStatus.OK);



    }


}

