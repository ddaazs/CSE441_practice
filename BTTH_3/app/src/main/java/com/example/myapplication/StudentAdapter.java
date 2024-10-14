package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    private List<Student> students;

    public StudentAdapter(List<Student> students) {
        this.students = students;
    }

    @NonNull
    @Override
    public StudentAdapter.StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student,parent,false);
        return new StudentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentAdapter.StudentViewHolder holder, int position) {
        Student student = students.get(position);
        String fullname = student.getFull_name().getLast() + " " + student.getFull_name().getMid() + " " + student.getFull_name().getFirst();
        holder.txtId.setText(student.getId());
        holder.txtFullName.setText(fullname);
        holder.txtGpa.setText(String.valueOf(student.getGpa()));
        if (student.getGender().equals("Nữ")) {
            holder.imgGender.setImageResource(R.drawable.female);
        } else {
            holder.imgGender.setImageResource(R.drawable.male);
        }
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    class StudentViewHolder extends RecyclerView.ViewHolder{
        ImageView imgGender;
        TextView txtFullName;
        TextView txtId;
        TextView txtGpa;
        public StudentViewHolder(View itemview){
            super(itemview);
            imgGender = itemview.findViewById(R.id.img_gender);
            txtId = itemview.findViewById(R.id.txt_id);
            txtFullName = itemview.findViewById(R.id.txt_fullname);
            txtGpa = itemview.findViewById(R.id.txt_gpa);
        }
    }
}


