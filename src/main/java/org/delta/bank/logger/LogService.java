package org.delta.bank.logger;

import com.google.inject.Inject;
import org.delta.bank.account.BaseBankAccount;

public class LogService {
    @Inject
    Logger logger;

    public void logMessage(String message) {
        logger.logMessage(message);
    }

    public void log(BaseBankAccount account) {
        logger.log(account);
    }
}
