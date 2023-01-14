package com.nguyenanhtuyen.hocintentresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class XuLyUocSoActivity extends AppCompatActivity {
    TextView txtN;
    Button btnTraVeUocSo;
    Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xu_ly_uoc_so);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnTraVeUocSo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyTraVeUocSo();
            }
        });
    }

    private void xuLyTraVeUocSo() {
        int n = Integer.parseInt(txtN.getText().toString());
        ArrayList<Integer>dsus = new ArrayList<>();
        for(int i=1; i<=n; i++){
            if(n%i==0){
                dsus.add(i);
            }
        }
        intent.putExtra("dsus",dsus);
        setResult(115,intent); //115 là mã kết quả
        finish();
    }


    private void addControls() {
        intent = getIntent();
        int n = intent.getIntExtra("N",0);
        txtN = findViewById(R.id.txtN);
        btnTraVeUocSo = findViewById(R.id.btnTraVeUocSo);
        txtN.setText(n+"");
    }
}