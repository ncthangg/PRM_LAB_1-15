package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private CommentDialog DemoDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab6a);
    }
    public  boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return  super.onCreateOptionsMenu(menu);
    }
    public void goodBye(View view){
        switch ((view.getId())){
            case R.id.btnAdd:
                DialogFragment commentDialog= CommentDialog.newInstance();
                commentDialog.show(getSupportFragmentManager(), "commentDialog");
                break;

        }
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){
            case R.id.Exit:
                finishAffinity();
                break;
        }
        return  super.onOptionsItemSelected(item);
    }
}