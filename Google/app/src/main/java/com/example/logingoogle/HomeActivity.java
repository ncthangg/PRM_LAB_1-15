package com.example.logingoogle;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.Properties;
import java.util.Random;
import java.util.concurrent.Executors;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = "GoogleSignIn";
    private GoogleSignInClient mGoogleSignInClient;
    private Button btnSignOut;
    private Button btnChangePassword;


    // Lưu OTP tạm thời
    public static String generatedOTP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Get user data from Intent
        Intent intent = getIntent();
        String userId = intent.getStringExtra("ID");
        String userName = intent.getStringExtra("DISPLAY_NAME");
        String userEmail = intent.getStringExtra("EMAIL");
        String profilePicUrl = intent.getStringExtra("PROFILE_PICTURE");

        // Logging received data
        Log.d(TAG, "------------------ Google Sign-In Data ------------------");
        Log.d(TAG, "ID: " + userId);
        Log.d(TAG, "Display Name: " + userName);
        Log.d(TAG, "Email: " + userEmail);
        Log.d(TAG, "Profile Picture: " + profilePicUrl);
        Log.d(TAG, "-------------------------------------------------------");

        // Set user data in UI
        TextView txtName = findViewById(R.id.txtName);
        TextView txtEmail = findViewById(R.id.txtEmail);
        ImageView imgProfile = findViewById(R.id.imgProfile);
        btnSignOut = findViewById(R.id.btnSignOut);
        btnChangePassword = findViewById(R.id.btnChangePassword);

        txtName.setText(userName);
        txtEmail.setText(userEmail);

        // Load profile picture using Glide (if available)
        if (profilePicUrl != null && !profilePicUrl.isEmpty()) {
            Glide.with(this).load(profilePicUrl).into(imgProfile);
        }

        // Configure Google Sign-In Client
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        // Set sign-out button click listener
        btnSignOut.setOnClickListener(v -> signOut());

        // Set change-password button click listener
        btnChangePassword.setOnClickListener(v -> changePassword(userEmail));

    }
    private void changePassword(String userEmail){
        String email = userEmail;
        if (email.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập email!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Generate OTP (6 số)
        generatedOTP = Lib.generateOTP();

        // Gửi OTP qua Email
        Lib.sendOTPEmail(this, email, generatedOTP);

        // Chuyển sang màn hình ResetPasswordActivity
        Intent intent = getIntent();
        intent = new Intent(this, ResetPasswordActivity.class);
        intent.putExtra("email", email);
        startActivity(intent);
    }


    // Sign-Out Method
    private void signOut() {
        mGoogleSignInClient.signOut().addOnCompleteListener(this, task -> {
            Toast.makeText(HomeActivity.this, "Đăng xuất thành công!", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "User signed out.");

            // Redirect to MainActivity after logout
            Intent intent = new Intent(HomeActivity.this, MainActivity.class);
            startActivity(intent);
            finish(); // Close HomeActivity
        });
    }




}

