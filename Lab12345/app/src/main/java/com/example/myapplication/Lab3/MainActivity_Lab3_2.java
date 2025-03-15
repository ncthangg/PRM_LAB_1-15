package com.example.myapplication.Lab3;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.util.ArrayList;

public class MainActivity_Lab3_2 extends AppCompatActivity {

    ListView lvFootballer;
    ArrayList<Footballer> arrayFootballer;
    FootballerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_lab3_2);

        lvFootballer = (ListView) findViewById(R.id.listViewFootballer);


        arrayFootballer = new ArrayList<Footballer>();

        arrayFootballer.add(new Footballer(
                R.drawable.pele,
                "Pele",
                "October 23, 1940 (age 72)",
                R.drawable.brazil
        ));
        arrayFootballer.add(new Footballer(
                R.drawable.maradona,
                "Diego Maradona",
                "October 30, 1960 (age 52)",
                R.drawable.argentina
        ));
        arrayFootballer.add(new Footballer(
                R.drawable.johancruyff,
                "Johan Cruyff",
                "April 25, 1947 (age 65)",
                R.drawable.netherland
        ));
        arrayFootballer.add(new Footballer(
                R.drawable.michelplatini,
                "Michel Platini",
                "June 21, 1955 (age 57)",
                R.drawable.france
        ));
        arrayFootballer.add(new Footballer(
                R.drawable.ronaldodelima,
                "Ronaldo De Lima",
                "September 22, 1976 (age 36)",
                R.drawable.brazil
        ));

        adapter = new FootballerAdapter(this, R.layout.footballer, arrayFootballer);

        lvFootballer.setAdapter(adapter);

    }
}