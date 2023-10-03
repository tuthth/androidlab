package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpL2 extends AppCompatActivity implements View.OnClickListener {
    TextView lbWelcome;
    EditText txtName;
    EditText txtPassword;
    EditText txtPasswordConfirm;
    TextView lbSignIn;
    AppCompatButton btnSignUp;
    private final String require = "REQUIRED";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_l2);

        lbWelcome = (TextView) findViewById(R.id.lbWelcome);
        txtName = (EditText) findViewById(R.id.txtName);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        txtPasswordConfirm = (EditText) findViewById(R.id.txtPasswordConfirm);
        lbSignIn = (TextView) findViewById(R.id.lbSignIn);
        btnSignUp = (AppCompatButton) findViewById(R.id.btnSignUp);

        lbSignIn.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);
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
        if(TextUtils.isEmpty(txtPasswordConfirm.getText().toString())){
            txtPasswordConfirm.setError(require);
            return false;
        }
        if(!TextUtils.equals(txtPassword.getText().toString(), txtPasswordConfirm.getText().toString())){
            Toast.makeText(this, "Password does not match", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
    private void signUp(){
        if(checkInput()){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Sign up success", Toast.LENGTH_LONG).show();
            finish();
        }else return;
    }
    private void signInForm(){
        Intent intent = new Intent(this, SignInL2.class);
        startActivity(intent);
        finish();
    }
    @Override
    public void onClick(View v){
        if (v.getId() == R.id.lbSignIn) {
            signInForm();
        } else if (v.getId() == R.id.btnSignUp) {
            signUp();
        }
    }
}