package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvShoes;
    ArrayList<Shoes> arrayShoes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvShoes = (ListView) findViewById(R.id.listViewShoes);
        arrayShoes = new ArrayList<Shoes>();

        arrayShoes.add(new Shoes("Nike", 200000, R.drawable.giay1));
        arrayShoes.add(new Shoes("Adidas", 500000, R.drawable.giay2));
        arrayShoes.add(new Shoes("Puma", 2200000, R.drawable.giay3));
        arrayShoes.add(new Shoes("Thượng Đình", 100000, R.drawable.giay4));
        arrayShoes.add(new Shoes("Jordan", 20000000, R.drawable.giay5));
        arrayShoes.add(new Shoes("Nike Đen", 500000, R.drawable.giay6));

        ShoesAdapter anAdapter = new ShoesAdapter(
                MainActivity.this,
                R.layout.shoes_custom,
                arrayShoes
        );

        lvShoes.setAdapter(anAdapter);
    }
}