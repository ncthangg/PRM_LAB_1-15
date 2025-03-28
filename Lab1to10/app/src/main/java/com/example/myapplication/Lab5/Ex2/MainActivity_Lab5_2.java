package com.example.myapplication.Lab5.Ex2;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

import com.example.myapplication.Lab5.Ex2.Adapter.ModuleAdapter;
import com.example.myapplication.R;

public class MainActivity_Lab5_2 extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ModuleAdapter moduleAdapter;
    private List<Module> moduleList;
    private Button buttonAddModule;
    private int selectedOSIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lab5_2);

        recyclerView = findViewById(R.id.recyclerView);
        buttonAddModule = findViewById(R.id.buttonAddModule);

        moduleList = new ArrayList<>();

        // Thêm dữ liệu mẫu
        moduleList.add(new Module(R.drawable.samsung, "Samsung Ultra 5s", "Chip SnapDragon 666 cực kì mạnh mẽ", "Android"));
        moduleList.add(new Module(R.drawable.appleicon, "Iphone 16 plus", "Hệ thống bảo mật cực kì cao", "iOS"));

        moduleAdapter = new ModuleAdapter(this, moduleList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(moduleAdapter);

        buttonAddModule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddModuleDialog();
            }
        });
    }

    private void showAddModuleDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_add_module, null);
        builder.setView(dialogView);

        EditText editTextTitle = dialogView.findViewById(R.id.editTextTitle);
        EditText editTextDescription = dialogView.findViewById(R.id.editTextDescription);

        builder.setTitle("Add New Module")
                .setSingleChoiceItems(new String[]{"Android", "iOS"}, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        selectedOSIndex = which;
                    }
                })
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String title = editTextTitle.getText().toString();
                        String description = editTextDescription.getText().toString();
                        String operatingSystem = selectedOSIndex == 0 ? "Android" : "iOS";
                        int selectedImage = selectedOSIndex == 0 ? R.drawable.android_phone : R.drawable.iphone;

                        Module newModule = new Module(selectedImage, title, description, operatingSystem);
                        moduleAdapter.addModule(newModule);
                    }
                })
                .setNegativeButton("Cancel", null);

        builder.create().show();
    }
}
