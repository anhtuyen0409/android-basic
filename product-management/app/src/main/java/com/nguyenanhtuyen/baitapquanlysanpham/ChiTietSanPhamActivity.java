package com.nguyenanhtuyen.baitapquanlysanpham;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.nguyenanhtuyen.model.SanPham;

public class ChiTietSanPhamActivity extends AppCompatActivity {
    EditText edtMaSanPham, edtTenSanPham, edtGia;
    Button btnXoaSanPham, btnTroVe;
    Intent intent;
    SanPham sp; //khai báo biến toàn cục để sử dụng nhiều lần

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_san_pham);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnXoaSanPham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyXoaSanPham();
            }
        });
        btnTroVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyTroVe();
            }
        });
    }

    private void xuLyTroVe() {
        finish();
    }

    private void xuLyXoaSanPham() {
        intent.putExtra("xacnhanxoa",true);
        intent.putExtra("sanpham",sp);
        setResult(115,intent); //trả dữ liệu về mã là 115
        finish(); //phải có finish
    }

    private void addControls() {
        edtMaSanPham = findViewById(R.id.edtMaSanPham);
        edtTenSanPham = findViewById(R.id.edtTenSanPham);
        edtGia = findViewById(R.id.edtGia);
        btnXoaSanPham = findViewById(R.id.btnXoaSanPham);
        btnTroVe = findViewById(R.id.btnTroVe);
        intent = getIntent();
        sp = (SanPham) intent.getSerializableExtra("sanpham"); //nhận dữ liệu từ bên màn hình main
        //show chi tiết sản phẩm
        edtMaSanPham.setText(sp.getMa());
        edtTenSanPham.setText(sp.getTen());
        edtGia.setText(sp.getGia()+"");

    }
}