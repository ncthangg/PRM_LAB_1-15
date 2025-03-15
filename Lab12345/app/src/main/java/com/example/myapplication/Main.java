package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Lab1.MainActivity;
import com.example.myapplication.Lab1.MainActivity1;
import com.example.myapplication.Lab1.MainActivity2;
import com.example.myapplication.Lab1.MainActivity3;
import com.example.myapplication.Lab2.MainActivity_Lab2_1;
import com.example.myapplication.Lab2.MainActivity_Lab2_2;
import com.example.myapplication.Lab2.SignInActivity;
import com.example.myapplication.Lab3.MainActivity_Lab3_1;
import com.example.myapplication.Lab3.MainActivity_Lab3_2;
import com.example.myapplication.Lab3.MainActivity_Lab3_3;
import com.example.myapplication.Lab4.MainActivity_Lab4;
import com.example.myapplication.Lab5.Ex1.MainActivity_Lab5_1;
import com.example.myapplication.Lab5.Ex2.MainActivity_Lab5_2;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button btnToActivity1 = findViewById(R.id.btn_to_activity1);
        Button btnToActivity2 = findViewById(R.id.btn_to_activity2);
        Button btnToRelativeLayout = findViewById(R.id.btn_to_RelativeLayout);
        Button btnToConstrainLayout = findViewById(R.id.btn_to_ConstrainLayout);
        Button btnToRandomNumber = findViewById(R.id.btn_to_RandomNumber);
        Button btnToMathCalculator = findViewById(R.id.btn_to_MathCalculator);
        Button btnToSignInSignUp = findViewById(R.id.btn_to_SignInSignUp);
        Button btnToListView = findViewById(R.id.btn_to_ListView);
        Button btnToFootballerListView = findViewById(R.id.btn_to_FootballerListView);
        Button btnToFruitListView = findViewById(R.id.btn_to_FootballerListView2);
        Button btnToLab4 = findViewById(R.id.btn_to_Lab4);
        Button btnToLab5_1 = findViewById(R.id.btn_to_Lab5_1);
        Button btnToLab5_2 = findViewById(R.id.btn_to_Lab5_2);
        // Chuyển đến Activity1
        btnToActivity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Chuyển đến Activity2
        btnToActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main.this, MainActivity1.class);
                startActivity(intent);
            }
        });

        btnToRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        btnToConstrainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main.this, MainActivity3.class);
                startActivity(intent);
            }
        });

        btnToRandomNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main.this, MainActivity_Lab2_1.class);
                startActivity(intent);
            }
        });

        btnToMathCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main.this, MainActivity_Lab2_2.class);
                startActivity(intent);
            }
        });
        btnToSignInSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main.this, SignInActivity.class);
                startActivity(intent);
            }
        });

        btnToListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main.this, MainActivity_Lab3_1.class);
                startActivity(intent);
            }
        });

        btnToFootballerListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main.this, MainActivity_Lab3_2.class);
                startActivity(intent);
            }
        });

        btnToFruitListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main.this, MainActivity_Lab3_3.class);
                startActivity(intent);
            }
        });
        btnToLab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main.this, MainActivity_Lab4.class);
                startActivity(intent);
            }
        });
        btnToLab5_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main.this, MainActivity_Lab5_1.class);
                startActivity(intent);
            }
        });
        btnToLab5_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main.this, MainActivity_Lab5_2.class);
                startActivity(intent);
            }
        });
    }
}