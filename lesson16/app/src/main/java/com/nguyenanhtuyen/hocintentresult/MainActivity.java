package com.nguyenanhtuyen.hocintentresult;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtNhapN;
    Button btnLayUocSo;
    TextView txtKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnLayUocSo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moManHinhTraVeUocSo();
            }
        });
    }

    private void moManHinhTraVeUocSo() {
        Intent intent = new Intent(MainActivity.this,XuLyUocSoActivity.class);
        //truyền dữ liệu
        intent.putExtra("N",Integer.parseInt(edtNhapN.getText().toString()));
        startActivityForResult(intent,113); //113 là mã yêu cầu
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==113 && resultCode==115){
            ArrayList<Integer>dsus = data.getIntegerArrayListExtra("dsus"); //dsus là biến ta đặt bên màn hình 2
            txtKetQua.setText("");
            for(int us : dsus){
                txtKetQua.append(us+"\n");
            }
        }
    }

    private void addControls() {
        edtNhapN = findViewById(R.id.edtNhapN);
        btnLayUocSo = findViewById(R.id.btnLayUocSo);
        txtKetQua = findViewById(R.id.txtKetQua);
    }
}