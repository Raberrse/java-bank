package org.delta.bank.account;

import org.delta.bank.person.Owner;

public class SavingsBankAccount extends BaseBankAccount {

    public SavingsBankAccount(
            Owner owner,
            String bankAccountNumber,
            double balance
    ) {

        super(owner, bankAccountNumber, balance);
    }
}
