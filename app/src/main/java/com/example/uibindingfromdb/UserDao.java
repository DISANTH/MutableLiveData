package com.example.uibindingfromdb;

import android.icu.text.Replaceable;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface UserDao
{
    @Insert()
    Long insertUser(User user);

    @Update
    void updateUser(User user);

    @Delete
    void deleteUser(User user);

    @Query("SELECT *FROM user LIMIT 1")
    LiveData<User> getUsers();

    @Query("SELECT *FROM user LIMIT 1")
    User getUser();
}
