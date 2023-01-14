package com.nguyenanhtuyen.hoclistviewcoban;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListView1Activity extends AppCompatActivity {
    ListView lvData1;
    //giả định ta có dữ liệu 1 chuỗi có sẵn
    String[] arrData = {"Hà Giang","Cao Bằng","Hà Nội","Huế","Đà Nẵng", "Quảng Nam","Bình Định","Phú Yên",
            "Nha Trang","Ninh Thuận", "Vũng Tàu","Đồng Nai","TP.Hồ Chí Minh","Kiên Giang","Bến Tre","Cà Mau"};
    //vì dữ liệu của ta có kiểu dữ liệu là String nên cái ArrayAdapter cũng phải là kiểu String
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view1);
        addControls();
        addEvents();
    }

    private void addEvents() {
        //sự kiện người dùng chọn 1 dòng bất kỳ trên listview
        lvData1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //ta quan tâm đến đối số i -> vị trí dòng người dùng chọn
                Toast.makeText(ListView1Activity.this, "Bạn chọn "+arrData[i], Toast.LENGTH_LONG).show();

            }
        });
    }

    private void addControls() {
        lvData1 = findViewById(R.id.lvData1);
        //tạo adapter
        //mục đích sử dụng adapter là để nó vẽ lv trên giao diện
        //mô hình: dữ liệu -> adapter -> giao diện (listview)
        //đối số 1: màn hình hiện tại
        //đối số 2: kiểu layout
        //đối số 3: dữ liệu truyền vào
        adapter = new ArrayAdapter<String>(ListView1Activity.this, android.R.layout.simple_list_item_1,arrData);
        //gán adapter cho listview
        lvData1.setAdapter(adapter);
    }
}