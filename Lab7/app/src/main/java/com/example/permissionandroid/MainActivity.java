package com.example.permissionandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_PERMISSIONS_CODE = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnrequestpermission = findViewById(R.id.btn_request_permission);
        Button btnopensettingpermission = findViewById(R.id.btn_open_settings_permission);

        btnrequestpermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickRequestPermission();
            }
        });


        btnopensettingpermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickRequestPermission();
            }
        });

    }

    private void ClickRequestPermission() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return;
        }
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Permisson Granted", Toast.LENGTH_SHORT).show();
        } else {
            String permissions = (Manifest.permission.ACCESS_FINE_LOCATION);
            requestPermissions(new String[]{permissions}, REQUEST_PERMISSIONS_CODE);

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSIONS_CODE){
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this,"Permisson Granted", Toast.LENGTH_SHORT).show();

            }else {
                Toast.makeText(this,"Permisson Denied", Toast.LENGTH_SHORT).show();
            }
        }

    }
}