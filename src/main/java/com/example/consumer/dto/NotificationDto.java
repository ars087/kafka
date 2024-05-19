package com.example.consumer.dto;

public class NotificationDto {


    private int id;
    private String message;


    public NotificationDto() {
    }


    public NotificationDto(int id, String message) {
        this.id = id;
        this.message = message;

    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
