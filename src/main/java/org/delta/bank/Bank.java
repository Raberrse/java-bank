package org.delta.bank;

import com.google.inject.Inject;
import org.delta.bank.account.*;
import org.delta.bank.logger.LogService;
import org.delta.bank.moneySavings.SavingsUpdate;
import org.delta.bank.moneyTransfer.MoneyTransferService;
import org.delta.bank.ownerJSONParser.OwnerJSONParserService;
import org.delta.bank.person.Owner;
import org.delta.bank.person.OwnerFactory;

import java.util.Map;

public class Bank {
    @Inject private MoneyTransferService moneyTransferService;
    @Inject private AccountService accountService;
    @Inject private OwnerFactory ownerFactory;
    @Inject private LogService logger;
    @Inject private OwnerJSONParserService ownerJSONParserService;

    public Bank() {

    }

    public void run() throws Exception {
        Owner owner = ownerFactory.createOwner(
                "Adam",
                "Papousek"
        );

        BaseBankAccount bankAccount = accountService.createBasedBankAccount(
                owner,
                12346
        );

        SaveBankAccount saveAccount = accountService.createSaveBankAccount(
                owner,
                12346
        );

        Map<String, BaseBankAccount> accounts = accountService.getAccounts();
        for(Map.Entry<String, BaseBankAccount> entrySet : accountService.getAccounts().entrySet()){
            BaseBankAccount account = entrySet.getValue();
            logger.log(account);

            if(account instanceof SavingsBankAccount){
                SavingsUpdate savingsUpdate = new SavingsUpdate();
                savingsUpdate.interestMoney(account);
            }
        }

        logger.logMessage("Before:");
        logger.log(bankAccount);
        logger.log(saveAccount);

        moneyTransferService.transferMoney(bankAccount, saveAccount, 250);

        logger.logMessage("After:");
        logger.log(bankAccount);
        logger.log(saveAccount);

        moneyTransferService.transferByATM(bankAccount, 250);
        logger.log(bankAccount);
        moneyTransferService.transferByATM(saveAccount, 100);
        logger.log(saveAccount);

        ownerJSONParserService = new OwnerJSONParserService();
        logger.logMessage(ownerJSONParserService.ParseToJSON(owner));


//        System.out.println("FA: " + bankAccount.getBalance());
//        System.out.println("TA: " + saveAccount.getBalance());
//
//        moneyTransferService.transferMoney(bankAccount, saveAccount, 2000);
//
//        System.out.println("FA: " + bankAccount.getBalance());
//        System.out.println("TA: " + saveAccount.getBalance());
//
//        BaseBankAccount studentAccount = new StudentBankAccount(owner, "2342324", 4000);
//        System.out.println("Student Account");
//        System.out.println(studentAccount.getBalance());
//        moneyTransferService.transferMoney(studentAccount, saveAccount, 200);
//        System.out.println(studentAccount.getBalance());
    }
}
