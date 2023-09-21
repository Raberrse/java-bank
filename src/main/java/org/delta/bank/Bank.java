package org.delta.bank;

import org.delta.bank.account.BaseBankAccount;
import org.delta.bank.account.StudentBankAccount;
import org.delta.bank.moneyTransfer.MoneyTransferService;
import org.delta.bank.person.Owner;

public class Bank {

    public void run() throws Exception {
        System.out.println("Hello bank");

        MoneyTransferService moneyTransferService = new MoneyTransferService();

        Owner owner = new Owner(
                "Mirek",
                "Borek"
        );

        BaseBankAccount bankAccount = new BaseBankAccount(
                owner,
                "12345",
                4000
        );

        BaseBankAccount secondAccount = new BaseBankAccount(
                owner,
                "38134",
                6000
        );

        System.out.println(bankAccount.getBalance());
        System.out.println(secondAccount.getBalance());

        moneyTransferService.transferMoney(bankAccount, secondAccount, 2000);

        System.out.println(bankAccount.getBalance());
        System.out.println(secondAccount.getBalance());

        BaseBankAccount studentAccount = new StudentBankAccount(owner, "93214192", 5000);

        System.out.println(studentAccount.getBalance());

        moneyTransferService.transferMoney(studentAccount, secondAccount, 200);

        System.out.println(studentAccount.getBalance());
    }
}