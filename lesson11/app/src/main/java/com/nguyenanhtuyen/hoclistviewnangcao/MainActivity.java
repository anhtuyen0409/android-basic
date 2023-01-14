package com.nguyenanhtuyen.hoclistviewnangcao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.nguyenanhtuyen.adapter.SanPhamAdapter;

public class MainActivity extends AppCompatActivity {
    //khai báo các control
    ListView lvCountry;
    SanPhamAdapter sanPhamAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        fakeData();
        addEvents();
    }

    private void addEvents() {
        lvSanPham.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,
                        "Bạn chọn "+sanPhamAdapter.getItem(i).getTen(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void fakeData() {
        sanPhamAdapter.add(new SanPham(R.drawable.ic_pic1,"Viet Nam",15000));
        sanPhamAdapter.add(new SanPham(R.drawable.ic_pic2,"United States",18000));
        sanPhamAdapter.add(new SanPham(R.drawable.ic_pic3,"Russia0",20000));

    }

    private void addControls() {
        lvCountry = findViewById(R.id.lvCountry);
        sanPhamAdapter = new SanPhamAdapter(MainActivity.this, R.layout.item);
        lvSanPham.setAdapter(sanPhamAdapter);
    }
}