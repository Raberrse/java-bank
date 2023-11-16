package org.delta.bank.account;

import com.google.common.eventbus.EventBus;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.bank.notification.NotificationData;
import org.delta.bank.notification.NotifyCustomerEvent;
import org.delta.bank.person.Owner;

import java.util.HashMap;
import java.util.Map;

@Singleton
public class AccountService {
    private Map<String, BaseBankAccount> accounts;
    @Inject private BankFactory bankFactory;
    @Inject private EventBus eventBus;

    public AccountService(){
        this.accounts = new HashMap<>();
    }

    public BaseBankAccount createBasedBankAccount(Owner owner, int balance){
        BaseBankAccount bankAccount = this.bankFactory.createBaseBankAccount(owner, balance);
        this.accounts.put(bankAccount.getNumber(), bankAccount);
        this.eventBus.post(new NotifyCustomerEvent(new NotificationData(owner.getFirstName())));

        return bankAccount;
    }

    public StudentBankAccount createStudentAccount(Owner owner, int balance){
        StudentBankAccount bankAccount = this.bankFactory.createStudentBankAccount(owner, balance);
        this.accounts.put(bankAccount.getNumber(), bankAccount);
        this.eventBus.post(new NotifyCustomerEvent(new NotificationData(owner.getFirstName())));

        return bankAccount;
    }

    public SaveBankAccount createSaveBankAccount(Owner owner, int balance){
        SaveBankAccount bankAccount = this.bankFactory.createSaveBankAccount(owner, balance);
        this.accounts.put(bankAccount.getNumber(), bankAccount);
        this.eventBus.post(new NotifyCustomerEvent(new NotificationData(owner.getFirstName())));

        return bankAccount;
    }

    public Map<String, BaseBankAccount> getAccounts(){
        return accounts;
    }
}
