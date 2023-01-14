package com.nguyenanhtuyen.hocguivanhandulieu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.nguyenanhtuyen.model.DanhBa;

public class MainActivity extends AppCompatActivity {
    Button btnTruyenTrucTiep, btnDongGoiDuLieu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnTruyenTrucTiep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyTruyenTrucTiepIntent();
            }
        });
        btnDongGoiDuLieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyDongGoiDuLieuVaoBundle();
            }
        });
    }

    private void xuLyDongGoiDuLieuVaoBundle() {
        Intent intent = new Intent(MainActivity.this,Sub2Activity.class);

        //goid dữ liệu vào bundle
        Bundle bundle = new Bundle();
        bundle.putInt("a",113);
        bundle.putDouble("b",5.5);
        bundle.putBoolean("c",true);
        bundle.putString("d","Hello android!");
        DanhBa t = new DanhBa(1,"Nguyễn Anh Tuyên","0394420076");
        bundle.putSerializable("e",t);

        //truyền bundle vào intent
        intent.putExtra("myBundle",bundle);
        startActivity(intent);
    }

    private void xuLyTruyenTrucTiepIntent() {
        Intent intent = new Intent(MainActivity.this,Sub1Activity.class);
        //truyền dữ liệu trực tiếp vào intent
        intent.putExtra("a",113); //a là biến, 113 là giá trị truyền
        intent.putExtra("b",5.5);
        intent.putExtra("c",true);
        intent.putExtra("d","Hello android");
        DanhBa bill = new DanhBa(1,"Bill Gate","0394420076");
        intent.putExtra("e",bill);

        startActivity(intent); //mở màn hình sub1 đồng thời truyền dữ liệu vào màn hình sub1
    }

    private void addControls() {
        btnTruyenTrucTiep = findViewById(R.id.btnTruyenTrucTiep);
        btnDongGoiDuLieu = findViewById(R.id.btnDongGoiDuLieu);
    }
}