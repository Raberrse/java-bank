package org.delta.bank.ownerJSONParser;

import com.google.gson.Gson;
import org.delta.bank.account.BaseBankAccount;
import org.delta.bank.person.Owner;

public class OwnerJSONParserService {

    private Gson gson = new Gson();

    public String ParseToJSON(Owner owner) {
        return gson.toJson(owner);
    }
}

