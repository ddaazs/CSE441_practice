package com.example.myapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private List<Country> countries;
private RecyclerView rcvCountry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        countries = new ArrayList<>();
        countries.add(new Country(R.drawable.us,"Anh","London"));
        countries.add(new Country(R.drawable.vi,"Việt Nam","Hà Nội"));
        countries.add(new Country(R.drawable.uk,"Mỹ","Washington D.C."));

        rcvCountry = findViewById(R.id.rcv_country);
        rcvCountry.setAdapter(new CountryAdapter(countries));
        rcvCountry.setLayoutManager(new LinearLayoutManager(this));
    }
}