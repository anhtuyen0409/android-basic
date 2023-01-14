package com.nguyenanhtuyen.baitaprenluyenmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.SearchView;

import com.nguyenanhtuyen.adapter.NhanVienAdapter;
import com.nguyenanhtuyen.model.NhanVien;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvNhanVien;
    NhanVienAdapter nhanVienAdapter;
    NhanVien selectedNV; //nhân viên được chọn
    ArrayList<NhanVien> dsGoc = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
        registerForContextMenu(lvNhanVien);
    }

    private void addEvents() {
        lvNhanVien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedNV = nhanVienAdapter.getItem(i);
            }
        });
        lvNhanVien.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedNV = nhanVienAdapter.getItem(i);
                return false;
            }
        });
    }

    private void addControls() {
        lvNhanVien = findViewById(R.id.lvNhanVien);
        nhanVienAdapter = new NhanVienAdapter(MainActivity.this,R.layout.item);
        lvNhanVien.setAdapter(nhanVienAdapter);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.mnuEdit){
            hienThiManHinhEdit();
        }
        else if(item.getItemId()==R.id.mnuDelete){
            xuLyXoa();
        }
        return super.onContextItemSelected(item);
    }

    private void xuLyXoa() {
        nhanVienAdapter.remove(selectedNV);
    }

    private void hienThiManHinhEdit() {
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.detail_layout);

        //khai báo các control trong màn hình thêm nhân viên
        final EditText edtMaNV = dialog.findViewById(R.id.edtMaNV);
        final EditText edtTenNV = dialog.findViewById(R.id.edtTenNV);
        final RadioButton radNam = dialog.findViewById(R.id.radNam);
        final RadioButton radNu = dialog.findViewById(R.id.radNu);
        final Button btnLuu = dialog.findViewById(R.id.btnLuu);

        //xử lý sự kiện thêm nhân viên
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedNV.setMa(edtMaNV.getText().toString());
                selectedNV.setTen(edtTenNV.getText().toString());
                selectedNV.setNam(radNam.isChecked());
                nhanVienAdapter.notifyDataSetChanged(); //thay đổi thông tin
                dialog.dismiss(); //tắt màn hình để show màn hình listview

                dsGoc.clear();
                for(int i=0; i<nhanVienAdapter.getCount();i++){
                    dsGoc.add(nhanVienAdapter.getItem(i));
                }
            }
        });
        //hiển thị thông tin nhân viên được chọn
        edtMaNV.setText(selectedNV.getMa());
        edtTenNV.setText(selectedNV.getTen());
        if(selectedNV.isNam()){
            radNam.setChecked(true);
        }
        else{
            radNu.setChecked(true);
        }
        dialog.show();
    }

    //nạp các menu đã định nghĩa
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu); //nạp option menu lên
        MenuItem mnuSearch = menu.findItem(R.id.mnuSearch);
        SearchView searchView = (SearchView) mnuSearch.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if(s.isEmpty()){
                    nhanVienAdapter.clear();
                    nhanVienAdapter.addAll(dsGoc);
                }
                else{
                    ArrayList<NhanVien> dsTimKiem = new ArrayList<>();
                    for(NhanVien nv : dsGoc){
                        if(nv.getMa().contains(s) || nv.getTen().contains(s)){
                            dsTimKiem.add(nv);
                        }
                    }
                    nhanVienAdapter.clear();
                    nhanVienAdapter.addAll(dsTimKiem);
                }

                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnuNew:
                hienThiManHinhThemNhanVien();
                break;
            case R.id.mnuHelp:
                break;
            case R.id.mnuAbout:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void hienThiManHinhThemNhanVien() {
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.detail_layout);

        //khai báo các control trong màn hình thêm nhân viên
        final EditText edtMaNV = dialog.findViewById(R.id.edtMaNV);
        final EditText edtTenNV = dialog.findViewById(R.id.edtTenNV);
        final RadioButton radNam = dialog.findViewById(R.id.radNam);
        final RadioButton radNu = dialog.findViewById(R.id.radNu);
        final Button btnLuu = dialog.findViewById(R.id.btnLuu);

        //xử lý sự kiện thêm nhân viên
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NhanVien nv = new NhanVien();
                nv.setMa(edtMaNV.getText().toString());
                nv.setTen(edtTenNV.getText().toString());
                nv.setNam(radNam.isChecked());
                nhanVienAdapter.add(nv);
                dialog.dismiss(); //tắt màn hình để show màn hình listview

                dsGoc.clear();
                for(int i=0; i<nhanVienAdapter.getCount();i++){
                    dsGoc.add(nhanVienAdapter.getItem(i));
                }
            }
        });
        dialog.show();
    }
}