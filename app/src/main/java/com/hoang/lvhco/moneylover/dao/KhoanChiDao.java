package com.hoang.lvhco.moneylover.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.hoang.lvhco.moneylover.database.DB_Helper;
import com.hoang.lvhco.moneylover.model.KhoanChi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KhoanChiDao {
    private SQLiteDatabase db;
    private DB_Helper db_helper;
    public static final String TABLE_NAME1= "KhoanChi";
    public static final String SQL_KHOAN_CHI = "CREATE TABLE KhoanChi (Id INTEGER PRIMARY KEY AUTOINCREMENT ,TenKhoanChi text, SoTienChi double ,NgayChi date)";
    public static final String TAG = "KhoanChiDao";

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    public KhoanChiDao(Context context){
        db_helper = new DB_Helper(context);
        db = db_helper.getWritableDatabase();


    }
    public int insertKhoanChi(KhoanChi khoanChi){
        ContentValues values = new ContentValues();
        values.put("TenKhoanChi",khoanChi.getTenKhoanChi());
        values.put("SoTienChi",khoanChi.getSoTienKhoanChi());
        values.put("NgayChi",sdf.format(khoanChi.getNgayChi()));
        try {
            if (db.insert(TABLE_NAME1,null,values)==-1){
                return -1;
            }
        }catch (Exception e){
            Log.e(TAG,e.toString());
        }
        return 1;
    }
    public List<KhoanChi> getAllKhoanChi() throws ParseException{
        List<KhoanChi> dsKhoanChi = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME1,null,null,null,null,null,null);
        c.moveToFirst();
        while (c.isAfterLast() == false){
           KhoanChi kc = new KhoanChi();
            kc.setId(c.getInt(0));
           kc.setTenKhoanChi(c.getString(1));
           kc.setSoTienKhoanChi(c.getDouble(2));
           kc.setNgayChi(sdf.parse(c.getString(3)));
           dsKhoanChi.add(kc);
           Log.d("//=====",kc.toString());
           c.moveToNext();
        }c.close();
        return dsKhoanChi;
    }
    // update
    public int updateKhoanChi(int Id, String TenKhoanChi, Double SoTienChi, Date NgayChi){
        ContentValues values = new ContentValues();
        values.put("Id",Id);
        values.put("TenKhoanChi",TenKhoanChi);
        values.put("SoTienChi",SoTienChi);
        values.put("NgayChi",sdf.format(NgayChi));
        int result = db.update(TABLE_NAME1,values,"Id=?",new String[]{String.valueOf(Id)});
        if (result==0){
            return -1;
        }
        return 1;
    }

    public int deleteKhoanChi(int Id){
        int result = db.delete(TABLE_NAME1,"Id=?",new String[]{String.valueOf(Id)});
        if (result ==0){
            return -1;
        }
        return 1;
    }
    public double getTongKhoanChi(){
        double thongke = 0;
        String sSQL = "SELECT SUM(KhoanChi.SoTienChi) FROM KhoanChi";

        Cursor c = db.rawQuery(sSQL,null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            thongke = c.getDouble(0);
            c.moveToNext();
        }
        c.close();
        return thongke;
    }
public double getKhoanChiTheoThang̣(){
        double ChiThang = 0;
        String sSQL1 = "SELECT SUM(KhoanChi.SoTienChi)FROM KhoanChi where Month(KhoanChi.NgayChi)= 12 ";
        Cursor c = db.rawQuery(sSQL1,null);
        c.moveToFirst();
    while (c.isAfterLast() == false) {
        ChiThang = c.getDouble(0);
        c.moveToNext();
    }
    c.close();
    return ChiThang;
}
public double getKhoanChiTheoNam(){
    double ChiNam = 0;
    String sSQL1 = "SELECT SUM(KhoanChi.SoTienChi)FROM KhoanChi where Year(KhoanChi.NgayChi)= 2018 ";
    Cursor c = db.rawQuery(sSQL1,null);
    c.moveToFirst();
    while (c.isAfterLast() == false) {
        ChiNam = c.getDouble(0);
        c.moveToNext();
    }
    c.close();
    return ChiNam;
}
}
