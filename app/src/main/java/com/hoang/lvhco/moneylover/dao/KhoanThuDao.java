package com.hoang.lvhco.moneylover.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.hoang.lvhco.moneylover.database.DB_Helper;
import com.hoang.lvhco.moneylover.model.KhoanThu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class KhoanThuDao {
    private SQLiteDatabase db;
    private DB_Helper db_helper;
    public static final String TABLE_NAME= "KhoanThu";
    public static final String SQL_KHOAN_THU = "CREATE TABLE KhoanThu (TenKhoanThu text primary key, SoTienThu int ,NgayThu date)";
    public static final String TAG = "KhoanChiDao";

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy--MM-dd");
    public KhoanThuDao(Context context){
        db_helper = new DB_Helper(context);
        db = db_helper.getWritableDatabase();

    }
    public int insertKhoanThu(KhoanThu khoanThu){
        ContentValues values = new ContentValues();
        values.put("TenKhoanThu",khoanThu.getTenKhoanThu());
        values.put("SoTienThu",khoanThu.getSoTienKhoanThu());
        values.put("NgayThu",sdf.format(khoanThu.getNgayThu()));
        try {
            if (db.insert(TABLE_NAME,null,values) == -1){
                return -1;
            }
        }catch (Exception ex){
            Log.e(TAG,ex.toString());
        }
        return 1;
    }
    // getAll
    public List<KhoanThu> getAllKhoanThu() throws ParseException{
        List<KhoanThu> dsKhoanThu = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME,null,null,null,null,null,null);
        c.moveToFirst();
        while (c.isAfterLast() ==false){
            KhoanThu kt = new KhoanThu();
            kt.setTenKhoanThu(c.getString(0));
            kt.setSoTienKhoanThu(c.getInt(1));
            kt.setNgayThu(sdf.parse(c.getString(2)));
            dsKhoanThu.add(kt);
            Log.d("//=====",kt.toString());
            c.moveToNext();

        } c.close();
        return dsKhoanThu;
    }
    // update
    public int updateKhoanThu(KhoanThu khoanThu){
        ContentValues values = new ContentValues();
        values.put("TenKhoanThu",khoanThu.getTenKhoanThu());
        values.put("SoTienKhoanThu",khoanThu.getSoTienKhoanThu());
        values.put("NgayThu",sdf.format(khoanThu.getNgayThu()));
        int result = db.update(TABLE_NAME,values,"TenKhoanThu=?",new String[]{khoanThu.getTenKhoanThu()});
        if (result ==0){
            return -1;
        }
        return 1;
    }
    public int deleteKhoanThuByID(String TenKhoanThu){
        int result = db.delete(TABLE_NAME,"TenKhoanThu=?",new String[]{TenKhoanThu});
        if (result == 0){
            return -1;
        }
        return 1;
    }
}
