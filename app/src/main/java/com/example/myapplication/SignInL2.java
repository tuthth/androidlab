package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SignInL2 extends AppCompatActivity implements View.OnClickListener {
    TextView lbWelcome;
    TextView lbOr;
    TextView lbSignUp;
    EditText txtName;
    EditText txtPassword;
    AppCompatButton btnSignIn;

    private final String require = "REQUIRED";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_l2);

        txtName = (EditText) findViewById(R.id.txtName);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        lbWelcome = (TextView) findViewById(R.id.lbWelcome);
        lbOr = (TextView) findViewById(R.id.lbOr);
        lbSignUp = (TextView) findViewById(R.id.lbSignUp);
        btnSignIn = (AppCompatButton) findViewById(R.id.btnSignIn);

        lbSignUp.setOnClickListener(this);
        btnSignIn.setOnClickListener(this);
    }
    private boolean checkInput(){
        if(TextUtils.isEmpty(txtName.getText().toString())){
            txtName.setError(require);
            return false;
        }
        if(TextUtils.isEmpty(txtPassword.getText().toString())){
            txtPassword.setError(require);
            return false;
        }
        return true;
    }
    private void signIn(){
        if(!checkInput()){
            return;
        }
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    private void signUp(){
        Intent intent = new Intent(this, SignUpL2.class);
        startActivity(intent);
        finish();
    }
    @Override
    public void onClick(View v){
        if (v.getId() == R.id.btnSignIn) {
            signIn();
        } else if (v.getId() == R.id.lbSignUp) {
            signUp();
        }
    }

}