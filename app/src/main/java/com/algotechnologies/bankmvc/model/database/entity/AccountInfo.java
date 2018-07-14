package com.algotechnologies.bankmvc.model.database.entity;

import android.arch.persistence.room.*;
import android.support.annotation.NonNull;

/**
 * Created by Saad Aftab on 16/06/2018.
 */

@Entity(tableName = "accounts_info")
public class AccountInfo {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "account_number")
    private String accountNumber;

    @NonNull
    @ColumnInfo(name = "account_title")
    private String title;

    @NonNull
    @ColumnInfo(name = "account_amount")
    private String amount;

    @NonNull
    @ColumnInfo(name = "account_type")
    private String type;

    @NonNull
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(@NonNull String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    @NonNull
    public String getAmount() {
        return amount;
    }

    public void setAmount(@NonNull String amount) {
        this.amount = amount;
    }

    @NonNull
    public String getType() {
        return type;
    }

    public void setType(@NonNull String type) {
        this.type = type;
    }

}
