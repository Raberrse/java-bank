package org.delta.bank.feeCalculation;

import org.delta.bank.account.BaseBankAccount;
import org.delta.bank.account.SavingsBankAccount;
import org.delta.bank.account.StudentBankAccount;

public class FeeCalculationService {

    public double calculateFee(BaseBankAccount bankAccount, double transferValue) {
        if (bankAccount instanceof StudentBankAccount) {
            return Fees.STUDENT_ACCOUNT.calculateFee(transferValue);
        } else if (bankAccount instanceof SavingsBankAccount) {
            return Fees.SAVINGS_ACCOUNT.calculateFee(transferValue);
        } else {
            return Fees.DEFAULT_ACCOUNT.calculateFee(transferValue);
        }
    }

    enum Fees {
        STUDENT_ACCOUNT(0, 0, 0),
        SAVINGS_ACCOUNT(50, 50, 500),
        DEFAULT_ACCOUNT(5, 1, 1000);

        private final double fee;
        private final double percentage;
        private final double minimumForPercentageFee;

        Fees(double fee, double percentage, double minimumForPercentageFee) {
            this.fee = fee;
            this.percentage = percentage;
            this.minimumForPercentageFee = minimumForPercentageFee;
        }

        public double calculateFee(double transferValue) {
            if (transferValue < minimumForPercentageFee) {
                return fee;
            }
            return (transferValue * percentage / 100) - fee;
        }
    }
}
