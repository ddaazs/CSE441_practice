package com.example.myapplication;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddSinhVienActivity extends AppCompatActivity {
    private EditText edtHoTen, edtMSSV, edtLop, edtDiem;
    private FirebaseDatabase database;
    private DatabaseReference sinhVienRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sinhvien);

        edtHoTen = findViewById(R.id.edtHoTen);
        edtMSSV = findViewById(R.id.edtMSSV);
        edtLop = findViewById(R.id.edtLop);
        edtDiem = findViewById(R.id.edtDiem);

        database = FirebaseDatabase.getInstance();
        sinhVienRef = database.getReference("sinhvien");

        findViewById(R.id.btnSave).setOnClickListener(v -> {
            String hoTen = edtHoTen.getText().toString();
            String mssv = edtMSSV.getText().toString();
            String lop = edtLop.getText().toString();
            double diem = Double.parseDouble(edtDiem.getText().toString());

            if (hoTen.isEmpty() || mssv.isEmpty() || lop.isEmpty() || edtDiem.getText().toString().isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đủ thông tin!", Toast.LENGTH_SHORT).show();
                return;
            }

            ModelStudent sinhVien = new ModelStudent(hoTen, mssv, lop, diem);
            sinhVienRef.child(mssv).setValue(sinhVien);
            finish();
        });
    }
}

