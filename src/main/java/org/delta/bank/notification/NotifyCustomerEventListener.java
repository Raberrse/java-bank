package org.delta.bank.notification;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Singleton;

@Singleton
public class NotifyCustomerEventListener {

    @Subscribe
    public void notifyCustomerEvent(NotifyCustomerEvent notifyCustomerEvent) {
        System.out.println("#######");
        System.out.println("## Call Notify customer event " + notifyCustomerEvent.getNotificationData().getCustomerName());
        System.out.println("#######");
    }
}
