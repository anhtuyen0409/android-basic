package com.nguyenanhtuyen.model;

import java.io.Serializable;

public class Country implements Serializable {
    private int hinh;
    private String ten;
    private int danSo;

    public Country() {
    }

    public Country(int hinh, String ten, int danSo) {
        this.hinh = hinh;
        this.ten = ten;
        this.danSo = danSo;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getDanSo() {
        return danSo;
    }

    public void setDanSo(int danSo) {
        this.danSo = danSo;
    }
}
