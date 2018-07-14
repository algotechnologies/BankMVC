package com.algotechnologies.bankmvc.model.account;

import android.content.Context;

import com.algotechnologies.bankmvc.model.account.base.BankAccount;
import com.algotechnologies.bankmvc.model.database.entity.AccountInfo;
import com.algotechnologies.bankmvc.model.repository.AccountRepository;

/**
 * Created by Saad Aftab on 16/06/2018.
 */
public class CheckingAccount extends BankAccount {

    private Context context;

    public CheckingAccount(Context context) {
        this.context = context;
    }

    @Override
    public AccountInfo open(String accountTitle, double amount) {
        // Prepare account info entity for DB
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setType("Checking");
        accountInfo.setAccountNumber(String.valueOf(System.currentTimeMillis()));
        accountInfo.setTitle(accountTitle);
        accountInfo.setAmount(String.valueOf(amount));

        // Save the info into Room DB
        AccountRepository accountRepository = new AccountRepository(context);
        accountRepository.insert(accountInfo);

        return accountInfo;
    }

    @Override
    public double withdraw(long accountNumber, double amount) {
        // Subtract amount from DB & return updated amount
        return 0;
    }

}
