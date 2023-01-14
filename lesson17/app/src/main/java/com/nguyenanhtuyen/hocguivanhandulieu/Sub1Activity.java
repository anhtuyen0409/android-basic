package com.nguyenanhtuyen.hocguivanhandulieu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.nguyenanhtuyen.model.DanhBa;

public class Sub1Activity extends AppCompatActivity {
    TextView txtData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub1);
        addControls();
    }

    private void addControls() {
        txtData = findViewById(R.id.txtData);
        Intent intent = getIntent(); //nhận dữ liệu từ màn hình MainActivity gửi qua
        int a = intent.getIntExtra("a",0); //a là biến (lưu ý phải trùng với biến bên truyền dl), 0 là giá trị ko mong muốn - giá trị mặc định nếu ko trả về kết quả mong muốn
        double b = intent.getDoubleExtra("b",0.0);
        boolean c = intent.getBooleanExtra("c",false);
        String d = intent.getStringExtra("d");
        DanhBa e = (DanhBa) intent.getSerializableExtra("e");
        txtData.setText("");
        txtData.append("a="+a);
        txtData.append("\n");
        txtData.append("b="+b);
        txtData.append("\n");
        txtData.append("c="+c);
        txtData.append("\n");
        txtData.append("d="+d);
        txtData.append("\n");
        txtData.append(e+"");

    }
}