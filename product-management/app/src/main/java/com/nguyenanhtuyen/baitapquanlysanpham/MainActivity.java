package com.nguyenanhtuyen.baitapquanlysanpham;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.nguyenanhtuyen.model.SanPham;

public class MainActivity extends AppCompatActivity {
    ListView lvSanPham;
    ArrayAdapter<SanPham> sanPhamArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        lvSanPham.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SanPham sp = sanPhamArrayAdapter.getItem(i);
                Intent intent = new Intent(MainActivity.this,ChiTietSanPhamActivity.class);
                intent.putExtra("sanpham",sp); //ttuyeefn dữ liệu qa màn hình chi tiết với tên biến là sanpham, dữ liệu là sp
                startActivityForResult(intent,113); //mã yêu cầu là 113
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==113 && resultCode==115){
            boolean isDelete = data.getBooleanExtra("xacnhanxoa",false);
            SanPham spXoa = (SanPham) data.getSerializableExtra("sanpham");
            for(int i=0; i<sanPhamArrayAdapter.getCount(); i++){
                SanPham sp = sanPhamArrayAdapter.getItem(i);
                if(sp.getMa().equals(spXoa.getMa())){
                    sanPhamArrayAdapter.remove(sp);
                    break;
                }
            }
        }
    }

    private void addControls() {
        lvSanPham = findViewById(R.id.lvSanPham);
        sanPhamArrayAdapter = new ArrayAdapter<SanPham>(MainActivity.this, android.R.layout.simple_list_item_1);
        lvSanPham.setAdapter(sanPhamArrayAdapter);
        sanPhamArrayAdapter.add(new SanPham("sp1","Cocacola",15000));
        sanPhamArrayAdapter.add(new SanPham("sp2","Pepsi",10000));
        sanPhamArrayAdapter.add(new SanPham("sp3","Redbull",25000));
        sanPhamArrayAdapter.add(new SanPham("sp4","Sting",20000));
        sanPhamArrayAdapter.add(new SanPham("sp5","Number one",35000));
    }
}