package org.delta.bank.account;

import org.delta.bank.person.Owner;

public class StudentBankAccount extends BaseBankAccount {

    public StudentBankAccount(
            Owner owner,
            String bankAccountNumber,
            double balance
    ) {

        super(owner, bankAccountNumber, balance);
    }
}
