package com.nguyenanhtuyen.hocguivanhandulieu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.nguyenanhtuyen.model.DanhBa;

public class Sub2Activity extends AppCompatActivity {
    TextView txtData2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);
        addControls();
    }

    private void addControls() {
        txtData2 = findViewById(R.id.txtData2);
        //lấy intent
        Intent intent = getIntent();
        //lấy bundle
        Bundle bundle = intent.getBundleExtra("myBundle");
        //lấy chi tiết các dữ liệu đóng gói trong bundle
        int a = bundle.getInt("a");
        double b= bundle.getDouble("b");
        boolean c = bundle.getBoolean("c");
        String d = bundle.getString("d");
        DanhBa e = (DanhBa) bundle.getSerializable("e");

        //hiển thị trên màn hình
        txtData2.setText("");
        txtData2.append("a = "+a);
        txtData2.append("\n");
        txtData2.append("b = "+b);
        txtData2.append("\n");
        txtData2.append("c = "+c);
        txtData2.append("\n");
        txtData2.append("d = "+d);
        txtData2.append("\n");
        txtData2.append(e+"");
    }
}