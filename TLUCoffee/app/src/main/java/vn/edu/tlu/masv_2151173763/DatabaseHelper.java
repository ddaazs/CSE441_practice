package vn.edu.tlu.masv_2151173763;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @SuppressLint("NewApi")
    public DatabaseHelper(@Nullable Context context, @Nullable String name, int version, @NonNull SQLiteDatabase.OpenParams openParams) {
        super(context, name, version, openParams);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableLoaiMon = "CREATE TABLE loaimon (" +
                "MaLoai INTEGER(11) PRIMARY KEY AUTOINCREMENT," +
                "TenLoai VARCHAR(50)," +
                "MoTa TEXT" + ");";

        String createTableMon = "CREATE TABLE mon (" +
                "MaMon INTEGER PRIMARY KEY AUTOINCREMENT," +
                "TenMon VARCHAR(100)," +
                "MaLoai INTEGER(11)," +
                "MoTa TEXT," +
                "DonGia FLOAT," +
                "Hinh VARCHAR(255)," +
                "FOREIGN KEY(MaLoai) REFERENCES LoaiMon(MaLoai)" +");";

        String createTableChiTiethd = "CREATE TABLE chitiethd (" +
                "SoHD INTERGER PRIMARY KEY AUTOINCREMENT," +
                "MaMon INTERGER," +
                "MaHD INTERGER," +
                "SoLuong INTERGER,"  +
                "FOREIGN KEY(MaMon) REFERENCES mon(MaMon)," +
                "FOREIGN KEY(MaMon) REFERENCES mon(MaMon)" +");";

        String createTablehoadon = "CREATE TABLE hoadon (" +
                "MaHD INTERGER PRIMARY KEY AUTOINCREMENT," +
                "NgayDat DATETIME," +
                "ThoiGianGiaoHangDuKien DATETIME," +
                "DiaChiGiaoHang VARCHAR(255)," +
                "MaKH INT," +
                "TinhTranh ENUM" +
                "FOREIGN KEY(MaKH) REFERENCES

        db.execSQL(createTableMon);
        db.execSQL(createTableLoaiMon);
        db.execSQL(createTableChiTiethd);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
