package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnConstraint, btnFacebook, btnInstagram, btnRandom, btnCalculate, btnSignInForm, btnListView, btnCustomListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnConstraint = findViewById(R.id.btnConstraint);
        btnFacebook = findViewById(R.id.btnFacebook);
        btnInstagram = findViewById(R.id.btnInstagram);
        btnRandom = findViewById(R.id.btnRandom);
        btnCalculate = findViewById(R.id.btnCalculate);
        btnSignInForm = findViewById(R.id.btnSignInForm);
        btnListView = findViewById(R.id.btnListView);
        btnCustomListView = findViewById(R.id.btnCustomListView);

        btnConstraint.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ConstraintLayoutL1.class);
            startActivity(intent);
        });


        btnFacebook.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, FacebookL1.class);
            startActivity(intent);
        });

        btnInstagram.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, InstagramL1.class);
            startActivity(intent);
        });

        btnRandom.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, RandomL2.class);
            startActivity(intent);
        });

        btnCalculate.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, CalculatorL2.class);
            startActivity(intent);
        });
        btnSignInForm.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SignInL2.class);
            startActivity(intent);
        });
        btnListView.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ListViewL3.class);
            startActivity(intent);
        });
        btnCustomListView.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, CustomListViewL3.class);
            startActivity(intent);
        });

    }
}