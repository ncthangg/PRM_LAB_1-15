package com.example.myapplication.Lab2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class MainActivity_Lab2_2 extends AppCompatActivity {

    EditText textNumber1, textNumber2;
    Button btnAdd, btnSubtract, btnMultiply, btnDivide;
    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_lab2_2);

        textNumber1 = findViewById(R.id.txt1);
        textNumber2 = findViewById(R.id.txt2);
        btnAdd = findViewById(R.id.buttonAdd);
        btnSubtract = findViewById(R.id.buttonSubtract);
        btnMultiply = findViewById(R.id.buttonMultiply);
        btnDivide = findViewById(R.id.buttonDivide);
        textResult = findViewById(R.id.txtResult);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult("add");
            }
        });

        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult("subtract");
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult("multiply");
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult("divide");
            }
        });
    }

    private void calculateResult(String operation) {
        String num1Str = textNumber1.getText().toString();
        String num2Str = textNumber2.getText().toString();

        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ số!", Toast.LENGTH_SHORT).show();
            return;
        }

        double num1 = Double.parseDouble(num1Str);
        double num2 = Double.parseDouble(num2Str);
        double result = 0;

        switch (operation) {
            case "add":
                result = num1 + num2;
                break;
            case "subtract":
                result = num1 - num2;
                break;
            case "multiply":
                result = num1 * num2;
                break;
            case "divide":
                if (num2 == 0) {
                    Toast.makeText(this, "Không thể chia cho 0!", Toast.LENGTH_SHORT).show();
                    return;
                }
                result = num1 / num2;
                break;
            default:
                Toast.makeText(this, "Vui lòng chọn phép toán!", Toast.LENGTH_SHORT).show();
                return;
        }

        textResult.setText(result+ "");
    }
}