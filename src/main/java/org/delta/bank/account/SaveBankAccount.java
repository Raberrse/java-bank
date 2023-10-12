package org.delta.bank.account;

import org.delta.bank.person.Owner;

public class SaveBankAccount extends BaseBankAccount implements SavingsBankAccount {
    public SaveBankAccount(
            Owner owner,
            String bankAccountNumber,
            double balance
    ) {

        super(owner, bankAccountNumber, balance);
    }

}
