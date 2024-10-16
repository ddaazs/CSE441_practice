package com.example.myapplication;

import static java.security.AccessController.getContext;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Student_Adapter extends ArrayAdapter<ModelStudent> {
    private Context context;
    private List<ModelStudent> sinhVienList;

    public Student_Adapter(Context context, ArrayList<ModelStudent> sinhVienList) {
        super(context, 0, sinhVienList);
        this.context = context;
        this.sinhVienList = sinhVienList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ModelStudent sinhVien = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_sinhvien, parent, false);
        }

        TextView tvHoTen = convertView.findViewById(R.id.tvHoTen);
        TextView tvMSSV = convertView.findViewById(R.id.tvMSSV);
        TextView tvLop = convertView.findViewById(R.id.tvLop);
        TextView tvDiem = convertView.findViewById(R.id.tvDiem);

        tvHoTen.setText(sinhVien.getHoten());
        tvMSSV.setText(sinhVien.getMssv());
        tvLop.setText(sinhVien.getLop());
        tvDiem.setText(String.valueOf(sinhVien.getDiem()));

        convertView.findViewById(R.id.btnEdit).setOnClickListener(v -> {
            Intent intent = new Intent(context, EditSinhVienActivity.class);
            intent.putExtra("mssv", sinhVien.getMssv());
            context.startActivity(intent);
        });

        convertView.findViewById(R.id.btnDelete).setOnClickListener(v -> {
            FirebaseDatabase.getInstance().getReference("sinhvien")
                    .child(sinhVien.getMssv()).removeValue();
        });

        return convertView;
    }
}

