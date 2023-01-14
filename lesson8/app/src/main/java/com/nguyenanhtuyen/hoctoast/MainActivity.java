package com.nguyenanhtuyen.hoctoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnToastShort, btnToastLong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnToastShort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyToastShort();
            }
        });
        btnToastLong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyToastLong();
            }
        });
    }

    private void xuLyToastLong() {
        //vì Toast chỉ hiển thị trên màn hình người dùng không thể tương tác được nên viết cách này cho gọn, không cần khai báo biến
        Toast.makeText(MainActivity.this, "This is Long Toast", Toast.LENGTH_LONG).show();
    }

    private void xuLyToastShort() {
        Toast toast = Toast.makeText(MainActivity.this, "This is Toast Short!", Toast.LENGTH_SHORT);
        toast.show();
    }

    private void addControls() {
        btnToastShort = findViewById(R.id.btnToastShort);
        btnToastLong = findViewById(R.id.btnToastLong);
    }
}