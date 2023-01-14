package com.nguyenanhtuyen.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.nguyenanhtuyen.baitaprenluyenmenu.R;
import com.nguyenanhtuyen.model.NhanVien;

public class NhanVienAdapter extends ArrayAdapter<NhanVien> {
    Activity context;
    int resource;
    public NhanVienAdapter(@NonNull Activity context, int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = this.context.getLayoutInflater().inflate(this.resource,null);
        ImageView imgHinh = view.findViewById(R.id.imgHinh);
        TextView txtMaNV = view.findViewById(R.id.txtMaNV);
        TextView txtTenNV = view.findViewById(R.id.txtTenNV);
        NhanVien nv  =getItem(position);
        txtMaNV.setText(nv.getMa());
        txtTenNV.setText(nv.getTen());
        if(nv.isNam()){
            imgHinh.setImageResource(R.drawable.ic_user1);
        }
        else{
            imgHinh.setImageResource(R.drawable.ic_user2);
        }
        return view;
    }
}
