package com.example.myapplication.Lab2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.util.Random;

public class MainActivity_Lab2_1 extends AppCompatActivity {

    EditText min, max;
    Button button;
    TextView result;
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_lab2_1);

        // Ánh xạ
        min = findViewById(R.id.editTextNumberMin);
        max = findViewById(R.id.editTextNumberMax);
        button = findViewById(R.id.button);
        result = findViewById(R.id.textViewResult);

        button.setOnClickListener(view -> {
            try {
                int minValue = Integer.parseInt(min.getText().toString());
                int maxValue = Integer.parseInt(max.getText().toString());
                if (minValue >= maxValue) {
                    result.setText("Min phải nhỏ hơn Max! ");
                } else {
                    int randomNumber = random.nextInt((maxValue - minValue) + 1) + minValue;
                    result.setText("Kết quả: " + randomNumber);
                }
            } catch (NumberFormatException e) {
                result.setText("");
                Toast.makeText(this, "Vui lòng nhập số hợp lệ!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}