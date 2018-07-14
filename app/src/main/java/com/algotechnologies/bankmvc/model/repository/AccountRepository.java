package com.algotechnologies.bankmvc.model.repository;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.os.AsyncTask;

import com.algotechnologies.bankmvc.model.database.RoomDB;
import com.algotechnologies.bankmvc.model.database.dao.IAccountInfo;
import com.algotechnologies.bankmvc.model.database.entity.AccountInfo;

import java.util.List;

/**
 * Created by Saad Aftab on 19/06/2018.
 */
public class AccountRepository {

    private IAccountInfo accountInfoDao;

    public AccountRepository(Context context) {
        RoomDB db = RoomDB.getDatabase(context);
        accountInfoDao = db.accountInfoDao();
    }

    public void insert(AccountInfo accountInfo) {
        new InsertAsyncTask(accountInfoDao).execute(accountInfo);
    }

    public LiveData<List<AccountInfo>> getAllAccounts() {
        return accountInfoDao.getAllAccounts();
    }

    private static class InsertAsyncTask extends AsyncTask<AccountInfo, Void, Void> {

        private IAccountInfo mAsyncTaskDao;

        InsertAsyncTask(IAccountInfo dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(AccountInfo... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

}