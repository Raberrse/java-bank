package org.delta.bank.notification;

public class NotificationData {

    private String customerName;

    public NotificationData(String s){
        this.customerName = s;
    }

    public String getCustomerName() {
        return customerName;
    }
}
