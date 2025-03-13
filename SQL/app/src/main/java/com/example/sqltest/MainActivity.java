package com.example.sqltest;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnShowUsers, btnAddUser, btnUpdateUser, btnDeleteUser;
    ListView listViewUsers;
    EditText edtFullName, edtEmail;
    ArrayList<String> usersList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnShowUsers = findViewById(R.id.btnShowUsers);
        btnAddUser = findViewById(R.id.btnAddUser);
        btnUpdateUser = findViewById(R.id.btnUpdateUser);
        btnDeleteUser = findViewById(R.id.btnDeleteUser);
        listViewUsers = findViewById(R.id.listViewUsers);
        edtFullName = findViewById(R.id.edtFullName);
        edtEmail = findViewById(R.id.edtEmail);

        usersList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, usersList);
        listViewUsers.setAdapter(adapter);

        btnShowUsers.setOnClickListener(v -> new LoadUsersTask().execute());
        btnAddUser.setOnClickListener(v -> new AddUserTask().execute(edtFullName.getText().toString(), edtEmail.getText().toString()));
        btnUpdateUser.setOnClickListener(v -> new UpdateUserTask().execute(edtFullName.getText().toString(), edtEmail.getText().toString()));
        btnDeleteUser.setOnClickListener(v -> new DeleteUserTask().execute(edtEmail.getText().toString()));

    }

    // Lấy danh sách User
    private class LoadUsersTask extends AsyncTask<Void, Void, ArrayList<String>> {
        @Override
        protected ArrayList<String> doInBackground(Void... voids) {
            ArrayList<String> list = new ArrayList<>();
            try {
                Class.forName("net.sourceforge.jtds.jdbc.Driver");
                Connection conn = SQLServerConnection.getConnection();
                if (conn != null) {
                    ResultSet rs = conn.createStatement().executeQuery("SELECT FullName, Email FROM Users");
                    while (rs.next()) {
                        list.add(rs.getString("FullName") + " - " + rs.getString("Email"));
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
            usersList.clear();
            usersList.addAll(result);
            adapter.notifyDataSetChanged();
            listViewUsers.setVisibility(View.VISIBLE);
        }
    }

    // Thêm User
    private class AddUserTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            try {
                Class.forName("net.sourceforge.jtds.jdbc.Driver");
                Connection conn = SQLServerConnection.getConnection();
                if (conn != null) {
                    String sql = "INSERT INTO Users (FullName, Email) VALUES (?, ?)";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, params[0]);
                    stmt.setString(2, params[1]);
                    stmt.executeUpdate();
                    conn.close();
                }
            } catch (Exception e) {
                return e.getMessage();
            }
            return "Thêm thành công!";
        }

        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
            new LoadUsersTask().execute();
        }
    }

    // Cập nhật User
    private class UpdateUserTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            try {
                Class.forName("net.sourceforge.jtds.jdbc.Driver");
                Connection conn = SQLServerConnection.getConnection();
                if (conn != null) {
                    String sql = "UPDATE Users SET FullName = ? WHERE Email = ?";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, params[0]);
                    stmt.setString(2, params[1]);
                    stmt.executeUpdate();
                    conn.close();
                }
            } catch (Exception e) {
                return e.getMessage();
            }
            return "Cập nhật thành công!";
        }
    }

    // Xóa User
    private class DeleteUserTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            try {
                Class.forName("net.sourceforge.jtds.jdbc.Driver");
                Connection conn = SQLServerConnection.getConnection();
                if (conn != null) {
                    PreparedStatement stmt = conn.prepareStatement("DELETE FROM Users WHERE Email = ?");
                    stmt.setString(1, params[0]);
                    stmt.executeUpdate();
                    conn.close();
                }
            } catch (Exception e) {
                return e.getMessage();
            }
            return "Xóa thành công!";
        }
    }

}