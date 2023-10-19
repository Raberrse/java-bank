package org.delta.bank.account;

import org.delta.bank.logger.LogService;
import org.delta.bank.person.Owner;


public class BankFactory {
    private LogService logService;
    private BankAccountNumberGenerator bankAccountNumberGenerator;

    public BankFactory(){
        this.logService = new LogService();
        this.bankAccountNumberGenerator = new BankAccountNumberGenerator();
    }

    public BaseBankAccount createBaseBankAccount(Owner owner, int number){
        this.logService.logMessage("Debug... ");
        String generatedNumber = this.bankAccountNumberGenerator.generate();

        return new BaseBankAccount(owner,generatedNumber,number);
    }

    public SaveBankAccount createSaveBankAccount(Owner owner, int number){
        this.logService.logMessage("Debug... ");
        String generatedNumber = this.bankAccountNumberGenerator.generate();

        return new SaveBankAccount(owner,generatedNumber,number);
    }

    public StudentBankAccount createStudentBankAccount(Owner owner, int number){
        this.logService.logMessage("Debug... ");
        String generatedNumber = this.bankAccountNumberGenerator.generate();

        return new StudentBankAccount(owner,generatedNumber,number);
    }


}
