package com.nguyenanhtuyen.model;

import java.io.Serializable;

public class DanhBa implements Serializable {
    private int id;
    private String name;
    private String phone;

    public DanhBa() {
    }

    public DanhBa(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return this.id+"-"+this.name+"-"+this.phone;
    }
}
