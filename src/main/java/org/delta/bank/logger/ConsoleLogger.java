package org.delta.bank.logger;

import org.delta.bank.account.BaseBankAccount;
import org.delta.bank.account.SaveBankAccount;
import org.delta.bank.account.StudentBankAccount;

public class ConsoleLogger implements Logger{

    public  void log(BaseBankAccount input){

        if(input instanceof StudentBankAccount){
            System.out.println("StudentBankAccount Balance " + input.getBalance()  + " name - " + input.getOwner().getFirstName() );
            return;
        }

        if(input instanceof SaveBankAccount){
            System.out.println("SavingsBankAccount Balance " + input.getBalance()  + " name - " + input.getOwner().getFirstName());
            return;
        }

        if(input instanceof BaseBankAccount) {
            System.out.println("BaseBankAccount Balance " + input.getBalance() + " name - " + input.getOwner().getFirstName());
        }
    }

    public void logMessage(String input){
        System.out.println(input);
    }
}
