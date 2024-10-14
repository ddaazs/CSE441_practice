package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcvStudent;
    private StudentAdapter studentAdapter;

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
        rcvStudent = findViewById(R.id.rcv_student);
        rcvStudent.setLayoutManager(new LinearLayoutManager(this));

        List<Student> studentList = loadStudentsFromJson();
        studentAdapter = new StudentAdapter(studentList);
        rcvStudent.setAdapter(studentAdapter);
    }

    private List<Student> loadStudentsFromJson() {
        String json = null;
        try {
            InputStream is = getResources().openRawResource(R.raw.students);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            Log.e("MainActivity", "Error reading JSON file", e);
        }

        Gson gson = new Gson();
        Type studentListType = new TypeToken<List<Student>>() {
        }.getType();
        return gson.fromJson(json, studentListType);
    }
}