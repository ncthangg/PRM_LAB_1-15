package com.example.myapplication.Lab6.MenuPopup;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class MainActivity_Lab6c extends AppCompatActivity {
Button btnMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab6c);
        btnMenu = (Button) findViewById(R.id.buttonMenu);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowMenu();
            }
        });
    }

    private  void ShowMenu(){
        PopupMenu popupMenu = new PopupMenu(this,btnMenu);
        popupMenu.getMenuInflater().inflate(R.menu.menu_popup,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                int id = menuItem.getItemId();

                if (id == R.id.menuThem) {
                    btnMenu.setText("Menu Them");
                } else if (id == R.id.menuSua) {
                    btnMenu.setText("Menu Sua");
                } else if (id == R.id.menuXoa) {
                    btnMenu.setText("Menu Xoa");
                }

                return false;
            }

        });
        popupMenu.show();
    }
}