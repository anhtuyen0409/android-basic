package com.nguyenanhtuyen.hocfindviewbyid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
    }

    private void addControls() {
        //R.id.txtWelcome tham chiếu tới id mà mình đặt id cho control
        //nó là kiểu int được lưu vào nhóm id (vì nó là thuộc tính id)
        //R là lớp tự động phát sinh của Android
        //TextView txtWelcome là biến control để trỏ tới control mà control này có id là txtWelcome được lưu trong R.id.txtWelcome
        //txtWelcome bên trái dấu = là Object Control (android gọi là view)
        //ta có thể đặt tên biến control với tên khác (nhưng nên đặt trùng)
        TextView txtWelcome = findViewById(R.id.txtWelcome);
        //bây giờ ta có thể truy suất được control có id là txtWelcome để thực hiện mục đích của mình
        //ví dụ thay đổi text:
        txtWelcome.setText("Hello Tuyen!");
    }
}