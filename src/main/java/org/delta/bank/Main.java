package org.delta.bank;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.delta.bank.notification.NewsLetterNotifyListener;
import org.delta.bank.notification.NotifyCustomerEventListener;

public class Main {
    public static void main(String[] args) {

        try {
            Injector injector = Guice.createInjector(new BankInjection());
            Bank bank = injector.getInstance(Bank.class);
            injector.getInstance(NotifyCustomerEventListener.class);
            injector.getInstance(NewsLetterNotifyListener.class);

            bank.run();
        } catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());

        }
    }
}
