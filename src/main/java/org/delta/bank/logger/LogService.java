package org.delta.bank.logger;

import org.delta.bank.account.BaseBankAccount;

public class LogService {
    private final Logger logger = new ConsoleLogger();

    public void logMessage(String message) {
        logger.logMessage(message);
    }

    public void log(BaseBankAccount account) {
        logger.log(account);
    }
}
