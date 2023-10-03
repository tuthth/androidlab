package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CalculatorL2 extends AppCompatActivity {
    EditText txtNumber1;
    EditText txtNumber2;
    EditText txtResultNumber;
    Button btnAdd;
    Button btnSubtract;
    Button btnMultiply;
    Button btnDivide;
    Button btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_l2);

        txtNumber1 = (EditText) findViewById(R.id.txtNumber1);
        txtNumber2 = (EditText) findViewById(R.id.txtNumber2);
        txtResultNumber = (EditText) findViewById(R.id.txtResultNumber);
        txtResultNumber.setClickable(false);
        txtResultNumber.setFocusable(false);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSubtract = (Button) findViewById(R.id.btnSubtract);
        btnMultiply = (Button) findViewById(R.id.btnMultiply);
        btnDivide = (Button) findViewById(R.id.btnDivide);
        btnClear = (Button) findViewById(R.id.btnClear);

        btnClear.setOnClickListener(view -> {
            txtNumber1.setText("");
            txtNumber2.setText("");
            txtResultNumber.setText("");
        });
        btnAdd.setOnClickListener(view -> {
            int number1 = Integer.parseInt(txtNumber1.getText().toString());
            int number2 = Integer.parseInt(txtNumber2.getText().toString());

            int result = number1 + number2;
            txtResultNumber.setText(String.valueOf(result));
        });
        btnSubtract.setOnClickListener(view -> {
            int number1 = Integer.parseInt(txtNumber1.getText().toString());
            int number2 = Integer.parseInt(txtNumber2.getText().toString());

            int result = number1 - number2;
            txtResultNumber.setText(String.valueOf(result));
        });
        btnMultiply.setOnClickListener(view -> {
            int number1 = Integer.parseInt(txtNumber1.getText().toString());
            int number2 = Integer.parseInt(txtNumber2.getText().toString());

            double result = number1 * number2;
            txtResultNumber.setText(String.valueOf(result));
        });
        btnDivide.setOnClickListener(view -> {
            int number1 = Integer.parseInt(txtNumber1.getText().toString());
            int number2 = Integer.parseInt(txtNumber2.getText().toString());

            if(number2 == 0){
                Toast.makeText(getApplicationContext(), "Cannot divide by zero", Toast.LENGTH_SHORT).show();
            }else{
                double result = (double)number1 / (double)number2;
                txtResultNumber.setText(String.valueOf(result));
            }
        });

    }
}