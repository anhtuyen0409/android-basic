package com.nguyenanhtuyen.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.nguyenanhtuyen.hoclistviewnangcao.R;

public class SanPhamAdapter extends ArrayAdapter<SanPham> {
    Activity context;
    int resource;
    public SanPhamAdapter(@NonNull Activity context, int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        //this.resource thực ra chính là item.xml
        View customView = inflater.inflate(this.resource,null);

        //khai báo các control trong item.xml
        ImageView imgHinh = customView.findViewById(R.id.imgHinh);
        TextView txtTen = customView.findViewById(R.id.txtTen);
        TextView txtGia = customView.findViewById(R.id.txtGia);

        //lấy sản phẩm ở vị trí position
        SanPham sp = getItem(position);
        imgHinh.setImageResource(sp.getHinh());
        txtTen.setText(sp.getTen());
        txtGia.setText(sp.getGia()+" VNĐ");

        return customView;
    }
}
