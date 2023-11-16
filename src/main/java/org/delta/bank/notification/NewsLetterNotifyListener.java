package org.delta.bank.notification;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Singleton;

@Singleton
public class NewsLetterNotifyListener {

    @Subscribe
    public void newsLetterNotifyEvent(NotifyCustomerEvent notifyCustomerEvent){

        System.out.println("Call newsletter customer event " + notifyCustomerEvent.getNotificationData().getCustomerName());
    }

}