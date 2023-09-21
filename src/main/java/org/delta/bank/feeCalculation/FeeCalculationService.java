package org.delta.bank.feeCalculation;

import org.delta.bank.account.BaseBankAccount;
import org.delta.bank.account.StudentBankAccount;

public class FeeCalculationService {

    public double calculateFee(BaseBankAccount bankAccount, double transferValue) {

        if (bankAccount instanceof StudentBankAccount) {
            return 0;
        }

        if (transferValue < 1000) {

            return 5;
        }

        return ((transferValue / 100) * 1) - 5;
    }
}
