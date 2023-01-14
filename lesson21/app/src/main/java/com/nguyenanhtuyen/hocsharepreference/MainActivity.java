package com.nguyenanhtuyen.hocsharepreference;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AppOpsManager;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnLuu, btnDoc;
    String tenPreference = "trangthai";
    TextView txtTrangThai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyLuu();
            }
        });
        btnDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyDoc();
            }
        });
    }

    private void xuLyDoc() {
        SharedPreferences preferences = getSharedPreferences(tenPreference,MODE_PRIVATE);
        boolean b = preferences.getBoolean("b",false);
        float f = preferences.getFloat("f",0.00f);
        int i = preferences.getInt("i",0);
        long l = preferences.getLong("l",0l);
        String s = preferences.getString("s","");
        txtTrangThai.append("b = "+b);
        txtTrangThai.append("\n");
        txtTrangThai.append("f = "+f);
        txtTrangThai.append("\n");
        txtTrangThai.append("i = "+i);
        txtTrangThai.append("\n");
        txtTrangThai.append("l = "+l);
        txtTrangThai.append("\n");
        txtTrangThai.append("s = "+s);
    }

    private void xuLyLuu() {
        SharedPreferences preferences = getSharedPreferences(tenPreference,MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("b",true);
        editor.putFloat("f",15.5f);
        editor.putInt("i",100);
        editor.putLong("l",200l);
        editor.putString("s","tuyen");
        editor.commit(); //xác nhận lưu
    }

    private void addControls() {
        btnLuu = findViewById(R.id.btnLuu);
        btnDoc = findViewById(R.id.btnDoc);
        txtTrangThai = findViewById(R.id.txtTrangThai);
    }
}