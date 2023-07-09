package com.example.myapplication.service;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.model.UserModel;
import com.example.myapplication.repository.DatabaseContext;

public class UserService extends DatabaseContext {
    public UserService(Context context) {
        super(context);
    }

    public long insert(UserModel user) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("USERNAME", user.username);
        contentValues.put("PASSWORD", user.password);
        contentValues.put("FIRST_NAME", user.firstName);
        contentValues.put("LAST_NAME", user.lastName);
        contentValues.put("EMAIL", user.email);
        contentValues.put("JOINED_DATE", user.joinedDate);

        long userId = sqLiteDatabase.insert("USER", null, contentValues);
        sqLiteDatabase.close();
        return userId;
    }

    public UserModel findByUserId(long userId) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT username, email, first_name, last_name from USER WHERE ID = ?", new String[]{String.valueOf(userId)});
        UserModel user = null;
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String username = cursor.getString(0);
            String email = cursor.getString(1);
            String firstName = cursor.getString(2);
            String lastName = cursor.getString(3);
            user = new UserModel(username, email, firstName, lastName);
        }
        cursor.close();

        return user;
    }

    public UserModel findByUsernameAndPassword(String username) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT username, password, email, first_name, last_name from USER WHERE USERNAME = ?", new String[]{username});
        UserModel user = null;
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            username = cursor.getString(0);
            String password = cursor.getString(1);
            String email = cursor.getString(2);
            String firstName = cursor.getString(3);
            String lastName = cursor.getString(4);
            user = new UserModel(username, password, email, firstName, lastName);
            break;
        }
        cursor.close();

        return user;
    }
}
