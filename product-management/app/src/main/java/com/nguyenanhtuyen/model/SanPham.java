package com.nguyenanhtuyen.model;

import java.io.Serializable;

public class SanPham implements Serializable {
    private String ma;
    private String ten;
    private int gia;

    public SanPham() {
    }

    public SanPham(String ma, String ten, int gia) {
        this.ma = ma;
        this.ten = ten;
        this.gia = gia;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public int getGia() {
        return gia;
    }

    @Override
    public String toString() {
        return this.ten;
    }
}
