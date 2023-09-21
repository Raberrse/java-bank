package org.delta.bank.moneyTransfer;

import org.delta.bank.account.BaseBankAccount;
import org.delta.bank.validation.ValidationService;

public class MoneyTransferService {

    ValidationService validationService = new ValidationService();

    public void transferMoney(
            BaseBankAccount sourceAccount,
            BaseBankAccount destinationAccount,
            double value
    ) throws Exception {

       validationService.validateAccountBalanceAfterTransfer(
               sourceAccount.getBalance(),
               value
       );

        sourceAccount.setBalance(sourceAccount.getBalance() - value);
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

        sourceAccount.setBalance(sourceAccount.getBalance() - value);
    }
}
