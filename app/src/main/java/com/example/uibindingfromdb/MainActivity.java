package com.example.uibindingfromdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.uibindingfromdb.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity
{
    ActivityMainBinding bin;
    MainViewModel vm;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate( savedInstanceState );
        vm = ViewModelProviders.of(this).get(MainViewModel.class);
        bin = DataBindingUtil.setContentView(this,R.layout.activity_main);
        bin.setLifecycleOwner(this);
        bin.setUser(new User(1,2,3,4,5,6));
//        vm.getUsers().removeObservers(this);
        vm.getUsers().observe( this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
//                if(user == null)
//                    Toast.makeText( MainActivity.this, "user null", Toast.LENGTH_SHORT ).show();
//                else
                bin.setUser(user);
                vm.setUsers();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public class updateAsyncTsk  extends AsyncTask<Void,Void,Void>
    {
        @Override
        protected Void doInBackground(Void... voids)
        {
            System.out.println("Hello");
            while (true)
            {
                User user = vm.getUser();
                if(user != null)
                {
                    User updateUser = new User((user.getNum1()+1)%10000,(user.getNum2()+1)%10000,(user.getNum3()+1)%10000,(user.getNum4()+1)%10000,(user.getNum5()+1)%10000,(user.getNum6()+1)%10000);
                    updateUser.setId(1);
                    vm.updateUser(updateUser);
                }
                else
                    vm.insertUser(new User(2,3,4,5,6,7));
                for(int i = 0;i < 10000;i++);
            }
        }
    }

    public void onClick(View view)
    {
        new updateAsyncTsk().execute();
    }
    public class insertAsyncTsk  extends AsyncTask<Void,Void,Void>
    {
        @Override
        protected Void doInBackground(Void... voids)
        {
            vm.insertUser(new User(2,3,4,5,6,7));
            Log.e( "insert","Success" );
            return null;
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}

