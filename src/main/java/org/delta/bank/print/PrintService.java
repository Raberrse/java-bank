package org.delta.bank.print;

import com.google.inject.Inject;
import org.delta.bank.account.BaseBankAccount;

public class PrintService {

    @Inject private PrintInterface printService;

    public void printBankAccountBalance(BaseBankAccount bankAccount) {
        this.printService.printBankAccountBalance(bankAccount);
    }

    public void debug(String message) {
        this.printService.debug(message);
    }
}
