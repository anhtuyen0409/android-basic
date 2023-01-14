package com.nguyenanhtuyen.hoctabhost;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //khai bao cac control
    TabHost tabHost;
    EditText edtTenDangNhap, edtMatKhau;
    Button btnDangNhap, btnThoat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                //String s ở đây chính là id của các tab
                if(s.equals("t1")){
                    Toast.makeText(MainActivity.this,"Đây là màn hình đăng nhập",Toast.LENGTH_SHORT).show();
                }
                else if(s.equals("t2")){
                    Toast.makeText(MainActivity.this,"Đây là màn hình hướng dẫn",Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyDangNhap();
            }
        });
    }

    private void xuLyDangNhap() {
        Toast.makeText(MainActivity.this,"username: "+edtTenDangNhap.getText().toString()+" " +
                "- password: "+edtMatKhau.getText().toString(),Toast.LENGTH_SHORT).show();
    }

    private void addControls() {
        tabHost = findViewById(R.id.tabHost);
        tabHost.setup(); //khoi tao tabhost
        //tiến hành khởi tạo các tab
        TabHost.TabSpec tab1 = tabHost.newTabSpec("t1"); //tạo đối tượng 1 tab có id là t1
        tab1.setContent(R.id.tab1); //thiết lập nội dung layout
        //tab1.setIndicator("Đăng nhập"); //thiết lập tiêu đề tab
        //trường hợp ta muốn chèn hình vào button, ta chỉ được chọn lựa 1 là chèn hình 2 là chèn chữ, không thể chèn cả 2
        tab1.setIndicator("",getResources().getDrawable(R.drawable.ic_login2));
        tabHost.addTab(tab1);

        TabHost.TabSpec tab2 = tabHost.newTabSpec("t2");
        tab2.setContent(R.id.tab2);
        tab2.setIndicator("Hướng dẫn");
        tabHost.addTab(tab2);

        edtTenDangNhap = findViewById(R.id.edtTenDangNhap);
        edtMatKhau = findViewById(R.id.edtMatKhau);
        btnDangNhap = findViewById(R.id.btnDangNhap);
        btnThoat = findViewById(R.id.btnThoat);
    }
}