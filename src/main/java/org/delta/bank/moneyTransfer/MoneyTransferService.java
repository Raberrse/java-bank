package org.delta.bank.moneyTransfer;

import com.google.inject.Inject;
import org.delta.bank.account.BaseBankAccount;
import org.delta.bank.feeCalculation.FeeCalculationService;
import org.delta.bank.validation.ValidationService;

public class MoneyTransferService {

    @Inject ValidationService validationService = new ValidationService();
    @Inject FeeCalculationService feeCalculationService = new FeeCalculationService();

    public void transferMoney(
            BaseBankAccount sourceAccount,
            BaseBankAccount destinationAccount,
            double value
    ) throws Exception {

       validationService.validateAccountBalanceAfterTransfer(
               sourceAccount.getBalance(),
               value
       );

        double fee = feeCalculationService.calculateFee(sourceAccount, value);

        sourceAccount.setBalance(sourceAccount.getBalance() - value - fee);
        destinationAccount.setBalance(destinationAccount.getBalance() + value);
    }

    public void transferByATM(
            BaseBankAccount sourceAccount,
            double value
    ) throws Exception {

        validationService.validateAccountBalanceAfterTransfer(
                sourceAccount.getBalance(),
                value
        );

        double fee = feeCalculationService.calculateFee(sourceAccount, value);

        sourceAccount.setBalance(sourceAccount.getBalance() - value - fee);
    }
}
