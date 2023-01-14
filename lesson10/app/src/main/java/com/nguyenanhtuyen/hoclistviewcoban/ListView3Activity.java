package com.nguyenanhtuyen.hoclistviewcoban;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.nguyenanhtuyen.model.Contact;

public class ListView3Activity extends AppCompatActivity {
    //khai báo các control trên listview3
    EditText edtMa, edtTen, edtSDT;
    Button btnThem;
    ListView lvContact;
    ArrayAdapter<Contact> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view3);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyThem();
            }
        });
        lvContact.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Contact c = adapter.getItem(i);
                adapter.remove(c);
                return false;
            }
        });
        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Contact c = adapter.getItem(i);
                edtMa.setText(c.getId()+"");
                edtTen.setText(c.getName());
                edtSDT.setText(c.getPhone());
            }
        });
    }

    private void xuLyThem() {
        Contact cont = new Contact();
        cont.setId(Integer.parseInt(edtMa.getText().toString()));
        cont.setName(edtTen.getText().toString());
        cont.setPhone(edtSDT.getText().toString());
        adapter.add(cont);
        //sau khi thêm xoá dữ liệu trên các control để nhâp dữ liệu mới
        edtMa.setText("");
        edtTen.setText("");
        edtSDT.setText("");
    }

    private void addControls() {
        edtMa = findViewById(R.id.edtMa);
        edtTen = findViewById(R.id.edtTen);
        edtSDT = findViewById(R.id.edtSDT);
        btnThem = findViewById(R.id.btnThem);
        lvContact = findViewById(R.id.lvContact);
        adapter = new ArrayAdapter<Contact>(
                ListView3Activity.this,
                android.R.layout.simple_list_item_1);
        lvContact.setAdapter(adapter);
    }
}