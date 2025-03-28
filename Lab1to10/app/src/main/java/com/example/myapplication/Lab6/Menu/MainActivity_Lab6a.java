package com.example.myapplication.Lab6.Menu;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.example.myapplication.R;

public class MainActivity_Lab6a extends AppCompatActivity {

    private CommentDialog DemoDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab6a);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    public void goodBye(View view){
        Log.d("DEBUG", "Button clicked!"); // Kiểm tra xem sự kiện có xảy ra không

        if (view.getId() == R.id.btnAdd) {
            Log.d("DEBUG", "Opening Dialog...");
            DialogFragment commentDialog = CommentDialog.newInstance();
            commentDialog.show(getSupportFragmentManager(), "commentDialog");
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.btnAdd) {
            Log.d("DEBUG", "Opening Dialog...");
            DialogFragment commentDialog = CommentDialog.newInstance();
            commentDialog.show(getSupportFragmentManager(), "commentDialog");
        }

        if (item.getItemId() == R.id.Exit) {
            finishAffinity(); // Đóng toàn bộ ứng dụng
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}