package com.nguyenanhtuyen.hocvongdoiactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnMoToanBo, btnMoMotPhan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(MainActivity.this,"onStart",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(MainActivity.this,"onStop",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(MainActivity.this,"onDestroy",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(MainActivity.this,"onPause",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(MainActivity.this,"onResume",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(MainActivity.this,"onRestart",Toast.LENGTH_SHORT).show();
    }

    private void addEvents() {
        btnMoToanBo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyMoToanBo();
            }
        });
        btnMoMotPhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyMoMotPhan();
            }
        });
    }

    private void xuLyMoMotPhan() {
        Intent intent = new Intent(MainActivity.this,Sub2Activity.class);
        startActivity(intent);
    }

    private void xuLyMoToanBo() {
        Intent intent = new Intent(MainActivity.this,Sub1Activity.class);
        startActivity(intent);
    }

    private void addControls() {
        btnMoToanBo = findViewById(R.id.btnMoToanBo);
        btnMoMotPhan = findViewById(R.id.btnMoMotPhan);
    }
}