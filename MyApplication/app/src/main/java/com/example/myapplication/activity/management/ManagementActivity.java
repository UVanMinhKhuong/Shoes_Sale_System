package com.example.myapplication.activity.management;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.activity.category.CategoryActivity;
import com.example.myapplication.activity.product.ProductActivity;
import com.example.myapplication.activity.user.BaseActivity;
import com.example.myapplication.activity.user.LoginActivity;
import com.example.myapplication.constant.SharedPreference;

public class ManagementActivity extends BaseActivity {
    LinearLayout categoryItem, productItem, userItem;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.management_activity);

        super.preCheckUserSigned();

        categoryItem = findViewById(R.id.layoutCategory);
        productItem = findViewById(R.id.layoutProduct);
        userItem = findViewById(R.id.layoutUser);


        categoryItem.setOnClickListener(view -> {
            Intent intent = new Intent(ManagementActivity.this, CategoryActivity.class);
            startActivity(intent);
        });

        productItem.setOnClickListener(view -> {
            Intent intent = new Intent(ManagementActivity.this, ProductActivity.class);
            startActivity(intent);
        });

        userItem.setOnClickListener(view -> {
            Toast.makeText(ManagementActivity.this, "Click user!", Toast.LENGTH_SHORT).show();
        });

    }
}
