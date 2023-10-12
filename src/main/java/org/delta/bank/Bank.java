package org.delta.bank;

import org.delta.bank.account.BaseBankAccount;
import org.delta.bank.account.SaveBankAccount;
import org.delta.bank.account.SavingsBankAccount;
import org.delta.bank.account.StudentBankAccount;
import org.delta.bank.moneyTransfer.MoneyTransferService;
import org.delta.bank.person.Owner;

public class Bank {
    MoneyTransferService moneyTransferService = new MoneyTransferService();

    public void run() throws Exception {
        Owner owner = new Owner(
                "Adam",
                "Papousek"
        );

        BaseBankAccount bankAccount = new BaseBankAccount(
                owner,
                "12345",
                4000
        );

        SaveBankAccount saveAccount = new SaveBankAccount(
                owner,
                "38134",
                6000
        );

        System.out.println("FA: " + bankAccount.getBalance());
        System.out.println("TA: " + saveAccount.getBalance());

        moneyTransferService.transferMoney(bankAccount, saveAccount, 2000);

        System.out.println("FA: " + bankAccount.getBalance());
        System.out.println("TA: " + saveAccount.getBalance());

        BaseBankAccount studentAccount = new StudentBankAccount(owner, "2342324", 4000);
        System.out.println("Student Account");
        System.out.println(studentAccount.getBalance());
        moneyTransferService.transferMoney(studentAccount, saveAccount, 200);
        System.out.println(studentAccount.getBalance());

    }
}