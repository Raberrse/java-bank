package org.delta.bank.moneySavings;

import org.delta.bank.account.BaseBankAccount;
import org.delta.bank.account.SaveBankAccount;
import org.delta.bank.account.StudentBankAccount;
import org.delta.bank.enums.accounts;

public class SavingsCalculator {
    public double calculateSavings(BaseBankAccount acc){

        if(acc instanceof SaveBankAccount){
            return acc.getBalance() * accounts.Savings.savings_fee;
        }

        if(acc instanceof StudentBankAccount){
            return acc.getBalance() * accounts.Students.savings_fee;
        }

        return 0;
    }
}
