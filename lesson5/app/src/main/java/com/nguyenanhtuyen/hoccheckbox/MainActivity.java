package com.nguyenanhtuyen.hoccheckbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //khai báo các control
    CheckBox chkBunRieu, chkBunBo, chkPho;
    TextView txtKetQua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
    }

    private void addControls() {
        chkBunRieu = findViewById(R.id.chkBunRieu);
        chkBunBo = findViewById(R.id.chkBunBo);
        chkPho = findViewById(R.id.chkPho);
        txtKetQua = findViewById(R.id.txtKetQua);
    }

    public void xuLyDatMon(View view) {
        StringBuilder builder = new StringBuilder();
        if(chkBunRieu.isChecked()){
            builder.append(chkBunRieu.getText().toString());
            builder.append("\n");
        }
        if(chkBunBo.isChecked()){
            builder.append(chkBunBo.getText().toString());
            builder.append("\n");
        }
        if(chkPho.isChecked()){
            builder.append(chkPho.getText().toString());
            builder.append("\n");
        }
        //show kết quả chọn món
        txtKetQua.setText(builder.toString());
    }
}