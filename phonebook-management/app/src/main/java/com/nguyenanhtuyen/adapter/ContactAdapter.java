package com.nguyenanhtuyen.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.nguyenanhtuyen.baitapquanlydanhba.R;
import com.nguyenanhtuyen.model.Contact;

public class ContactAdapter extends ArrayAdapter<Contact> {
    //sửa context thành Activity
    Activity context;
    int resource;
    public ContactAdapter(@NonNull Activity context, int resource) {
        super(context, resource);
        this.context = context; //màn hình sử dụng
        this.resource = resource;
    }
    //gọi hàm getView

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View customView = this.context.getLayoutInflater().inflate(this.resource,null);

        //gọi tất cả các control có trong giao diện (kể cả control không có tương tác)
        TextView txtTen = customView.findViewById(R.id.txtTen);
        TextView txtSDT = customView.findViewById(R.id.txtSDT);
        ImageView imgCall = customView.findViewById(R.id.imgCall);
        ImageView imgSMS = customView.findViewById(R.id.imgSMS);
        ImageView imgCalendar = customView.findViewById(R.id.imgCalendar);

        //lấy đối tượng contact ở vị trí position
        final Contact contact = getItem(position);
        txtTen.setText(contact.getName());
        txtSDT.setText(contact.getPhone());

        //gán sự kiện cho nút gọi
        imgCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyGoi(contact);
            }
        });
        //gán sự kiện cho nút sms
        imgSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLySMS(contact);
            }
        });
        //gán sự kiện cho nút calender
        imgCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyCalendar(contact);
            }
        });

        return customView;
    }

    private void xuLyCalendar(Contact contact) {
        Toast.makeText(this.context,"Bạn chọn chức năng xem lịch",Toast.LENGTH_SHORT).show();
    }

    private void xuLySMS(Contact contact) {
        Toast.makeText(this.context, "Bạn chọn chức năng nhắn tin",Toast.LENGTH_SHORT).show();
    }

    private void xuLyGoi(Contact contact) {
        Toast.makeText(this.context, "Bạn chọn chức năng gọi",Toast.LENGTH_SHORT).show();
    }
}
