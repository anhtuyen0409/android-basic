package com.nguyenanhtuyen.model;

public class NhanVien {
    private String ma;
    private String ten;
    private boolean isNam;

    public NhanVien() {
    }

    public NhanVien(String ma, String ten, boolean isNam) {
        this.ma = ma;
        this.ten = ten;
        this.isNam = isNam;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setNam(boolean nam) {
        isNam = nam;
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public boolean isNam() {
        return isNam;
    }
}
