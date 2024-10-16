package com.example.myapplication;

public class ModelStudent {
    private String hoten;
    private String mssv;
    private String lop;
    private double diem;

    public ModelStudent(String hoten, String mssv, String lop, double diem) {
        this.hoten = hoten;
        this.mssv = mssv;
        this.lop = lop;
        this.diem = diem;
    }

    public String getHoten() {
        return hoten;
    }

    public String getMssv() {
        return mssv;
    }

    public String getLop() {
        return lop;
    }

    public double getDiem() {
        return diem;
    }
}

