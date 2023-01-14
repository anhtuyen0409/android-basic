package com.nguyenanhtuyen.hocspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //khai báo các control
    Spinner spnSanPham;
    TextView txtSanPham;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        spnSanPham.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String s = adapter.getItem(i);
                txtSanPham.setText(s);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void addControls() {
        spnSanPham = findViewById(R.id.spnSanPham);
        txtSanPham = findViewById(R.id.txtSanPham);
        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item);
        adapter.add("Cocacola");
        adapter.add("Pepsi");
        adapter.add("Redbull");
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //gán spinner cho adapter vừa định nghĩa
        spnSanPham.setAdapter(adapter);
    }
}