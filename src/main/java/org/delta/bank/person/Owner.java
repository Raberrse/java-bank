package org.delta.bank.person;

public class Owner {

    private final String firstName;
    private final String lastName;

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
}
