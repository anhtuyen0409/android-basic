package com.nguyenanhtuyen.hocimagecontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //khai báo các control
    EditText edtTenDangNhap, edtMatKhau;
    TextView txtKetQua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
    }

    private void addControls() {
        edtTenDangNhap = findViewById(R.id.edtTenDangNhap);
        edtMatKhau = findViewById(R.id.edtMatKhau);
        txtKetQua = findViewById(R.id.txtKetQua);
    }

    public void xuLyDangNhap(View view) {
        String userName = edtTenDangNhap.getText().toString();
        String passWord = edtMatKhau.getText().toString();
        txtKetQua.setText(userName+";"+passWord);
    }
}