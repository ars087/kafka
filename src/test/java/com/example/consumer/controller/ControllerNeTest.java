package com.example.consumer.controller;


import com.example.consumer.dto.NotificationDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc

class ControllerNeTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper ;


    @Test
   public  void Test_EndPoint_And_Post_Method() throws Exception {

        NotificationDto notificationDto =new NotificationDto(1,"Ivan");

        mockMvc.perform(post("/add")
                .content(mapper.writeValueAsString(notificationDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
//                 .andExpect(jsonPath("$.id").isNumber())
//                 .andExpect(jsonPath("$.id").value("Ivan"));



    }


}