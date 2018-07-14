package com.algotechnologies.bankmvc.model.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.algotechnologies.bankmvc.model.database.entity.AccountInfo;

import java.util.List;

/**
 * Created by Saad Aftab on 19/06/2018.
 */

@Dao
public interface IAccountInfo {

    @Insert
    void insert(AccountInfo accountInfo);

    @Query("SELECT * from accounts_info ORDER BY account_number ASC")
    LiveData<List<AccountInfo>> getAllAccounts();

}
