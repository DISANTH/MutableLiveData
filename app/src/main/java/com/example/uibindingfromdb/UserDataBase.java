package com.example.uibindingfromdb;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {User.class},version = 2)
public abstract class UserDataBase extends RoomDatabase
{
    public abstract UserDao getUserDao();
    private static UserDataBase INSTANCE;
    public static UserDataBase getINSTANCE(Context context)
    {
        if(INSTANCE == null)
        {
            INSTANCE = Room.databaseBuilder(context,UserDataBase.class,"room_Sqlite")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }

    public static UserDataBase.Callback callbackforBookingModel=new UserDataBase.Callback(){

        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateBookingModelDbAsyncTask(INSTANCE).execute();
        }
    };

    public static class PopulateBookingModelDbAsyncTask extends AsyncTask<Void,Void,Void>
    {
        UserDataBase userDataBase;
        public PopulateBookingModelDbAsyncTask(UserDataBase userDataBase) {
            this.userDataBase = userDataBase;
        }
        @Override
        protected Void doInBackground(Void...voids) {
            UserDao userDao = userDataBase.getUserDao();
            userDao.insertUser(new User(2,3,4,5,6,7));
            return null;
        }
    }
}
