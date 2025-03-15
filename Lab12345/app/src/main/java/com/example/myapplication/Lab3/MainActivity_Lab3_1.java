package com.example.myapplication.Lab3;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.util.ArrayList;

public class MainActivity_Lab3_1 extends AppCompatActivity {

    ListView lvMonHoc;
    ArrayList<String> arrayCourse;
    EditText edtMonHoc;
    Button btnAdd, btnEdit, btnDelete;
    int vitri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_lab3_1);

        lvMonHoc = (ListView) findViewById(R.id.ListViewMonHoc);
        edtMonHoc = (EditText) findViewById(R.id.edtName);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnEdit = (Button) findViewById(R.id.btnEdit);
        btnDelete = (Button) findViewById(R.id.btnDelete);

        arrayCourse = new ArrayList<>();
        arrayCourse.add("Apple");
        arrayCourse.add("Samsung");
        arrayCourse.add("Oppo");
        arrayCourse.add("Google Pixel");
        arrayCourse.add("Lenovo");
        arrayCourse.add("Acer");
        arrayCourse.add("Nokia");

        ArrayAdapter<String> adapter= new ArrayAdapter<>(
                MainActivity_Lab3_1.this,
                android.R.layout.simple_list_item_1,
                arrayCourse
        );

        lvMonHoc.setAdapter(adapter);

        lvMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adaptView, View view, int i, long id){

                edtMonHoc.setText(arrayCourse.get(i));
                vitri = i;
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                arrayCourse.add(edtMonHoc.getText().toString());
                adapter.notifyDataSetChanged();
                edtMonHoc.setText("");
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                arrayCourse.set(vitri, edtMonHoc.getText().toString());
                adapter.notifyDataSetChanged();
                edtMonHoc.setText("");
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayCourse.remove(edtMonHoc.getText().toString());
                adapter.notifyDataSetChanged();
                edtMonHoc.setText("");
            }
        });

    }
}
