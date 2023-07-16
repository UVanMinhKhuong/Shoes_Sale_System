package com.example.myapplication.activity.user;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.constant.SharedPreference;
import com.example.myapplication.model.UserModel;
import com.example.myapplication.service.UserService;
import com.example.myapplication.utility.BCryptUtil;


import java.util.Objects;

public class LoginActivity extends AppCompatActivity {
    private UserService userService;

    private Button btnLogin;
    private EditText edtUsername, edtPassword;
    private TextView txtRegister;

    public LoginActivity() {
        this.userService = new UserService(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_login_activity);

        txtRegister = findViewById(R.id.txtRegister);
        btnLogin = findViewById(R.id.btnLogin);

        edtUsername = findViewById(R.id.editTextName);
        edtPassword = findViewById(R.id.editTextPassword);

        btnLogin.setOnClickListener(view -> {
            String username = edtUsername.getText().toString();
            String password = edtPassword.getText().toString();

            UserModel user = userService.findByUsernameAndPassword(username);
            if (Objects.isNull(user)) {
                Toast.makeText(LoginActivity.this, "Username or password is incorrect!", Toast.LENGTH_SHORT).show();
            } else {
                // Check password is correct
                boolean isCorrectPassword = BCryptUtil.verifyPassword(user.password, password);
                if (isCorrectPassword) {
                    // Step to work shared preferences
                    //1. Create a new shared preferences object
                    SharedPreferences sharedPreferences = getSharedPreferences(SharedPreference.USER_SESSION, MODE_PRIVATE);
                    //2. Create a new editor by shared preferences object
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    //3. Save to shared preference
                    editor.putString("Username", user.username);
                    //4. Confirm to save data to shared preference
                    editor.commit();

                    Toast.makeText(LoginActivity.this, "Login success.", Toast.LENGTH_LONG).show();
                    switchToSuccess(user);
                } else {
                    Toast.makeText(LoginActivity.this, "Username or password is incorrect!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        txtRegister.setOnClickListener(view -> {
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        });

    }

    private void switchToSuccess(UserModel userModel) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("email", userModel.email);
        startActivity(intent);
    }
}
