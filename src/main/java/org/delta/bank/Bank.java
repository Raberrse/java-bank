package org.delta.bank;

import org.delta.bank.account.BaseBankAccount;
import org.delta.bank.account.SavingsBankAccount;
import org.delta.bank.account.StudentBankAccount;
import org.delta.bank.moneyTransfer.MoneyTransferService;
import org.delta.bank.person.Owner;

public class Bank {

    public void run() throws Exception {

        MoneyTransferService moneyTransferService = new MoneyTransferService();

        Owner owner = new Owner(
                "Adam",
                "Papousek"
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

        System.out.println("FA: " + bankAccount.getBalance());
        System.out.println("TA: " + secondAccount.getBalance());

        moneyTransferService.transferMoney(bankAccount, secondAccount, 2000);

        System.out.println("FA: " + bankAccount.getBalance());
        System.out.println("TA: " + secondAccount.getBalance());

        BaseBankAccount studentAccount = new StudentBankAccount(owner, "2342324", 4000);
        System.out.println("Student Account");
        System.out.println(studentAccount.getBalance());
        moneyTransferService.transferMoney(studentAccount, secondAccount, 200);
        System.out.println(studentAccount.getBalance());

        BaseBankAccount savingsAccount = new SavingsBankAccount(owner, "2132124", 4000);
        System.out.println("Savings Account");
        System.out.println(savingsAccount.getBalance());
        moneyTransferService.transferMoney(savingsAccount, secondAccount, 200);
        System.out.println(savingsAccount.getBalance());

    }
}