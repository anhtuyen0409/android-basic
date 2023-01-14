package com.nguyenanhtuyen.hocasynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText edtSoLuong;
    Button btnVe;
    TextView txtTiLe;
    LinearLayout llButton;
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT);
    Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n = Integer.parseInt(edtSoLuong.getText().toString());
                ButtonTask task = new ButtonTask();
                task.execute(n);
            }
        });

    }

    private void addControls() {
        edtSoLuong = findViewById(R.id.edtSoLuong);
        btnVe = findViewById(R.id.btnVe);
        txtTiLe = findViewById(R.id.txtTiLe);
        llButton = findViewById(R.id.llButton);
    }
    class ButtonTask extends AsyncTask<Integer,Integer,Void>{
        //hàm tự động chạy khi tiến trình kích hoạt
        //ta có thể viết các phương thức khởi tạo trong hàm này
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            txtTiLe.setText("0%");
            llButton.removeAllViews();
        }

        //hàm tự kích hoạt khi tiến trình kết thúc
        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            txtTiLe.setText("100%");
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            int value = values[0];
            int percent  =values[1];
            txtTiLe.setText(percent+"%");
            Button btn = new Button(MainActivity.this);
            btn.setText(value+"");
            btn.setLayoutParams(layoutParams);
            llButton.addView(btn);
        }

        //hàm này không thể tương tác với giao diện được, nên phải dùng hàm onpogressupdate
        @Override
        protected Void doInBackground(Integer... integers) {
            int n = integers[0];
            for(int i=0; i<n; i++){
                int percent = i*100/n;
                int value = rand.nextInt(100);
                publishProgress(value,percent);
                SystemClock.sleep(100);
            }
            return null;
        }
    }
}