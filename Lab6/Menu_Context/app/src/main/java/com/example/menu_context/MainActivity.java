package com.example.menu_context;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button btnChonmau;
ConstraintLayout manHinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnChonmau = (Button) findViewById(R.id.button_Chonmau);
        manHinh = (ConstraintLayout) findViewById(R.id.manHinh);

        registerForContextMenu(btnChonmau);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_context,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuDo:  manHinh.setBackgroundColor(Color.RED);
            break;
            case R.id.menuVang:  manHinh.setBackgroundColor(Color.YELLOW);
                break;
            case R.id.menuXanh:  manHinh.setBackgroundColor(Color.BLUE);
                break;

        }
        return super.onContextItemSelected(item);
    }
}