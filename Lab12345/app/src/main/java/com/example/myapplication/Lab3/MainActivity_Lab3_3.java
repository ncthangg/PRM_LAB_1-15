package com.example.myapplication.Lab3;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.util.ArrayList;

public class MainActivity_Lab3_3 extends AppCompatActivity {
    ListView lvFruit;
    ArrayList<Fruit> arrayFruit;
    FruitAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_lab3_3);

        lvFruit = (ListView) findViewById(R.id.listViewFruit);


        arrayFruit = new ArrayList<Fruit>();

        arrayFruit.add(new Fruit(
                 R.drawable.apple,
                "Apple",
                "apple...some description goes here"
        ));
        arrayFruit.add(new Fruit(
                R.drawable.chuoi,
                "Banana",
                "banana...some description goes here"
        ));
        arrayFruit.add(new Fruit(

                R.drawable.blueberry,
                "Blueberry",
                "blueberry...some description goes here"
        ));
        arrayFruit.add(new Fruit(

                R.drawable.corn,
                "Corn",
                "corn...some description goes here"
        ));
        arrayFruit.add(new Fruit(

                R.drawable.nho,
                "Grapes",
                "grapes...some description goes here"
        ));

        adapter = new FruitAdapter(this, R.layout.fruit, arrayFruit);

        lvFruit.setAdapter(adapter);

    }
}
