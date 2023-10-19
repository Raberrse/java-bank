package org.delta.bank.logger;

import org.delta.bank.account.BaseBankAccount;
import org.delta.bank.account.SaveBankAccount;
import org.delta.bank.account.StudentBankAccount;

public interface Logger {
    // message
    void logMessage(String input);
    // info
    void log(BaseBankAccount acc);
}
