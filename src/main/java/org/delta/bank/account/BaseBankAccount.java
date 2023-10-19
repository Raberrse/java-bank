package org.delta.bank.account;

import org.delta.bank.person.Owner;

public class BaseBankAccount {
    protected Owner owner;
    protected String bankAccountNumber;
    protected double balance;

    public BaseBankAccount(
            Owner owner,
            String bankAccountNumber,
            double balance
    ) {

        this.owner = owner;
        this.bankAccountNumber = bankAccountNumber;
        this.balance = balance;
    }

    public void setBalance(double value) {
        this.balance = value;
    }

    public double getBalance() {
        return balance;
    }

    public Owner getOwner() {
        return owner;
    }

    public String getNumber(){
        return bankAccountNumber;
    }
}
