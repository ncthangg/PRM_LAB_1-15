package com.example.myapplication.Lab2;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class SignUpActivity extends AppCompatActivity {

    private static final CharSequence REQUIRE = "Không được để trống";
    EditText etUserName, etPassword, etConfirmPassword;
    TextView tvSignIn;
    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);

        etUserName = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        tvSignIn = findViewById(R.id.tvSignin);
        btnSignUp = findViewById(R.id.btnSignup);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });

        tvSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
    }

    private boolean checkInput(){
        if(TextUtils.isEmpty(etUserName.getText().toString())){
            etUserName.setError(REQUIRE);
            return false;
        }

        if(TextUtils.isEmpty(etPassword.getText().toString())){
            etPassword.setError(REQUIRE);
            return false;
        }

        if(TextUtils.isEmpty(etConfirmPassword.getText().toString())){
            etConfirmPassword.setError(REQUIRE);
            return false;
        }

        if(!TextUtils.equals(etPassword.getText().toString(), etConfirmPassword.getText().toString()) ){
            Toast.makeText(this, "Password are not match", Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }

    private void signUp(){
        if(!checkInput()){
            return;
        }
        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Account Created", Toast.LENGTH_LONG).show();
        finish();
    }

    private void signIn(){

        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
        finish();
    }

}