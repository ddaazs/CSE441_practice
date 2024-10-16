package com.example.myapplication;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EditSinhVienActivity extends AppCompatActivity {
    private EditText edtHoTen, edtLop, edtDiem;
    private String mssv;
    private FirebaseDatabase database;
    private DatabaseReference sinhVienRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_sinhvien);

        edtHoTen = findViewById(R.id.edtHoTen);
        edtLop = findViewById(R.id.edtLop);
        edtDiem = findViewById(R.id.edtDiem);
        mssv = getIntent().getStringExtra("mssv");

        database = FirebaseDatabase.getInstance();
        sinhVienRef = database.getReference("sinhvien").child(mssv);

        // Lấy thông tin sinh viên
        sinhVienRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                ModelStudent sinhVien = snapshot.getValue(ModelStudent.class);
                if (sinhVien != null) {
                    edtHoTen.setText(sinhVien.getHoten());
                    edtLop.setText(sinhVien.getLop());
                    edtDiem.setText(String.valueOf(sinhVien.getDiem()));
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Handle errors
            }
        });

        findViewById(R.id.btnSave).setOnClickListener(v -> {
            String hoTen = edtHoTen.getText().toString();
            String lop = edtLop.getText().toString();
            double diem = Double.parseDouble(edtDiem.getText().toString());

            sinhVienRef.child("hoten").setValue(hoTen);
            sinhVienRef.child("lop").setValue(lop);
            sinhVienRef.child("diem").setValue(diem);

            finish();
        });
    }
}

