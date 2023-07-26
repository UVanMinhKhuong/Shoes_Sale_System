package com.example.myapplication.model;

import android.os.Build;

import java.time.LocalDateTime;

public class UserModel {
    public int id;
    public String username;
    public String password;
    public String firstName;
    public String lastName;
    public String email;
    public String phone;
    public String joinedDate;

    public UserModel(String username, String password, String email, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            this.joinedDate = LocalDateTime.now().toString();
        }
    }

    public UserModel(String username, String email, String firstName, String lastName) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}