package com.example.uibindingfromdb;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;

public class UserRepository
{
    private MediatorLiveData<User> mSectionLive = new MediatorLiveData<>();
    LiveData<User> userLiveData;
    private UserDao userDao;
    User user;

    public LiveData<User> getUserLiveData()
    {
//        final LiveData<User> sections = userDao.getUsers();
//
//        mSectionLive.addSource(sections, new Observer<User>() {
//            @Override
//            public void onChanged(@Nullable User sectionList) {
//                    mSectionLive.removeSource(sections);
//                    mSectionLive.setValue(sectionList);
//            }
//        });
//        return mSectionLive;
        userLiveData = userDao.getUsers();
        return userLiveData;
    }

    public UserRepository(Context context)
    {
        userDao = UserDataBase.getINSTANCE(context).getUserDao();
        userLiveData = userDao.getUsers();
        user = userLiveData.getValue();
        System.out.println("Hello");
    }

    public User getUser()
    {
        return userDao.getUser();
    }
    public void updateuser(User user)
    {
         userDao.updateUser(user);
    }

    public void deleteuser(User user)
    {
        userDao.deleteUser(user);
    }

    public Long insertUser(User user)
    {
        return userDao.insertUser(user);
    }
}
