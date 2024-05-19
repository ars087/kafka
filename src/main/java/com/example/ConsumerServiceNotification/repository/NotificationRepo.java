package com.example.ConsumerServiceNotification.repository;
import com.example.ConsumerServiceNotification.entity.NotificationEntity;
import org.springframework.data.keyvalue.repository.KeyValueRepository;

public interface NotificationRepo extends KeyValueRepository<NotificationEntity,String> {
}
