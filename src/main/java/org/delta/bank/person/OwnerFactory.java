package org.delta.bank.person;

import com.google.inject.Inject;
import org.delta.bank.print.PrintService;

public class OwnerFactory {
    @Inject private final PrintService printService;

    public OwnerFactory() {
        this.printService = new PrintService();
    }

    public Owner createOwner(String name, String lastName) {

        this.printService.debug("..Owner");

        return new Owner(name, lastName);
    }
}
