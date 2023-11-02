package org.delta.bank;

import com.google.inject.AbstractModule;
import org.delta.bank.logger.ConsoleLogger;
import org.delta.bank.logger.Logger;
import org.delta.bank.print.ConsolePrintService;
import org.delta.bank.print.PrintInterface;

public class BankInjection extends AbstractModule {

    @Override
    protected void configure() {
        this.bind(PrintInterface.class).to(ConsolePrintService.class);
        this.bind(Logger.class).to(ConsoleLogger.class);

    }
}

