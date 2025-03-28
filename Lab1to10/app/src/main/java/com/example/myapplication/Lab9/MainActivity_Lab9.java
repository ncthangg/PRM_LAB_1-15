package com.example.myapplication.Lab9;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.util.ArrayList;

public class MainActivity_Lab9 extends AppCompatActivity {

    Database database;
    ListView lvCongViec;
    ArrayList<CongViec> arrayCongViec;
    CongViecAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab9);

        lvCongViec = (ListView) findViewById(R.id.listviewCongViec);
        arrayCongViec = new ArrayList<>();
        adapter = new CongViecAdapter(this, R.layout.dong_cong_viec, arrayCongViec);
        lvCongViec.setAdapter(adapter);

        database = new Database(this, "GhiChu.sqlite", null, 1);
        database.QueryData("Create table if not exists CongViec(id Integer Primary Key Autoincrement," + "TenCV nvarchar(200))");
//        database.QueryData("Insert into CongViec values(null, 'Project Android')");
//        database.QueryData("Insert into CongViec values(null, 'Design app')");

        GetDataCongViec();
    }

    private void GetDataCongViec(){

        //Select data
        Cursor dataCongViec = database.GetData("Select * from CongViec");

        // Xoa mang truoc lhi add de cap nhat lai dux lieu moi tranh bi du thua trung lap
        arrayCongViec.clear();

        while (dataCongViec.moveToNext()) {
            String ten = dataCongViec.getString(1);
            int id = dataCongViec.getInt(0);
            arrayCongViec.add(new CongViec(id, ten));
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d("MENU_DEBUG", "onCreateOptionsMenu được gọi");
        Toast.makeText(this, "Menu đang tải...", Toast.LENGTH_SHORT).show();
        getMenuInflater().inflate(R.menu.add_congviec, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.menuAdd) {
            DialogThem();
        }
        return super.onOptionsItemSelected(item);
    }

    private void DialogThem() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_them_cong_viec);

        EditText edtTen = (EditText) dialog.findViewById(R.id.editTextTenCV);
        Button btnThem = (Button) dialog.findViewById(R.id.buttonThem);
        Button btnHuy = (Button) dialog.findViewById(R.id.buttonHuy);

        //Bat su kien cho Button Them
        btnThem.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String tencv = edtTen.getText().toString();
                if(tencv.equals("")){
                    Toast.makeText(MainActivity_Lab9.this, "Vui lòng nhập tên công việc !", Toast.LENGTH_SHORT).show();
                }else{
                    database.QueryData("Insert into CongViec values(null, '"+tencv+"')");
                    Toast.makeText(MainActivity_Lab9.this, "Đã thêm!", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();

                    //Show du lieu tren listview
                    GetDataCongViec();
                }
            }
        });

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void DialogSuaCongViec(String ten, int id){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_sua);

        EditText edtTenCV = (EditText) dialog.findViewById(R.id.editTextTenCV);
        Button btnXacNhan = (Button) dialog.findViewById(R.id.buttonXacNhan);
        Button btnHuyEdit = (Button) dialog.findViewById(R.id.buttonHuyEdit);

        edtTenCV.setText(ten);
        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tenMoi = edtTenCV.getText().toString().trim();
                database.QueryData("UPDATE CongViec SET TenCV = '"+tenMoi+"' WHERE id = '"+ id +"'");
                Toast.makeText(MainActivity_Lab9.this, "Đã cập nhật!", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                GetDataCongViec();
            }
        });

        btnHuyEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    //Ham xoa cong viec
    public void DialogXoaCongViec(String tencv, int Id){
        AlertDialog.Builder dialogXoa = new AlertDialog.Builder(this);
        dialogXoa.setMessage("Ban co muon xoa cong viec" + tencv + "khong ?");
        dialogXoa.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                database.QueryData("DELETE FROM CongViec WHERE Id = '" + Id + "'");
                Toast.makeText(MainActivity_Lab9.this, "Đã xóa !", Toast.LENGTH_SHORT).show();
                GetDataCongViec();
            }
        });
        dialogXoa.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialogXoa.show();
    }

}