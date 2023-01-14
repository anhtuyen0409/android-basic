package com.nguyenanhtuyen.hoclistviewcoban;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnListViewCoBan_Mang, btnListViewCoBan_StringArray, btnListViewCoBan_Object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnListViewCoBan_Mang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyMoListView1();
            }
        });
        btnListViewCoBan_StringArray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyMoListView2();
            }
        });
        btnListViewCoBan_Object.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyMoListView3();
            }
        });
    }

    private void xuLyMoListView3() {
        Intent intent = new Intent(MainActivity.this, ListView3Activity.class);
        startActivity(intent);
    }

    private void xuLyMoListView2() {
        Intent intent = new Intent(MainActivity.this, ListView2Activity.class);
        startActivity(intent);
    }

    private void xuLyMoListView1() {
        Intent intent = new Intent(MainActivity.this, ListView1Activity.class);
        startActivity(intent);
    }


    private void addControls() {

        btnListViewCoBan_Mang = findViewById(R.id.btnListViewCoBan_Mang);
        btnListViewCoBan_StringArray = findViewById(R.id.btnListViewCoBan_StringArray);
        btnListViewCoBan_Object = findViewById(R.id.btnListViewCoBan_Object);
    }
}