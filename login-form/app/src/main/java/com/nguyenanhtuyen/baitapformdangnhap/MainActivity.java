package com.nguyenanhtuyen.baitapformdangnhap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edtUser, edtPassword;
    CheckBox chkLuuThongTin;
    Button btnDangNhap, btnThoat;
    String nameShare = "thongtindangnhap"; //lưu thông tin đăng nhập trên file xml có tên là thongtindangnhap

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyDangNhap();
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyThoat();
            }
        });
    }

    private void xuLyThoat() {
    }

    private void xuLyDangNhap() {
        if(edtUser.getText().toString().equals("admin") && edtPassword.getText().toString().equals("123")){
            Intent intent = new Intent(MainActivity.this,QuanLyActivity.class);
            startActivity(intent);
        }
    }


    //lưu thông tin đăng nhập
    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences preferences = getSharedPreferences(nameShare,MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("user",edtUser.getText().toString());
        editor.putString("password",edtPassword.getText().toString());
        editor.putBoolean("save",chkLuuThongTin.isChecked());
        editor.commit();
    }

    //đọc thông tin đăng nhập
    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences = getSharedPreferences(nameShare,MODE_PRIVATE);
        String user = preferences.getString("user","");
        String password = preferences.getString("password","");
        boolean save = preferences.getBoolean("save",false);
        if(save==true){
            edtUser.setText(user);
            edtPassword.setText(password);
        }
        chkLuuThongTin.setChecked(save);
    }

    private void addControls() {
        edtUser = findViewById(R.id.edtUser);
        edtPassword = findViewById(R.id.edtPassword);
        chkLuuThongTin = findViewById(R.id.chkLuuThongTin);
        btnDangNhap = findViewById(R.id.btnDangNhap);
        btnThoat = findViewById(R.id.btnThoat);
    }
}