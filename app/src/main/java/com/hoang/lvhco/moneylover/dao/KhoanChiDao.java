package com.hoang.lvhco.moneylover.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.hoang.lvhco.moneylover.database.DB_Helper;

import java.text.SimpleDateFormat;

public class KhoanChiDao {
    private SQLiteDatabase db;
    private DB_Helper db_helper;
    public static final String TABLE_NAME= "KhoanThu";
    public static final String SQL_KHOAN_CHI = "CREATE TABLE KhoanChi (TenKhoanChi text primary key, SoTienChi int ,NgayChi date)";
    public static final String TAG = "KhoanChiDao";

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy--MM-dd");
    public KhoanChiDao(Context context){
        db_helper = new DB_Helper(context);
        db = db_helper.getWritableDatabase();
    }
}
