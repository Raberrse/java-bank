package org.delta.bank.validation;

public class ValidationService {

    public void validateAccountBalanceAfterTransfer(
            double accountValue,
            double transferValue
    ) throws Exception {

        if (accountValue < transferValue) {
            throw new Exception("");
        }
    }
}
