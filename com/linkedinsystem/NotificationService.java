package com.linkedinsystem;

public class NotificationService implements NotificationObserver{
    @Override
    public void update(Notification notification) {
        System.out.println(
                "New Notification: " +
                        notification.getContent()
        );
    }

    public void sendNotification(Member member, Notification notification){
        member.addNotification(notification);
        update(notification);
    }
}
