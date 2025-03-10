package com.example.sqltest;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLServerConnection {

    private static String ip = "192.168.2.127"; //Ip cua ban

    private static String port = "1433";

    private static String Classes = "net.sourceforge.jtds.jdbc.Driver";

    private static String database = "VNPAY_TestDB";

    private static String username = "sa"; //username sql server cua ban

    private static String password = "12345"; //mat khau sql server cua ban

    private static String url = "jdbc:jtds:sqlserver://" + ip + ":" + port + ";databasename=" + database + ";";

    private static Connection connection = null;

    public static Connection getConnection() {
        try {
            Class.forName(Classes);
            DriverManager.setLoginTimeout(10);
            connection = DriverManager.getConnection(url, username, password);
            Log.d("SQL_TEST", "Kết nối thành công: " + (connection != null));
            return connection;
        } catch (ClassNotFoundException e) {
            Log.e("SQL_TEST", "Driver không tìm thấy: " + e.getMessage());
            return null;
        } catch (SQLException e) {
            Log.e("SQL_TEST", "Lỗi kết nối SQL: " + e.getMessage());
            return null;
        }
    }
}
