package com.example.uibindingfromdb;

import android.app.Application;
import android.os.AsyncTask;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends AndroidViewModel
{
    MutableLiveData<User> mutableLiveData = new MutableLiveData<>(  );

    private CustomMutableLiveData<User> users = new CustomMutableLiveData<User>();
    private MutableLiveData<User> usersList = new MutableLiveData<>();
    private LiveData<User> liveData;
    private UserRepository userRepository;

    public MainViewModel(@NonNull Application application) {
        super( application );
        userRepository = new UserRepository(application);
//        User user = userRepository.getUserLiveData().getValue();
//        usersList.setValue(user);
//        new getUserAsyncTask(userRepository).execute();
        liveData =userRepository.getUserLiveData();
//        usersList.setValue(liveData.getValue());
//        try
//        {
//            User user = liveData.getValue();
//            users.setValue(user);
//        }
//        catch (Exception e)
//        {
//
//        }
    }

    public void setUsers(){
//        User user = userRepository.getUserLiveData().getValue();
//        usersList.setValue(user);
        liveData = userRepository.getUserLiveData();
    }
    public LiveData<User> getUsers()
    {
        return liveData;
    }
    public User getUser() {
        return userRepository.getUser();
    }

    public void updateUser(User user)
    {
        userRepository.updateuser(user);
    }

    public void deleteUser(User user)
    {
        userRepository.deleteuser(user);
    }

    public Long insertUser(User user)
    {
        return userRepository.insertUser(user);
    }
    public class getUserAsyncTask extends AsyncTask<Void,Void,Void>
    {
        UserRepository userRepository;
        public getUserAsyncTask(UserRepository userRepository) {
            this.userRepository = userRepository;
        }
        @Override
        protected Void doInBackground(Void... voids)
        {
            User user = userRepository.getUser();
            usersList.postValue(user);
            return null;
        }
    }
}
