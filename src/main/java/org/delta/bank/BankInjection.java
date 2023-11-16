package org.delta.bank;

import com.google.common.eventbus.EventBus;
import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.Matchers;
import com.google.inject.spi.InjectionListener;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;
import org.delta.bank.logger.ConsoleLogger;
import org.delta.bank.logger.Logger;
import org.delta.bank.print.ConsolePrintService;
import org.delta.bank.print.PrintInterface;

public class BankInjection extends AbstractModule {

    private EventBus eventBus = new EventBus("Default eventbus");

    @Override
    protected void configure() {
        this.bind(PrintInterface.class).to(ConsolePrintService.class);
        this.bind(Logger.class).to(ConsoleLogger.class);
        this.bind(EventBus.class).toInstance(eventBus);

        bindListener(Matchers.any(), new TypeListener() {
            @Override
            public <I> void hear(TypeLiteral<I> typeLiberal, TypeEncounter<I> typeEncounter) {
                typeEncounter.register(new InjectionListener<I>(){
                    public void afterInjection(I i){eventBus.register(i);}
                });
            }
        });
    }
}

