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
import com.example.myapplication.Lab11.MainActivity_Lab11;
import com.example.myapplication.Lab11.TraineeListActivity;
import com.example.myapplication.Lab2.MainActivity_Lab2_1;
import com.example.myapplication.Lab2.MainActivity_Lab2_2;
import com.example.myapplication.Lab2.SignInActivity;
import com.example.myapplication.Lab3.MainActivity_Lab3_1;
import com.example.myapplication.Lab3.MainActivity_Lab3_2;
import com.example.myapplication.Lab3.MainActivity_Lab3_3;
import com.example.myapplication.Lab4.MainActivity_Lab4;
import com.example.myapplication.Lab5.Ex1.MainActivity_Lab5_1;
import com.example.myapplication.Lab5.Ex2.MainActivity_Lab5_2;
import com.example.myapplication.Lab6.Menu.MainActivity_Lab6a;
import com.example.myapplication.Lab6.MenuContext.MainActivity_Lab6b;
import com.example.myapplication.Lab6.MenuPopup.MainActivity_Lab6c;
import com.example.myapplication.Lab7.MainActivity_Lab7;
import com.example.myapplication.Lab8.MainActivity_Lab8;
import com.example.myapplication.Lab9.MainActivity_Lab9;

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
        Button btnToLab6a = findViewById(R.id.btn_to_Lab6a);
        Button btnToLab6b = findViewById(R.id.btn_to_Lab6b);
        Button btnToLab6c = findViewById(R.id.btn_to_Lab6c);
        Button btnToLab7 = findViewById(R.id.btn_to_Lab7);
        Button btnToLab8 = findViewById(R.id.btn_to_Lab8);
        Button btnToLab9 = findViewById(R.id.btn_to_Lab9);
        Button btnToLab11 = findViewById(R.id.btn_to_Lab11);
        Button btnToLab11List = findViewById(R.id.btn_to_Lab11List);


        btnToActivity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main.this, MainActivity.class);
                startActivity(intent);
            }
        });
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
        btnToLab6a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main.this, MainActivity_Lab6a.class);
                startActivity(intent);
            }
        });
        btnToLab6b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main.this, MainActivity_Lab6b.class);
                startActivity(intent);
            }
        });
        btnToLab6c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main.this, MainActivity_Lab6c.class);
                startActivity(intent);
            }
        });
        btnToLab7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main.this, MainActivity_Lab7.class);
                startActivity(intent);
            }
        });
        btnToLab8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main.this, MainActivity_Lab8.class);
                startActivity(intent);
            }
        });
        btnToLab9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main.this, MainActivity_Lab9.class);
                startActivity(intent);
            }
        });
        btnToLab11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main.this, MainActivity_Lab11.class);
                startActivity(intent);
            }
        });
        btnToLab11List.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main.this, TraineeListActivity.class);
                startActivity(intent);
            }
        });
    }
}