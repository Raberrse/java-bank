package org.delta.bank.account;

import java.util.Random;

public class BankAccountNumberGenerator {
    public String generate(){
        Random random = new Random();
        long min = 1000000000L;  // Smallest 10-digit number
        long max = 9999999999L;  // Largest 10-digit number
        return String.valueOf( + ((long) (random.nextDouble() * (max - min))));
    }
}
