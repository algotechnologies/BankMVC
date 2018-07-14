package com.algotechnologies.bankmvc.model.account.base;

import com.algotechnologies.bankmvc.model.database.entity.AccountInfo;

/**
 * Created by Saad Aftab on 16/06/2018.
 */
public abstract class BankAccount {

    public abstract AccountInfo open(String accountTitle, double amount);

    public abstract double withdraw(long accountNumber, double amount);

    public boolean close(long accountNumber) {
        // Delete this info from DB
        return true;
    }

    public double deposite(long accountNumber, double amount) {
        // Add amount into DB & return updated amount
        return 0;
    }

}
