package com.example.myapplication.Lab6.MenuContext;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.myapplication.R;

public class MainActivity_Lab6b extends AppCompatActivity {
Button btnChonmau;
ConstraintLayout manHinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab6b);

        btnChonmau = (Button) findViewById(R.id.button_Chonmau);
        manHinh = (ConstraintLayout) findViewById(R.id.manHinh);

        registerForContextMenu(btnChonmau);

        // Khi bấm nút, menu sẽ hiển thị
        btnChonmau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openContextMenu(v);
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_context, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menuDo) {
            manHinh.setBackgroundColor(Color.RED);
            return true;
        } else if (id == R.id.menuVang) {
            manHinh.setBackgroundColor(Color.YELLOW);
            return true;
        } else if (id == R.id.menuXanh) {
            manHinh.setBackgroundColor(Color.BLUE);
            return true;
        }
        return super.onContextItemSelected(item);
    }
}