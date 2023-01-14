package com.nguyenanhtuyen.hocassets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //khai báo các control
    TextView txtFont;
    ListView lvFont;
    ArrayAdapter<String> fontAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        lvFont.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //chuyển kiểu chữ theo font được chọn
                String fontName = fontAdapter.getItem(i);
                Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/"+fontName);
                txtFont.setTypeface(typeface);
            }
        });
    }

    private void addControls() {
        txtFont = findViewById(R.id.txtFont);
        lvFont = findViewById(R.id.lvFont);
        fontAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1);
        lvFont.setAdapter(fontAdapter);
        //nạp danh sách font chữ lên listview
        try {
            AssetManager assetManager = getAssets();
            String[] arrFont = assetManager.list("fonts");
            fontAdapter.addAll(arrFont);
        }
        catch (Exception ex){
            Log.e("Lỗi",ex.toString());
        }
    }
}