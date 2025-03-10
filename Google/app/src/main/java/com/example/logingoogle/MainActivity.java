package com.example.logingoogle;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class MainActivity extends AppCompatActivity {

    private static final int RC_SIGN_IN = 9001;
    private GoogleSignInClient mGoogleSignInClient;
    private static final String TAG = "GoogleSignIn";

    private Button btnGoogleSignIn, btnGoogleSignOut;
    private Button btnForgotPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Configure Google Sign-In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        // Initialize UI elements
        btnGoogleSignIn = findViewById(R.id.btnGoogleSignIn);
        btnGoogleSignOut = findViewById(R.id.btnGoogleSignOut);
        btnForgotPassword = findViewById(R.id.btnForgotPassword);

        // Check if the user is already signed in
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        if (account != null) {
            updateUI(true);
        } else {
            updateUI(false);
        }

        btnGoogleSignIn.setOnClickListener(v -> signIn());
        btnGoogleSignOut.setOnClickListener(v -> signOut());
        btnForgotPassword.setOnClickListener(v -> forgotPassword());
    }


    private void forgotPassword() {
        Intent intent = new Intent(this, ForgotPasswordActivity.class);
        startActivity(intent);
    }

    // Method to sign in
    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    // Method to sign out
    private void signOut() {
        mGoogleSignInClient.signOut().addOnCompleteListener(this, task -> {
            Toast.makeText(MainActivity.this, "Đăng xuất thành công!", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "User signed out.");
            updateUI(false);
        });
    }

    // Method to revoke access (completely remove account association)
    private void revokeAccess() {
        mGoogleSignInClient.revokeAccess().addOnCompleteListener(this, task -> {
            Toast.makeText(MainActivity.this, "Tài khoản đã bị xóa khỏi ứng dụng!", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "Access revoked.");
            updateUI(false);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                GoogleSignInAccount account = task.getResult(ApiException.class);
                if (account != null) {
                    Log.d(TAG, "------------------ Google Sign-In Data ------------------");
                    Log.d(TAG, "ID: " + account.getId());
                    Log.d(TAG, "Display Name: " + account.getDisplayName());
                    Log.d(TAG, "Email: " + account.getEmail());
                    Log.d(TAG, "Profile Picture: " + (account.getPhotoUrl() != null ? account.getPhotoUrl().toString() : "No Profile Picture"));
                    Log.d(TAG, "-------------------------------------------------------");

                    // Navigate to HomeActivity and pass data
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    intent.putExtra("ID", account.getId());
                    intent.putExtra("DISPLAY_NAME", account.getDisplayName());
                    intent.putExtra("EMAIL", account.getEmail());
                    intent.putExtra("PROFILE_PICTURE", account.getPhotoUrl() != null ? account.getPhotoUrl().toString() : "");                   startActivity(intent);
                    finish(); // Close MainActivity
                }
            } catch (ApiException e) {
                Log.e(TAG, "Đăng nhập thất bại! Mã lỗi: " + e.getStatusCode());
                Toast.makeText(this, "Đăng nhập thất bại! Lỗi: " + e.getStatusCode(), Toast.LENGTH_LONG).show();
            }
        }
    }


    // Method to update UI based on login status
    private void updateUI(boolean isSignedIn) {
        if (isSignedIn) {
            btnGoogleSignIn.setVisibility(View.GONE);
            btnGoogleSignOut.setVisibility(View.VISIBLE);
        } else {
            btnGoogleSignIn.setVisibility(View.VISIBLE);
            btnGoogleSignOut.setVisibility(View.GONE);
        }
    }
}
