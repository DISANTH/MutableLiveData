package com.example.uibindingfromdb;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "User")
public class User extends BaseObservable
{
    @PrimaryKey(autoGenerate = true)
    int id;
    int num1;
    int num2;
    int num3;
    int num4;
    int num5;
    int num6;

    public void setId(int id) {
        this.id = id;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
        notifyPropertyChanged(BR.num1);
    }

    public void setNum2(int num2) {
        this.num2 = num2;
        notifyPropertyChanged(BR.num2);
    }

    public void setNum3(int num3) {
        this.num3 = num3;
        notifyPropertyChanged(BR.num3);
    }

    public void setNum4(int num4) {
        this.num4 = num4;
        notifyPropertyChanged(BR.num4);
    }

    public void setNum5(int num5) {
        this.num5 = num5;
        notifyPropertyChanged(BR.num5);
    }

    public void setNum6(int num6) {
        this.num6 = num6;
        notifyPropertyChanged(BR.num6);
    }

    @Bindable
    public int getNum1() {
        return num1;
    }

    @Bindable
    public int getNum2() {
        return num2;
    }

    @Bindable
    public int getNum3() {
        return num3;
    }

    @Bindable
    public int getNum4() {
        return num4;
    }

    @Bindable
    public int getNum5() {
        return num5;
    }

    @Bindable
    public int getNum6() {
        return num6;
    }

    public User(int num1, int num2, int num3, int num4, int num5, int num6) {
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
        this.num4 = num4;
        this.num5 = num5;
        this.num6 = num6;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", num1=" + num1 +
                ", num2=" + num2 +
                ", num3=" + num3 +
                ", num4=" + num4 +
                ", num5=" + num5 +
                ", num6=" + num6 +
                '}';
    }
}
