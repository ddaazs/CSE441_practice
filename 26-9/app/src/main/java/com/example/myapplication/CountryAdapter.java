package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {
    public List<Country> countries;

    public CountryAdapter(List<Country> countries) {
        this.countries = countries;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_country,parent,false);
        return new CountryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        Country country = countries.get(position);
        holder.imgFlag.setImageResource(country.getFlag());
        holder.txtCountryName.setText(country.getCountryName());
        holder.txtCountryCapital.setText(country.getCountryCapital());
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    class CountryViewHolder extends RecyclerView.ViewHolder {
        ImageView imgFlag;
        TextView txtCountryName;
        TextView txtCountryCapital;
        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFlag = itemView.findViewById(R.id.img_flag);
            txtCountryName = itemView.findViewById(R.id.txt_countryName);
            txtCountryCapital = itemView.findViewById((R.id.txt_countryCapital));
        }
    }
}
