package com.nguyenanhtuyen.hocasynctasktaihinh;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    Button btnTaiHinh;
    ImageView imgHinh;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnTaiHinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageTask task = new ImageTask();
                task.execute("data:image/jpeg;base64,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");
            }
        });
    }

    class ImageTask extends AsyncTask<String,Void, Bitmap>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog.show();
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            dialog.dismiss();
            imgHinh.setImageBitmap(bitmap);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                Bitmap bitmap = BitmapFactory.decodeStream(connection.getInputStream());
                return bitmap;
            }
            catch (Exception ex){
                Log.e("Lỗi",ex.toString());
            }
            return null;
        }
    }

    private void addControls() {
        btnTaiHinh = findViewById(R.id.btnTaiHinh);
        imgHinh = findViewById(R.id.imgHinh);
        dialog = new ProgressDialog(MainActivity.this);
        dialog.setTitle("Thông báo");
        dialog.setMessage("Đang tải hình, vui lòng chờ...");
    }
}