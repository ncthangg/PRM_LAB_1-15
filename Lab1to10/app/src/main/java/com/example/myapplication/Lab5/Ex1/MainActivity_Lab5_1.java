package com.example.myapplication.Lab5.Ex1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Lab5.Ex1.Adapter.UserAdapter;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity_Lab5_1 extends AppCompatActivity {
    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private List<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lab5_1);

        userList = new ArrayList<>();
        initializeDefaultUsers();

        recyclerView = findViewById(R.id.recyclerView);
        userAdapter = new UserAdapter(userList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(userAdapter);

    }

    private void initializeDefaultUsers() {
        userList.add(new User("user1", "Tí", "something@ftp.edu.vn"));
        userList.add(new User("user2", "Tèo", "something@ftp.edu.vn"));
        userList.add(new User("user3", "Tùng", "something@ftp.edu.vn"));
        userList.add(new User("user4", "Toàn", "something@ftp.edu.vn"));
        userList.add(new User("user5", "Tín", "something@ftp.edu.vn"));
        userList.add(new User("user6", "Tủn", "something@ftp.edu.vn"));
    }
}
