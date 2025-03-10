package com.example.sqltest;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnShowUsers;
    ListView listViewUsers;
    ArrayList<String> usersList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnShowUsers = findViewById(R.id.btnShowUsers);
        listViewUsers = findViewById(R.id.listViewUsers);

        usersList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, usersList);
        listViewUsers.setAdapter(adapter);

        btnShowUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new LoadUsersTask().execute();
            }
        });

    }

    // AsyncTask để load dữ liệu từ SQL Server
    private class LoadUsersTask extends AsyncTask<Void, Void, ArrayList<String>> {
        @Override
        protected ArrayList<String> doInBackground(Void... voids) {
            ArrayList<String> list = new ArrayList<>();
            try {
                Class.forName("net.sourceforge.jtds.jdbc.Driver");
                Connection conn = SQLServerConnection.getConnection();
                if (conn != null) {
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT FullName, Email FROM Users");
                    while (rs.next()) {
                        String user = rs.getString("FullName") + " - " + rs.getString("Email");
                        list.add(user);
                    }
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return list;
        }

        @Override
        protected void onPostExecute(ArrayList<String> result) {
            if (result.isEmpty()) {
                Toast.makeText(MainActivity.this, "Không có dữ liệu!", Toast.LENGTH_SHORT).show();
            } else {
                usersList.clear();
                usersList.addAll(result);
                adapter.notifyDataSetChanged();
                listViewUsers.setVisibility(View.VISIBLE); // Hiện ListView
            }
        }
    }

}