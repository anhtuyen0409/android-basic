package com.nguyenanhtuyen.hocevents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AnonymousListenerActivity extends AppCompatActivity {
    String TAG="AnonymousListenerActivity";
    //khai báo tất cả các control đã  định nghĩa
    EditText edtSoA, edtSoB;
    Button btnCong, btnTru, btnNhan, btnChia;
    TextView txtKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anonymous_listener);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyCong();
            }
        });
        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyTru();
            }
        });
        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyNhan();
            }
        });
        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyChia();
            }
        });
        txtKetQua.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                xuLyXoaDuLieu();
                return false;
            }
        });
    }

    private void xuLyXoaDuLieu() {
        txtKetQua.setText("");
        edtSoA.setText("");
        edtSoB.setText("");
        edtSoA.requestFocus();
    }

    private void xuLyChia() {
        try {
            double a = Double.parseDouble(edtSoA.getText().toString());
            double b = Double.parseDouble(edtSoB.getText().toString());
            double kq = a/b;
            txtKetQua.setText(a+" / "+b+" = "+kq);
        }
        catch (Exception ex){
            Log.e(TAG,ex.toString());
        }

    }

    private void xuLyNhan() {
        try {
            double a = Double.parseDouble(edtSoA.getText().toString());
            double b = Double.parseDouble(edtSoB.getText().toString());
            double kq = a * b;
            txtKetQua.setText(a+" * "+b+" = "+kq);
        }
        catch (Exception ex){
            Log.e(TAG,ex.toString());
        }

    }

    private void xuLyTru() {
        try {
            double a = Double.parseDouble(edtSoA.getText().toString());
            double b = Double.parseDouble(edtSoB.getText().toString());
            double kq = a - b;
            txtKetQua.setText(a+" - "+b+" = "+kq);
        }
        catch (Exception ex){
            Log.e(TAG,ex.toString());
        }

    }

    private void xuLyCong() {
        try {
            //chuyển về kiểu double
            double a = Double.parseDouble(edtSoA.getText().toString());
            double b = Double.parseDouble(edtSoB.getText().toString());
            double kq = a + b;
            txtKetQua.setText(a+" + "+b+" = "+kq);
        }
        catch (Exception ex){
            Log.e(TAG,ex.toString());
        }

    }

    private void addControls() {
        edtSoA = findViewById(R.id.edtSoA);
        edtSoB = findViewById(R.id.edtSoB);
        btnCong = findViewById(R.id.btnCong);
        btnTru = findViewById(R.id.btnTru);
        btnNhan = findViewById(R.id.btnNhan);
        btnChia = findViewById(R.id.btnChia);
        txtKetQua = findViewById(R.id.txtKetQua);
    }
}