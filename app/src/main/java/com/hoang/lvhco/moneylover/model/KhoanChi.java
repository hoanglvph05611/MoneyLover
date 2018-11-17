package com.hoang.lvhco.moneylover.model;

import java.util.Date;

public class KhoanChi {
    String TenChi;
    int SoTienChi;
    Date NgayChi;

    public KhoanChi(String tenChi, int soTienChi, Date ngayChi) {
        TenChi = tenChi;
        SoTienChi = soTienChi;
        NgayChi = ngayChi;
    }

    public String getTenChi() {
        return TenChi;
    }

    public void setTenChi(String tenChi) {
        TenChi = tenChi;
    }

    public int getSoTienChi() {
        return SoTienChi;
    }

    public void setSoTienChi(int soTienChi) {
        SoTienChi = soTienChi;
    }

    public Date getNgayChi() {
        return NgayChi;
    }

    public void setNgayChi(Date ngayChi) {
        NgayChi = ngayChi;
    }

    @Override
    public String toString() {
        return "KhoanChi{" +
                "TenChi='" + TenChi + '\'' +
                ", SoTienChi=" + SoTienChi +
                ", NgayChi=" + NgayChi +
                '}';
    }
}
