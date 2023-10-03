package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.widget.EditText;

import java.util.Random;

public class RandomL2 extends AppCompatActivity {
    EditText txtStartNumber;
    EditText txtEndNumber;
    EditText txtResultNumber;
    AppCompatButton btnGenerate;
    AppCompatButton btnClear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_l2);

        txtStartNumber = (EditText) findViewById(R.id.txtStartNumber);
        txtEndNumber = (EditText) findViewById(R.id.txtEndNumber);
        txtResultNumber = (EditText) findViewById(R.id.txtResultNumber);
        txtResultNumber.setFocusable(false);
        txtResultNumber.setClickable(false);

        btnClear = findViewById(R.id.btnClear);
        btnClear.setOnClickListener(view -> {
            txtStartNumber.setText("");
            txtEndNumber.setText("");
            txtResultNumber.setText("");
        });
        btnGenerate = findViewById(R.id.btnGenerate);
        btnGenerate.setOnClickListener(view -> {

            try {
                int startNumber = Integer.parseInt(txtStartNumber.getText().toString());
                int endNumber = Integer.parseInt(txtEndNumber.getText().toString());

                if (startNumber <= endNumber) {
                    Random random = new Random();
                    int result = random.nextInt(endNumber - startNumber + 1) + startNumber;
                    txtResultNumber.setText(String.valueOf(result));
                } else {

                    txtResultNumber.setText("Invalid range");
                }
            } catch (NumberFormatException e) {

                txtResultNumber.setText("Invalid input");
            }
        });
    }

}