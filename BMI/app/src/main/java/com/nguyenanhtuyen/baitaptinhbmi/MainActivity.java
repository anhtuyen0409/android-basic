package com.nguyenanhtuyen.baitaptinhbmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String TAG="MainActivity";
    EditText edtTen, edtChieuCao, edtCanNang;
    Button btnTinhBMI;
    TextView txtBMI, txtChuanDoan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnTinhBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyTinhBMI();
            }
        });
    }

    private void xuLyTinhBMI() {
        try {
            double chieuCao = Double.parseDouble(edtChieuCao.getText().toString());
            double canNang = Double.parseDouble(edtCanNang.getText().toString());
            double BMI = canNang/(chieuCao*chieuCao);
            if(BMI < 18){
                txtChuanDoan.setText("Người gầy");
            }
            else if(BMI>=18 && BMI<=24.9){
                txtChuanDoan.setText("Người bình thường");
            }
            else if(BMI>=25 && BMI<=29.9){
                txtChuanDoan.setText("Người béo phì độ 1");
            }
            else if(BMI>=30 && BMI<=34.9){
                txtChuanDoan.setText("Người béo phì độ 2");
            }
            else if(BMI>35){
                txtChuanDoan.setText("Người béo phì độ 3");
            }
            txtBMI.setText(BMI+"");
        }
        catch (Exception ex){
            Log.e(TAG,ex.toString());
        }
    }

    private void addControls() {
        edtTen = findViewById(R.id.edtTen);
        edtChieuCao = findViewById(R.id.edtChieuCao);
        edtCanNang = findViewById(R.id.edtCanNang);
        txtBMI = findViewById(R.id.txtBMI);
        txtChuanDoan = findViewById(R.id.txtChuanDoan);
        btnTinhBMI = findViewById(R.id.btnTinhBMI);
    }
}