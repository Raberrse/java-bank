package org.delta.bank.moneySavings;

import org.delta.bank.account.BaseBankAccount;

public class SavingsUpdate {
    public void interestMoney(BaseBankAccount sourceAccount){
        SavingsCalculator interestCalculator = new SavingsCalculator();
        sourceAccount.setBalance(interestCalculator.calculateSavings(sourceAccount));
    }
}
