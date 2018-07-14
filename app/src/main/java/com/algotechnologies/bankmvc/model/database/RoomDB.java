package com.algotechnologies.bankmvc.model.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.algotechnologies.bankmvc.model.database.dao.IAccountInfo;
import com.algotechnologies.bankmvc.model.database.entity.AccountInfo;

/**
 * Created by Saad Aftab on 19/06/2018.
 */

@Database(entities = {AccountInfo.class}, version = 1)
public abstract class RoomDB extends RoomDatabase {

    public abstract IAccountInfo accountInfoDao();

    private static RoomDB INSTANCE;

    public static RoomDB getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (RoomDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            RoomDB.class, "database_accounts")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
