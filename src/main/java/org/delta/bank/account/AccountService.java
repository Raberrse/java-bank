package org.delta.bank.account;

import org.delta.bank.person.Owner;

import java.util.HashMap;
import java.util.Map;

public class AccountService {
    private Map<String, BaseBankAccount> accounts;
    private BankFactory bankFactory;

    public AccountService(){
        this.accounts = new HashMap<>();
        this.bankFactory = new BankFactory();
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
