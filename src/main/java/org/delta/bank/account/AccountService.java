package org.delta.bank.account;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.bank.person.Owner;

import java.util.HashMap;
import java.util.Map;

@Singleton
public class AccountService {
    private Map<String, BaseBankAccount> accounts;
    @Inject private BankFactory bankFactory;

    public AccountService(){
        this.accounts = new HashMap<>();
    }

    public BaseBankAccount createBasedBankAccount(Owner owner, int balance){
        BaseBankAccount bankAccount = this.bankFactory.createBaseBankAccount(owner, balance);
        this.accounts.put(bankAccount.getNumber(), bankAccount);

        return bankAccount;
    }

    public StudentBankAccount createStudentAccount(Owner owner, int balance){
        StudentBankAccount bankAccount = this.bankFactory.createStudentBankAccount(owner, balance);
        this.accounts.put(bankAccount.getNumber(), bankAccount);

        return bankAccount;
    }

    public SaveBankAccount createSaveBankAccount(Owner owner, int balance){
        SaveBankAccount bankAccount = this.bankFactory.createSaveBankAccount(owner, balance);
        this.accounts.put(bankAccount.getNumber(), bankAccount);

        return bankAccount;
    }

    public Map<String, BaseBankAccount> getAccounts(){
        return accounts;
    }
}
