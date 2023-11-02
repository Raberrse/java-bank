package org.delta.bank;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {
    public static void main(String[] args) {

        try {
            Injector injector = Guice.createInjector(new BankInjection());
            Bank bank = injector.getInstance(Bank.class);

            bank.run();
        } catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());

        }
    }
}
