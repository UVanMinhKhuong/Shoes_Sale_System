package com.example.myapplication.activity.user;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.model.UserModel;
import com.example.myapplication.service.UserService;
import com.example.myapplication.utility.BCryptUtil;

public class RegisterActivity extends AppCompatActivity {
    private UserService userService;
    private EditText edtUsername, edtPassword, edtEmail, edtFirstName, edtLastName;
    private TextView txtLogin;
    private Button btnRegister;

    public RegisterActivity() {
        this.userService = new UserService(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_register_activity);

        btnRegister = findViewById(R.id.btnRegister);
        txtLogin = findViewById(R.id.txtLogin);

        edtUsername = findViewById(R.id.editTextUsername);
        edtPassword = findViewById(R.id.editTextPassword);
        edtEmail = findViewById(R.id.editTextEmail);
        edtFirstName = findViewById(R.id.editTextFirstName);
        edtLastName = findViewById(R.id.editTextLastName);

        btnRegister.setOnClickListener(view -> {
            String password = edtPassword.getText().toString();
            String passwordDecode = BCryptUtil.decodePassword(password);

            UserModel user = new UserModel(edtUsername.getText().toString(),
                    passwordDecode,
                    edtEmail.getText().toString(),
                    edtFirstName.getText().toString(),
                    edtLastName.getText().toString()
            );
            long userId = userService.insert(user);
            Toast.makeText(RegisterActivity.this, String.format("The user has been created with id is %s", userId), Toast.LENGTH_LONG).show();

            startToLoginActivity();
        });

        txtLogin.setOnClickListener(view -> {
            startToLoginActivity();
        });

    }

    void startToLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
