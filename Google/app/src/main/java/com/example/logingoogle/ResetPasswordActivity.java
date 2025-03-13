package com.example.logingoogle;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ResetPasswordActivity extends AppCompatActivity {

    private EditText etOTP, etNewPassword, etConfirmPassword;
    private Button btnResetPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        etOTP = findViewById(R.id.etOTP);
        etNewPassword = findViewById(R.id.etNewPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        btnResetPassword = findViewById(R.id.btnResetPassword);

        // Ban đầu vô hiệu hóa các ô nhập mật khẩu
        etNewPassword.setEnabled(false);
        etConfirmPassword.setEnabled(false);

        // Sự kiện khi người dùng nhập OTP
        etOTP.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().equals(ForgotPasswordActivity.generatedOTP)) {
                    etNewPassword.setEnabled(true);
                    etConfirmPassword.setEnabled(true);
                } else {
                    etNewPassword.setEnabled(false);
                    etConfirmPassword.setEnabled(false);
                }
            }
        });

        btnResetPassword.setOnClickListener(v -> {
            String enteredOTP = etOTP.getText().toString().trim();
            String newPassword = etNewPassword.getText().toString().trim();
            String confirmPassword = etConfirmPassword.getText().toString().trim();

            if (!enteredOTP.equals(ForgotPasswordActivity.generatedOTP)) {
                Toast.makeText(this, "OTP không đúng!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (newPassword.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập mật khẩu mới!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!newPassword.equals(confirmPassword)) {
                Toast.makeText(this, "Mật khẩu xác nhận không khớp!", Toast.LENGTH_SHORT).show();
                return;
            }

            // Cập nhật mật khẩu thành công
            Toast.makeText(this, "Mật khẩu đã được đổi!", Toast.LENGTH_LONG).show();
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });
    }

}
