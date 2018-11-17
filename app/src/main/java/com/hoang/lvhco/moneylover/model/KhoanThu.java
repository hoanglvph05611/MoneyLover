package com.hoang.lvhco.moneylover.model;

import java.util.Date;

public class KhoanThu {
    String TenKhoanThu;
    double SoTienKhoanThu;
    Date NgayThu;

    public KhoanThu() {
    }

    public KhoanThu(String tenKhoanThu, double soTienKhoanThu, Date ngayThu) {
        this.TenKhoanThu = tenKhoanThu;
        this.SoTienKhoanThu = soTienKhoanThu;
        this.NgayThu = ngayThu;
    }

    public String getTenKhoanThu() {
        return TenKhoanThu;
    }

    public void setTenKhoanThu(String tenKhoanThu) {
        TenKhoanThu = tenKhoanThu;
    }

    public double getSoTienKhoanThu() {
        return SoTienKhoanThu;
    }

    public void setSoTienKhoanThu(double soTienKhoanThu) {
        SoTienKhoanThu = soTienKhoanThu;
    }

    public Date getNgayThu() {
        return NgayThu;
    }

    public void setNgayThu(Date ngayThu) {
        NgayThu = ngayThu;
    }

    @Override
    public String toString() {
        return "KhoanThu{" +
                "TenKhoanThu='" + TenKhoanThu + '\'' +
                ", SoTienKhoanThu=" + SoTienKhoanThu +
                ", NgayThu=" + NgayThu +
                '}';
    }
}