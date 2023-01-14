package com.nguyenanhtuyen.hoclistviewcoban;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListView2Activity extends AppCompatActivity {
    //khai báo các control trong listview2
    ListView lvData2;
    String[] arrData2;
    ArrayAdapter<String> adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view2);
        addControls();
        addEvents();
    }

    private void addEvents() {
        lvData2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListView2Activity.this, "Bạn chọn "+arrData2[i], Toast.LENGTH_LONG).show();
            }
        });
    }

    private void addControls() {
        lvData2 = findViewById(R.id.lvData2);
        arrData2 = getResources().getStringArray(R.array.myArray);
        adapter2 = new ArrayAdapter<String>(
                ListView2Activity.this,
                android.R.layout.simple_list_item_1,
                arrData2);
        lvData2.setAdapter(adapter2);
    }
}