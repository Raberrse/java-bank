package org.delta.bank.person;

import com.google.inject.Inject;

public class Owner {
    @Inject private final String firstName;
    @Inject private final String lastName;

    public Owner(
            String firstName,
            String lastName
    ) {

        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getFullName() {
        return firstName + " " + lastName;
    }
}
