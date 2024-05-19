package com.example.ConsumerServiceNotification.entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;
@RedisHash(value = "notify")
public class NotificationEntity {
    @Id
    @Indexed
    private int id;
    private String message;

    public NotificationEntity() {
    }

    public NotificationEntity(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
