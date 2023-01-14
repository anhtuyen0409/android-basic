package com.nguyenanhtuyen.hocalertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //khai báo các control
    EditText edtHeSoA, edtHeSoB, edtHeSoC;
    Button btnGiai, btnThoat;
    TextView txtKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyThoat();
            }
        });
        btnGiai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyGiai();
            }
        });
    }

    private void xuLyGiai() {
        //chuyển dữ liệu người dùng nhập vào sang kiểu double
        double a = Double.parseDouble(edtHeSoA.getText().toString());
        double b = Double.parseDouble(edtHeSoB.getText().toString());
        double c = Double.parseDouble(edtHeSoC.getText().toString());
        if(a==0){
            if(b==0){
                if(c==0){
                    txtKetQua.setText("Phương trình có vô số nghiệm");
                }
                else{
                    txtKetQua.setText("Phương trình vô nghiệm");
                }
            }
            else{
                double x = -c/b;
                txtKetQua.setText("Phương trình có nghiệm x = "+x);
            }
        }
        else{
            double delta = (b*b)-(4*a*c);
            if(delta < 0){
                txtKetQua.setText("Phương trình vô nghiệm");
            }
            else if(delta == 0){
                double x3 = -b/(2*a);
                txtKetQua.setText("Phương trình có nghiệm kép: x1 = x2 = "+x3);
            }
            else{
                double x1 = (-b-Math.sqrt(delta))/(2*a);
                double x2 = (-b+Math.sqrt(delta))/(2*a);
                txtKetQua.setText("Phương trình có 2 nghiệm phân biệt: x1 = "+x1+"; x2 = "+x2);
            }
        }
    }

    private void xuLyThoat() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        //thiết lập tiêu đề
        builder.setTitle("Xác nhận");
        //thiết lập icon
        builder.setIcon(android.R.drawable.ic_dialog_info);
        //thiết lập nội dung
        builder.setMessage("Bạn có chắc chắn thoát không?");
        //thiết lập các nút lệnh cho người dùng tương tác
        builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss(); //ẩn đi
            }
        });
        //tạo cửa sổ dialog
        AlertDialog dialog = builder.create();
        //khi hiển thị cửa sổ, người dùng nhấn bên ngoài vùng cửa sổ sẽ không cho thoát cửa sổ
        dialog.setCanceledOnTouchOutside(false);
        //hiển thị cửa sổ này lên
        dialog.show();
    }

    private void addControls() {
        edtHeSoA = findViewById(R.id.edtHeSoA);
        edtHeSoB = findViewById(R.id.edtHeSoB);
        edtHeSoC = findViewById(R.id.edtHeSoC);
        btnGiai = findViewById(R.id.btnGiai);
        btnThoat = findViewById(R.id.btnThoat);
        txtKetQua = findViewById(R.id.txtKetQua);
    }

}