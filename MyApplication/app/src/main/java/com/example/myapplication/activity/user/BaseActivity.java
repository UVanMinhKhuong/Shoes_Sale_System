package com.example.myapplication.activity.user;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.activity.management.ManagementActivity;
import com.example.myapplication.constant.SharedPreference;

public class BaseActivity extends AppCompatActivity {

    protected  void preCheckUserSigned(){
        SharedPreferences sharedPreferences = getSharedPreferences(SharedPreference.USER_SESSION, MODE_PRIVATE);
        // Get the user current login by username
        String usernameSession = sharedPreferences.getString("Username", null);
        if (usernameSession == null) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
    }
}
