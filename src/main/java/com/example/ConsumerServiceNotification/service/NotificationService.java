package com.example.ConsumerServiceNotification.service;

import com.example.ConsumerServiceNotification.entity.NotificationEntity;
import com.example.ConsumerServiceNotification.repository.NotificationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final NotificationRepo notificationRepo;

    @Autowired
    public NotificationService(NotificationRepo notificationRepo) {
        this.notificationRepo = notificationRepo;
    }

    public void addNotify(NotificationEntity notification) {

        notificationRepo.save(notification);
    }


    public  void  deleteNotify(NotificationEntity notification) {

        notificationRepo.delete(notification);

    }

public  void updateNotify(NotificationEntity notification) {

      //  notificationRepo.
}


}
