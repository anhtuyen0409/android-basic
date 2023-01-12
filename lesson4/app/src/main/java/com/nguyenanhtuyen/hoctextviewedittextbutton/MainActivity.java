package com.nguyenanhtuyen.hoctextviewedittextbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //ta cần khai báo các control có tham gia vào chương trình
    //hệ số a, hệ sô b, kết quả
    EditText edtHeSoA, edtHeSoB;
    TextView txtKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
    }

    private void addControls() {
        //khởi tạo tham chiếu ô nhớ cho các control ở đây
        edtHeSoA = findViewById(R.id.edtHeSoA);
        edtHeSoB = findViewById(R.id.edtHeSoB);
        txtKetQua = findViewById(R.id.txtKetQua);
    }

    public void xuLyThoat(View view) {
        //đóng màn hình hiện tại
        finish();
    }

    public void xuLyGiai(View view) {
        //lấy giá trị người dùng nhập vào trong ô hệ số a
        //vì nó luôn là chuỗi nên dùng parseDouble để chuyển sang số
        Double heSoA = Double.parseDouble(edtHeSoA.getText().toString());
        Double heSoB = Double.parseDouble(edtHeSoB.getText().toString());
        if(heSoA==0){
            if(heSoB==0){
                txtKetQua.setText("Phương trình có vô số nghiệm!");
            }
            else{
                txtKetQua.setText("Phương trình vô nghiệm!");
            }
        }
        else{
            Double kq = -heSoB/heSoA;
            txtKetQua.setText("Phương trình có nghiệm: x = "+kq);
        }
    }
}