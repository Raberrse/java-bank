package org.delta.bank.notification;

public class NotifyCustomerEvent {

    private NotificationData notificationData;

    public NotifyCustomerEvent(NotificationData notificationData){
        this.notificationData = notificationData;
    }

    public NotificationData getNotificationData() {
        return notificationData;
    }
}
